package com.lock.javaculus.calculus;

import com.lock.javaculus.types.terms.*;

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

            Term newTerm;

            // calculate the derivatives of special terms like sin or cos
            // TODO: add derivatives of other terms like tan, sec and cot
            // TODO: add powers to trigonometric terms.

            if (term instanceof SinTerm) {
                newTerm = new CosTerm(newCount);
            } else if (term instanceof CosTerm) {
                newTerm = new SinTerm(-newCount);
            } else if (term instanceof SinhTerm) {
                newTerm = new CoshTerm(newCount);
            } else if (term instanceof CoshTerm) {
                newTerm = new SinhTerm(newCount);
            } else {
                newTerm = new Term(newCount, newPower);
            }

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
