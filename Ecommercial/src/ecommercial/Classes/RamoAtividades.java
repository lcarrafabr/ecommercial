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
public class RamoAtividades {

    public Integer cod_ramo_atividade;
    public String ramo_atividade;



    public Integer getCod_ramo_atividade() {
        return cod_ramo_atividade;
    }

    public void setCod_ramo_atividade(Integer cod_ramo_atividade) {
        this.cod_ramo_atividade = cod_ramo_atividade;
    }

    public String getRamo_atividade() {
        return ramo_atividade;
    }

    public void setRamo_atividade(String ramo_atividade) {
        this.ramo_atividade = ramo_atividade;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO ramo_atividades  "+
" 	(COD_RAMO_ATIVIDADE,          "+
" 	RAMO_ATIVIDADE               "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        System.out.println("inicio");
        stmt.setString(1, getRamo_atividade());
        System.out.println("passou do 2");

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
                    "from ramo_atividades "+
                    "where COD_RAMO_ATIVIDADE = COD_RAMO_ATIVIDADE ";

            int quantParam = 0;

            if (getRamo_atividade() != null) {
                comando = comando + "AND RAMO_ATIVIDADE like ?";
            }
            if (getCod_ramo_atividade() != null){
               comando = comando + " AND COD_RAMO_ATIVIDADE = ? ";
            }




            comando = comando + " order by COD_RAMO_ATIVIDADE, RAMO_ATIVIDADE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getRamo_atividade() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getRamo_atividade()+"%");

            }
            if (getCod_ramo_atividade() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_ramo_atividade());

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

        String comando = "UPDATE ramo_atividades "+
" 	SET                     "+
" 	RAMO_ATIVIDADE = ?               "+
" 	WHERE "+
" 	COD_RAMO_ATIVIDADE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getRamo_atividade());
        stmt.setInt(2, getCod_ramo_atividade());

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

" DELETE FROM ramo_atividades  "+
" 	WHERE "+
" 	COD_RAMO_ATIVIDADE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_ramo_atividade());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}



}
