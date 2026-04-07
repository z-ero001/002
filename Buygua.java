package com.itheima.dayStatic1;

import java.util.Arrays;
import java.util.Scanner;

public class Buygua {
    static int n,ans=50;
    static long m;
    static long[] a=new long[50];
    static long[] sum=new long[50];

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextLong()*2;
        for(int i=0;i<n;i++){
            a[i]=scan.nextLong()*2;

        }
        Arrays.sort(a);
        reverseArray(a,n);
        for(int i=n-1;i>=0;i--){
            sum[i]=sum[i+1]+a[i];
        }
        dfs(0,0,0);
        if(ans !=50) System.out.println(ans);
        else System.out.println("-1");


    }
    static void dfs(long S,int i,int cnt) {
        if (cnt >= ans)
            return;
        if (S == m)
            ans = cnt;
        if (i >= n || S > m || S + sum[i] < m)
            return;
        dfs(S, i + 1, cnt);
        dfs(S + a[i], i + 1, cnt);
        dfs(S + a[i] / 2, i + 1, cnt + 1);
    }

    static void reverseArray(long[] arr, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
}}
