// Print Nokiya Keypad.
class Keypad{
    public static String[] map = {".","abc","def","ghi","jkl","lmn","pqrs","tu","vwx","yz"};

    public static void printKey(String str,int indx,String newStr){
        if(indx==str.length()){
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(indx);
        String mapping = map[ch-'0'];
        for(int i = 0;i<mapping.length();i++){
            printKey(str,indx+1,newStr+mapping.charAt(i));
        }

    }
    public static void main(String[] args) {
        String str = "23";
        printKey(str,0,"");
    }
}