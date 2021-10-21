package com.company.figures;

public class MyTriangle {
    private final MyPoint v1;
    private final MyPoint v2;
    private final MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        MyPoint v01 = new MyPoint(x1, y1);
        MyPoint v02 = new MyPoint(x2, y2);
        MyPoint v03 = new MyPoint(x3, y3);
        double AB = v01.distance(v02);
        double BC = v02.distance(v03);
        double AC = v03.distance(v01);
        if ((AB + BC > AC) && (AB + AC > BC) && (BC + AC > AB)) {
            this.v1 = v01;
            this.v2 = v02;
            this.v3 = v03;
        } else throw new IllegalArgumentException("Illegal points for triangle");
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        double AB = v1.distance(v2);
        double BC = v2.distance(v3);
        double AC = v3.distance(v1);
        if ((AB + BC > AC) && (AB + AC > BC) && (BC + AC > AB)) {
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
        } else throw new IllegalArgumentException("Illegal points for triangle");
    }

    public String toString() {
        return "MyTriangle [v1 = " + v1 +
                ", v2 = " + v2 +
                ", v3 = " + v3 + "]";
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        double eps = 0.0000001;
        double AB = v1.distance(v2);
        double BC = v2.distance(v3);
        double AC = v3.distance(v1);
        if ((Math.abs(AB-AC)<=eps) && (Math.abs(AC - BC)<=eps)) return "Equilateral";
        else if ((Math.abs(AB - AC)<=eps) || (Math.abs(AB - BC)<=eps) || (Math.abs(BC - AC)<=eps)) return "Isosceles";
        else return "Scalene";
    }
}
