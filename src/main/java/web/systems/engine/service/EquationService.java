package web.systems.engine.service;

import static web.systems.engine.dto.Transformer.TRANSFORM_TO_ENTITY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.systems.engine.db.service.EquationManager;
import web.systems.engine.dto.EquationDTO;

@Service
public class EquationService {

    private static final int TWO = 2;
    private static final int ZERO = 0;
    private static final String EQUATION_MESSAGE = "%fx + %fx + %f = 0\n%s";
    private static final String ROOTS_MESSAGE = "Root1 = %f, Root2 = %f";
    private static final String NO_ROOTS_MESSAGE = "There is no roots for this equation";

    @Autowired
    private EquationManager equationManager;

    public String getRoot(EquationDTO equation) {
        Double determinant = getDeterminant(equation.getA(), equation.getB(), equation.getC());
        equation.setDeterminant(determinant);

        Double a = equation.getA();
        Double b = equation.getB();

        Double firstRoot = null;
        Double secondRoot = null;

        if (determinant > ZERO) {
            firstRoot = (-b + Math.sqrt(determinant)) / (TWO * a);
            secondRoot = (-b - Math.sqrt(determinant)) / (TWO * a);
        }
        // Condition for real and equal roots
        else if (determinant == ZERO) {
            firstRoot = secondRoot = -b / (TWO * a);
        }
        // If roots are not real
        else {
            System.out.format(NO_ROOTS_MESSAGE);
        }
        equation.setFirstRoot(firstRoot);
        equation.setSecondRoot(secondRoot);
        
        equationManager.addEquation(TRANSFORM_TO_ENTITY(equation));
        return createEquationString(equation);
    }

    private Double getDeterminant(Double a, Double b, Double c) {
        return b * b - 4 * a * c;
    }

    private String createEquationString(EquationDTO equation) {
        return String.format(EQUATION_MESSAGE, equation.getA(), equation.getB(), equation.getC(),
                             createRootsString(equation));
    }

    private String createRootsString(EquationDTO equation) {
        return (equation.getFirstRoot() == null) ? NO_ROOTS_MESSAGE
                : String.format(ROOTS_MESSAGE, equation.getFirstRoot(), equation.getSecondRoot());
    }

}
