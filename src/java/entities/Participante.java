/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Gabriel P Kreusch
 */
@Entity
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idparticipante;
    private boolean status;

    @OneToOne
    private Contato contato;

    @OneToOne
    private Compromisso compromisso;

    public Participante() {
    }

    public Participante(boolean status, Contato contato, Compromisso compromisso) {
        this.status = status;
        this.contato = contato;
        this.compromisso = compromisso;
    }

    public Participante(Long idparticipante, boolean status, Contato contato, Compromisso compromisso) {
        this.idparticipante = idparticipante;
        this.status = status;
        this.contato = contato;
        this.compromisso = compromisso;
    }

    public Long getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(Long idparticipante) {
        this.idparticipante = idparticipante;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Contato getIdcontato() {
        return contato;
    }

    public void setIdcontato(Contato idcontato) {
        this.contato = idcontato;
    }

    public Compromisso getIdcompromisso() {
        return compromisso;
    }

    public void setIdcompromisso(Compromisso idcompromisso) {
        this.compromisso = idcompromisso;
    }

    @Override
    public String toString() {
        return "Participante{" + "idparticipante=" + idparticipante + ", status=" + status + ", idcontato=" + contato + ", idcompromisso=" + compromisso + '}';
    }
}
