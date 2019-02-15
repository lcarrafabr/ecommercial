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
public class TabelaPrecos {

    public Integer cod_tabela_preco;
    public String tabela;
    public String tipo_tabela;
    public String ativo;
    public Float aliq_desc;
    public String obs;

    public Float getAliq_desc() {
        return aliq_desc;
    }

    public void setAliq_desc(Float aliq_desc) {
        this.aliq_desc = aliq_desc;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Integer getCod_tabela_preco() {
        return cod_tabela_preco;
    }

    public void setCod_tabela_preco(Integer cod_tabela_preco) {
        this.cod_tabela_preco = cod_tabela_preco;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getTipo_tabela() {
        return tipo_tabela;
    }

    public void setTipo_tabela(String tipo_tabela) {
        this.tipo_tabela = tipo_tabela;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO tabela_precos  "+
" 	(COD_TABELA_PRECO,              "+
" 	TABELA,                         "+
" 	TIPO_TABELA,                    "+
" 	ATIVO,                          "+
" 	ALIQ_DESC,                      "+
" 	OBS                             "+
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

        stmt.setString(1,getTabela());
        stmt.setString(2, getTipo_tabela());
        stmt.setString(3, getAtivo());
        stmt.setFloat(4, getAliq_desc());
        stmt.setString(5, getObs());

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
            comando = "select tp.* " +
                    "from tabela_precos tp "+
                    "where tp.COD_TABELA_PRECO = tp.COD_TABELA_PRECO ";

            int quantParam = 0;

            if (getCod_tabela_preco() != null){
               comando = comando + " AND tp.COD_TABELA_PRECO = ? ";
            }
            if (getTabela() != null){
                comando = comando + "AND tp.TABELA like ? ";
            }


            comando = comando + " order by tp.COD_TABELA_PRECO, tp.TABELA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_tabela_preco() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tabela_preco());
            }
            if (getTabela() != null){
                quantParam = quantParam +1;
                stmtQuery.setString(quantParam, getTabela()+"%");
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

        String comando = "UPDATE tabela_precos "+
" 	SET                     "+
" 	TABELA = ?,               "+
" 	TIPO_TABELA = ?,  "+
" 	ATIVO = ?,  "+
" 	ALIQ_DESC = ?,  "+
" 	OBS = ?  "+
" 	WHERE "+
" 	COD_TABELA_PRECO = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getTabela());
        stmt.setString(2, getTipo_tabela());
        stmt.setString(3, getAtivo());
        stmt.setFloat(4, getAliq_desc());
        stmt.setString(5, getObs());
        stmt.setInt(6, getCod_tabela_preco());

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

" DELETE FROM tabela_precos  "+
" 	WHERE "+
" 	COD_TABELA_PRECO = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_tabela_preco());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }





}//Fim da classe
