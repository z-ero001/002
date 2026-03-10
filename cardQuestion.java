package com.itheima.dayStatic1;
/*小蓝有很多数字卡片，每张卡片上都是数字
小蓝准备用这些卡片来拼一些数，他想从1 开始拼出正整数，每拼一个，就保存起来，卡片就不能用来拼其它数了。
小蓝想知道自己能从 1 拼到多少
例如，当小蓝有30 张卡片，其中0 到9 各3 张，则小蓝可以拼出1 到10
但是拼11时卡片1已经只有一张了，不够拼出11
现在小蓝手里有0到9的卡片各2021 张，共 20210 张，请问小蓝可以从 1 拼到多少？
 */
public class cardQuestion {
        public static void main (String[ ] args){

            int [] a =new int [10];
            for (int i = 0; i < 10; i++) {
                a[i]=2021;

            }
            int x=1;
            while(true){

                int n=x;

                while(n>0){

                    int d=n%10;
                    if(a[d]==0){

                        System.out.println(x-1);
                        return;
                    }
                    a[d]--;

                    n/=10;

                }

                x++;

            }

}}
