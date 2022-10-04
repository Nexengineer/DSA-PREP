class FirstAndLast{
    public static int first = -1;
    public static int last = -1;
    public static void firstNlast(String str,int indx,char ele){
        if(indx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char CurrentChar = str.charAt(indx);
        if(CurrentChar==ele){
            if(first == -1){
                first = indx;
            }
            else{
                last = indx;
            }
        }
        firstNlast(str,indx+1,ele);
    }
    public static void main(String[] args) {
        String str  = "aaabbbccaad";
        firstNlast(str,0,'a');
    }
}