// x^n for stack height = n.

class Xpow2{
    public static int X_pow(int x,int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int xpownm1 = X_pow(x,n-1);
        int pow = x* xpownm1;
        return pow;
    }
    public static void main(String[] args) {
        int x=2,n=5;
        int ans = X_pow(x,n);
        System.out.println(ans);
    }
}