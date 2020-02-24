package web.systems.engine.service;

import static web.systems.engine.dto.Transformer.TRANSFORM_TO_DTO;
import static web.systems.engine.dto.Transformer.TRANSFORM_TO_ENTITY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.systems.engine.db.entity.EquationEntity;
import web.systems.engine.db.service.EquationManager;
import web.systems.engine.dto.EquationDTO;

@Service
public class EquationService {

    private static final int TWO = 2;
    private static final int ZERO = 0;
    private static final String EQUATION_MESSAGE = "%.2fx + %.2fx + %.2f = 0;\n\n%s";
    private static final String ROOTS_MESSAGE = "Root1 = %.2f, Root2 = %.2f";
    private static final String NO_ROOTS_MESSAGE = "There is no roots for this equation";

    @Autowired
    private EquationManager equationManager;

    private Double getDeterminant(Double a, Double b, Double c) {
        return b * b - 4 * a * c;
    }

    public Integer getRoot(EquationDTO equation) {
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

        EquationEntity equationEntity = TRANSFORM_TO_ENTITY(equation);
        equationManager.addEquation(equationEntity);

        return equationEntity.getId();
    }

    public EquationDTO getById(Integer id) {
        return TRANSFORM_TO_DTO(equationManager.getById(id));
    }

    public String createEquationString(EquationDTO equation) {
        return String.format(EQUATION_MESSAGE, equation.getA(), equation.getB(), equation.getC(),
                             createRootsString(equation));
    }

    private String createRootsString(EquationDTO equation) {
        return (equation.getFirstRoot() == null) ? NO_ROOTS_MESSAGE
                : String.format(ROOTS_MESSAGE, equation.getFirstRoot(), equation.getSecondRoot());
    }

}
