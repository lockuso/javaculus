package com.lock.javaculus.types.terms;

public class SinhTerm extends Term {
    public SinhTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.sinh(x), getPower());
    }
}
