/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import java.awt.Component;
import java.awt.Container;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
public class Funcoes {    /**
     *
     * @param container
     */

    protected  static void limpaCampos(Container container){
         for(Component component : container.getComponents()) {
             if((component instanceof JTextField) || (component instanceof JFormattedTextField)) {
                 ((JTextComponent)component).setText("");

             } else if (component instanceof JScrollPane) {
                 ((JTextArea) ((JScrollPane) component).getViewport().getComponent(0)).setText("");
             }
                else if (component instanceof JSpinner){
                 ((JSpinner)component).setValue(0);
             }
         }
     }




    /**
     *
     * @param container
     * @param habilitar
     */
    protected static void setHabilitarCampos(Container container,boolean habilitar){
         for(Component component : container.getComponents()) {
             if(        (component instanceof JTextField)
                     || (component instanceof JFormattedTextField)

                     ) {
                 ((JTextComponent)component).setEnabled(habilitar);
             }
         }

         for(Component component : container.getComponents()) {
             if( (component instanceof JComboBox)

                     ) {
                 ((JComboBox)component).setEnabled(habilitar);
             }
         }


     }

    /**
     *
     * @return
     */
    public static DefaultFormatterFactory setFormatoData()
     {
         MaskFormatter comFoco = null;
         try
         {
             comFoco = new MaskFormatter("##/##/####");
         }
         catch (Exception pe) { }
         DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
         return factory;
     }

    /**
     *
     * @return
     * @throws ParseException
     */
    public static Date getNow() throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date datLanc = new Date();
        String datAtual = null;
        Calendar calendar = Calendar.getInstance();
        datLanc = calendar.getTime();
        datAtual = formato.format(datLanc);
        datLanc = (Date) formato.parse(datAtual);

        return datLanc;


  }

    /**
     *
     * @return
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public static String getNowBR() throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date datLanc = new Date();
        String datAtual = null;
        Calendar calendar = Calendar.getInstance();
        datLanc = calendar.getTime();
        datAtual = formato.format(datLanc);

        return datAtual;


  }

    public static String getNowMysql() throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date datLanc = new Date();
        String datAtual = null;
        Calendar calendar = Calendar.getInstance();
        datLanc = calendar.getTime();
        datAtual = formato.format(datLanc);

        return datAtual;


  }
    /**
     *
     * @param data
     * @return
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public static String getDataFormat(Date data) throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String datFormatada = null;
        datFormatada = formato.format(data);

        return datFormatada;

  }




    public static Date getDataFormatBR(String data) throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        return formato.parse(data);

  }

    public static String getDataFormatMysql(Date data) throws ParseException, java.text.ParseException{
        //Formatar data
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String datFormatada = null;
        datFormatada = formato.format(data);

        return datFormatada;

  }



    /**
     *
     * @param valor
     * @return
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public static String getMoneyFormat(Double valor) throws ParseException, java.text.ParseException{
     //Formatar valor
      DecimalFormat formatoMoney = new DecimalFormat("###,###,##0.00");
      String oValor = null;
      oValor = formatoMoney.format(valor);

      return oValor;


  }

    /**
     *
     * @param codigo
     * @return
     * @throws ParseException
     * @throws java.text.ParseException
     */
    public static String getCodigoFormat(int codigo) throws ParseException, java.text.ParseException{
      //Formatar codigo
      String codigoRetorno = null;
      DecimalFormat formatoCodigo = new DecimalFormat("0000000");
      codigoRetorno = formatoCodigo.format(codigo);

      return codigoRetorno;


  }

 public static int getSolicitarCodigo(String tipoCodigo){
           String s = (String)JOptionPane.showInputDialog(
                               "Informe o número do "+ tipoCodigo + ":",
                               null);

           //If a string was returned, say so.
           if ((s != null) && (s.length() > 0)) {
               return Integer.parseInt(s);
           }else{
               return 0;
           }



    }
// public static void setLancContabil(ClassConecta conexao,String dataLanc, int codComunidade, int codConta, int numDocumento, int codPessoa,String operacaoDesc, String historico,double valorDoc, String tipoDoc) throws SQLException, ParseException{
//
//              //Lançar caixa
//              LivroCaixa oLivro = new LivroCaixa();
//
//              oLivro.setCodConta(codConta);
//              oLivro.setCodPessoa(codPessoa);
//              oLivro.setCodComunidade(codComunidade);
//
//              if (dataLanc == null){
//                 dataLanc = Funcoes.getNowBR();
//              }
//              oLivro.setDataLanc(Funcoes.getDataFormatBR(dataLanc));
//              oLivro.setHistorico(operacaoDesc + " "+ historico);
//              oLivro.setValor(valorDoc);
//              oLivro.setNumDoc(numDocumento);
//              oLivro.setTipoDoc(tipoDoc);
//
//              oLivro.setCadastrar(conexao);
//              ClassConecta.con.commit();
//              ClassConecta.con.setAutoCommit(false);
//
//    }

public static Date incMonth(String data,int quantMonth) throws ParseException{
           Calendar calendar = Calendar.getInstance();
           calendar.setTime( Funcoes.getDataFormatBR( data ) );
           calendar.add(Calendar.MONTH, quantMonth);
           return  calendar.getTime();

}

public static int getYear(String data) throws ParseException{

         Calendar calendar = Calendar.getInstance();
         calendar.setTime( Funcoes.getDataFormatBR(data) );
         int year = calendar.get(Calendar.YEAR);

         return year;

}

