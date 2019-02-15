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
public class PessoasEnderecos {

    public Integer cod_endereco;
    public Integer cod_pessoa;
    public String tipo_endereco;
    public String numero;
    public String complemento;

    public Integer getCod_endereco() {
        return cod_endereco;
    }

    public void setCod_endereco(Integer cod_endereco) {
        this.cod_endereco = cod_endereco;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo_endereco() {
        return tipo_endereco;
    }

    public void setTipo_endereco(String tipo_endereco) {
        this.tipo_endereco = tipo_endereco;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO pessoa_enderecos  "+
" 	(COD_ENDERECO,          "+
" 	COD_PESSOA,               "+
" 	TIPO_ENDERECO,  "+
" 	NUMERO,  "+
" 	COMPLEMENTO  "+
" 	) "+
" 	VALUES "+
" 	(?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1,getCod_endereco());
        stmt.setInt(2, getCod_pessoa());
        stmt.setString(3, getTipo_endereco());
        stmt.setString(4, getNumero());
        stmt.setString(5, getComplemento());

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
            comando = "select p.*, pe.*, l.*, tl.TIPO, b.*, c.CIDADE, e.ESTADO, e.SIGLA, p.PAIS " +
                    "from pessoas pes, pessoa_enderecos pe, logradouros l, tipos_logradouros tl, bairros b, cidades c, estados e, paises p "+
                    "where pes.COD_PESSOA = pe.COD_PESSOA "+
                    "and pe.COD_ENDERECO = l.COD_LOGRADOURO "+
                    "and l.COD_TIPO_LOGRADOURO = tl.COD_TIPO_LOGRADOURO "+
                    "and l.COD_BAIRRO = b.COD_BAIRRO "+
                    "and b.COD_CIDADE = c.COD_CIDADE "+
                    "and c.COD_ESTADO = e.COD_ESTADO "+
                    "and e.COD_PAIS = p.COD_PAIS ";

            int quantParam = 0;

            if (getTipo_endereco() != null) {
                comando = comando + "AND pe.TIPO_ENDERECO like ?";
            }
            if (getCod_pessoa() != null){
               comando = comando + " AND pes.COD_PESSOA = ? ";
            }




            comando = comando + " order by pes.COD_PESSOA, pe.TIPO_ENDERECO ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


           if (getTipo_endereco() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getTipo_endereco()+"%");

            }
            if (getCod_pessoa() != null){
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

        String comando = "UPDATE pessoa_enderecos "+
" 	SET                     "+
" 	NUMERO = ?,  "+
" 	COMPLEMENTO = ?  "+
" 	WHERE "+
" 	COD_PESSOA = ? "+
"       AND "+
"       COD_ENDERECO = ?  "+
"       AND "+
"       TIPO_ENDERECO = ? ";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setString(1, getNumero());
        stmt.setString(2, getComplemento());
        stmt.setInt(3, getCod_pessoa());
        stmt.setInt(4, getCod_endereco());
        stmt.setString(5, getTipo_endereco());

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

" DELETE FROM pessoa_enderecos  "+
" 	WHERE "+
" 	COD_ENDERECO = ?  "+
"       AND COD_PESSOA = ?";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_endereco());
        stmt.setInt(2, getCod_pessoa());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }







}//FIM
