class Factorial{
    public static int fact(int n){
        if(n==0 ||n==1){
            return 1;
        }
        int factm = fact(n-1);
        int fact_n = n*factm;
        return fact_n;
    }
    public static void main(String[] args) {
        int n = 5;
        int res = fact(n);
        System.out.println(res);
    }
}