package mx.utng.s26.model.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String name;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String carrera;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String paraEscolar;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String grupo;

    @Temporal(TemporalType.DATE)
    private Date recordAt;

    @PrePersist
    public void PrePersist(){
        recordAt = new Date();
    }


    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getRecordAt() {
        return recordAt;
    }
    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getCarrera() {
        return carrera;
    }
    public String getGrupo() {
        return grupo;
    }
    public String getParaEscolar() {
        return paraEscolar;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public void setParaEscolar(String paraEscolar) {
        this.paraEscolar = paraEscolar;
    }
}
