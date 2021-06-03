/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOContato;
import entities.Contato;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gabriel P Kreusch
 */
@WebService(serviceName = "ContatoWS")
public class ContatoWS {

    /**
     * Cria um contato
     *
     * @param contato
     * @return Retorna um boolean indicando se o Contato foi criado ou não
     */
    @WebMethod(operationName = "criarContato")
    public boolean criarContato(@WebParam(name = "nome") String nome, @WebParam(name = "fone") String fone, @WebParam(name = "email") String email) {

        Contato contato = new Contato(nome, fone, email);
        return DAOContato.create(contato);
    }

    /**
     * Altera um contato
     *
     * @return Retorna um boolean indicando se o Contato foi alterado ou não
     */
    @WebMethod(operationName = "alterarContato")
    public boolean alterarContato(@WebParam(name = "idcontato") long idcontato, @WebParam(name = "nome") String nome, @WebParam(name = "fone") String fone, @WebParam(name = "email") String email) {

        Contato contato = new Contato(idcontato, nome, fone, email);
        return DAOContato.update(contato);
    }

    /**
     * Exclui um contato
     *
     * @param idcontato
     * @return Retorna um boolean indicando se o Contato foi excluido ou não
     */
    @WebMethod(operationName = "excluirContato")
    public boolean excluirContato(@WebParam(name = "idcontato") long idcontato) {
        return DAOContato.delete(idcontato);
    }

    /**
     * Busca um contato por ID
     *
     * @param idcontato
     * @return Retorna o Contato encontrado
     */
    @WebMethod(operationName = "contatoPorID")
    public Contato contatoPorID(@WebParam(name = "idcontato") long idcontato) {
        return DAOContato.getByID(idcontato);
    }

    /**
     * Busca contatos por nome
     *
     * @param nome
     * @return Retorna uma lista de contatos encontrados
     */
    @WebMethod(operationName = "contatoPorNome")
    public List<Contato> contatoPorNome(@WebParam(name = "nome") String nome) {
        return DAOContato.getByName(nome);
    }

    /**
     * Busca todos os contatos no banco
     *
     * @return Retorna uma lista de contatos encontrados
     */
    @WebMethod(operationName = "listarContatos")
    public List<Contato> listarContatos() {
        return DAOContato.getAll();
    }
}
