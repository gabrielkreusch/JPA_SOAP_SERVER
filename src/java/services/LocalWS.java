/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import DAO.DAOLocal;
import entities.Local;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gabriel P Kreusch
 */
@WebService(serviceName = "LocalWS")
public class LocalWS {

    /**
     * Cria um Local
     * 
     * @param descricao
     * @param rua
     * @param bairro
     * @param cidade
     * @param numero
     * @param cep
     * @return 
     */
    @WebMethod(operationName = "criarLocal")
    public boolean criarLocal(@WebParam(name = "descricao") String descricao, @WebParam(name = "rua") String rua, @WebParam(name = "bairro") String bairro, @WebParam(name = "cidade") String cidade, @WebParam(name = "numero") String numero, @WebParam(name = "cep") String cep) {
        
        Local local = new Local(descricao, rua, bairro, cidade, numero, cep);
        return DAOLocal.create(local);
    }

        @WebMethod(operationName = "alterarLocal")
    public boolean alterarLocal(@WebParam(name = "idlocal") long idlocal, @WebParam(name = "descricao") String descricao, @WebParam(name = "rua") String rua, @WebParam(name = "bairro") String bairro, @WebParam(name = "cidade") String cidade, @WebParam(name = "numero") String numero, @WebParam(name = "cep") String cep) {
        
        Local local = new Local(idlocal, descricao, rua, bairro, cidade, numero, cep);
        return DAOLocal.update(local);
    }

    @WebMethod(operationName = "excluirLocal")
    public boolean excluirLocal(@WebParam(name = "idlocal") long idlocal) {
        return DAOLocal.delete(idlocal);
    }

    @WebMethod(operationName = "localPorID")
    public Local localPorID(@WebParam(name = "idlocal") long idlocal) {
        return DAOLocal.getByID(idlocal);
    }

    @WebMethod(operationName = "listarLocais")
    public List<Local> listarLocais() {
        return DAOLocal.getAll();
    }
}