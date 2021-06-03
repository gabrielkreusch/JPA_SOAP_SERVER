/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Gabriel P Kreusch
 */
@Entity
@Table(name = "compromisso")
public class Compromisso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcompromisso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;

    @CascadeOnDelete
    @OneToMany(mappedBy = "compromisso", cascade = CascadeType.ALL)
    private List<Participante> participantes;

    @ManyToOne
    @JoinColumn(name = "idlocal", referencedColumnName = "idlocal", nullable = true)
    private Local local;

    public Compromisso() {
    }

    public Compromisso(Date dataInicio, Date dataFim, Local local) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
    }

    public Compromisso(Long idcompromisso, Date dataInicio, Date dataFim, Local local) {
        this.idcompromisso = idcompromisso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
    }

    public Long getIdcompromisso() {
        return idcompromisso;
    }

    public void setIdcompromisso(Long idcompromisso) {
        this.idcompromisso = idcompromisso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Compromisso{" + "idcompromisso=" + idcompromisso + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", participantes=" + participantes + ", local=" + local + '}';
    }
}