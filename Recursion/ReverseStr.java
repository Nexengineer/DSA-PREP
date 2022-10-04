// REVERSE STRING USING RECURSION.
class ReverseStr{
    public static void revStr(String st,int inx){
        if(inx==0){ //base condition
            System.out.print(st.charAt(inx));
            return;
        }
        System.out.print(st.charAt(inx));
        revStr(st,inx-1);
    }
    public static void main(String[] args) {
        String st = "abcd";
        revStr(st,st.length()-1);
    }
}

//Time Complexity = O(n).