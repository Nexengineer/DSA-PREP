//https://leetcode.com/problems/next-greater-element-ii/
//Time Complexity: O(n)
//Space Complexity: O(n)
//Approach: Using stack
//Explanation: We will find the next greater element for the first time and then for the second time. We will store the index of the next greater element in the map. Then we will traverse the nums array and if the element is present in the map, we will store the next greater element in the vector.

class Solution
{
public:
    vector<int> nextGreaterElements(vector<int> &nums)
    {
        vector<int> v(nums.size(), -1); // initializing the vector with -1
        map<int, int> m;                // map to store the index of the next greater element
        stack<int> s;
        s.push(0);
        int j = 1;
        // finding the next greater element for the first time
        while (j < nums.size())
        {
            if (!s.empty())
            {
                int p = s.top();
                if (nums[j] > nums[p])
                {
                    m[p] = j + 1; // storing the index of the next greater element
                    s.pop();
                }
                else
                {
                    s.push(j); // pushing the element in the stack
                    j++;
                }
            }
            else
            {
                s.push(j);
                j++;
            }
        }
        j = 0;

        // finding the next greater element for the second time
        while (!s.empty() && j < nums.size())
        {
            if (nums[j] > nums[s.top()])
            {
                m[s.top()] = j + 1;
                s.pop();
            }
            else
                j++;
        }

        for (int i = 0; i < nums.size(); i++)
        {
            // if the element is present in the map
            if (m[i])
            {
                v[i] = nums[m[i] - 1];
            }
        }
        return v;
    }
};