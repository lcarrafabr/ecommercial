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
 * @author Luciano Carrafa Benfica
 */
public class Atividades {

    public Integer cod_atividade;
    public Integer cod_ramo_atividade;
    public String atividade;

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Integer getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(Integer cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    public Integer getCod_ramo_atividade() {
        return cod_ramo_atividade;
    }

    public void setCod_ramo_atividade(Integer cod_ramo_atividade) {
        this.cod_ramo_atividade = cod_ramo_atividade;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO atividades  "+
" 	(COD_ATIVIDADE,             "+
" 	COD_RAMO_ATIVIDADE,                 "+
" 	ATIVIDADE                   "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_ramo_atividade());
        stmt.setString(2, getAtividade());

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
            comando = "select r.*, a.* " +
                    "from ramo_atividades r inner join atividades a "+
                    "on r.COD_RAMO_ATIVIDADE = a.COD_RAMO_ATIVIDADE "+
                    "and a.COD_ATIVIDADE = a.COD_ATIVIDADE ";

            int quantParam = 0;

            if (getAtividade() != null) {
                comando = comando + "AND a.ATIVIDADE like ? ";
            }
            if (getCod_atividade() != null){
               comando = comando + " AND a.COD_ATIVIDADE = ? ";
            }




            comando = comando + " order by a.COD_ATIVIDADE, a.ATIVIDADE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getAtividade() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getAtividade()+"%");

            }
            if (getCod_atividade() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_atividade());

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

        String comando = "UPDATE atividades "+
" 	SET                     "+
" 	COD_RAMO_ATIVIDADE = ?,               "+
" 	ATIVIDADE = ?  "+
" 	WHERE "+
" 	COD_ATIVIDADE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_ramo_atividade());
        stmt.setString(2, getAtividade());
        stmt.setInt(3, getCod_atividade());

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

" DELETE FROM atividades  "+
" 	WHERE "+
" 	COD_ATIVIDADE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_atividade());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }




}
