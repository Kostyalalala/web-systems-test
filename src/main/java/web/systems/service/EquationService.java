package web.systems.service;

import static web.systems.transformer.Transformer.transformToEquation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.systems.entity.EquationEntity;

@Service
public class EquationService {

    @Autowired
    private EquationManager equationManager;

    public String getRoot(Double a, Double b, Double c) {
        EquationEntity equation = transformToEquation(a, b, c);
        Double determinant = getDeterminant(a, b, c);
        equation.setDeterminant(determinant);

        if (determinant > 0) {
            equation.setFirstRoot((-b + Math.sqrt(determinant)) / (2 * a));
            equation.setSecondRoot((-b - Math.sqrt(determinant)) / (2 * a));
        }
        // Condition for real and equal roots
        else if (determinant == 0) {

            Double root = -b / (2 * a);
            equation.setFirstRoot(root);
            equation.setSecondRoot(root);
        }
        // If roots are not real
        else {
            System.out.format("There is no roots for this equation");
        }
        equationManager.addEmployee(equation);
        return createEquationString(equation);
    }

    private Double getDeterminant(Double a, Double b, Double c) {
        return b * b - 4 * a * c;
    }

    private String createEquationString(EquationEntity equation) {
        return String.format("%fx + %fx + %f = 0\n%s", equation.getA(), equation.getB(), equation.getC(),
                             createRootsString(equation));
    }

    private String createRootsString(EquationEntity equation) {
        return (equation.getFirstRoot() == null) ? "There is no roots for this equation"
                : String.format("Root1 = %f, Root2 = %f", equation.getFirstRoot(), equation.getSecondRoot());
    }

    public void setEquationManager(EquationManager equationManager) {
        this.equationManager = equationManager;
    }

}
