package com.lock.javaculus.types.terms;

public class TanhTerm extends Term {
    public TanhTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.tanh(x), getPower());
    }
}
