package com.lock.javaculus.types.terms;

import com.lock.javaculus.types.terms.Term;

public class CosTerm extends Term {

    public CosTerm(double count) {
        super(count, 1);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Math.cos(x), getPower());
    }
}
