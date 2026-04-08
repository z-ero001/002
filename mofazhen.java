package com.itheima.dayStatic1;

import java.util.*;

public class mofazhen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] length=new int[5001];
        int count=0;
        int []x=new int[n];
        int []y=new int[n];
        int []r=new int[n];
        for(int i=0;i<n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            r[i]=sc.nextInt();
        }
        double[] R=new double[n];
        double[] Rd=new double[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                R[i]=Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2));
                Rd[i]=R[i]-r[i];if(Rd[i]<0)Rd[i]=0;
                if(R[i]<r[i]){
                    count++;
                }
            }

        }
        Arrays.sort(Rd);
        double sum=0;
        int temp=n;
        for(int i=0;i<temp-count*2;i++){
                if(Rd[i]!=0){
                    sum+=Rd[i];
                }
                if(Rd[i]==0){
                    temp++;
                }
        }
        System.out.println(sum);
    }
}
