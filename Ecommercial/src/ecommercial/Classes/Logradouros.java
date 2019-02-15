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
public class Logradouros {

    public Integer cod_logradouro;
    public Integer cod_bairro;
    public Integer cod_tipo_logradouro;
    public String logradouro;
    public String cep;
    public String link_mapa;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getCod_bairro() {
        return cod_bairro;
    }

    public void setCod_bairro(Integer cod_bairro) {
        this.cod_bairro = cod_bairro;
    }

    public Integer getCod_logradouro() {
        return cod_logradouro;
    }

    public void setCod_logradouro(Integer cod_logradouro) {
        this.cod_logradouro = cod_logradouro;
    }

    public Integer getCod_tipo_logradouro() {
        return cod_tipo_logradouro;
    }

    public void setCod_tipo_logradouro(Integer cod_tipo_logradouro) {
        this.cod_tipo_logradouro = cod_tipo_logradouro;
    }

    public String getLink_mapa() {
        return link_mapa;
    }

    public void setLink_mapa(String link_mapa) {
        this.link_mapa = link_mapa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO logradouros  "+
" 	(COD_LOGRADOURO,            "+
" 	COD_BAIRRO,                 "+
" 	COD_TIPO_LOGRADOURO,        "+
" 	LOGRADOURO,                 "+
" 	CEP,                        "+
" 	LINK_MAPA                   "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCod_bairro());
        stmt.setInt(2, getCod_tipo_logradouro());
        stmt.setString(3, getLogradouro());
        stmt.setString(4, getCep());
        stmt.setString(5, getLink_mapa());

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
            comando = "select l.*, tl.TIPO, b.*, c.CIDADE, e.ESTADO, e.SIGLA, p.PAIS " +
                    "from logradouros l, tipos_logradouros tl, bairros b, cidades c, estados e, paises p "+
                    "where l.COD_TIPO_LOGRADOURO = tl.COD_TIPO_LOGRADOURO "+
                    "and l.COD_BAIRRO = b.COD_BAIRRO "+
                    "and b.COD_CIDADE = c.COD_CIDADE "+
                    "and c.COD_ESTADO = e.COD_ESTADO "+
                    "and e.COD_PAIS = p.COD_PAIS ";

            int quantParam = 0;

            if (getLogradouro() != null) {
                comando = comando + "AND l.LOGRADOURO like ?";
            }
            if (getCod_logradouro() != null){
               comando = comando + " AND l.COD_LOGRADOURO = ? ";
            }
            if (getCod_bairro() != null){
               comando = comando + " AND l.COD_BAIRRO = ? ";
            }




            comando = comando + " order by l.COD_LOGRADOURO, l.LOGRADOURO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getLogradouro() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getCod_logradouro()+"%");

            }
            if (getCod_logradouro() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_logradouro());
            }
            if (getCod_bairro() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_bairro());
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

        String comando = "UPDATE logradouros "+
" 	SET                     "+
" 	COD_BAIRRO = ?,               "+
" 	COD_TIPO_LOGRADOURO = ?,  "+
" 	LOGRADOURO = ?,  "+
" 	CEP = ?,  "+
" 	LINK_MAPA = ?  "+
" 	WHERE "+
" 	COD_LOGRADOURO = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_bairro());
        stmt.setInt(2, getCod_tipo_logradouro());
        stmt.setString(3, getLogradouro());
        stmt.setString(4, getCep());
        stmt.setString(5, getLink_mapa());
        stmt.setInt(6, getCod_logradouro());

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

" DELETE FROM logradouros  "+
" 	WHERE "+
" 	COD_LOGRADOURO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_logradouro());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }







}//FIM
