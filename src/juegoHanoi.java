import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class juegoHanoi extends JFrame {


    private JTable tblTorreA;
    private JTable tblTorreB;
    private JTable tblTorreC;
    private JPanel panel1;
    private JButton btnTorreAalaB;
    private JButton btnTorreAalaC;
    private JButton btnTorreBalaA;
    private JButton btnTorreBalaC;
    private JButton btnTorreCalaA;
    private JButton btnTorreCalaB;
    private JComboBox comboBoxNum;
    private JTextField textNumMinimos;
    private JTextField txtNumUsuario;
    private JButton btnIniciar;
    private JButton btnReiniciar;
    private JButton btnResolver;
    private Partida partida;
    private tableManagment tb;

    public juegoHanoi(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        tb=new tableManagment();
        crarTablaA();
        crarTablaB();
        crarTablaC();

        btnReiniciar.setEnabled(false);
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               partida=new Partida(Integer.parseInt(comboBoxNum.getSelectedItem().toString()));
               textNumMinimos.setText(String.valueOf(String.format("%.0f",partida.getNumMovimeintos())));
               txtNumUsuario.setText(String.valueOf(partida.getNumUsuarioMovimientos()));
               //btnIniciar.setEnabled(false);
               //btnReiniciar.setEnabled(true);
                imprimirTablas();

            }
        });
        btnTorreAalaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean respuesta;
                respuesta=partida.deTorreAaTorreB();
                if(!respuesta){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    int movimientosUsuario;
                    movimientosUsuario=partida.sumarMovimientos();
                    txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                    System.out.println("MOVIMIENTOS"+movimientosUsuario);

                }
                imprimirTablas();

            }
        });

        btnTorreAalaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta;
                respuesta=partida.deTorreAaTorreC();
                if(respuesta==0){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else {
                    if (respuesta==2){
                        JOptionPane.showMessageDialog(null, "Gano la partida con número de movimientos", "Información", JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        int movimientosUsuario;
                        movimientosUsuario=partida.sumarMovimientos();
                        txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                    }

                }
                imprimirTablas();

            }
        });
        btnTorreBalaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean respuesta;
                respuesta=partida.deTorreBaTorreA();
                if(!respuesta){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    int movimientosUsuario;
                    movimientosUsuario=partida.sumarMovimientos();
                    txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                }
                imprimirTablas();
            }
        });
        btnTorreBalaC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta;
                respuesta=partida.deTorreBaTorreC();
                if(respuesta==0){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else {
                    if (respuesta==2){
                        JOptionPane.showMessageDialog(null, "Gano la partida con número de movimientos", "Información", JOptionPane.INFORMATION_MESSAGE);

                    }
                    else{
                        int movimientosUsuario;
                        movimientosUsuario=partida.sumarMovimientos();
                        txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                    }
                }
                imprimirTablas();
            }
        });
        btnTorreCalaA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean respuesta;
                respuesta=partida.deTorreCaTorreA();
                if(!respuesta){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    int movimientosUsuario;
                    movimientosUsuario=partida.sumarMovimientos();
                    txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                }
                imprimirTablas();
            }
        });
        btnTorreCalaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean respuesta;
                respuesta=partida.deTorreCaTorreB();
                if(!respuesta){
                    JOptionPane.showMessageDialog(null, "No puede realizar este movimiento", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    int movimientosUsuario;
                    movimientosUsuario=partida.sumarMovimientos();
                    txtNumUsuario.setText(String.valueOf(movimientosUsuario));
                }
                imprimirTablas();
            }
        });
        btnResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //partida.iniciarRec(false);
                //imprimirTablas();
                boolean stop = false;
                while (stop == false) {
                    imprimirTablas();
                    JOptionPane pane = new JOptionPane("Paso: " + partida.getNumUsuarioMovimientos() + "\n \n Desea Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
                    JDialog dialog = pane.createDialog("Numero de Pasos");
                    dialog.setVisible(true);
                    int opt = (int) pane.getValue();
                    System.out.println("OPCION"+opt);
                    if (opt == JOptionPane.YES_OPTION) {
                        partida.iniciarRec(stop);
                        imprimirTablas();
                    } else {
                        stop = true;
                        imprimirTablas();
                    }
                }
            }
        });
    }


    private void crarTablaA() {
        tblTorreA.setModel(tb.impresionPrimera("Torre A"));
        tblTorreA.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());
    }
    private void crarTablaB() {
        tblTorreB.setModel(tb.impresionPrimera("Torre B"));
        tblTorreB.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());
    }
    private void crarTablaC() {
        tblTorreC.setModel(tb.impresionPrimera("Torre C"));
        tblTorreC.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());
    }

    private void imprimirTablas(){
        tblTorreA.setModel(tb.impresionTorres("Torre A",partida.datosTorreA().length,partida.datosTorreA()));
        tblTorreA.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());

        tblTorreB.setModel(tb.impresionTorres("Torre B",partida.datosTorreB().length,partida.datosTorreB()));
        tblTorreB.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());

        tblTorreC.setModel(tb.impresionTorres("Torre C",partida.datosTorreC().length,partida.datosTorreC()));
        tblTorreC.getColumnModel().getColumn(0).setCellRenderer(tb.formatoCentro());
    }
    }



