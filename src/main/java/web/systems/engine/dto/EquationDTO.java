package web.systems.engine.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquationDTO {

    private Double a;
    private Double b;
    private Double c;
    private Double determinant;
    private Double firstRoot;
    private Double secondRoot;

}
