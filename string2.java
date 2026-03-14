package com.itheima.dayStatic1;

import java.util.Scanner;

public class string2 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
                    //贡献法
            String str = scan.next();
            char chs[] = str.toCharArray();
            int len = str.length();
            int res = 0;
            for(int i = 0;i < len;i++){
                int left = 0;
                int right = 0;
                char c = chs[i];
                for(int j = i - 1;j >=0 && chs[j] != c;j --){
                    left++;
                }
                for(int j  = i + 1;j < len && chs[j] != c;j++){
                    right++;
                }
                res += (left+1)*(right+1);
            }
            System.out.println(res);
            scan.close();
        }
    }
