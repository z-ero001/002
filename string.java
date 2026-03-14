/*对于一个字符串 S，我们定义 S 的分值 f(S) 为 S 中恰好出现一次的字符个数。
例如 f(aba)=1，f(abc)=3，f(aaa)=0。
现在给定一个字符串 S0⋯n−1​（长度为 n，1≤n≤105），
请你计算对于所有 S 的非空子串 Si⋯j​(0≤i≤j<n)，f(Si⋯j​) 的和是多少。*/



package com.itheima.dayStatic1;
import  java.util.Scanner;
import  java.util.Map;
import  java.util.HashMap;

public class string {
    public static void main (String []args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                String str1=str.substring(i,j);
                count+=countstr(str1);
                System.out.println(count);
            }
        }
        System.out.println(count);

    }
    public static int countstr (String str){
        Map<Character,Integer> characterInteger=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            characterInteger.put(ch,characterInteger.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(Map.Entry<Character,Integer> entry:characterInteger.entrySet()){
            if(entry.getValue()==1){
                count++;
            }

        }
        return count;
    }
}
