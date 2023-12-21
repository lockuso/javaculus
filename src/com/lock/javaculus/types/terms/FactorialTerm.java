package com.lock.javaculus.types.terms;

import com.lock.javaculus.usuals.Factorial;

public class FactorialTerm extends Term {
    public FactorialTerm(double count, double power) {
        super(count, power);
    }

    @Override
    public double calculateTerm(double x) {
        return getCount() * Math.pow(Factorial.recursiveFactoriald(x), getPower());
    }
}
