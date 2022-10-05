class Recursion2{
    public static void printNum2(int n){
        if(n==6){
            return;
        }
        System.out.println(n);
        printNum2(n+1);
    }
    public static void main(String[] args) {
        int n = 1;
        printNum2(n);
    }
}