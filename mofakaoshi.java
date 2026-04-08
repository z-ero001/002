package com.itheima.dayStatic1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class mofakaoshi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 第一组数字个数
        int m = sc.nextInt(); // 第二组数字个数

        int[] a = new int[n];
        int[] b = new int[m];

        // 读入第一组
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        // 读入第二组
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        int count = 0; // 统计符合条件的组合数
        Set<Integer> set = new HashSet<>();

        for(int numA : a){
            for(int numB : b){
                if(isPrime(numA + numB)&&(numA+numB)<=n+m){
                    set.add(numA + numB);
                }
            }
        }

        System.out.println(set.size());
    }

    // 正确的质数判断函数
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i=3;i<=Math.sqrt(num);i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}