package com.itheima.dayStatic1.leetcode100;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum (int []nums, int target){
//         int length = nums.length;
//         for(int i=0;i<length;i++){
//             for(int j=i+1;j<length;j++){
//                 if(nums[i]+nums[j]==target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return null;
       // -------------------------------//
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>(len-1);
        for(int i=0;i<len;i++){
          if(map.containsKey(target-nums[i])){
              return new int[]{map.get(target-nums[i]),i};
          }
          map.put(nums[i],i);
        }
        return null;
    }
}
