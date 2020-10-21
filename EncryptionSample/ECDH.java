/*
 This sample code illustrates below mention feature
    1) Diffie Hillman key exchange
    2) HKDF Aes encryption and decryption

 Tech used:
 1) BouncyCastle: (
        <dependency>
            <groupId>org.bouncycastle</groupId>
            <artifactId>bcprov-jdk15on</artifactId>
            <version>1.66</version>
        </dependency>
        )
 2) JAVA
 
 NOTE: ---->
 Please use last to methods of this file if you are using PROJECTEKA-HIU For decryption.
 If you are making both the system by your self use this sample implementation
*/

import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class main {
    public static final String ALGORITHM = "ECDH";
    public static final String CURVE = "curve25519";
    public static final String PROVIDER = BouncyCastleProvider.PROVIDER_NAME;
    public static final String strToPerformActionOn = "SomeValue";

    // Driver function
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        System.out.println("Details");
        System.out.println("ALGORITHM: " + ALGORITHM);
        System.out.println("CURVE: " + CURVE);
        System.out.println("DATA: " + strToPerformActionOn);
        System.out.println("<---------------- BEGIN ------------------->");
        System.out.println("\n");

        // Generate the DH keys for sender and receiver
        KeyPair receiverKeyPair = generateKeyPair();
        String receiverPrivateKey = getBase64String(getEncodedPrivateKey(receiverKeyPair.getPrivate()));
        String receiverPublicKey = getBase64String(getEncodedPublicKey(receiverKeyPair.getPublic()));

        KeyPair senderKeyPair = generateKeyPair();
        String senderPrivateKey = getBase64String(getEncodedPrivateKey(senderKeyPair.getPrivate()));
        String senderPublicKey = getBase64String(getEncodedPublicKey(senderKeyPair.getPublic()));

        // Generate random key for sender and receiver
        String randomSender = generateRandomKey();
        String randomReceiver = generateRandomKey();

        // Generating Xor of random Keys
        byte[] xorOfRandom = xorOfRandom(randomSender, randomReceiver);

        String encryptedData = encrypt(xorOfRandom, senderPrivateKey, receiverPublicKey, strToPerformActionOn);

        System.out.println("\n");

        String decryptedData = decrypt(xorOfRandom, receiverPrivateKey, senderPublicKey, encryptedData);

        System.out.println("\n");
        System.out.println("Data to encrypt: " + strToPerformActionOn + " , encrypted Data: " + encryptedData + " , decrypted data: " + decryptedData);
        System.out.println("\n");
        System.out.println("<---------------- DONE ------------------->");

    }

    // Method for encryption
    public static String encrypt(byte[] xorOfRandom, String senderPrivateKey, String receiverPublicKey, String stringToEncrypt) throws Exception {
        System.out.println("<------------------- ENCRYPTION -------------------->");
        // Generating shared secret
        String sharedKey = doECDH(getBytesForBase64String(senderPrivateKey), getBytesForBase64String(receiverPublicKey));
        System.out.println("Shared key: " + sharedKey);

        // Generating iv and HKDF-AES key
        byte[] iv = Arrays.copyOfRange(xorOfRandom, xorOfRandom.length - 12, xorOfRandom.length);
        byte[] aesKey = generateAesKey(xorOfRandom, sharedKey);
        System.out.println("HKDF AES key: " + getBase64String(aesKey));

        // Perform Encryption
        String encryptedData = "";
        try {
            byte[] stringBytes = stringToEncrypt.getBytes();

            GCMBlockCipher cipher = new GCMBlockCipher(new AESEngine());
            AEADParameters parameters =
                    new AEADParameters(new KeyParameter(aesKey), 128, iv, null);

            cipher.init(true, parameters);
            byte[] plainBytes = new byte[cipher.getOutputSize(stringBytes.length)];
            int retLen = cipher.processBytes
                    (stringBytes, 0, stringBytes.length, plainBytes, 0);
            cipher.doFinal(plainBytes, retLen);

            encryptedData = getBase64String(plainBytes);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("EncryptedData: " + encryptedData);
        System.out.println("<---------------- Done ------------------->");
        return encryptedData;
    }

    // Method for decryption
    public static String decrypt(byte[] xorOfRandom, String receiverPrivateKey, String senderPublicKey, String stringToDecrypt) throws Exception {
        System.out.println("<------------------- DECRYPTION -------------------->");
        // Generating shared secret
        String sharedKey = doECDH(getBytesForBase64String(receiverPrivateKey),getBytesForBase64String(senderPublicKey));
        System.out.println("Shared key: " + sharedKey);

        // Generating iv and HKDF-AES key
        byte[] iv = Arrays.copyOfRange(xorOfRandom, xorOfRandom.length - 12, xorOfRandom.length);
        byte[] aesKey = generateAesKey(xorOfRandom, sharedKey);
        System.out.println("HKDF AES key: " + getBase64String(aesKey));

        // Perform Decryption
        String decryptedData = "";
        try {
            byte[] encryptedBytes = getBytesForBase64String(stringToDecrypt);

            GCMBlockCipher cipher = new GCMBlockCipher(new AESEngine());
            AEADParameters parameters =
                    new AEADParameters(new KeyParameter(aesKey), 128, iv, null);

            cipher.init(false, parameters);
            byte[] plainBytes = new byte[cipher.getOutputSize(encryptedBytes.length)];
            int retLen = cipher.processBytes
                    (encryptedBytes, 0, encryptedBytes.length, plainBytes, 0);
            cipher.doFinal(plainBytes, retLen);

            decryptedData = new String(plainBytes);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("DecryptedData: " + decryptedData);
        System.out.println("<---------------- Done ------------------->");
        return decryptedData;
    }

    // Method for generating random string
    public static String generateRandomKey() {
        byte[] salt = new byte[32];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return getBase64String(salt);
    }

    // Method for generating DH Keys
    public static KeyPair generateKeyPair() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, PROVIDER);
        X9ECParameters ecParameters = CustomNamedCurves.getByName(CURVE);
        ECParameterSpec ecSpec=new ECParameterSpec(ecParameters.getCurve(), ecParameters.getG(),
                ecParameters.getN(), ecParameters.getH(), ecParameters.getSeed());

        keyPairGenerator.initialize(ecSpec, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    private static PrivateKey loadPrivateKey (byte [] data) throws Exception
    {
        X9ECParameters ecP = CustomNamedCurves.getByName(CURVE);
        ECParameterSpec params=new ECParameterSpec(ecP.getCurve(), ecP.getG(),
                ecP.getN(), ecP.getH(), ecP.getSeed());
        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(new BigInteger(data), params);
        KeyFactory kf = KeyFactory.getInstance(ALGORITHM, PROVIDER);
        return kf.generatePrivate(privateKeySpec);
    }

    private static PublicKey loadPublicKey (byte [] data) throws Exception
    {
        Security.addProvider(new BouncyCastleProvider());
        X9ECParameters ecP = CustomNamedCurves.getByName(CURVE);
        ECParameterSpec ecNamedCurveParameterSpec = new ECParameterSpec(ecP.getCurve(), ecP.getG(),
                ecP.getN(), ecP.getH(), ecP.getSeed());

        return KeyFactory.getInstance(ALGORITHM, PROVIDER)
                .generatePublic(new ECPublicKeySpec(ecNamedCurveParameterSpec.getCurve().decodePoint(data),
                        ecNamedCurveParameterSpec));
    }

    // Method for generating shared secret
    private static String doECDH (byte[] dataPrv, byte[] dataPub) throws Exception
    {
        KeyAgreement ka = KeyAgreement.getInstance(ALGORITHM, PROVIDER);
        ka.init(loadPrivateKey(dataPrv));
        ka.doPhase(loadPublicKey(dataPub), true);
        byte [] secret = ka.generateSecret();
        return getBase64String(secret);
    }

    // method to perform Xor of random keys
    private static byte [] xorOfRandom(String randomKeySender, String randomKeyReceiver)
    {
        byte[] randomSender = getBytesForBase64String(randomKeySender);
        byte[] randomReceiver = getBytesForBase64String(randomKeyReceiver);

        byte[] out = new byte[randomSender.length];
        for (int i = 0; i < randomSender.length; i++) {
            out[i] = (byte) (randomSender[i] ^ randomReceiver[i%randomReceiver.length]);
        }
        return out;
    }

    // Method for generating HKDF AES key
    private static byte [] generateAesKey(byte[] xorOfRandoms, String sharedKey ){
        byte[] salt = Arrays.copyOfRange(xorOfRandoms, 0, 20);
        HKDFBytesGenerator hkdfBytesGenerator = new HKDFBytesGenerator(new SHA256Digest());
        HKDFParameters hkdfParameters = new HKDFParameters(getBytesForBase64String(sharedKey), salt, null);
        hkdfBytesGenerator.init(hkdfParameters);
        byte[] aesKey = new byte[32];
        hkdfBytesGenerator.generateBytes(aesKey, 0, 32);
        return aesKey;
    }

    public static String getBase64String(byte[] value){

        return new String(org.bouncycastle.util.encoders.Base64.encode(value));
    }

    public static byte[] getBytesForBase64String(String value){
        return org.bouncycastle.util.encoders.Base64.decode(value);
    }

    public static byte [] getEncodedPublicKey(PublicKey key) throws Exception
    {
        ECPublicKey ecKey = (ECPublicKey)key;
        return ecKey.getQ().getEncoded(true);
    }

    public static byte [] getEncodedPrivateKey(PrivateKey key) throws Exception
    {
        ECPrivateKey ecKey = (ECPrivateKey)key;
        return ecKey.getD().toByteArray();
    }

    /*
     If using ProjectEka HIU for the decryption then Please use below methods for converting public keys
    * */
    // Replacement for ------> getEncodedPublicKey
    public static byte[] getEncodedPublicKeyForProjectEKAHIU(PublicKey key){
        ECPublicKey ecKey = (ECPublicKey)key;
        return ecKey.getEncoded();
    }
    
    // Replacement for ------> loadPublicKey
    private static PublicKey loadPublicKeyForProjectEKAHIU (byte [] data) throws Exception
    {
        KeyFactory ecKeyFac = KeyFactory.getInstance(ALGORITHM, PROVIDER);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(data);
        PublicKey publicKey = ecKeyFac.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }
}