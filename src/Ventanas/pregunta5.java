package Ventanas;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class pregunta5 extends javax.swing.JFrame {

    ArrayList< ArrayList<String>> conjuntos = new ArrayList<>();
    ArrayList<String> auxiliar = new ArrayList<>();
    int numeroConjuntos = 1;
    String[] nombreConjuntos = new String[]{"A", "B", "C"};

    public pregunta5() {
        initComponents();
        this.setTitle("Pregunta 5");
        this.setSize(new Dimension(510, 620));
    }

    public String unionDeConjuntos(ArrayList<ArrayList<String>> conjuntos) {
        ArrayList<String> union = new ArrayList<>();
        for (int i = 0; i < conjuntos.size(); i++) {
            for (String elemento : conjuntos.get(i)) {
                if (!union.contains(elemento)) {
                    union.add(elemento);
                }
            }
        }

        return concatenarElementosDeConjunto(union);
    }

    public String interseccionDeConjuntos(ArrayList<ArrayList<String>> conjuntos) {
        System.out.println("Numero de elementos en conjuntos es "+conjuntos.size());
        ArrayList<String> conjuntoA = conjuntos.get(0);
        ArrayList<String> interseccion = new ArrayList<>(conjuntoA);
        for (int i = 0; i < conjuntoA.size(); i++) { //conjuntos A, B y C
            if (!buscarElementoEnConjuntos(conjuntos, conjuntoA.get(i))){
                interseccion.remove(conjuntoA.get(i));
            }
        }

        if (interseccion.isEmpty()) {
            return "No existe ningun elemento entre los conjuntos";
        } else {
            return concatenarElementosDeConjunto(interseccion);
        }
    }
    
    public boolean buscarElementoEnConjuntos(ArrayList<ArrayList<String>> conjuntos, String elementoBuscado){
        for (int i = 0; i < conjuntos.size(); i++){
            if (!conjuntos.get(i).contains(elementoBuscado)){
                return false;
            }
        }
        return true;
    }

    public String diferenciaDeConjuntos(String nombreConjuntoA, ArrayList<String> conjuntoA, String nombreConjuntoB, ArrayList<String> conjuntoB) {
        //Se retornara A - B
        ArrayList<String> diferencia = new ArrayList<>(conjuntoA);
        for (int i = 0; i < conjuntoB.size(); i++) {
            for (String elemento : conjuntoA) {
                if (elemento.equals(conjuntoB.get(i))) {
                    diferencia.remove(elemento);
                }
            }
        }

        String resultado = nombreConjuntoA + " - " + nombreConjuntoB + " = ";
        resultado += concatenarElementosDeConjunto(diferencia);
        return resultado;
    }

    public boolean agregarElementoAConjunto(String elemento) {
        if (elemento.trim().length() > 0) {
            if (!auxiliar.contains(elemento)) {
                auxiliar.add(elemento);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El elemento " + elemento + " ya existe en el conjunto");
                txElemento.setText("");
                txElemento.grabFocus();
                return false;
            }
        } else {
            txElemento.grabFocus();
            return false;
        }
    }

    public String concatenarElementosDeConjunto(ArrayList<String> conjunto) {
        String resultado = "{";
        for (String elemento : conjunto) {
            resultado += elemento + ", ";
        }
        if (conjunto.isEmpty()){
            resultado += "}";
        }else{
            resultado = resultado.substring(0, resultado.length() - 2) + "}";
        }
        return resultado;
    }

    public void mostrarConjuntos() {
        String resultado = "";
        if (conjuntos.size() > 0) {
            for (int i = 0; i < conjuntos.size(); i++) {
                resultado += nombreConjuntos[i] + " = " + concatenarElementosDeConjunto(conjuntos.get(i)) + "\n";
            }
        }
        resultado += nombreConjuntos[conjuntos.size()] + " = " + concatenarElementosDeConjunto(auxiliar) + "\n";

        taVistaConjuntos.setText(resultado);
    }
    
    public String mostrarNombreDeConjuntos(String concatenador){
        String resultado = "";
        for (int i = 0; i < conjuntos.size(); i++){
            resultado += nombreConjuntos[i] + " " + concatenador + " ";
        }
        return resultado.substring(0, resultado.length() - 3);
    }
    
    public void crearNuevoConjunto(){
        ArrayList<String> conjunto = new ArrayList<>(auxiliar);
        conjuntos.add(conjunto);
        auxiliar.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txElemento = new javax.swing.JTextField();
        btAgregarElemento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taVistaConjuntos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btRealizarOperaciones = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taVistaOperaciones = new javax.swing.JTextArea();
        btNuevoConjunto = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txElemento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txElemento.setForeground(new java.awt.Color(47, 46, 65));
        txElemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txElementoKeyTyped(evt);
            }
        });
        jPanel1.add(txElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, -1));

        btAgregarElemento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAgregarElemento.setForeground(new java.awt.Color(47, 46, 65));
        btAgregarElemento.setText("Agregar elemento al conjunto");
        btAgregarElemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarElementoActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 240, -1));

        taVistaConjuntos.setEditable(false);
        taVistaConjuntos.setColumns(20);
        taVistaConjuntos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        taVistaConjuntos.setForeground(new java.awt.Color(47, 46, 65));
        taVistaConjuntos.setRows(5);
        taVistaConjuntos.setText("A = {}");
        jScrollPane1.setViewportView(taVistaConjuntos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 430, 130));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Elementos del conjunto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Conjuntos creados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        btRealizarOperaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRealizarOperaciones.setForeground(new java.awt.Color(47, 46, 65));
        btRealizarOperaciones.setText("Realizar operaciones");
        btRealizarOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizarOperacionesActionPerformed(evt);
            }
        });
        jPanel1.add(btRealizarOperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        taVistaOperaciones.setEditable(false);
        taVistaOperaciones.setColumns(20);
        taVistaOperaciones.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        taVistaOperaciones.setForeground(new java.awt.Color(47, 46, 65));
        taVistaOperaciones.setRows(5);
        jScrollPane2.setViewportView(taVistaOperaciones);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 430, 200));

        btNuevoConjunto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btNuevoConjunto.setForeground(new java.awt.Color(47, 46, 65));
        btNuevoConjunto.setText("Nuevo conjunto");
        btNuevoConjunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoConjuntoActionPerformed(evt);
            }
        });
        jPanel1.add(btNuevoConjunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 140, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Ventanas");

        jMenuItem1.setText("Pregunta 5");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Pregunta 6");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoConjuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoConjuntoActionPerformed
        if ((!auxiliar.isEmpty() || conjuntos.size() > 0) && numeroConjuntos < 3) {
            numeroConjuntos++;
            crearNuevoConjunto();
            mostrarConjuntos();
        }else{
            JOptionPane.showMessageDialog(null, "Solo se pueden crear 3 conjuntos");
        }
    }//GEN-LAST:event_btNuevoConjuntoActionPerformed

    private void btAgregarElementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarElementoActionPerformed
        if (agregarElementoAConjunto(txElemento.getText())){
            mostrarConjuntos();
            txElemento.setText("");
            txElemento.grabFocus();
        }
    }//GEN-LAST:event_btAgregarElementoActionPerformed

    private void btRealizarOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizarOperacionesActionPerformed
        btNuevoConjunto.setEnabled(false);
        if (!auxiliar.isEmpty()){
            crearNuevoConjunto();
        }
        if (conjuntos.size() > 1){
            String resultado = "";
            //Union
            resultado += "Union de los conjuntos "+mostrarNombreDeConjuntos(",")+"\n";
            resultado += "   "+mostrarNombreDeConjuntos("U") +" = "+ unionDeConjuntos(conjuntos) + "\n";
            
            //Interseccion
            resultado += "\nInterseccion de los conjuntos "+mostrarNombreDeConjuntos(",")+"\n";
            resultado += "   "+mostrarNombreDeConjuntos("∩") +" = "+ interseccionDeConjuntos(conjuntos) + "\n";
            
            //Diferencia            
            resultado += "\nDiferencia de los conjuntos "+mostrarNombreDeConjuntos(",")+"\n";
            for (int i = 0; i < conjuntos.size(); i++){//Conjuntos A, B y C
                for (int j = 0; j < conjuntos.size(); j++){//Conjuntos A, B y C)
                    if ( i != j){
                        resultado += "   "+diferenciaDeConjuntos(nombreConjuntos[i], conjuntos.get(i), nombreConjuntos[j], conjuntos.get(j))+"\n";
                    }
                }
            }
            
            taVistaOperaciones.setText(resultado);
        }else{
            JOptionPane.showMessageDialog(null, "Debe de haber como minimo 2 conjuntos para realizar opraciones");
        }
    }//GEN-LAST:event_btRealizarOperacionesActionPerformed

    private void txElementoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txElementoKeyTyped
        if (txElemento.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_txElementoKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pregunta5 ventana = new pregunta5();
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        pregunta6 ventana = new pregunta6();
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pregunta5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pregunta5().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarElemento;
    private javax.swing.JButton btNuevoConjunto;
    private javax.swing.JButton btRealizarOperaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taVistaConjuntos;
    private javax.swing.JTextArea taVistaOperaciones;
    private javax.swing.JTextField txElemento;
    // End of variables declaration//GEN-END:variables
}
