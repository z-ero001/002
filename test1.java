/*读取两个整数 a（行数）和 b（每行字符数），
然后按 a 行 b 列的格式循环输出 "2025" 字符串，
且每行的起始字符会随行数偏移*/

package com.itheima.dayStatic1;
import java.util.Scanner;

    public class test1 {
    public static void main(String[] args){
        //只创建一个Scanner 对象，节省资源
        Scanner sc = new Scanner(System.in);

        int a=sc.nextInt();
        //   sc.nextInt()读取单个字符串（遇到空格 / 回车就停止）
        /*   sc.nextLine()：读取整行字符串（包含空格，按回车结束）
             sc.nextInt()：读取整数（int 类型）
             sc.nextDouble()：读取小数（double 类型）
              sc.nextBoolean()：读取布尔值（true/false）*/
        int  b=sc.nextInt();

        //正确初始化字符数组（存储"2","0","2","5"）
        String [] arr={"2", "0", "2", "5"};
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out .print(arr[ (i+j) % 4] );
            }
            System.out.println();
        }


        sc.close();
    }


}
