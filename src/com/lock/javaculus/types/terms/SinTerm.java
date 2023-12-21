package com.lock.javaculus.types.terms;

import com.lock.javaculus.types.terms.Term;

public class SinTerm extends Term {
    public SinTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.sin(x), getPower());
    }
}
