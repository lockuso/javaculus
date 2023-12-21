package com.lock.javaculus.types.terms;

public class CoshTerm extends Term {
    public CoshTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.cosh(x), getPower());
    }
}
