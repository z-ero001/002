package com.itheima.dayStatic1;

import java.util.Scanner;

public class Chess {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int arr[][]=new int [n+2][n+2];
        int result[][]=new int  [n+1][n+1];
        while(m-- !=0){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            arr[x1][y1]++;
            arr[x2][y2+1]++;
            arr[x2+1][y1]++;
            arr[x2+1][y2+1]++;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
                if(arr[i][j]%2==0){
                    result[i][j]=0;
                }else{
                    result[i][j]=1;
                }
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
