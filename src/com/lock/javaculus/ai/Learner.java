package com.lock.javaculus.ai;

import com.lock.javaculus.Constants;
import com.lock.javaculus.calculus.FunctionDerivative;
import com.lock.javaculus.calculus.Equation;
import com.lock.javaculus.calculus.EquationDerivative;
import com.lock.javaculus.calculus.IFunction;

import java.util.HashMap;

public class Learner {
    private HashMap<String, Integer> flags = new HashMap<String, Integer>();

    private double learningRate;
    private double iterations;

    public Learner() {
        flags.put("learningRate", Constants.JC_NULL);
        flags.put("iterations", Constants.JC_NULL);
    }

    public Learner enable(int flag, String attribute) {
        flags.put(attribute, flag);

        return this;
    }

    public Learner disable(int flag, String attribute) {
        flags.put(attribute, Constants.JC_NULL);

        return this;
    }

    public Learner setIterations(double iterations) {
        this.iterations = iterations;

        return this;
    }

    public Learner setLearningRate(double learningRate) {
        this.learningRate = learningRate;

        return this;
    }

    public double getIterations() {
        return iterations;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public double gradientDescent(Equation equation, double currentValue) {
        EquationDerivative derivative = new EquationDerivative(equation);

        if (flags.get("learningRate") == Constants.JC_AUTOFILL) {
            learningRate = 0.05;
        } else if (flags.get("iterations") == Constants.JC_AUTOFILL) {
            iterations = 15;
        }

        double newCoord = currentValue;

        for (int i = 0; i < iterations; i++) {
            newCoord = derivative.gradientDescent(newCoord, learningRate);
        }

        return newCoord;
    }

    public double gradientDescent(Equation equation) {
        return gradientDescent(equation, Math.random());
    }

    public double gradientDescent(IFunction function, double currentValue) {
        FunctionDerivative derivative = new FunctionDerivative(function);

        if (flags.get("learningRate") == Constants.JC_AUTOFILL) {
            learningRate = 0.05;
        } else if (flags.get("iterations") == Constants.JC_AUTOFILL) {
            iterations = 15;
        }

        double newCoord = currentValue;

        for (int i = 0; i < iterations; i++) {
            newCoord = derivative.gradientDescent(newCoord, learningRate);
        }

        return newCoord;
    }

    public double gradientDescent(IFunction function) {
        return gradientDescent(function, Math.random());
    }
}
