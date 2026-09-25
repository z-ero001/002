package com.itheima.dayStatic1.leetcode100;

public class Solution4 {
    public int maxArea(int[] height) {
        //暴力破解
//        int maxArea = 0;
//        // i左柱子，j右柱子，j必须在i右边
//        for(int i = 0; i < height.length; i++){
//            for(int j = i + 1; j < height.length; j++){
//                int w = j - i;
//                int h = Math.min(height[i], height[j]);
//                int area = w * h;
//                if(area > maxArea){
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;

//        public class Solution {
//            public int maxArea(int[] height) {
//                int l = 0, r = height.length - 1;
                int ans = 0;
//                while (l < r) {
//                    int area = Math.min(height[l], height[r]) * (r - l);
//                    ans = Math.max(ans, area);
//                    if (height[l] <= height[r]) {
//                        ++l;
//                    }
//                    else {
//                        --r;
//                    }
//                }
          return ans;
//            }
//        }

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/container-with-most-water/solutions/207215/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}

