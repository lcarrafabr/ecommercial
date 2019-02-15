/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommercial.Classes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cmtj
 */
 public class ColorRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

//       if (column == 2){//Data
//         //Pegar data atual
//         Date datAtual = new Date();
//         Calendar calendar = Calendar.getInstance();
//         datAtual = calendar.getTime();
//
//
//         //Pegar data da coluna
//         Date datVenc   = null;
//         DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            try {
//                datVenc = (java.util.Date) formatter.parse(getText());
//            } catch (ParseException ex) {
//                Logger.getLogger(ColorRenderer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//         if ( datVenc.before(datAtual) ){
//          comp.setForeground(Color.red);
//         }
//
//
//       }else{
//          comp.setForeground(Color.black);
//         }
           
       

       if (row % 2 == 0) {
           comp.setBackground(Color.LIGHT_GRAY);
       } else {
           comp.setBackground(Color.WHITE);
       }

       return comp;
    }
 }