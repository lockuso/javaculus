package com.lock.javaculus.types.terms;

public class Term {
    private double count;
    private double power;

    public Term(double count, double power) {
        this.count = count;
        this.power = power;
    }

    public double getCount() {
        return count;
    }

    public double getPower() {
        return power;
    }

    public double calculateTerm(double x) {
        return count * (Math.pow(x, this.power));
    }
}
