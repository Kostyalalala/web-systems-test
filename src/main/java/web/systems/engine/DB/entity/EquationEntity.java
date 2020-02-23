package web.systems.engine.DB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equations")
public class EquationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double a;
    private Double b;
    private Double c;
    private Double determinant;
    private Double firstRoot;
    private Double secondRoot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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