//Find sybsequences of a String.
// Time complexity = O(2^n).

class SubSequence{
    public static void subSeq(String str,int indx, String newStr){
        if(indx==str.length()){
            System.out.println(newStr);
            return;
        }
        char c = str.charAt(indx);
        //to be
        subSeq(str,indx+1,newStr+c);
        //not to be
        subSeq(str,indx+1,newStr);

    }
    public static void main(String[] args) {
        String str = "abc";
        subSeq(str,0,"");
    }
}