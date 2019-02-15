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
public class TipoContas {

    public Integer cod_tipo_conta;
    public String cod_contabil;
    public String tipo_conta;
    public String natureza_saldo;
    public String indicador_tipo;

    public String getCod_contabil() {
        return cod_contabil;
    }

    public void setCod_contabil(String cod_contabil) {
        this.cod_contabil = cod_contabil;
    }

    public Integer getCod_tipo_conta() {
        return cod_tipo_conta;
    }

    public void setCod_tipo_conta(Integer cod_tipo_conta) {
        this.cod_tipo_conta = cod_tipo_conta;
    }

    public String getIndicador_tipo() {
        return indicador_tipo;
    }

    public void setIndicador_tipo(String indicador_tipo) {
        this.indicador_tipo = indicador_tipo;
    }

    public String getNatureza_saldo() {
        return natureza_saldo;
    }

    public void setNatureza_saldo(String natureza_saldo) {
        this.natureza_saldo = natureza_saldo;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO tipos_contas  "+
" 	(COD_TIPO_CONTA,                        "+
" 	COD_CONTABIL,                           "+
" 	TIPO_CONTA,                             "+
" 	NATUREZA_SALDO,                         "+
" 	INDICADOR_TIPO                          "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1,getCod_contabil());
        stmt.setString(2, getTipo_conta());
        stmt.setString(3, getNatureza_saldo());
        stmt.setString(4, getIndicador_tipo());

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
            comando = "select tc.* " +
                    "from tipos_contas tc "+
                    "where tc.COD_TIPO_CONTA = tc.COD_TIPO_CONTA ";

            int quantParam = 0;

            if (getCod_tipo_conta() != null){
               comando = comando + " AND tc.COD_TIPO_CONTA = ? ";
            }
            if (getTipo_conta() != null){
                comando = comando + "AND tc.TIPO_CONTA like ? ";
            }


            comando = comando + " order by tc.COD_TIPO_CONTA, tc.TIPO_CONTA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_tipo_conta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tipo_conta());
            }
            if (getTipo_conta() != null){
                quantParam = quantParam +1;
                stmtQuery.setString(quantParam, getTipo_conta()+"%");
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

        String comando = "UPDATE tipos_contas "+
" 	SET                     "+
" 	COD_CONTABIL = ?,       "+
" 	TIPO_CONTA = ?,         "+
" 	NATUREZA_SALDO = ?,     "+
" 	INDICADOR_TIPO = ?      "+
" 	WHERE "+
" 	COD_TIPO_CONTA = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getCod_contabil());
        stmt.setString(2, getTipo_conta());
        stmt.setString(3, getNatureza_saldo());
        stmt.setString(4, getIndicador_tipo());
        stmt.setInt(5, getCod_tipo_conta());

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

" DELETE FROM tipos_contas  "+
" 	WHERE "+
" 	COD_TIPO_CONTA = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_tipo_conta());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }



}//Fim da classe
