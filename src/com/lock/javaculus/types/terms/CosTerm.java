package com.lock.javaculus.types.terms;

import com.lock.javaculus.types.terms.Term;

public class CosTerm extends Term {

    public CosTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.cos(x), getPower());
    }
}
