package web.systems.engine.service;

import static web.systems.engine.dto.Transformer.TRANSFORM_TO_DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.systems.engine.db.service.EquationManager;
import web.systems.engine.dto.EquationDTO;

@Service
public class EquationResultService {
    @Autowired
    private EquationManager equationManager;

    private static final String EQUATION_MESSAGE = "%.2fx + %.2fx + %.2f = 0;\n\n%s";
    private static final String ROOTS_MESSAGE = "Root1 = %.2f, Root2 = %.2f";
    private static final String NO_ROOTS_MESSAGE = "There is no roots for this equation";

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
