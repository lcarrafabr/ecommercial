/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class PessoaJuridica {

    public Integer cod_pessoa;
    public Integer cod_atividade;
    public String razao_social;
    public String fantasia;
    public String cnpj;
    public Date dat_abertura;

    public Date getDatAbertura() {
        return dat_abertura;
    }

    public void setDatAbertura(Date dat_abertura) {
        this.dat_abertura = dat_abertura;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(Integer cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }


    public void setCadastrar(){
  try{


        String comando = "INSERT INTO pessoa_juridica  "+
" 	(COD_PESSOA,       "+
" 	COD_ATIVIDADE,     "+
" 	RAZAO_SOCIAL,      "+
" 	FANTASIA,          "+
"       CNPJ,              "+
"       DAT_ABERTURA      "+
" 	)                  "+
" 	VALUES "+
" 	(?,  "+  //Aqui deveria ser NULL como é uma chave primaria estrangeira que não se auto incrementa. Esta parte deve ser preenchida com um valor
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataAbertura = null;
        if (getDatAbertura() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataAbertura = oDatOut.format(getDatAbertura());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setInt(2, getCod_atividade());
        stmt.setString(3, getRazao_social());
        stmt.setString(4, getFantasia());
        stmt.setString(5, getCnpj());
        stmt.setString(6,oDataAbertura);

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
            comando = "select p.*, pj.*, ati.* " +
                    "from pessoas p inner join pessoa_juridica pj "+
                    "on p.COD_PESSOA = pj.COD_PESSOA "+
                    "inner join atividades ati "+
                    "on pj.COD_ATIVIDADE = ati.COD_ATIVIDADE ";

            int quantParam = 0;

            if (getCod_pessoa() != null){
               comando = comando + " AND pj.COD_PESSOA = ? ";
            }

            comando = comando + " order by pj.COD_PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


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

        String comando = "UPDATE pessoa_juridica "+
" 	SET "+
" 	COD_PESSOA = ?,                 "+
" 	COD_ATIVIDADE = ?,                 "+
" 	RAZAO_SOCIAL = ?,                        "+
" 	CNPJ = ?,                         "+
"       FANTASIA = ?,                       "+
"       DAT_ABERTURA = ?               "+
" 	WHERE                             "+
" 	COD_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataAbertura = null;
        if (getDatAbertura() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataAbertura = oDatOut.format(getDatAbertura());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setInt(2, getCod_atividade());
        stmt.setString(3, getRazao_social());
        stmt.setString(4, getCnpj());
        stmt.setString(5, getFantasia());
        stmt.setString(6,oDataAbertura);
        stmt.setInt(7, getCod_pessoa());

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

" DELETE FROM pessoa_juridica  "+
" 	WHERE "+
" 	COD_PESSOA = ?  ";

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);
        //Formatar data Prevista

        stmt.setInt(1,getCod_pessoa());


        stmt.executeUpdate();

        //System.out.println("Transação Concluída");
        JOptionPane.showMessageDialog(null, "O REGISTRO foi excluído com sucesso.", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}//FIM CLASSE
