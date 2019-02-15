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
public class TiposClientes {


    public Integer cod_tipo__cliente;
    public Integer cod_tabela_preco;
    public String tipo;
    public String urgencia;
    public String bloquear_venda_inadimplente;
    public String cor;
    public String descricao;
    public Float tempo_medio_atendimento;

    public String getBloquear_venda_inadimplente() {
        return bloquear_venda_inadimplente;
    }

    public void setBloquear_venda_inadimplente(String bloquear_venda_inadimplente) {
        this.bloquear_venda_inadimplente = bloquear_venda_inadimplente;
    }

    public Integer getCod_tabela_preco() {
        return cod_tabela_preco;
    }

    public void setCod_tabela_preco(Integer cod_tabela_preco) {
        this.cod_tabela_preco = cod_tabela_preco;
    }

    public Integer getCod_tipo__cliente() {
        return cod_tipo__cliente;
    }

    public void setCod_tipo__cliente(Integer cod_tipo__cliente) {
        this.cod_tipo__cliente = cod_tipo__cliente;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getTempo_medio_atendimento() {
        return tempo_medio_atendimento;
    }

    public void setTempo_medio_atendimento(Float tempo_medio_atendimento) {
        this.tempo_medio_atendimento = tempo_medio_atendimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO tipos_cliente  "+
" 	(COD_TIPO_CLIENTE,              "+
" 	COD_TABELA_PRECO,               "+
" 	TIPO,                           "+
" 	URGENCIA,                       "+
" 	BLOQUEAR_VENDA_INADIMPLENTE,    "+
" 	COR,                            "+
" 	DESCRICAO,                      "+
" 	TEMPO_MEDIO_ATENDIMENTO         "+
" 	) "+
" 	VALUES "+
" 	(null,  "+
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

        stmt.setInt(1, getCod_tabela_preco());
        stmt.setString(2, getTipo());
        stmt.setString(3, getUrgencia());
        stmt.setString(4, getBloquear_venda_inadimplente());
        stmt.setString(5, getCor());
        stmt.setString(6, getDescricao());
        stmt.setFloat(7, getTempo_medio_atendimento());

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
            comando = "select tc.*, tp.TABELA " +
                    "from tipos_cliente tc inner join tabela_precos tp "+
                    "ON tc.COD_TIPO_CLIENTE = tp.COD_TABELA_PRECO ";

            int quantParam = 0;

            if (getTipo() != null) {
                comando = comando + "AND tc.TIPO like ? ";
            }
            if (getCod_tipo__cliente() != null){
               comando = comando + " AND tc.COD_TIPO_CLIENTE = ? ";
            }




            comando = comando + " order by tc.COD_TIPO_CLIENTE, tc.TIPO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getTipo() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo()+"%");
            }
            if (getCod_tipo__cliente() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_tipo__cliente());

            }




        resultSet = stmtQuery.executeQuery();


        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql" + sqlex);

        }

     return resultSet;
     }

}//Fim da classe
