/*
Leetcode Daily Challenge 
October 3rd, 2022
1578. Minimum Time to Make Rope Colorful
https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.

Example 1:
Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.


Example 2:
Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.


Example 3:
Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.

*/

class Solution {
public:
    typedef pair<char,int> p;
    int minCost(string colors, vector<int>& nT) {
        stack<p>st;//defining a stack of pair with first element character and second element integer
        int ans=0;// will store the count of minimum time
        for(int i=0;i<colors.size();i++){
            if(!st.empty() && st.top().first==colors[i]){//if stack is not empty and top element of stack is equal to current element of string
                if(st.top().second<nT[i]){//if top element of stack is less than current element of vector
                    ans+=st.top().second;//add top element of stack (integer) to ans
                    st.pop();
                    st.push({colors[i],nT[i]});//pushing the current element of string and current element of vector
                }
                else{//if top element of stack is greater than current element of vector
                    ans+=nT[i];//add current element of vector to ans
                }
            }
            else{
                st.push({colors[i],nT[i]});//pushing the current element of string and vector in stack
            }
        }
        return ans;
    }
};