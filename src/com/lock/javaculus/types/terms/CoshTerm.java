package com.lock.javaculus.types.terms;

public class CoshTerm extends Term {
    // TODO: add powers to these.
    public CoshTerm(double count) {
        super(count, 1);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.cosh(x), getPower());
    }
}
