package com.itheima.dayStatic1;

class SolarTerm{
    int year;
    int month;
    int day;

    String majorSoar;//节气（每个月的第一个节气）
    String minarSolor;//中气（每个月的第一个节气）
    int dayOfMajor;
    int dayOfMinor;
    //所有节气数组
    String [] majorSolarArr= {"","小寒","立春","惊蛰","清明","立夏","芒种","小暑","立秋",
    "白露","寒露","立冬","大雪"};
    //所有中气数组
    String [] minorSolorArr={"","大寒","雨水","春分","谷雨","小满","夏至","大暑",
            "处暑","秋分","霜降","小雪","冬至"};
    //getter,setter
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year=year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    //构造方法
    public SolarTerm(){}
    public SolarTerm(int year){
        this.year=year;
        int month=1;
        setYearOfThousand();
        while(true){
            this.month=month;
            setDay();
            if(month<10){
                System.out.print(getYear()+"年 0"+getMonth()
                        +"月"+getDayOfMajor()+"日为"+getMajorSolars()+"");
                System.out.println(getYear()+"年0"+getMonth()
                        +"月"+getDayOfMinor()+ "日为"+getMinorSolars());
            }
            else{
                System.out.print(getYear()+"年"+getMonth()+
                        "月"+getDayOfMajor()+"日为"+getMajorSolars()+"");
                System.out.println(getYear()+"年0"+getMonth()
                        +"月"+getDayOfMinor()+ "日为"+getMinorSolars());
            }
            month++;
            if(month>12){
                break;
            }
        }}
        public SolarTerm(int year,int month){
            this(year);
            this.month=month;
        }
        public SolarTerm(int  year,int month,int day){
            this(year,month);
            this.day=day;
        }
        //年份的千位
        int yearOfThousand =0;
        int yearOfHundred=0;
        int yearOfTen=0;
        int yearOfBit=0;

    int yearOfTemp;

    public void setYearOfBit() {
        yearOfTemp = getYear();
        yearOfBit = getYear() % 10;
        yearOfTemp /= 10;
    }

    public void setYearOfTen() {
        setYearOfBit();
        yearOfTen = yearOfTemp % 10;
        yearOfTemp /= 10;
    }

    public void setYearOfHundred() {
        setYearOfTen();
        yearOfHundred = yearOfTemp % 10;
        yearOfTemp /= 10;
    }

    public void setYearOfThousand() {
        setYearOfHundred();;
        yearOfThousand = yearOfTemp % 10;
        yearOfTemp /= 10;
    }

    public int getYearOfThousand() {
        return yearOfThousand;
    }

    public int getYearOfHundred() {
        return yearOfHundred;
    }

    public int getYearOfTen() {
        return yearOfTen;
    }

    public int getYearOfBit() {
        return yearOfBit;
    }

    public int getYearOfTemp() {
        return yearOfTemp;
    }

    public void setDay() {
        //[Y×D + C] − L, Y = 年代数的后 2 位、D = 0.2422、L = 闰年数、C 取决于节气和年份
        double c = 0;
        double d = 0.2422;
        int l = 0;
        //得到年份后两位
        int y = getYearOfTen() * 10 + getYearOfBit();
        //此处只计算 21 世纪的二十四节气,设定月份对应节气的 C 值
        double majorSolarValues[] = {0.0, 5.4055, 3.87, 5.63, 4.81, 5.52, 5.678, 7.108, 7.5, 7.646, 8.318, 7.438, 7.18};
        c = majorSolarValues[month];
        //1月,2月农历属于上一年
        if(month < 3) {
            l = (int)((y - 1) / 4);
        }
        else {
            l = (int)(y / 4);
        }
        dayOfMajor = (int) (y * d + c) - 1;
        if (getMonth() == 1 && y == 19)
            dayOfMajor -= 1;
        if (getMonth() == 7 && y == 16)
            dayOfMajor += 1;
        if (getMonth() == 8 && y == 02)
            dayOfMajor += 1;
        if (getMonth() == 11 && y == 89)
            dayOfMajor += 1;

        //此处只计算21世纪的二十四节气,设定月份对应中气的C值
        double minorSolarValues[] = {0.0, 5.4055, 3.87, 5.63, 4.81, 5.52, 5.678, 7.108, 7.5, 7.646, 8.318, 7.438, 7.18};
        c = minorSolarValues[month];
        //1月,2月农历属于上一年
        if(month < 3) {
            l = (int) ((y - 1) / 4);
        } else {
            l = (int) (y / 4);
        }

        dayOfMinor = (int) (y * d + c) - 1;
        if (getMonth() == 1 && y == 82)
            dayOfMinor += 1;
        if (getMonth() == 2 && y == 26)
            dayOfMinor -= 1;
        if (getMonth() == 5 && y == 8)
            dayOfMinor += 1;
        if (getMonth() == 10 && y == 89)
            dayOfMinor += 1;
    }

    public int getDayOfMajor() {
        return dayOfMajor;
    }

    public int getDayOfMinor() {
        return dayOfMinor;
    }

    public String getMajorSolars() {
        majorSoar = majorSolarArr[month];
        return majorSoar;
    }

    public String getMinorSolars() {
        minarSolor = minorSolorArr[month];
        return minarSolor;
    }


    }




public class solarTerms {
    public static void main(String[] args) {

        SolarTerm solarTerms = new SolarTerm(2022);
    }

}
