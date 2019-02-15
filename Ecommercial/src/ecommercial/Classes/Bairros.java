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
 * @author Lucaino Carrafa Benfica
 */
public class Bairros {

    public Integer cod_Bairro;
    public Integer cod_Cidade;
    public String bairro;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCod_Bairro() {
        return cod_Bairro;
    }

    public void setCod_Bairro(Integer cod_Bairro) {
        this.cod_Bairro = cod_Bairro;
    }

    public Integer getCod_Cidade() {
        return cod_Cidade;
    }

    public void setCod_Cidade(Integer cod_Cidade) {
        this.cod_Cidade = cod_Cidade;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO bairros  "+
" 	(COD_BAIRRO,          "+
" 	COD_CIDADE,               "+
" 	BAIRRO  "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCod_Cidade());
        stmt.setString(2, getBairro());

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
            comando = "select b.*, c.CIDADE, e.ESTADO, p.PAIS " +
                    "from bairros b, cidades c, estados e, paises p "+
                    "where b.COD_CIDADE = c.COD_CIDADE "+
                    "and c.COD_ESTADO = e.COD_ESTADO "+
                    "and e.COD_PAIS = p.COD_PAIS ";

            int quantParam = 0;

            if (getBairro() != null) {
                comando = comando + "AND b.BAIRRO like ?";
            }
            if (getCod_Bairro() != null){
               comando = comando + " AND b.COD_BAIRRO = ? ";
            }




            comando = comando + " order by b.COD_BAIRRO, b.BAIRRO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getBairro() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getBairro()+"%");

            }
            if (getCod_Bairro() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_Bairro());

            }




        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }
    public ResultSet getConsultarBairros() throws SQLException
    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "select b.*, c.* " +
                    "from bairros b, cidades c "+
                    "where b.COD_CIDADE = c.COD_CIDADE ";

            int quantParam = 0;

            if (getCod_Cidade() != null){
               comando = comando + " AND c.COD_CIDADE = ? ";
            }




            comando = comando + " order by c.CIDADE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_Cidade() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_Cidade());
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

        String comando = "UPDATE bairros "+
" 	SET                     "+
" 	COD_CIDADE = ?,               "+
" 	BAIRRO = ?  "+
" 	WHERE "+
" 	COD_BAIRRO = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_Cidade());
        stmt.setString(2, getBairro());
        stmt.setInt(3, getCod_Bairro());

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
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando =

" DELETE FROM bairros  "+
" 	WHERE "+
" 	COD_BAIRRO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_Bairro());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }
    


}//FIM
