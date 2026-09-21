package com.itheima.dayStatic1;
    abstract class Shape {


        public abstract void getArea();
        public void showInfo() {
            System.out.println("这是一个图形");
        }
    }
    class Circle extends Shape {
        private double radius;
        public Circle() {
            this.radius = 0;
        }
        public Circle(double radius) {
            this.radius = radius;
        }
        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        @Override
        public void getArea() {
            double area = Math.PI * radius * radius;
            System.out.println("圆形的面积为：" + area);
        }

        @Override
        public void showInfo() {
            System.out.println("这是一个圆形");
        }



    }

