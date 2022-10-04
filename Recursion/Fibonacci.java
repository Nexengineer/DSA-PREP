class Fibonacci{
    public static void fib(int a,int b,int n){
        if(n==0){
            return;
        }
        int c = a+b;
        System.out.println(c);
        fib(b,c,n-1);
    }
    public static void main(String[] args) {
        int a = 0,b = 1;
        System.out.println(a);
        System.out.println(b);
        int n = 50;
        fib(a,b,n-2);
    }
}