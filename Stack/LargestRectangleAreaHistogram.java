import java.util.*;
import java.io.*;
class LargestRectangleAreaHistogram{
  public static int largestRectangleArea(int[] heights) {
    int i=0,ans=0,t;
    Stack<Integer> st=new Stack<>();
    while(i<heights.length)
    {
        if(st.isEmpty()||heights[st.peek()]<=heights[i])
            st.push(i++);
        else{
            t=st.pop();
            ans=Math.max(ans,heights[t]*(st.isEmpty()?i:i-st.peek()-1));
        }
    }
    while(!st.isEmpty())
    {
        t=st.pop();
            ans=Math.max(ans,heights[t]*(st.isEmpty()?i:i-st.peek()-1));
    }
    return ans;
}
public static void main (String[] args) {
  Scanner sc=new Scanner(System.in);
 System.out.print("Enter number of bars in histogram");
 int n=sc.nextInt();
 int h[]=new int[n];
 System.out.print("Enter heights");
 for(int i=0;i<n;i++)
  h[i]=sc.nextInt();
 
System.out.println("Area of largest rectagle :"+largestRectangleArea(h));
}
}