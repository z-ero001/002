package com.itheima.dayStatic1;

import java.util.Scanner;

public class TestA {
  public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      int []arr =new int[10];

       for(int i=0;i<arr.length;i++){
           arr[i]=sc.nextInt();
System.out.println(arr[i]+" -");
      }
  }
}
