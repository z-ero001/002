package com.itheima.dayStatic1;

public class Student {
    //属性：姓名，年龄，性别
    //新增：老师的姓名

    private String name;
    private int age;
    private String gender;
    public static String teacher;



    public Student() {
    }
    public Student (String name ,int age ,String gendet ){
            this.name=name;
            this.age=age;
            this.gender=gendet;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    //行为
    public void study(){
        System.out .println(name+"is studying.");
    }

    public void show(){
        System.out.println(name+"'"+age+"'"+gender+"'"+teacher);
    }

}
