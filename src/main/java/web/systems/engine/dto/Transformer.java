package web.systems.engine.dto;

import web.systems.engine.db.entity.EquationEntity;

public class Transformer {
    public static EquationEntity TRANSFORM_TO_EQUATION(Double a, Double b, Double c) {
        return EquationEntity.builder().a(a).b(b).c(c).build();
    }

    public static EquationDTO TRANSFORM_TO_DTO(EquationEntity equationEntity) {
        return EquationDTO.builder()
            .a(equationEntity.getA())
            .b(equationEntity.getB())
            .c(equationEntity.getC())
            .determinant(equationEntity.getDeterminant())
            .firstRoot(equationEntity.getFirstRoot())
            .secondRoot(equationEntity.getSecondRoot())
            .build();
    }

    public static EquationEntity TRANSFORM_TO_ENTITY(EquationDTO equationDTO) {
        return EquationEntity.builder()
            .a(equationDTO.getA())
            .b(equationDTO.getB())
            .c(equationDTO.getC())
            .determinant(equationDTO.getDeterminant())
            .firstRoot(equationDTO.getFirstRoot())
            .secondRoot(equationDTO.getSecondRoot())
            .build();
    }
}
