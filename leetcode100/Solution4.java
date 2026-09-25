package com.itheima.dayStatic1.leetcode100;

public class Solution4 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        // i左柱子，j右柱子，j必须在i右边
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                int w = j - i;
                int h = Math.min(height[i], height[j]);
                int area = w * h;
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
