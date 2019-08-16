
/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.52%)
 * Likes:    4274
 * Dislikes: 485
 * Total Accepted:    612.7K
 * Total Submissions: 2.5M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //linked list for fast insertion
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        //need to sort input
        Arrays.sort(nums);

        //hashset for fast search
        Set<Integer> i_done = new HashSet<>();
        Set<Integer> j_done = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            //avoid repeated numbers
            if (i_done.contains(nums[i]))
                continue;
            i_done.add(nums[i]);

            j_done.clear();
            for (int j = i + 1; j < nums.length - 1; j++) {

                //avoid repeated numbers
                if (j_done.contains(nums[j]))
                    continue;
                j_done.add(nums[j]);

                //find out missing number
                int needed = -(nums[i] + nums[j]);

                //search for it on the right side of the array
                int index = Arrays.binarySearch(nums, j + 1, nums.length, needed);

                //Add it to the solution, the tree numbers are already sorted
                if (index > -1)
                    res.add(Arrays.asList(nums[i], nums[j], needed));
            }
        }
        return res;
    }
}
