import com.lock.javaculus.Constants;
import com.lock.javaculus.ai.Activations;
import com.lock.javaculus.ai.Learner;
import com.lock.javaculus.calculus.*;

import java.util.ArrayList;

public class Main {

    static class CubicFunction implements IFunction {
        public static final CubicFunction THIS = new CubicFunction();

        @Override
        public double fun(double in) {
            return Math.pow(in, 3) - 3 * Math.pow(in, 1);
        }
    }

    public static void main(String[] args) {
        /*
        ArrayList<Term> terms = new ArrayList<Term>();

        terms.add(new Term(1, 3));
        terms.add(new Term(-3, 1)); //

        // 3x^2 - 3

        Equation equation = new Equation(terms);
        EquationDerivative derivative = new EquationDerivative(equation);

        Equation derivativeEquation = derivative.getDerivativeEquation();

        System.out.println(derivativeEquation.calculateEquation(2));
         */

        Equation equation = new Equation();

        equation.addTerm(1, 3)
                .addTerm(-3, 1);

        /*

        Learner learner = new Learner();

        learner.enable(Constants.JC_AUTOFILL, "learningRate")
                .setIterations(100);

         */

        Integral integral = new Integral(8);

        integral.setCurrentFunction(equation);
        try {
            System.out.println(integral.calculateDefiniteIntegral(1, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        integral.setCurrentFunction(Constants.JC_NULL_EQUATION);
    }
}
