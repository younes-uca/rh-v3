package ma.sir.rh.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.rh.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "payement_salaire")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payement_salaire_seq",sequenceName="payement_salaire_seq",allocationSize=1, initialValue = 1)
public class PayementSalaire   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private Integer mois = 0;
    private Integer annee = 0;
    private BigDecimal salaire = BigDecimal.ZERO;
    private Integer nombreJoursConge = 0;
    private Integer nombreJoursAbsence = 0;
    private BigDecimal baisseSalaire = BigDecimal.ZERO;
    private BigDecimal salaireFinal = BigDecimal.ZERO;

    private Employee employee ;
    


    public PayementSalaire(){
        super();
    }

    public PayementSalaire(Long id,String code){
        this.id = id;
        this.code = code ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payement_salaire_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Employee getEmployee(){
        return this.employee;
    }
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    public BigDecimal getSalaire(){
        return this.salaire;
    }
    public void setSalaire(BigDecimal salaire){
        this.salaire = salaire;
    }
    public Integer getNombreJoursConge(){
        return this.nombreJoursConge;
    }
    public void setNombreJoursConge(Integer nombreJoursConge){
        this.nombreJoursConge = nombreJoursConge;
    }
    public Integer getNombreJoursAbsence(){
        return this.nombreJoursAbsence;
    }
    public void setNombreJoursAbsence(Integer nombreJoursAbsence){
        this.nombreJoursAbsence = nombreJoursAbsence;
    }
    public BigDecimal getBaisseSalaire(){
        return this.baisseSalaire;
    }
    public void setBaisseSalaire(BigDecimal baisseSalaire){
        this.baisseSalaire = baisseSalaire;
    }
    public BigDecimal getSalaireFinal(){
        return this.salaireFinal;
    }
    public void setSalaireFinal(BigDecimal salaireFinal){
        this.salaireFinal = salaireFinal;
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
        PayementSalaire payementSalaire = (PayementSalaire) o;
        return id != null && id.equals(payementSalaire.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

