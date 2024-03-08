/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetovendas.controller;

import java.util.List;
import projetovendas.interfaces.IOperacao;
import projetovendas.model.Cidade;
import projetovendas.model.Endereco;
import projetovendas.model.Estado;

/**
 *
 * @author aluno
 */
public class EnderecoController implements IOperacao{
    
    private Endereco endereco;
    private Cidade cidade;
    private Estado estado;
    
    public EnderecoController(){
        this.endereco = new Endereco();
        this.cidade = new Cidade();
        this.estado = new Estado();
    }

    @Override
    public void cadastrar() {
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.cadastrar();
    }

    @Override
    public boolean alterar() {
    return false;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean excluir() {
      return false;
    }

    @Override
    public void cancelar() {
      
    }
    
    public List<Cidade> getListaCidade(){
        return cidade.getCidades();
    } 
    
    public List<Estado> getListaEstado(){
        return estado.getEstados();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
   
}
