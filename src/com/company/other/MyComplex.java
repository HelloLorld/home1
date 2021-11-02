package com.company.other;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        if (imag<0) return "("+real+imag+"i)";
        return "(" + real + "+" + imag + "i)";
    }

    public boolean isReal() {
        if (real == 0) return false;
        else return true;
    }

    public boolean isImaginary() {
        if (imag == 0) return false;
        else return true;
    }

    public boolean equals(double real, double imag) {
        double eps = 0.0000001;
        if ((Math.abs(this.real - real) <= eps)
                && (Math.abs(this.imag - imag) <= eps)) return true;
        else return false;
    }

    public boolean equals(MyComplex another) {
        double eps = 0.0000001;
        if ((Math.abs(this.real - another.getReal()) <= eps)
                && (Math.abs(this.imag - another.getImag()) <= eps)) return true;
        else return false;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(real + right.getReal(), imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        double newReal = real * right.real - imag * right.imag;
        double newImag = real * right.imag + right.real * imag;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double denominator = Math.pow(right.real,2)+Math.pow(right.real,2);
        double newReal = (real* right.real+ imag* right.imag)/denominator;
        double newImag = (right.real*imag-real* right.imag)/denominator;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex complex = (MyComplex) o;

        if (Double.compare(complex.real, real) != 0) return false;
        return Double.compare(complex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
