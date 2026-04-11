package com.itheima.dayStatic1;

import java.util.Arrays;

public class feibonaqie {

    static long N=9999999;
    public static void main(String[] args) {



        for(;N>0;N--){
            long [] sum=new long[50];
            if(fn(N,sum)){
System.out.println(Arrays.toString(sum));
               System.out.println(N);break;
            }
        }
    }
    public static  Boolean fn(long m,long []sum){

        int i=7 ;
        long n=m;
        while(n>0){
            sum[i]=n%10;
            n=n/10;
            i--;
        }
        int tem=7;
        while(true){
            for(int j=0;j<7;j++){
                sum[tem+1]+=sum[tem-j];

            }

            if(sum[tem+1]==m)return true;
            if(sum[tem+1]>m) return false;
            tem++;
        }
    }

}
