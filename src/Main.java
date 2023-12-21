import com.lock.javaculus.Constants;
import com.lock.javaculus.ai.Activations;
import com.lock.javaculus.ai.Learner;
import com.lock.javaculus.calculus.*;
import com.lock.javaculus.types.terms.SinTerm;

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
        Equation equation = new Equation();

        equation.addTerm(new SinTerm(2));

        EquationDerivative derivative = new EquationDerivative(equation);

        Equation deriv = derivative.getDerivativeEquation();

        System.out.println(deriv.calculateEquation(0));
    }
}
