package com.lock.javaculus.types.complex;

public class ComplexNumber {
    // number with form a + ib

    private double realComponent;
    private double imaginaryComponent;

    public ComplexNumber(double realComponent, double imaginaryComponent) {
        this.realComponent = realComponent;
        this.imaginaryComponent = imaginaryComponent;
    }

    public ComplexNumber() {
        this.realComponent = 0d;
        this.imaginaryComponent = 0d;
    }

    public double getRealComponent() {
        return realComponent;
    }

    public double getImaginaryComponent() {
        return imaginaryComponent;
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.realComponent);
        sb.append(" + ");
        sb.append(this.imaginaryComponent);
        sb.append("i");

        return sb.toString();
    }

    public void add1d(double realNumber) {
        realComponent += realNumber;
    }

    public void add1d_i(double imaginaryNumber) {
        imaginaryComponent += imaginaryNumber;
    }

    public void add1c(ComplexNumber complexNumber) {
        realComponent += complexNumber.getRealComponent();
        imaginaryComponent += complexNumber.getImaginaryComponent();
    }

    public void mul1d(double realNumber) {
        realComponent *= realNumber;
        imaginaryComponent *= realNumber;
    }

    public void mul1d_i(double imaginaryNumber) {
        double i1 = realComponent * imaginaryNumber;
        double r1 = -(imaginaryComponent * imaginaryNumber);

        imaginaryComponent = i1;
        realComponent = r1;
    }

    public void mul1c(ComplexNumber complexNumber) {
        ComplexNumber c1 = this;
        ComplexNumber c2 = this;

        c1.mul1d(complexNumber.getRealComponent());
        c2.mul1d_i(complexNumber.getImaginaryComponent());

        c1.add1c(c2);

        realComponent = c1.getRealComponent();
        imaginaryComponent = c2.getImaginaryComponent();
    }
}
