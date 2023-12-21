package com.lock.javaculus.types.terms;

public class LnTerm extends Term {
    public LnTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.log(x), getPower());
    }
}
