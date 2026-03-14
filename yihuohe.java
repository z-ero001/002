package com.itheima.dayStatic1;
//给定一个数组 Ai​，分别求其每个子段的异或和，并求出它们的和。或者说，对于每组满足 1≤L≤R≤n 的 L,R，
// 求出数组中第 L 至第 R 个元素的异或和。然后输出每组 L,R 得到的结果加起来的值。
import java.util.Scanner;

public class yihuohe {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int []a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long result = 0;
            for (int i = 0; i < n; i++) {
                long sum = 0;
                for (int j = i; j < n; j++) {
                    sum ^= a[j];
                    result+=sum;
                }
            }
            System.out.println(result);
        }
    }

