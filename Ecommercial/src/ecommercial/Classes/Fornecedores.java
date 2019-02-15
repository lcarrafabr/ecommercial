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
public class Fornecedores {

    public Integer cod_pessoa;
    public Date dat_cadastro;
    public Integer cod_tipo_fornecedor;
    public String situacao;
    public String obs;

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public Date getDat_cadastro() {
        return dat_cadastro;
    }

    public void setDat_cadastro(Date dat_cadastro) {
        this.dat_cadastro = dat_cadastro;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getCod_Tipo_fornecedor() {
        return cod_tipo_fornecedor;
    }

    public void setCod_Tipo_fornecedor(Integer cod_tipo_fornecedor) {
        this.cod_tipo_fornecedor = cod_tipo_fornecedor;
    }

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO fornecedores   "+
" 	(COD_PESSOA,                                 "+
" 	DAT_CADASTRO,                                "+
" 	COD_TIPO_FORNECEDOR,                             "+
" 	SITUACAO,                                    "+
"       OBS                                          "+
" 	)                                            "+
" 	VALUES "+
" 	(?,  "+  //Aqui deveria ser NULL como é uma chave primaria estrangeira que não se auto incrementa. Esta parte deve ser preenchida com um valor
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);


        String oDatCadastro = null;
        if (getDat_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDatCadastro = oDatOut.format(getDat_cadastro());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, oDatCadastro);
        stmt.setInt(3, getCod_Tipo_fornecedor());
        stmt.setString(4, getSituacao());
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
            comando = "select p.PESSOA, f.* " +
                    "from pessoas p inner join fornecedores f "+
                    "on p.COD_PESSOA = f.COD_PESSOA ";

            int quantParam = 0;

            if (getCod_pessoa() != null){
               comando = comando + " AND f.COD_PESSOA = ? ";
            }

            comando = comando + " order by f.COD_PESSOA ";
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

        String comando = "UPDATE fornecedores "+
" 	SET "+
" 	COD_PESSOA = ?,                     "+
" 	DAT_CADASTRO = ?,                   "+
" 	TIPO_FORNECEDOR = ?,                "+
"       SITUACAO = ?,                       "+
"       OBS = ?                             "+
" 	WHERE                               "+
" 	COD_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDatCadastro = null;
        if (getDat_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDatCadastro = oDatOut.format(getDat_cadastro());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, oDatCadastro);
        stmt.setInt(3, getCod_Tipo_fornecedor());
        stmt.setString(4, getSituacao());
        stmt.setString(5, getObs());
        stmt.setInt(6, getCod_pessoa());
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

" DELETE FROM fornecedores  "+
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

}//Fim da classe
