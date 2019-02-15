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
public class PessoasFisicas {

    public Integer cod_pessoa;
    public String cpf;
    public String rg;
    public String sexo;
    public String estado_civil;
    public String nome_pai;
    public String nome_mae;
    public String local_trabalho;
    public String titulo_eleitor;
    public String carteira_habilitacao;
    public String nacionalidade;
    public String apelido;
    public String insc_empreededor_individual;
    public Double valor_renda_informal;
    public Double valor_renda_formal;
    public Double valor_renda_familiar;
    public Integer quant_integrantes_familia;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCarteira_habilitacao() {
        return carteira_habilitacao;
    }

    public void setCarteira_habilitacao(String carteira_habilitacao) {
        this.carteira_habilitacao = carteira_habilitacao;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getInsc_empreededor_individual() {
        return insc_empreededor_individual;
    }

    public void setInsc_empreededor_individual(String insc_empreededor_individual) {
        this.insc_empreededor_individual = insc_empreededor_individual;
    }

    public String getLocal_trabalho() {
        return local_trabalho;
    }

    public void setLocal_trabalho(String local_trabalho) {
        this.local_trabalho = local_trabalho;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public Integer getQuant_integrantes_familia() {
        return quant_integrantes_familia;
    }

    public void setQuant_integrantes_familia(Integer quant_integrantes_familia) {
        this.quant_integrantes_familia = quant_integrantes_familia;
    }

    public Double getValor_Renda_familiar() {
        return valor_renda_familiar;
    }

    public void setValor_Renda_familiar(Double renda_familiar) {
        this.valor_renda_familiar = renda_familiar;
    }

    public Double getValorRenda_formal() {
        return valor_renda_formal;
    }

    public void setValor_Renda_formal(Double renda_formal) {
        this.valor_renda_formal = renda_formal;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTitulo_eleitor() {
        return titulo_eleitor;
    }

    public void setTitulo_eleitor(String titulo_eleitor) {
        this.titulo_eleitor = titulo_eleitor;
    }

    public Double getValor_renda_informal() {
        return valor_renda_informal;
    }

    public void setValor_renda_informal(Double valor_renda_informal) {
        this.valor_renda_informal = valor_renda_informal;
    }



    public void setCadastrar(){
  try{


        String comando = "INSERT INTO pessoa_fisica  "+
" 	(COD_PESSOA,                     "+
" 	CPF,                             "+
" 	RG,                              "+
" 	SEXO,                            "+
"       ESTADO_CIVIL,                    "+
"       NOME_PAI,                        "+
"       NOME_MAE,                        "+
"       LOCAL_TRABALHO,                  "+
"       TITULO_ELEITOR,                  "+
"       CARTEIRA_HABILITACAO,            "+
"       NACIONALIDADE,                   "+
"       APELIDO,                         "+
"       INSC_EMPREEDEDOR_INDIVIDUAL,     "+
"       VALOR_RENDA_INFORMAL,            "+
"       VALOR_RENDA_FORMAL,              "+
"       VALOR_RENDA_FAMILIAR,            "+
"       QUANT_INTEGRANTES_FAMILIA        "+
" 	)               "+
" 	VALUES "+
" 	(?,  "+  //Aqui deveria ser NULL como é uma chave primaria estrangeira que não se auto incrementa. Esta parte deve ser preenchida com um valor
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
"       ?,  "+
" 	?,  "+
" 	?,  "+
"       ?,  "+
"       ?,  "+
"       ?   "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getCpf());
        stmt.setString(3, getRg());
        stmt.setString(4, getSexo());
        stmt.setString(5, getEstado_civil());
        stmt.setString(6,getNome_pai());
        stmt.setString(7, getNome_mae());
        stmt.setString(8, getLocal_trabalho());
        stmt.setString(9, getTitulo_eleitor());
        stmt.setString(10, getCarteira_habilitacao());
        stmt.setString(11,getNacionalidade());
        stmt.setString(12, getApelido());
        stmt.setString(13, getInsc_empreededor_individual());
        stmt.setDouble(14, getValor_renda_informal());
        stmt.setDouble(15, getValorRenda_formal());
        stmt.setDouble(16,getValor_Renda_familiar());
        stmt.setInt(17,getQuant_integrantes_familia());

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
            comando = "select p.PESSOA, pf.* " +
                    "from pessoas p inner join pessoa_fisica pf "+
                    "on p.COD_PESSOA = pf.COD_PESSOA ";

            int quantParam = 0;

            if (getCod_pessoa() != null){
               comando = comando + " AND pf.COD_PESSOA = ? ";
            }

            comando = comando + " order by pf.COD_PESSOA ";
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

        String comando = "UPDATE pessoa_fisica "+
" 	SET "+
" 	COD_PESSOA = ?,                 "+
" 	CPF = ?,                        "+
" 	RG = ?,                         "+
"       SEXO = ?,                       "+
"       ESTADO_CIVIL = ?,               "+
"       NOME_PAI = ?,                    "+
"       NOME_MAE = ?,                   "+
"       LOCAL_TRABALHO = ?,             "+
"       TITULO_ELEITOR = ?,             "+
"       CARTEIRA_HABILITACAO = ?,       "+
"       NACIONALIDADE = ?,              "+
"       APELIDO = ?,                    "+
"       INSC_EMPREEDEDOR_INDIVIDUAL = ?,  "+
"       VALOR_RENDA_INFORMAL = ?,         "+
"       VALOR_RENDA_FORMAL = ?,           "+
"       VALOR_RENDA_FAMILIAR = ?,         "+
"       QUANT_INTEGRANTES_FAMILIA = ?    "+
" 	WHERE                             "+
" 	COD_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getCpf());
        stmt.setString(3, getRg());
        stmt.setString(4, getSexo());
        stmt.setString(5, getEstado_civil());
        stmt.setString(6,getNome_pai());
        stmt.setString(7, getNome_mae());
        stmt.setString(8, getLocal_trabalho());
        stmt.setString(9, getTitulo_eleitor());
        stmt.setString(10, getCarteira_habilitacao());
        stmt.setString(11,getNacionalidade());
        stmt.setString(12, getApelido());
        stmt.setString(13, getInsc_empreededor_individual());
        stmt.setDouble(14, getValor_renda_informal());
        stmt.setDouble(15, getValorRenda_formal());
        stmt.setDouble(16,getValor_Renda_familiar());
        stmt.setInt(17,getQuant_integrantes_familia());
        stmt.setInt(18, getCod_pessoa());

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

" DELETE FROM pessoa_fisica  "+
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



}//FIM DA CLASSE
