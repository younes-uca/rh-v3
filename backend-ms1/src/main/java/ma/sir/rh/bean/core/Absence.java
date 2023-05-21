package ma.sir.rh.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.rh.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "absence")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="absence_seq",sequenceName="absence_seq",allocationSize=1, initialValue = 1)
public class Absence   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDebut ;
    private LocalDateTime dateFinA ;
    @Column(length = 500)
    private String description;

    private TypeAbsence typeAbsence ;
    
    private Employee employee ;
    


    public Absence(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="absence_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateFinA(){
        return this.dateFinA;
    }
    public void setDateFinA(LocalDateTime dateFinA){
        this.dateFinA = dateFinA;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeAbsence getTypeAbsence(){
        return this.typeAbsence;
    }
    public void setTypeAbsence(TypeAbsence typeAbsence){
        this.typeAbsence = typeAbsence;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Employee getEmployee(){
        return this.employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return id != null && id.equals(absence.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

