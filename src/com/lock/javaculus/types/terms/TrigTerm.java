package com.lock.javaculus.types.terms;

import java.util.ArrayList;

public class TrigTerm extends Term {
    private ArrayList<Term> terms;

    public TrigTerm(double count) {
        super(count, 1);

        this.terms = new ArrayList<>();
    }

    // contains multiple trigonometric terms

    public void addTerm(Term term) {
        terms.add(term);
    }

    public static TrigTerm sinPowerDerivative(double count, double power) {
        TrigTerm term = new TrigTerm(1);

        if (power > 1 | power < 1) {
            double newCount = count * power;
            double newPower = power - 1;

            term.addTerm(new CosTerm(newCount));
            term.addTerm(new SinTerm(1, newPower));
        } else if (power == 1) {
            term.addTerm(new CosTerm(count));
        }

        return term;
    }

    public static TrigTerm cosPowerDerivative(double count, double power) {
        TrigTerm term = new TrigTerm(1);

        if (power > 1) {
            double newCount = count * power;
            double newPower = power - 1;

            term.addTerm(new SinTerm(-newCount));
            term.addTerm(new CosTerm(1, newPower));
        } else if (power == 1) {
            term.addTerm(new SinTerm(count));
        }

        return term;
    }

    public double calculateTerm(double x) {
        double total = terms.get(0).calculateTerm(x);

        for (int i = 1; i < terms.size(); i++) {
            total *= terms.get(i).calculateTerm(x);
        }

        return total;
    }
}
