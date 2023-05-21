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
@Table(name = "pointage")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="pointage_seq",sequenceName="pointage_seq",allocationSize=1, initialValue = 1)
public class Pointage   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private LocalDateTime heureArrive ;
    private LocalDateTime heureSortie ;
    private Integer tempsRetard = 0;

    private Employee employee ;
    


    public Pointage(){
        super();
    }

    public Pointage(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="pointage_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public LocalDateTime getHeureArrive(){
        return this.heureArrive;
    }
    public void setHeureArrive(LocalDateTime heureArrive){
        this.heureArrive = heureArrive;
    }
    public LocalDateTime getHeureSortie(){
        return this.heureSortie;
    }
    public void setHeureSortie(LocalDateTime heureSortie){
        this.heureSortie = heureSortie;
    }
    public Integer getTempsRetard(){
        return this.tempsRetard;
    }
    public void setTempsRetard(Integer tempsRetard){
        this.tempsRetard = tempsRetard;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Employee getEmployee(){
        return this.employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointage pointage = (Pointage) o;
        return id != null && id.equals(pointage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

