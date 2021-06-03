/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOCompromisso;
import DAO.DAOContato;
import DAO.DAOParticipante;
import entities.Compromisso;
import entities.Contato;
import entities.Participante;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gabriel P Kreusch
 */
@WebService(serviceName = "ParticipanteWS")
public class ParticipanteWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "criarParticipante")
    public boolean criarParticipante(@WebParam(name = "status") boolean status, @WebParam(name = "idcontato") long idcontato, @WebParam(name = "idcompromisso") long idcompromisso) {
    
        Contato contato = DAOContato.getByID(idcontato);
        Compromisso compromisso = DAOCompromisso.getByID(idcompromisso);
        
        Participante participante = new Participante(status, contato, compromisso);
        
        return DAOParticipante.create(participante);
    }

        /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "alteraParticipante")
    public boolean alteraParticipante(@WebParam(name = "idparticipante") long idparticipante, @WebParam(name = "status") boolean status, @WebParam(name = "idcontato") long idcontato, @WebParam(name = "idcompromisso") long idcompromisso) {
    
        Contato contato = DAOContato.getByID(idcontato);
        Compromisso compromisso = DAOCompromisso.getByID(idcompromisso);
        
        Participante participante = new Participante(idparticipante, status, contato, compromisso);
        
        return DAOParticipante.update(participante);
    }

    @WebMethod(operationName = "deleteParticipante")
    public boolean deleteParticipante(@WebParam(name = "idparticipante") long idparticipante) {
        return DAOParticipante.delete(idparticipante);
    }

    @WebMethod(operationName = "participantePorID")
    public Participante participantePorID(@WebParam(name = "idparticipante") long idparticipante) {
        return DAOParticipante.getByID(idparticipante);
    }

    @WebMethod(operationName = "listarParticipantes")
    public List<Participante> listarParticipantes() {
        return DAOParticipante.getAll();
    }
}