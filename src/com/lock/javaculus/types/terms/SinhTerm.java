package com.lock.javaculus.types.terms;

public class SinhTerm extends Term {
    public SinhTerm(double count) {
        super(count, 1);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.sinh(x), getPower());
    }
}
