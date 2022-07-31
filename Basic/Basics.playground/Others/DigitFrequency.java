public class DigitFrequency {
    // public static void main(String[] args) {
    //     System.out.println(getDigitFrequency(445445, 5));
    // }
    public static int getDigitFrequency(int n, int d) {
        // write code here
        int count = 0;
        while(n != 0){
            int dob= n%10;
            n = n/10;
            if(dob == d){
                count ++;
            }
        }
        
        return count;
    }
}
