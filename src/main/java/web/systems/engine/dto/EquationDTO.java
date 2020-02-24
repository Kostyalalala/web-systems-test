package web.systems.engine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquationDTO {

    private Double a;
    private Double b;
    private Double c;
    private Double determinant;
    private Double firstRoot;
    private Double secondRoot;

}
