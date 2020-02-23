package web.systems.transformer;

import web.systems.entity.EquationEntity;

public class Transformer {
    public EquationEntity transformToEquation(Double a, Double b, Double c) {
        EquationEntity equation = new EquationEntity();
        equation.setA(a);
        equation.setB(b);
        equation.setC(c);

        return equation;
    }
}
