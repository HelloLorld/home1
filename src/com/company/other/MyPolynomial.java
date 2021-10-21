package com.company.other;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double ... coeffs) {
        this.coeffs = new double[coeffs.length];
        this.coeffs = coeffs.clone();
    }

    public int getDegree() {
        return coeffs.length-1;
    }

    public String toString() {
        StringBuilder polynom = new StringBuilder();
        for (int i = coeffs.length-1;i>=0;i--) {
            if (i==0) polynom.append(coeffs[i]);
            else {
                if(coeffs[i]<0) polynom.append("(");
                polynom.append(coeffs[i]);
                if(coeffs[i]<0) polynom.append(")");
                polynom.append("*");
                polynom.append("x^");
                polynom.append(i);
                polynom.append("+");
            }
        }
        return polynom.toString();
    }
    public double evaluate(double x) {
        double res = 0;
        for (int i = coeffs.length-1;i>=0;i--) {
            if (i == 0) res+= coeffs[i];
            else
            res+=coeffs[i]*Math.pow(x,i);
        }
        return res;
    }

    public MyPolynomial add (MyPolynomial right) {
        double[] ourCoeffs = this.coeffs.clone();
        double[] rigthCoeffs = right.coeffs.clone();
        if (ourCoeffs.length>=rigthCoeffs.length) {
            for(int i = 0;i<rigthCoeffs.length;i++)
                ourCoeffs[i]+=rigthCoeffs[i];
        }
        else {
            for(int i = 0;i<ourCoeffs.length;i++)
                rigthCoeffs[i]+=ourCoeffs[i];
        }
        if (ourCoeffs.length>=rigthCoeffs.length) return new MyPolynomial(ourCoeffs);
        else return new MyPolynomial(rigthCoeffs);
    }
    public MyPolynomial multiply(MyPolynomial right) {
        double[] newCoeffs;
        newCoeffs= new double[this.getDegree()+right.getDegree()+1];
        for (int i = this.coeffs.length-1;i>=0;i--)
            for(int j = right.coeffs.length-1;j>=0;j--)
            {
                newCoeffs[i+j] += coeffs[i]*right.coeffs[j];
            }
        return new MyPolynomial(newCoeffs);
    }
}
