/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import com.mysql.jdbc.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Representantes {

    public Integer cod_pessoa;
    public String situacao;
    public Date dat_cadastro;
    public Float aliq_comissao;
    public String comissionado;
    public String obs;

    public Float getAliq_comissao() {
        return aliq_comissao;
    }

    public void setAliq_comissao(Float aliq_comissao) {
        this.aliq_comissao = aliq_comissao;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public String getComissionado() {
        return comissionado;
    }

    public void setComissionado(String comissionado) {
        this.comissionado = comissionado;
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

    public void setCadastrar(){
  try{


        String comando = "INSERT INTO representantes  "+
" 	(COD_PESSOA,       "+
" 	SITUACAO,     "+
" 	DAT_CADASTRO,      "+
" 	ALIQ_COMISSAO,          "+
"       COMISSIONADO,              "+
"       OBS      "+
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

        String oDataCadastro = null;
        if (getDat_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataCadastro = oDatOut.format(getDat_cadastro());
        }

        stmt.setInt(1, getCod_pessoa());
        stmt.setString(2, getSituacao());
        stmt.setString(3, oDataCadastro);
        stmt.setFloat(4, getAliq_comissao());
        stmt.setString(5, getComissionado());
        stmt.setString(6,getObs());

        stmt.execute();

        //System.out.println("Transação Concluída");
        //JOptionPane.showMessageDialog(null, "Transação Concluída", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            System.err.println("Erro na Transação\n"+e);
            JOptionPane.showMessageDialog(null, "Erro na Transação", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }
}

}
