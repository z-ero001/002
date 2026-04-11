package com.itheima.dayStatic1;

import java.util.Arrays;
import java.util.Scanner;

public class shitang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int q = scan.nextInt();
        while(q!=0){
            q--;
            int a2=scan.nextInt();
            int a3=scan.nextInt();
            int a4=scan.nextInt();
            int b4=scan.nextInt();
            int b6=scan.nextInt();
            int sum=0;
            //分配6桌分配给3人寝室,3人寝为奇数时剩下一个；若(2*b6>a3)6人桌剩余，a3为0或1；若(2*b6<a3)前3人寝室剩余,b6==0;
            while(a3>1 && b6>0){
                a3-=2;b6--;sum+=6;
            }
            //将剩余的6人桌拆分给2人寝室，剩下的当作4人桌；若(b6>a2)6人桌剩余,a2为0；若(b6<a2)2人寝室剩余,b6==0;
            while(a2>0 && b6>0){
                a2--;b6--;b4++;sum+=2;
            }
            //若6人桌还有剩余，分给4人寝室；若(b6>a4)6人桌剩余，a4为0；若(b6<a4),b6==0;
            while(a4>0 && b6 > 0){
                a4--;b6--;sum+=4;
            }
            //若6人桌还有剩余，分给可能剩余一个的a3,则所有寝室分完，结束
            while(b6>0 && a3>0){
                b6--;a3--;sum+=3;
            }
            //将4人桌分给4人寝室;若(b4>a4)4人桌剩余，a4==0;(b4<a4)4人寝室剩余,b4==0，没桌子，结束;
            while(a4>0 && b4>0){
                a4--;b4--;sum+=4;
            }
            //将剩余的4人桌分给2人寝,当2人寝室为奇数时剩下一个;若(2*b4>a2)4人桌剩余,a2为1或0;若(2*b4<a2)2人寝剩余,没桌子，结束
            while(a2>1 && b4>0){
                a2-=2;b4--;sum+=4;
            }
            //将剩余的4人桌子分给剩余的3人寝室;若(b4>a3)4人桌剩余a3==0;若(b4<a3)3人寝室剩余，没桌子，结束
            while(a3>0 && b4>0){
                a3--;b4--;sum+=3;
            }
            //将剩余的4人桌分给可能剩余的a2;a2==0,分配完毕
            while(b4>0 && a2>0){
                b4--;a2--;sum+=2;
            }
            System.out.println(sum);

        }
        scan.close();
    }

    }

