import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class tableManagment {

     public DefaultTableModel impresion(String Nombre,String[][] datos){
         String[] columnas = {Nombre};
         DefaultTableModel model =new DefaultTableModel(datos,columnas);
         model.setRowCount(10);
         return model;
     }

     public DefaultTableCellRenderer formatoCentro(){
         DefaultTableCellRenderer renderHorixontal=new DefaultTableCellRenderer();
         renderHorixontal.setHorizontalAlignment(SwingConstants.CENTER);
         return renderHorixontal;
     }

    public DefaultTableModel impresionPrimera(String Nombre){
        String[] columnas = {Nombre};
        DefaultTableModel model =new DefaultTableModel(null,columnas);
        model.setRowCount(10);
        return model;
    }

    public DefaultTableModel impresionTorres(String Nombre,int tamanio, String[] vector){
        String[] columnas = {Nombre};
        DefaultTableModel model =new DefaultTableModel(null,columnas);
        for (int i = 0; i < tamanio; i++) {
            String dato=vector[i];
            String[] Datos = {dato};
           model.addRow(Datos);
        }
        return model;
    }
}
