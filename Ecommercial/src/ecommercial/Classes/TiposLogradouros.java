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
public class TiposLogradouros {
    
    public Integer cod_tipo_logradouro;
    public String tipo;
    public String num_tipo;

    public Integer getCod_tipo_logradouro() {
        return cod_tipo_logradouro;
    }

    public void setCod_tipo_logradouro(Integer cod_tipo_logradouro) {
        this.cod_tipo_logradouro = cod_tipo_logradouro;
    }

    public String getNum_tipo() {
        return num_tipo;
    }

    public void setNum_tipo(String num_tipo) {
        this.num_tipo = num_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO tipos_logradouros  "+
" 	(COD_TIPO_LOGRADOURO,          "+
" 	TIPO,               "+
" 	NUM_TIPO  "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getTipo());
        stmt.setString(2, getNum_tipo());

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
                    "from tipos_logradouros "+
                    "where COD_TIPO_LOGRADOURO = COD_TIPO_LOGRADOURO ";

            int quantParam = 0;

            if (getTipo() != null) {
                comando = comando + "AND TIPO like ?";
            }
            if (getCod_tipo_logradouro() != null){
               comando = comando + " AND COD_TIPO_LOGRADOURO = ? ";
            }




            comando = comando + " order by COD_TIPO_LOGRADOURO, TIPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getTipo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo()+"%");

            }
            if (getCod_tipo_logradouro() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tipo_logradouro());

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

        String comando = "UPDATE tipos_logradouros "+
" 	SET                     "+
" 	TIPO = ?,               "+
" 	NUM_TIPO = ?  "+
" 	WHERE "+
" 	COD_TIPO_LOGRADOURO = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getTipo());
        stmt.setString(2, getNum_tipo());
        stmt.setInt(3, getCod_tipo_logradouro());

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

" DELETE FROM tipos_logradouros  "+
" 	WHERE "+
" 	COD_TIPO_LOGRADOURO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_tipo_logradouro());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

}//FIM
