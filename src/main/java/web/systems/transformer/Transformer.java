package web.systems.transformer;

import web.systems.dto.EquationDTO;
import web.systems.entity.EquationEntity;

public class Transformer {
    public static EquationEntity transformToEquation(Double a, Double b, Double c) {
        EquationEntity equation = new EquationEntity();
        equation.setA(a);
        equation.setB(b);
        equation.setC(c);

        return equation;
    }

    public static EquationDTO transformToDTO(EquationEntity equationEntity) {
        EquationDTO equationDTO = new EquationDTO();
        equationDTO.setA(equationEntity.getA());
        equationDTO.setB(equationEntity.getB());
        equationDTO.setC(equationEntity.getC());
        equationDTO.setDeterminant(equationEntity.getDeterminant());
        equationDTO.setFirstRoot(equationEntity.getFirstRoot());
        equationDTO.setSecondRoot(equationEntity.getSecondRoot());
        return equationDTO;
    }

    public static EquationEntity transformToEntity(EquationDTO equationDTO) {
        EquationEntity equationEntity = new EquationEntity();
        equationEntity.setA(equationDTO.getA());
        equationEntity.setB(equationDTO.getB());
        equationEntity.setC(equationDTO.getC());
        equationEntity.setDeterminant(equationDTO.getDeterminant());
        equationEntity.setFirstRoot(equationDTO.getFirstRoot());
        equationEntity.setSecondRoot(equationDTO.getSecondRoot());
        return equationEntity;
    }
}
