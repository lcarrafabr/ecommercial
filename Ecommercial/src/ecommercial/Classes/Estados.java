/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vitiazze
 */
public class Estados {

    public Integer cod_estado;
    public Integer cod_pais;
    public String estado;
    public String sigla;

    public Integer getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(Integer cod_estado) {
        this.cod_estado = cod_estado;
    }

    public Integer getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(Integer cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO estados  "+
" 	(COD_ESTADO,          "+
" 	COD_PAIS,               "+
" 	ESTADO,  "+
" 	SIGLA              "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCod_pais());
        stmt.setString(2, getEstado());
        stmt.setString(3, getSigla());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}


    public ResultSet getConsultar() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select * " +
                    "from estados e, paises p "+
                    "where e.COD_PAIS = p.COD_PAIS "+
                    "and e.COD_ESTADO = e.COD_ESTADO ";

            int quantParam = 0;

            if (getEstado() != null) {
                comando = comando + "AND e.ESTADO like ? ";
            }
            if (getCod_estado() != null){
               comando = comando + " AND e.COD_ESTADO = ? ";
            }




            comando = comando + " order by e.COD_ESTADO, e.ESTADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getEstado() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getEstado()+"%");
            }
            if (getCod_estado() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_estado());

            }




        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

    public ResultSet getConsultarEstados() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select e.*, p.* " +
                    "from estados e, paises p "+
                    "where e.COD_PAIS = p.COD_PAIS ";

            int quantParam = 0;

            if (getCod_pais() != null){
               comando = comando + " AND p.COD_PAIS = ? ";
            }


            comando = comando + " order by e.ESTADO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_pais() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_pais());
            }



        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

     public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE estados "+
" 	SET                     "+
" 	COD_PAIS = ?,               "+
" 	ESTADO = ?,  "+
" 	SIGLA = ?              "+
" 	WHERE "+
" 	COD_ESTADO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_pais());
        stmt.setString(2, getEstado());
        stmt.setString(3, getSigla());
        stmt.setInt(4, getCod_estado());

        stmt.executeUpdate();

        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setExcluir(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM estados  "+
" 	WHERE "+
" 	COD_ESTADO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_estado());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


}//FIM
