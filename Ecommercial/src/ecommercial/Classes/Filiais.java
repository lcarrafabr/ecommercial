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
public class Filiais {

    public Integer cod_pessoa;
    public String situacao;
    public Date dat_abertura;
    public String permite_credito_cliente;
    public String permite_baixa_cartao;
    public String usar_mesma_seq_ordem;
    public String obs;
    public String insc_municipal;
    public String insc_suframa;
    public String insc_estadual;
    public String regime_tributario;
    public String operacao_simples_nacional;
    public Integer dias_carencia;
    public Float aliq_juros_mensal;
    public Float aliq_multa;

    public Float getAliq_juros_mensal() {
        return aliq_juros_mensal;
    }

    public void setAliq_juros_mensal(Float aliq_juros_mensal) {
        this.aliq_juros_mensal = aliq_juros_mensal;
    }

    public Float getAliq_multa() {
        return aliq_multa;
    }

    public void setAliq_multa(Float aliq_multa) {
        this.aliq_multa = aliq_multa;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public Date getDat_abertura() {
        return dat_abertura;
    }

    public void setDat_abertura(Date dat_abertura) {
        this.dat_abertura = dat_abertura;
    }

    public Integer getDias_carencia() {
        return dias_carencia;
    }

    public void setDias_carencia(Integer dias_carencia) {
        this.dias_carencia = dias_carencia;
    }

    public String getInsc_estadual() {
        return insc_estadual;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    public String getInsc_municipal() {
        return insc_municipal;
    }

    public void setInsc_municipal(String insc_municipal) {
        this.insc_municipal = insc_municipal;
    }

    public String getInsc_suframa() {
        return insc_suframa;
    }

    public void setInsc_suframa(String insc_suframa) {
        this.insc_suframa = insc_suframa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getOperacao_simples_nacional() {
        return operacao_simples_nacional;
    }

    public void setOperacao_simples_nacional(String operacao_simples_nacional) {
        this.operacao_simples_nacional = operacao_simples_nacional;
    }

    public String getPermite_baixa_cartao() {
        return permite_baixa_cartao;
    }

    public void setPermite_baixa_cartao(String permite_baixa_cartao) {
        this.permite_baixa_cartao = permite_baixa_cartao;
    }

    public String getPermite_credito_cliente() {
        return permite_credito_cliente;
    }

    public void setPermite_credito_cliente(String permite_credito_cliente) {
        this.permite_credito_cliente = permite_credito_cliente;
    }

    public String getRegime_tributario() {
        return regime_tributario;
    }

    public void setRegime_tributario(String regime_tributario) {
        this.regime_tributario = regime_tributario;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getUsar_mesma_seq_ordem() {
        return usar_mesma_seq_ordem;
    }

    public void setUsar_mesma_ordem(String usar_mesma_seq_ordem) {
        this.usar_mesma_seq_ordem = usar_mesma_seq_ordem;
    }


     public void setCadastrar(){
  try{


        String comando = "INSERT INTO filiais   "+
" 	(COD_PESSOA,                            "+
" 	SITUACAO,                               "+
" 	DAT_ABERTURA,                           "+
" 	PERMITE_CREDITO_CLIENTE,                "+
"       PERMITE_BAIXA_CARTAO,                   "+
"       USAR_MESMA_SEQ_ORDEM,                   "+
"       OBS,                                    "+
"       INSC_MUNICIPAL,                         "+
"       INSC_SUFRAMA,                           "+
"       INSC_ESTADUAL,                          "+
"       REGIME_TRIBUTARIO,                      "+
"       OPERACAO_SIMPLES_NACIONAL,              "+
"       DIAS_CARENCIA,                          "+
"       ALIQ_JUROS_MENSAL,                      "+
"       ALIQ_MULTA                              "+
" 	)                                       "+
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


        String oDatAbertura = null;
        if (getDat_abertura() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDatAbertura = oDatOut.format(getDat_abertura());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getSituacao());
        stmt.setString(3, oDatAbertura);
        stmt.setString(4, getPermite_credito_cliente());
        stmt.setString(5, getPermite_baixa_cartao());
        stmt.setString(6,getUsar_mesma_seq_ordem());
        stmt.setString(7, getObs());
        stmt.setString(8, getInsc_municipal());
        stmt.setString(9, getInsc_suframa());
        stmt.setString(10, getInsc_estadual());
        stmt.setString(11,getRegime_tributario());
        stmt.setString(12, getOperacao_simples_nacional());
        stmt.setDouble(13, getDias_carencia());
        stmt.setDouble(14, getAliq_juros_mensal());
        stmt.setDouble(15,getAliq_multa());

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
                    "from pessoas p inner join filiais f "+
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

        String comando = "UPDATE filiais "+
" 	SET "+
" 	COD_PESSOA = ?,                     "+
" 	DAT_ABERTURA = ?,                   "+
" 	SITUACAO = ?,                       "+
"       PERMITE_CREDITO_CLIENTE = ?,        "+
"       PERMITE_BAIXA_CARTAO = ?,           "+
"       USAR_MESMA_SEQ_ORDEM = ?,           "+
"       OBS = ?,                            "+
"       INSC_MUNICIPAL = ?,                 "+
"       INSC_SUFRAMA = ?,                   "+
"       INSC_ESTADUAL = ?,                  "+
"       REGIME_TRIBUTARIO = ?,              "+
"       OPERACAO_SIMPLES_NACIONAL = ?,      "+
"       DIAS_CARENCIA = ?,                  "+
"       ALIQ_JUROS_MENSAL = ?,              "+
"       ALIQ_MULTA = ?                      "+
" 	WHERE                               "+
" 	COD_PESSOA = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDatAbertura = null;
        if (getDat_abertura() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDatAbertura = oDatOut.format(getDat_abertura());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, oDatAbertura);
        stmt.setString(3, getSituacao());
        stmt.setString(4, getPermite_credito_cliente());
        stmt.setString(5, getPermite_baixa_cartao());
        stmt.setString(6, getUsar_mesma_seq_ordem());
        stmt.setString(7,getObs());
        stmt.setString(8, getInsc_municipal());
        stmt.setString(9, getInsc_suframa());
        stmt.setString(10, getInsc_estadual());
        stmt.setString(11, getRegime_tributario());
        stmt.setString(12,getOperacao_simples_nacional());
        stmt.setInt(13, getDias_carencia());
        stmt.setFloat(14, getAliq_juros_mensal());
        stmt.setFloat(15, getAliq_multa());
        stmt.setInt(16, getCod_pessoa());

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

" DELETE FROM filiais  "+
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
