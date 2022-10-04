//print unique subsequence.
import java.util.*;
class UniqueSubSequence{
    public static void subSeq(String str,int indx, String newStr,HashSet<String> set){
        if(indx==str.length()){
            if(set.contains(newStr)){
                return;
            }else{
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }
        char c = str.charAt(indx);
        //to be
        subSeq(str,indx+1,newStr+c,set);
        //not to be
        subSeq(str,indx+1,newStr,set);

    }
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String str = "aaa";
        subSeq(str,0,"",set);
    }
}