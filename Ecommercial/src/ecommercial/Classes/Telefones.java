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
public class Telefones {

    public Integer cod_telefone;
    public Integer cod_pessoa;
    public String numero;
    public String operadora;
    public String tipo_telefone;
    public String descricao;
    public String ramal;

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public Integer getCod_telefone() {
        return cod_telefone;
    }

    public void setCod_telefone(Integer cod_telefone) {
        this.cod_telefone = cod_telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO telefones  "+
" 	(COD_TELEFONE,    "+
" 	COD_PESSOA,  "+
" 	NUMERO,         "+
" 	RAMAL,   "+
"       OPERADORA,       "+
"       TIPO_TELEFONE, "+
"       DESCRICAO           "+
" 	)               "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
"       ?,  "+
"       ?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getNumero());
        stmt.setString(3, getRamal());
        stmt.setString(4, getOperadora());
        stmt.setString(5, getTipo_telefone());
        stmt.setString(6,getDescricao());

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
            comando = "select t.COD_TELEFONE,t.NUMERO, t.OPERADORA, t.TIPO_TELEFONE, t.RAMAL, t.DESCRICAO " +
                    "from pessoas p, telefones t "+
                    "where t.COD_PESSOA = p.COD_PESSOA ";

            int quantParam = 0;

            if (getCod_telefone() != null){
               comando = comando + " AND t.COD_TELEFONE = ? ";
            }

            if (getCod_pessoa() != null){
               comando = comando + " AND p.COD_PESSOA = ? ";
            }
            comando = comando + " order by t.COD_TELEFONE ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if ( getCod_telefone() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_telefone());

            }

           if ( getCod_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_pessoa());

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

        String comando = "UPDATE telefones "+
" 	SET "+
" 	COD_PESSOA = ?,     "+
" 	NUMERO = ?,         "+
" 	RAMAL = ?,          "+
"       OPERADORA = ?,      "+
"       TIPO_TELEFONE = ?,  "+
"       DESCRICAO = ?       "+
" 	WHERE               "+
" 	COD_TELEFONE = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getNumero());
        stmt.setString(3, getRamal());
        stmt.setString(4, getOperadora());
        stmt.setString(5, getTipo_telefone());
        stmt.setString(6, getDescricao());
        stmt.setInt(7, getCod_telefone());

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

" DELETE FROM telefones  "+
" 	WHERE "+
" 	COD_TELEFONE = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_telefone());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }



}





}//Fim
