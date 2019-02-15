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
public class GrupoContas {

    public Integer cod_grupo_conta;
    public Integer cod_tipo_conta;
    public String cod_contabil;
    public String grupo;

    public String getCod_contabil() {
        return cod_contabil;
    }

    public void setCod_contabil(String cod_contabil) {
        this.cod_contabil = cod_contabil;
    }

    public Integer getCod_grupo_conta() {
        return cod_grupo_conta;
    }

    public void setCod_grupo_conta(Integer cod_grupo_conta) {
        this.cod_grupo_conta = cod_grupo_conta;
    }

    public Integer getCod_tipo_conta() {
        return cod_tipo_conta;
    }

    public void setCod_tipo_conta(Integer cod_tipo_conta) {
        this.cod_tipo_conta = cod_tipo_conta;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO grupo_contas  "+
" 	(COD_GRUPO_CONTA,             "+
" 	COD_TIPO_CONTA,               "+
" 	COD_CONTABIL,                 "+
" 	GRUPO                         "+
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

        stmt.setInt(1,getCod_tipo_conta());
        stmt.setString(2, getCod_contabil());
        stmt.setString(3, getGrupo());

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
            comando = "select gc.*, tc.* " +
                    "from tipos_contas tc inner join grupo_contas gc "+
                    "on gc.COD_GRUPO_CONTA = gc.COD_GRUPO_CONTA "+
                    "and gc.COD_TIPO_CONTA = tc.COD_TIPO_CONTA ";

            int quantParam = 0;

            if (getCod_tipo_conta() != null){
               comando = comando + " AND tc.COD_TIPO_CONTA = ? ";
            }
            if (getCod_grupo_conta() != null){
                comando = comando + "AND gc.COD_GRUPO_CONTA = ? ";
            }
            if (getGrupo() != null){
                comando = comando + "AND gc.GRUPO like ? ";
            }


            comando = comando + " order by gc.COD_GRUPO_CONTA, gc.GRUPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_tipo_conta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tipo_conta());
            }
            if (getCod_grupo_conta() != null){
                quantParam = quantParam +1;
                stmtQuery.setInt(quantParam, getCod_grupo_conta());
            }
            if (getGrupo() != null){
                quantParam = quantParam +1;
                stmtQuery.setString(quantParam, getGrupo()+"%");
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

        String comando = "UPDATE grupo_contas "+
" 	SET                      "+
" 	COD_TIPO_CONTA = ?,      "+
" 	COD_CONTABIL = ?,        "+
" 	GRUPO = ?                "+
" 	WHERE "+
" 	COD_GRUPO_CONTA = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_tipo_conta());
        stmt.setString(2, getCod_contabil());
        stmt.setString(3, getGrupo());
        stmt.setInt(4, getCod_grupo_conta());

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

" DELETE FROM grupo_contas  "+
" 	WHERE "+
" 	COD_GRUPO_CONTA = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_grupo_conta());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


}// Fim classe
