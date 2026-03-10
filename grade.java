package com.itheima.dayStatic1;

import java.util.Arrays;
import java.util.Scanner;

public class grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // 总人数
        int k = sc.nextInt();    // 选择的人数
        int T = sc.nextInt();    // 方差阈值
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        // 如果k大于总人数，直接返回-1
        if (k > n) {
            System.out.println(-1);
            return;
        }

        // 枚举x从k到n，找最小的满足条件的x
        for (int x = k; x <= n; x++) {
            // 取前x个成绩并排序
            int[] sub = Arrays.copyOfRange(a, 0, x);
            Arrays.sort(sub);

            // 计算前缀和和前缀平方和
            long[] preSum = new long[x + 1];    // 前缀和（用long避免溢出）
            long[] preSq = new long[x + 1];     // 前缀平方和
            for (int i = 0; i < x; i++) {
                preSum[i + 1] = preSum[i] + sub[i];
                preSq[i + 1] = preSq[i] + (long) sub[i] * sub[i];
            }

            // 滑动窗口检查是否存在方差小于T的k个数
            boolean found = false;
            for (int i = 0; i <= x - k; i++) {
                int end = i + k;
                long sum = preSum[end] - preSum[i];
                long sqSum = preSq[end] - preSq[i];

                // 计算方差：(平方和/k) - (和/k)^2
                double variance = (double) sqSum / k - Math.pow((double) sum / k, 2);
                if (variance < T) {
                    found = true;
                    break;
                }
            }

            // 找到第一个满足条件的x，直接输出并结束
            if (found) {
                System.out.println(x);
                return;
            }
        }

        // 所有x都不满足条件
        System.out.println(-1);
    }
}
