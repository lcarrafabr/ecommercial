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
public class Cidades {

    public Integer cod_cidade;
    public Integer cod_estado;
    public String cidade;
    public Integer cod_ibge;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCod_cidade() {
        return cod_cidade;
    }

    public void setCod_cidade(Integer cod_cidade) {
        this.cod_cidade = cod_cidade;
    }

    public Integer getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(Integer cod_estado) {
        this.cod_estado = cod_estado;
    }

    public Integer getCod_ibge() {
        return cod_ibge;
    }

    public void setCod_ibge(Integer cod_ibge) {
        this.cod_ibge = cod_ibge;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO cidades  "+
" 	(COD_CIDADE,          "+
" 	COD_ESTADO,               "+
" 	CIDADE,  "+
" 	COD_IBGE              "+
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

        stmt.setInt(1,getCod_estado());
        stmt.setString(2, getCidade());
        stmt.setInt(3, getCod_ibge());

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
            comando = "select c.*, e.ESTADO, e.SIGLA " +
                    "from cidades c, estados e "+
                    "where c.COD_ESTADO = e.COD_ESTADO ";

            int quantParam = 0;

            if (getCidade() != null) {
                comando = comando + "AND c.CIDADE like ?";
            }
            if (getCod_cidade() != null){
               comando = comando + " AND c.COD_CIDADE = ? ";
            }




            comando = comando + " order by COD_CIDADE, CIDADE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCidade() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCidade()+"%");

            }
            if (getCod_cidade() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_cidade());

            }




        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }


    public ResultSet getConsultarCidade() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select c.*, e.* " +
                    "from cidades c, estados e "+
                    "where c.COD_ESTADO = e.COD_ESTADO "+
                    "and c.COD_CIDADE = c.COD_CIDADE ";

            int quantParam = 0;

            if (getCidade() != null) {
                comando = comando + "AND c.CIDADE = like ? ";
            }
            if (getCod_cidade() != null){
               comando = comando + " AND c.COD_CIDADE = ? ";
            }
            if (getCod_estado() != null){
               comando = comando + " AND c.COD_ESTADO = ? ";
            }



            comando = comando + " order by c.COD_CIDADE, c.CIDADE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getCidade() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCidade()+"%");
            }
            if (getCod_cidade() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_cidade());
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

    public void setAlterar(ClassConecta conexao){

        try{

        String comando = "UPDATE cidades "+
" 	SET                     "+
" 	COD_ESTADO = ?,               "+
" 	CIDADE = ?,  "+
" 	COD_IBGE = ?              "+
" 	WHERE "+
" 	COD_CIDADE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_estado());
        stmt.setString(2, getCidade());
        stmt.setInt(3, getCod_ibge());
        stmt.setInt(4, getCod_cidade());

        stmt.executeUpdate();

        System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi salvo com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setExcluir(){

        try{

        String comando =

" DELETE FROM cidades  "+
" 	WHERE "+
" 	COD_CIDADE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_cidade());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }




}//FIM
