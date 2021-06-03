/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOCompromisso;
import DAO.DAOContato;
import DAO.DAOLocal;
import entities.Compromisso;
import entities.Contato;
import entities.Local;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gabriel P Kreusch
 */
@WebService(serviceName = "CompromissoWS")
public class CompromissoWS {

    /**
     * Cria um Compromisso
     *
     * @param dataInicio 
     * @param dataFim 
     * @param idlocal 
     * @return Retorna um boolean indicando se o Compromisso foi criado ou não
     */
    @WebMethod(operationName = "criarCompromisso")
    public boolean criarCompromisso(@WebParam(name = "dataInicio") String dataInicio, @WebParam(name = "dataFim") String dataFim, @WebParam(name = "idlocal") long idlocal) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Local local = DAOLocal.getByID(idlocal);
        
        Compromisso compromisso = null;
        try {
            compromisso = new Compromisso(format.parse(dataInicio), format.parse(dataFim), local);
        } catch (ParseException ex) { }

        return DAOCompromisso.create(compromisso);
    }

    /**
     * Altera um Compromisso
     *
     * @param idcompromisso
     * @param dataInicio 
     * @param dataFim 
     * @param idlocal 
     * @return Retorna um boolean indicando se o Compromisso foi alterado ou não
     */
    @WebMethod(operationName = "alterarCompromisso")
    public boolean alterarCompromisso(@WebParam(name = "idcompromisso") long idcompromisso, @WebParam(name = "dataInicio") String dataInicio, @WebParam(name = "dataFim") String dataFim, @WebParam(name = "idlocal") long idlocal) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Local local = DAOLocal.getByID(idlocal);
        
        Compromisso compromisso = null;
        try {
            compromisso = new Compromisso(idcompromisso, format.parse(dataInicio), format.parse(dataFim), local);
        } catch (ParseException ex) {
            Logger.getLogger(CompromissoWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DAOCompromisso.update(compromisso);
    }
    
    /**
     * Exclui um Compromisso
     *
     * @param idcompromisso
     * @return Retorna um boolean indicando se o Compromisso foi excluido ou não
     */
    @WebMethod(operationName = "excluirCompromisso")
    public boolean excluirCompromisso(@WebParam(name = "idcompromisso") long idcompromisso) {
        return DAOCompromisso.delete(idcompromisso);
    }

    /**
     * Busca um Compromisso por ID
     *
     * @param idcompromisso
     * @return Retorna o Compromisso encontrado
     */
    @WebMethod(operationName = "compromissoPorID")
    public Compromisso compromissoPorID(@WebParam(name = "idcompromisso") long idcompromisso) {
        return DAOCompromisso.getByID(idcompromisso);
    }

    /**
     * Busca compromissos por Local
     *
     * @param idlocal
     * @return Retorna uma lista de compromissos encontrados
     */
    @WebMethod(operationName = "compromissoPorLocal")
    public List<Compromisso> compromissoPorLocal(@WebParam(name = "idlocal") long idlocal) {
        Local local = DAOLocal.getByID(idlocal);
        return DAOCompromisso.getByLocal(local);
    }

    /**
     * Busca compromissos por Contato
     *
     * @param idcontato
     * @return Retorna uma lista de compromissos encontrados
     */
    @WebMethod(operationName = "compromissoPorContato")
    public List<Compromisso> compromissoPorContato(@WebParam(name = "idcontato") long idcontato) {
       
        Contato contato = DAOContato.getByID(idcontato);
        return DAOCompromisso.getByContato(contato);
    }

    /**
     * Busca todos os compromissos no banco
     *
     * @return Retorna uma lista de compromissos encontrados
     */
    @WebMethod(operationName = "listarCompromissos")
    public List<Compromisso> listarCompromissos() {
        return DAOCompromisso.getAll();
    }
}