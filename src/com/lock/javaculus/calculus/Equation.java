package com.lock.javaculus.calculus;

import com.lock.javaculus.types.ManyValues;
import com.lock.javaculus.types.terms.Term;

import java.util.ArrayList;

public class Equation {
    private ArrayList<Term> terms = new ArrayList<Term>();

    public Equation(ArrayList<Term> terms) {
        this.terms = terms;
    }
    public Equation() {}

    public void setTerms(ArrayList<Term> terms) {
        this.terms = terms;
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    public double calculateEquation(double x) {
        double total = 0d;

        for (Term term : this.terms) {
            total += term.calculateTerm(x);
        }

        return total;
    }

    public Equation addTerm(double count, double power) {
        this.terms.add(new Term(count, power));

        return this;
    }

    public String asString() {
        StringBuilder sb = new StringBuilder();

        for (Term term : this.terms) {
            String count = Double.toString(term.getCount());
            String power = Double.toString(term.getPower());

            if (term.getPower() == 0d) {
                sb.append(count);
                sb.append(" +/; ");
            } else {
                sb.append(term.getCount() == 1d ? "" : count);
                sb.append("x");
                sb.append(term.getPower() == 1d ? "" : "^" + power);

                sb.append(" +/; ");
            }
        }

        return sb.toString();
    }

    public Equation asIntegral() {
        Equation integral = new Equation();

        for (Term term : this.terms) {
            double newPower = term.getPower() + 1;
            double newCount = term.getCount() / newPower;

            integral.addTerm(newCount, newPower);
        }

        return integral;
    }

    public static Equation integral(Equation equation) {
        return new Equation(equation.terms).asIntegral();
    }

    public static ManyValues<Double> quadraticFormula(double a, double b, double c) {
        ManyValues<Double> values = new ManyValues<Double>();

        double squareRootComponent = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        double upperComponent1 = squareRootComponent - b;
        double upperComponent2 = squareRootComponent + b;

        values.addValue(upperComponent1 / (2 * a));
        values.addValue(upperComponent2 / (2 * a));

        return values;
    }

    public static double cubicFormula(double a, double b, double c, double d) {
        // TODO: add imaginary and other solutions to the cube roots

        double p = -b / (3 * a);
        double q = Math.pow(p, 3) + ((b * c) - (3 * a * d)) / (6 * Math.pow(a, 2));
        double r = c / (3 * a);

        double component1 = r - Math.pow(p, 2);
        double component2 = Math.pow(q, 2) + Math.pow(component1, 3);
        double component3 = Math.sqrt(component2);

        double cubeRoot1 = Math.cbrt(q + component3);
        double cubeRoot2 = Math.cbrt(q - component3);

        return cubeRoot1 + cubeRoot2 + p;
    }

    public static ManyValues<Double> bruteForceSolution(Equation equation, double h) {
        ManyValues<Double> solutions = new ManyValues<Double>();

        double oldValue = equation.calculateEquation(-5);

        for (double i = -5d; i < 5d; i += h) {
            double value = equation.calculateEquation(i);

            if (value == 0d) {
                solutions.addValue(value);
            } else {
                if ((oldValue < 0 & value > 0) | (oldValue > 0 & value < 0)) {
                    solutions.addValue((2 * i - h) / 2);
                }
            }

            oldValue = value;
        }

        return solutions;
    }
}
