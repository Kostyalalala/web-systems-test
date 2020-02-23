package web.systems.engine.dto;

public class EquationDTO {

    private Double a;
    private Double b;
    private Double c;
    private Double determinant;
    private Double firstRoot;
    private Double secondRoot;

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getDeterminant() {
        return determinant;
    }

    public void setDeterminant(Double determinant) {
        this.determinant = determinant;
    }

    public Double getFirstRoot() {
        return firstRoot;
    }

    public void setFirstRoot(Double firstRoot) {
        this.firstRoot = firstRoot;
    }

    public Double getSecondRoot() {
        return secondRoot;
    }

    public void setSecondRoot(Double secondRoot) {
        this.secondRoot = secondRoot;
    }
}
