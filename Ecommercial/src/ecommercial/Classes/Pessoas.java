/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class Pessoas {

    public Integer cod_pessoa;
    public int identificador;
    public String pessoa;
    public Date data_nasc;
    public Date data_falecimento;
    public String observacao;
    public Date Data_cadastro;
    public Blob Foto;
    public Integer cod_filial;




    public Integer getCod_filial() {
        return cod_filial;
    }

    public void setCod_filial(Integer cod_filial) {
        this.cod_filial = cod_filial;
    }

    public Blob getFoto() {
        return Foto;
    }

    public void setFoto(Blob Foto) {
        this.Foto = Foto;
    }

    public Date getData_cadastro() {
        return Data_cadastro;
    }

    public void setData_cadastro(Date Data_cadastro) {
        this.Data_cadastro = Data_cadastro;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    public Date getData_falecimento() {
        return data_falecimento;
    }

    public void setData_falecimento(Date data_falecimento) {
        this.data_falecimento = data_falecimento;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod_pessoa != null ? cod_pessoa.hashCode() : 0);
        return hash;
    }

     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoas)) {
            return false;
        }
        Pessoas other = (Pessoas) object;
        if ((this.cod_pessoa == null && other.cod_pessoa != null) || (this.cod_pessoa != null && !this.cod_pessoa.equals(other.cod_pessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ecommercial.Pessoas[cod_pessoa=" + cod_pessoa + "]";
    }
    
    public Integer getId() throws SQLException    {
        ResultSet resultSet = null;

        try
        {
            String comando;
            comando = "SELECT max(COD_PESSOA) as ID "+
                      "FROM pessoas ";

           
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


        resultSet = stmtQuery.executeQuery();
        resultSet.last();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi possível executar o comando SQL" + sqlex);

        }

     return resultSet.getInt("ID");

     }

    public Integer verificaIdentificador(Integer identificador) throws SQLException    {
        ResultSet resultSet = null;

        try
        {

            String comando;
            comando = "SELECT IfNull(p.COD_PESSOA,0) as COD_PESSOA "+
                      "FROM pessoas p "+
                      "WHERE "+
                      "p.IDENTIFICADOR = "+identificador;

            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);


        resultSet = stmtQuery.executeQuery();
        resultSet.last();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi possível executar o comando SQL" + sqlex);

        }
     if (resultSet.getRow() == 0){
         System.out.println("wasNull");
         return 0;
     }else{
            System.out.println("else");
     return resultSet.getInt("COD_PESSOA");
        }
     }

    

  public void setCadastrar(){
  try{


        String comando = "INSERT INTO pessoas  "+
" 	(COD_PESSOA,    "+
" 	IDENTIFICADOR,  "+
" 	PESSOA,         "+
" 	DAT_CADASTRO,   "+
"       DAT_NASC,       "+
"       DAT_FALECIMENTO,"+
"       FOTO,           "+
"       OBS,             "+
"       COD_FILIAL      "+
" 	)               "+
" 	VALUES "+
" 	(null,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
" 	?,  "+
"       ?,  "+
"       ?,  "+
"       ?  "+
" 	); "
;

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataCadastro = null;
        if (getData_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataCadastro = oDatOut.format(getData_cadastro());
        }

        String oDataNascimento = null;
        if (getData_nasc() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataNascimento = oDatOut.format(getData_nasc());
        }

        String oDataFalecimento = null;
        if (getData_falecimento() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataFalecimento = oDatOut.format(getData_falecimento());
        }

        System.out.println("INICIO");
        stmt.setInt(1, getIdentificador());
        System.out.println("PASSOU DO 1");
        stmt.setString(2, getPessoa());
        System.out.println("PASSOU DO 2");
        stmt.setString(3, oDataCadastro);
        System.out.println("PASSOU DO 3");
        stmt.setString(4, oDataNascimento);
        System.out.println("PASSOU DO 4");
        stmt.setString(5, oDataFalecimento);
        System.out.println("PASSOU DO 5");
        stmt.setBlob(6,getFoto());
        System.out.println("PASSOU DO 6");
        stmt.setString(7, getObservacao());
        System.out.println("PASSOU DO 7");

        if (getCod_filial() == null){        // Verifica se o campo esta null
            stmt.setNull(8, Types.INTEGER);     // seta um tipo Inteiro
        }else{
        stmt.setInt(8, getCod_filial());
        }
       // stmt.setInt(8, getCod_filial());
        System.out.println("FINALMENTE PASSOU DO 8");

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
            comando =   "select * "+
                        "from pessoas "+
                         "where COD_PESSOA = COD_PESSOA ";

            int quantParam = 0;

            if (getPessoa() != null) {
                comando = comando + "AND PESSOA like ?";
            }
            if (getCod_pessoa() != null){
               comando = comando + " AND COD_PESSOA = ?";
            }
            if (getCod_filial() != null){
               comando = comando + " AND COD_FILIAL = ?";
            }

            comando = comando + " order by COD_PESSOA, PESSOA ";
            //O parâmetro resultSetType define se o ResultSet irá ser navegável e posicionado ou não:
            //ResultSet.TYPE_FORWARD_ONLY: com este parâmetro o ResultSet não poderá ser navegável, ou seja, poderemos somente avançar no objeto ResultSet para poder buscar valores.
            //ResultSet.TYPE_SCROLL_INSENSITIVE: com este parâmetro o ResultSet poderá ser navegável em qualquer direção, para frente e para trás, e será insensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            //ResultSet.TYPE_SCROLL_SENSITIVE: com este parâmetro o ResultSet poderá ser navegável para qualquer direção, e será sensível a mudanças feitas por outras transações ou por outros Statements da mesma transação.
            java.sql.PreparedStatement stmtQuery = ClassConecta.con.prepareStatement(comando);

            if (getPessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setString(quantParam, getPessoa()+"%");
            }
            if (getCod_pessoa() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_pessoa());
            }
            if (getCod_filial() != null){
               quantParam = quantParam +1;
               stmtQuery.setInt(quantParam, getCod_filial());
            }

        resultSet = stmtQuery.executeQuery();

        }
        catch (SQLException sqlex)
        {
             JOptionPane.showMessageDialog(null,"Não foi Possivél executar o comando sql \n" + sqlex);

        }

     return resultSet;
     }

   public void setAlterar(ClassConecta conexao){

        try{
        //ClassConecta conexao = new ClassConecta();

        //conexao.conecta();

        String comando = "UPDATE pessoas "+
" 	SET "+
" 	IDENTIFICADOR = ?,  "+
" 	PESSOA = ?,  "+
" 	DAT_CADASTRO = ?,  "+
"       DAT_NASC = ?, "+
"       DAT_FALECIMENTO = ?, "+
"       FOTO = ?, "+
"       OBS = ?, "+
"       COD_FILIAL = ? "+
" 	WHERE "+
" 	cod_pessoa = ?";

        System.out.println("Executando operação...");

        PreparedStatement stmt = (PreparedStatement) ClassConecta.con.prepareStatement(comando);

        String oDataCadastro = null;
        if (getData_cadastro() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataCadastro = oDatOut.format(getData_cadastro());
        }
        String oDataNascimento = null;
        if (getData_nasc() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataNascimento = oDatOut.format(getData_nasc());
        }

        String oDataFalecimento = null;
        if (getData_falecimento() != null){
          SimpleDateFormat oDatOut = new SimpleDateFormat("yyyy-MM-dd");
          oDataFalecimento = oDatOut.format(getData_falecimento());
        }

        stmt.setInt(1, getIdentificador());
        stmt.setString(2, getPessoa());
        stmt.setString(3, oDataCadastro);
        stmt.setString(4, oDataNascimento);
        stmt.setString(5, oDataFalecimento);
        stmt.setBlob(6, getFoto());
        stmt.setString(7, getObservacao());
        stmt.setInt(8, getCod_filial());
        stmt.setInt(9, getCod_pessoa());

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

" DELETE FROM pessoas  "+
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


}