public static int getMonth(String data) throws ParseException{

         Calendar calendar = Calendar.getInstance();
         calendar.setTime( Funcoes.getDataFormatBR(data) );
         int month = calendar.get(Calendar.MONTH);

         return month+1;

}

 public static String getZeroEsq(int codigo,int quant) throws ParseException, java.text.ParseException{
      //Calcular zeros
      String formato = "";

        for (int i = 0; i < quant; i++) {
            formato += "0";
        }

      //Formatar codigo
      String codigoRetorno = null;
      DecimalFormat formatoCodigo = new DecimalFormat(formato);
      codigoRetorno = formatoCodigo.format(codigo);

      return codigoRetorno;


  }

     public static void getItemJTable(int codigo,JTable tabela)
     {
         for (int linha = 0; linha < tabela.getRowCount(); linha++)
         {
              int codigoTabela = Integer.parseInt(tabela.getValueAt(linha, 0).toString());

              if (codigoTabela == codigo)
              {
                  tabela.setRowSelectionInterval(linha, linha);
              }

         }
     }

     public static void verificaCPF( String cpf){

         String s1, s2, s3, s4, s5, s6, s7, s8, s9, confere;
         int N1, N2, N3, N4, N5, N6, N7, N8, N9, verificador1, verificador2;

         s1 = cpf.substring(0,1); N1 = Integer.parseInt(s1);
         s2 = cpf.substring(1,2); N2 = Integer.parseInt(s2);
         s3 = cpf.substring(2,3); N3 = Integer.parseInt(s3);
         s4 = cpf.substring(4,5); N4 = Integer.parseInt(s4);
         s5 = cpf.substring(5,6); N5 = Integer.parseInt(s5);
         s6 = cpf.substring(6,7); N6 = Integer.parseInt(s6);
         s7 = cpf.substring(8,9); N7 = Integer.parseInt(s7);
         s8 = cpf.substring(9,10); N8 = Integer.parseInt(s8);
         s9 = cpf.substring(10,11); N9 = Integer.parseInt(s9);


         verificador1 = (N1 * 10 + N2 * 9 + N3 * 8 + N4 * 7 + N5 * 6 + N6 * 5 + N7 * 4 + N8 * 3 + N9 * 2);
         if ((verificador1 % 11 < 2)){
             verificador1 = 0;
         }else{
             verificador1 = 11 - (verificador1 % 11);
         }

         verificador2 = (N1 * 11 + N2 * 10 + N3 * 9 + N4 * 8 + N5 * 7 + N6 * 6 + N7 * 5 + N8 * 4 + N9 * 3 + verificador1 * 2);
         if ((verificador2 % 11 < 2)){
             verificador2= 0;
         }else{
             verificador2 = 11 - (verificador2 % 11);
         }

         confere = (s1 + s2 + s3 + "." + s4 + s5 + s6 + "." + s7 + s8 + s9 + "-" + verificador1 + "" + verificador2);

         if(confere.equals("000.000.000-00") || confere.equals("111.111.111-11") ||
            confere.equals("222.222.222-22") || confere.equals("333.333.333-33") ||
            confere.equals("444.444.444-44") || confere.equals("555.555.555-55") ||
            confere.equals("666.666.666-66") || confere.equals("777.777.777-77") ||
            confere.equals("888.888.888-88") || confere.equals("999.999.999-99") ){

             JOptionPane.showMessageDialog(null, "O CPF" + " " + cpf + " " + "não é válido", "ATENÇÃO Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
         }else{

         if (confere.equals(cpf)){

             JOptionPane.showMessageDialog(null, "O CPF" + " " + confere + " " + "é válido", "ATENÇÃO Mensagem do Sistema", JOptionPane.INFORMATION_MESSAGE);
         }else{

             JOptionPane.showMessageDialog(null, "O CPF" + " " + cpf + " " + "não é válido", "ATENÇÃO Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
         }

         }

     }



          //Validar CNPJ
	 public static boolean validaCNPJ(String strCNPJ) {
    int iSoma = 0, iDigito;
    char[] chCaracteresCNPJ;
    String strCNPJ_Calculado;

    if (! strCNPJ.substring(0,1).equals("")){
        try{
            strCNPJ=strCNPJ.replace('.',' ');
            strCNPJ=strCNPJ.replace('/',' ');
            strCNPJ=strCNPJ.replace('-',' ');
            strCNPJ=strCNPJ.replaceAll(" ","");
            strCNPJ_Calculado = strCNPJ.substring(0,12);
            if ( strCNPJ.length() != 14 ) return false;
            chCaracteresCNPJ = strCNPJ.toCharArray();
            for(int i = 0; i < 4; i++) {
                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i] - 48 ) * (6 - (i + 1)) ;
                }
            }
            for( int i = 0; i < 8; i++ ) {
                if ((chCaracteresCNPJ[i+4]-48 >= 0) && (chCaracteresCNPJ[i+4]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i+4] - 48 ) * (10 - (i + 1)) ;
                }
            }
            iDigito = 11 - (iSoma % 11);
            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
               /* Segunda parte */
            iSoma = 0;
            for (int i = 0; i < 5; i++) {
                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1)) ;
                }
            }
            for (int i = 0; i < 8; i++) {
                if ((chCaracteresCNPJ[i+5]-48 >= 0) && (chCaracteresCNPJ[i+5]-48 <= 9)) {
                    iSoma += (chCaracteresCNPJ[i+5] - 48) * (10 - (i + 1)) ;
                }
            }
            iDigito = 11 - (iSoma % 11);
            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
            return strCNPJ.equals(strCNPJ_Calculado);
        } catch (Exception e) {
            return false;
        }
    } else return false;

}

    


}//FIM DAS FUNÇÔES





