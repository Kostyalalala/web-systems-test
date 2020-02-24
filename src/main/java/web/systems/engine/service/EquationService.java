package web.systems.engine.service;

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

    @Autowired
    private EquationManager equationManager;

    private Double getDeterminant(Double a, Double b, Double c) {
        return b * b - 4 * a * c;
    }

    public Integer resolveEquation(EquationDTO equation) {
        Double determinant = getDeterminant(equation.getA(), equation.getB(), equation.getC());
        equation.setDeterminant(determinant);
        getRoots(equation);

        EquationEntity equationEntity = TRANSFORM_TO_ENTITY(equation);
        equationManager.addEquation(equationEntity);

        return equationEntity.getId();
    }

    private void getRoots(EquationDTO equationDTO) {
        Double determinant = equationDTO.getDeterminant();

        Double a = equationDTO.getA();
        Double b = equationDTO.getB();

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

        equationDTO.setFirstRoot(firstRoot);
        equationDTO.setSecondRoot(secondRoot);
    }
}
