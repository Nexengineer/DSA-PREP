//remove Duplicate character using recursion.
class RemoveDuplicate{
    public static boolean[] map = new boolean[26];
    public static void removeDuplicate(String str, int indx,String newStr){
        if(indx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(indx);
        if(map[currChar-'a']){
            removeDuplicate(str,indx+1,newStr);
        }
        else{
            newStr = newStr+currChar;
            map[currChar-'a'] = true;
            removeDuplicate(str,indx+1,newStr);
        }
    }
    public static void main(String[] args) {
        String str = "abbcccd";
        removeDuplicate(str,0,"");
    }
}