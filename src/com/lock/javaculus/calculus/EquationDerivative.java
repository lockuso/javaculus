package com.lock.javaculus.calculus;

import com.lock.javaculus.types.terms.Term;

import java.util.ArrayList;

public class EquationDerivative {
    private final Equation equation;

    public EquationDerivative(Equation eq) {
        this.equation = eq;
    }

    public Equation getDerivativeEquation() {
        double total = 0d;
        ArrayList<Term> newTerms = new ArrayList<Term>();

        for (Term term : this.equation.getTerms()) {
            double newPower = term.getPower() - 1;
            double newCount = term.getCount() * term.getPower();

            Term newTerm = new Term(newCount, newPower);
            newTerms.add(newTerm);
        }

        return new Equation(newTerms);
    }

    public double gradientDescent(double currentPosition, double waitingFactor) {
        // waiting factor should be between 0 and 1.

        Equation equation = getDerivativeEquation();

        return currentPosition - (waitingFactor * equation.calculateEquation(currentPosition));
    }
}
