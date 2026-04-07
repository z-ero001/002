package com.itheima.dayStatic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = bf.readLine().split(" ");
        String[] s2 = bf.readLine().split(" ");

        int n=Integer.parseInt(s1[0]);
        long ans=0;
        Set<Long> last =new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Set<Long> t=new TreeSet<>();
            long x=Long.parseLong(s2[i]);
            while(x!=1){
                t.add(x);
                if(last.contains(x)){
                    ans++;

                }
                BigInteger temp= BigInteger.valueOf(x);

                temp=temp.divide(BigInteger.TWO).add(BigInteger.ONE).sqrt();
                String s=temp.toString();
                x=Long.parseLong(s);
            }
                last=t;

        }
        System.out.println(ans);
    }
}