package Ventanas;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class pregunta6 extends javax.swing.JFrame {

    ArrayList<Integer> longitudesYaUsadas = new ArrayList<>();
    ArrayList<String> vocabulario = new ArrayList<>();
    ArrayList<String> cadenasGeneradas = new ArrayList<>();
    Palabras palabras = new Palabras();
    DefaultListModel<String> listModel = new DefaultListModel();

    public pregunta6() {
        initComponents();
        this.setSize(new Dimension(480, 500));
        jList1.setModel(listModel);
    }

    public void agregarElementoAVocabulario(String elemento) {
        if (!vocabulario.contains(elemento)) {
            if (vocabulario.size() < 7) {
                vocabulario.add(elemento);
            } else {
                JOptionPane.showMessageDialog(null, "El vocabulario solo permite un maximo de 7 elementos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El vocabulario ya contiene el elemento " + elemento);
        }
    }

    public void generarNCadenasAleatorias(int numeroDePalabras) {
        int longitud;
        for (int i = 0; i < numeroDePalabras; i++) {
            longitud = palabras.generarLongitudAleatoria(longitudesYaUsadas);
            cadenasGeneradas.add(palabras.generarPalabras(vocabulario, longitud));
            longitudesYaUsadas.add(longitud);
        }
    }

    public void mostrarCadenasGeneradas() {
        listModel.clear();
        for (int i = 0; i < cadenasGeneradas.size(); i++) {
            listModel.addElement(cadenasGeneradas.get(i));
        }
    }
    
    public void mostrarVocabulario(){
        String elementos = "";
        for (String elemento: vocabulario){
            elementos += elemento + ", ";
        }
        elementos = elementos.substring(0, elementos.length() - 2);
        vocabularioActual.setText("V = {"+elementos+"}");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btGenerarPalabras = new javax.swing.JButton();
        txCantidadPalabras = new javax.swing.JTextField();
        vocabularioActual = new javax.swing.JLabel();
        txElemento = new javax.swing.JTextField();
        btAgregarAVocabulario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(560, 430));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btGenerarPalabras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btGenerarPalabras.setForeground(new java.awt.Color(47, 46, 65));
        btGenerarPalabras.setText("Generar palabras");
        btGenerarPalabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarPalabrasActionPerformed(evt);
            }
        });
        jPanel1.add(btGenerarPalabras, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 180, 30));

        txCantidadPalabras.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txCantidadPalabras.setForeground(new java.awt.Color(47, 46, 65));
        txCantidadPalabras.setText("3");
        txCantidadPalabras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidadPalabrasKeyTyped(evt);
            }
        });
        jPanel1.add(txCantidadPalabras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 200, 30));

        vocabularioActual.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        vocabularioActual.setForeground(new java.awt.Color(47, 46, 65));
        vocabularioActual.setText("V = {}");
        jPanel1.add(vocabularioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, 30));

        txElemento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txElemento.setForeground(new java.awt.Color(47, 46, 65));
        txElemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txElementoKeyTyped(evt);
            }
        });
        jPanel1.add(txElemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 200, 30));

        btAgregarAVocabulario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAgregarAVocabulario.setForeground(new java.awt.Color(47, 46, 65));
        btAgregarAVocabulario.setText("Agregar a vocabulario");
        btAgregarAVocabulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarAVocabularioActionPerformed(evt);
            }
        });
        jPanel1.add(btAgregarAVocabulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 180, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Elemento:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Elementos registrados en el vocabulario terminal:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Numero de cadenas a generar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Cadenas generadas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jList1.setForeground(new java.awt.Color(47, 46, 65));
        jScrollPane3.setViewportView(jList1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 400, 160));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Pregunta 5");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pregunta 6");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btGenerarPalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarPalabrasActionPerformed
        if (vocabulario.size() > 0) {
            longitudesYaUsadas.clear();
            generarNCadenasAleatorias(Integer.parseInt(txCantidadPalabras.getText()));
            mostrarCadenasGeneradas();
        } else {
            JOptionPane.showMessageDialog(null, "El vocabulario debe tener entre 1 a 7 elementos");
        }
    }//GEN-LAST:event_btGenerarPalabrasActionPerformed

    private void btAgregarAVocabularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarAVocabularioActionPerformed
        String elementoCapturado = txElemento.getText().trim();
        if (elementoCapturado.length() == 1){
            agregarElementoAVocabulario(elementoCapturado);
            mostrarVocabulario();
        }
        txElemento.setText("");
        txElemento.grabFocus();
    }//GEN-LAST:event_btAgregarAVocabularioActionPerformed

    private void txCantidadPalabrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidadPalabrasKeyTyped
        if (!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }//GEN-LAST:event_txCantidadPalabrasKeyTyped

    private void txElementoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txElementoKeyTyped
        if (txElemento.getText().length() >= 1)
            evt.consume();
    }//GEN-LAST:event_txElementoKeyTyped

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
            java.util.logging.Logger.getLogger(pregunta6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new pregunta6().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarAVocabulario;
    private javax.swing.JButton btGenerarPalabras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txCantidadPalabras;
    private javax.swing.JTextField txElemento;
    private javax.swing.JLabel vocabularioActual;
    // End of variables declaration//GEN-END:variables
}
