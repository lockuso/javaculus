package com.lock.javaculus.types.terms;

public class TanTerm extends Term {
    public TanTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.tan(x), getPower());
    }
}
