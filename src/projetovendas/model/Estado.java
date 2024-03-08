package projetovendas.model;

import com.mysql.cj.jdbc.exceptions.MySQLStatementCancelledException;
import java.sql.SQLException;
import projetovendas.interfaces.IOperacao;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Estado implements IOperacao{   
    private String sigla_estado;
    private String nome_estado;
    private int idEstado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    private Statement mysqStatement = null;

    @Override
    public void cadastrar() {
        String insert = "insert into estado(sigla_estado, nome_estado)"
                + "values ('"+getSigla_estado() +"', '"+getNome_estado()+"')";
        mysqStatement = ConexaoDB.getStatement();
        try {
            mysqStatement.executeUpdate(insert);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

    public String getSigla_estado() {
        return sigla_estado;
    }

    public void setSigla_estado(String sigla_estado) {
        this.sigla_estado = sigla_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    @Override
    public String toString() {
        return "Estado{" + "sigla_estado=" + sigla_estado + ", nome_estado=" + nome_estado + ", idEstado=" + idEstado + ", mysqStatement=" + mysqStatement + '}';
    }

   public List<Estado> getEstados(){
       List<Estado> estados = new ArrayList();
       String sql = "select * from estado";
       mysqStatement = ConexaoDB.getStatement();
       
       try {
            ResultSet rs = mysqStatement.executeQuery(sql);
            while (rs.next()) {
                Estado est = new Estado();
                est.setIdEstado(rs.getInt("id_estado"));
                est.setNome_estado(rs.getString("nome_estado"));
                est.setSigla_estado(rs.getString("sigla_estado"));
                estados.add(est);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estados;
   }
    
    
    
    
    
}
