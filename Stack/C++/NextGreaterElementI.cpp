//https://leetcode.com/problems/next-greater-element-i/
//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: Using stack
//Explanation: We will store the index of the next greater element in the map. Then we will traverse the nums array and if the element is present in the map, we will store the next greater element in the vector.

class Solution
{
public:
    vector<int> nextGreaterElement(vector<int> &nums1, vector<int> &nums2)
    {
        vector<int> v(nums1.size(), -1); // initializing the vector with -1
        map<int, int> m;                 // map to store the index of the next greater element
        stack<int> s;
        s.push(nums2[0]); // pushing the first element of nums2
        int j = 1;
        while (j < nums2.size())
        {
            if (!s.empty())
            {
                int p = s.top();
                if (nums2[j] > p)
                {
                    m[p] = j + 1; // storing the index of the next greater element
                    s.pop();      // popping the element
                }
                else
                {
                    s.push(nums2[j]); // pushing the element in the stack
                    j++;
                }
            }
            else
                s.push(nums2[j]);
        }
        for (int i = 0; i < nums1.size(); i++)
        {
            if (m[nums1[i]])
            { // if the element is present in the map
                v[i] = nums2[m[nums1[i]] - 1];
            }
        }
        return v;
    }
};