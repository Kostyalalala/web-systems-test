package web.systems.engine.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "equations")
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
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

}