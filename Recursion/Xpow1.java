//x^n for Stack height log n .


class Xpow1{
    public static int pow_x(int x,int n){
        if(n==0){
            return 1;
        }
        if(x==1){
            return 1;
        }
        if(n%2==0){
            return pow_x(x,n/2)*pow_x(x,n/2);
        }
        else{
            return pow_x(x,n/2)*pow_x(x,n/2)*x;
        }
    }
    public static void main(String[] args) {
        int x=2,n=5;
        int ans = pow_x(x,n);
        System.out.println(ans);
    }
}