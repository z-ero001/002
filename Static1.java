package com.itheima.dayStatic1;

//static 表示静态。是java中的一个修饰符，可以修饰成员方法，成员变量
//被static 修饰的成员变量，叫做静态变量。
//特点：别该类所有对象共享

//不属于对象看，属于类。
//随着类的加载而加载，优先与对象存在；
//类名调用（推荐），对象名调用；


//被static 修饰的成员方法，叫做静态方法。







public class Static1 {
    public static void main(String[] args){
        //创建第一个学生对象
        Student s1=new Student();
        s1.setName("<UNK>");
        s1.setAge(20);
        s1.setGender("男");
       // s1.teacher="laoshi";

        //静态可以直接用类名调用

        Student.teacher="laoshi";

        s1.show();
        s1.study();




        Student s2=new Student();
        s2.setName("哇嘎");
        s2.setAge(25);
        s2.setGender("男");

        s2.show();
        s2.study();
    }

}
