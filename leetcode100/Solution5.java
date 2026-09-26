package com.itheima.dayStatic1.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int  sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j +1]) j=j+1;
                    while (j < k && nums[k] == nums[k - 1]) k=k-1;
                    j++;k--;

                }
                if (sum < 0) {
                    j++;
                }
                if (sum > 0) {
                    k--;
                }

            }
        }
        return ans;
    }
}
