package com.itheima.dayStatic1;

import java.util.Scanner;

public class dianchifenzu {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int []arr=new int[N];
        for(int i=0;i<N;i++){

            int M=sc.nextInt();
            int sum=0;
            for(int j=0;j<M;j++){
               sum^=sc.nextInt();
            }
            arr[i]=sum;
        }
        for(int i=0;i<N;i++){
            System.out.println(arr[i]==0 ? "YES" : "NO");
        }


    }
}
