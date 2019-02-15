/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class PlanoContas {

    public Integer cod_conta;
    public Integer cod_filial;
    public Integer cod_tipo_conta;
    public Integer cod_grupo_conta;
    public Integer cod_conta_pai;
    public String num_conta;
    public String nome_conta;
    public String historico_padrao;
    public String classificacao;
    public String circulante;
    public String grupo;

    public String getCirculante() {
        return circulante;
    }

    public void setCirculante(String circulante) {
        this.circulante = circulante;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getCod_conta() {
        return cod_conta;
    }

    public void setCod_conta(Integer cod_conta) {
        this.cod_conta = cod_conta;
    }

    public Integer getCod_conta_pai() {
        return cod_conta_pai;
    }

    public void setCod_conta_pai(Integer cod_conta_pai) {
        this.cod_conta_pai = cod_conta_pai;
    }

    public Integer getCod_filial() {
        return cod_filial;
    }

    public void setCod_filial(Integer cod_filial) {
        this.cod_filial = cod_filial;
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

    public String getHistorico_padrao() {
        return historico_padrao;
    }

    public void setHistorico_padrao(String historico_padrao) {
        this.historico_padrao = historico_padrao;
    }

    public String getNome_conta() {
        return nome_conta;
    }

    public void setNome_conta(String nome_conta) {
        this.nome_conta = nome_conta;
    }

    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        this.num_conta = num_conta;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO plano_contas  "+
" 	(COD_CONTA,             "+
" 	COD_FILIAL,             "+
" 	COD_TIPO_CONTA,         "+
" 	COD_GRUPO_CONTA,        "+
" 	COD_CONTA_PAI,          "+
" 	NUM_CONTA,              "+
" 	NOME_CONTA,             "+
" 	HISTORICO_PADRAO,       "+
" 	CLASSIFICACAO,          "+
" 	CIRCULANTE,             "+
" 	GRUPO                   "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCod_filial());
        stmt.setInt(2, getCod_tipo_conta());
        stmt.setInt(3, getCod_grupo_conta());
        if (getCod_conta_pai() == null){        // Verifica se o campo esta null
            stmt.setNull(4, Types.INTEGER);     // seta um tipo Inteiro
        }else{
        stmt.setInt(4, getCod_conta_pai());
        }
        stmt.setString(5, getNum_conta());
        stmt.setString(6, getNome_conta());
        stmt.setString(7, getHistorico_padrao());
        stmt.setString(8, getClassificacao());
        stmt.setString(9, getCirculante());
        stmt.setString(10, getGrupo());

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
            comando = "select pc.*, CONCAT (pc.NUM_CONTA, ' - ' , PC.NOME_CONTA) AS Nome_Conta " +  //concatena o num_conta com o nome da conta ex: 1.1 ativo circulante
                    "from plano_contas pc "+
                    "where pc.COD_CONTA = pc.COD_CONTA ";

            int quantParam = 0;

            if (getCod_conta() != null){
               comando = comando + " AND pc.COD_CONTA_PAI = ? ";
            }
            if (getNome_conta() != null){
                comando = comando + "AND pc.NOME_CONTA like ? ";
            }
//            if (getNum_conta() != null){
//               comando = comando + " AND pc.NUM_CONTA = ? ";
//            }


            comando = comando + " ORDER BY pc.NUM_CONTA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


            if (getCod_conta() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_conta());
            }
            if (getNome_conta() != null){
                quantParam = quantParam +1;
                stmtQuery.setString(quantParam, getNome_conta()+"%");
            }
//            if (getNum_conta() != null){
//               quantParam = quantParam +1;
//               stmtQuery.setString(quantParam, getNum_conta());
//            }

        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

    



}//Fim da classe
