package Arrays;

// [HARD]: Solved using sliding window techinqe
public class ConsecutiveOnes {
    public static void countConsicutiveOnes(int[] a, int k){
        if(a.length <= 0){
            return;
        }

        int wL = 0;
        int wR = 0;
        int zeroCount = 0;
        int bestWindow = 0;
        int bestLeft = 0;

        while(wR < a.length){
            if(zeroCount <= k){
                if(a[wR] == 0){
                    zeroCount++;
                }
                wR++;
            }

            if(zeroCount > k){
                if(a[wL] == 0){
                    zeroCount--;
                }
                wL++;
            }

            if(bestWindow < (wR-wL) && zeroCount <= k){
                bestWindow = wR-wL;
                bestLeft = wL;
            }
        }

        System.out.println("Start length: " + bestWindow + bestLeft);
    }
}
