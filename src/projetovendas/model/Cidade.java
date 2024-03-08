package projetovendas.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import projetovendas.interfaces.IOperacao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Cidade implements IOperacao {

    private String nome;
    private int codibge;
    private int idcidade;
    private Statement mysqStatement = null;

       
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodibge() {
        return codibge;
    }

    public void setCodibge(int codibge) {
        this.codibge = codibge;
    }

    @Override
    public void cadastrar() {
         String insert  = "insert into cidade(nome, cod_ibge) "
                + "values('"+getNome()+"',"+getCodibge()+")";
         mysqStatement = ConexaoDB.getStatement();
         
        try {
            mysqStatement.executeUpdate(insert);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
         
       
    }

    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + ", codibge=" + codibge + ", idcidade=" + idcidade + ", mysqStatement=" + mysqStatement + '}';
    }

    public int getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(int idcidade) {
        this.idcidade = idcidade;
    }

    @Override
    public boolean alterar() {
        return false;
    }

    @Override
    public boolean excluir() {
        return false;
    }

    @Override
    public void cancelar() {

    }
    public List<Cidade> getCidades(){
        List<Cidade> cidades = new ArrayList();
        String sql = "select * from cidade";
        mysqStatement = ConexaoDB.getStatement();
        
        try {
            ResultSet rs = mysqStatement.executeQuery(sql);
            while(rs.next()){
                Cidade cid = new Cidade();
                cid.setCodibge(rs.getInt("cod_ibge"));
                cid.setNome(rs.getString("nome"));
                cid.setIdcidade(rs.getInt("id_cidade"));
                cidades.add(cid);                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cidades;
    }    

}
