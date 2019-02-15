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
public class TipoFornecedores {

    public Integer cod_tipo_fornecedor;
    public String tipo_fornecedor;
    public String grupo;
    public String obs;

    public Integer getCod_tipo_fornecedor() {
        return cod_tipo_fornecedor;
    }

    public void setCod_tipo_fornecedor(Integer cod_tipo_fornecedor) {
        this.cod_tipo_fornecedor = cod_tipo_fornecedor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTipo_fornecedor() {
        return tipo_fornecedor;
    }

    public void setTipo_fornecedor(String tipo_fornecedor) {
        this.tipo_fornecedor = tipo_fornecedor;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO tipos_fornecedores  "+
" 	(COD_TIPO_FORNECEDOR,          "+
" 	TIPO_FORNECEDOR,               "+
" 	GRUPO,                         "+
" 	OBS                            "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,      "+
" 	?,      "+
" 	?       "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getTipo_fornecedor());
        stmt.setString(2, getGrupo());
        stmt.setString(3, getObs());

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
                    "from tipos_fornecedores "+
                    "where COD_TIPO_FORNECEDOR = COD_TIPO_FORNECEDOR ";

            int quantParam = 0;

            if (getCod_tipo_fornecedor() != null){
               comando = comando + " AND COD_TIPO_FORNECEDOR = ? ";
            }
            if (getTipo_fornecedor() != null){
               comando = comando + " AND TIPO_FORNECEDOR like ? ";
            }


            comando = comando + " order by COD_TIPO_FORNECEDOR, TIPO_FORNECEDOR ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_tipo_fornecedor() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tipo_fornecedor());
            }
            if (getTipo_fornecedor() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo_fornecedor()+"%");
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

        String comando = "UPDATE tipos_fornecedores "+
" 	SET                         "+
" 	TIPO_FORNECEDOR = ?,        "+
" 	GRUPO = ?,                  "+
" 	OBS = ?                     "+
" 	WHERE "+
" 	COD_TIPO_FORNECEDOR = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getTipo_fornecedor());
        stmt.setString(2, getGrupo());
        stmt.setString(3, getObs());
        stmt.setInt(4, getCod_tipo_fornecedor());

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

" DELETE FROM tipos_fornecedores  "+
" 	WHERE "+
" 	COD_TIPO_FORNECEDOR = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_tipo_fornecedor());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }


}//FIM
