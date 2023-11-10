/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.utadeo.tamagochi.views;


import com.utadeo.tamagochi.database.daos.TamagochiDAO;
import com.utadeo.tamagochi.database.entities.Tamagochi;
import java.awt.event.KeyEvent;

/**
 *
 * @author LENOVO
 */
public class Nombrem extends javax.swing.JFrame {
    
    private String tipo; 

    /**
     * Creates new form Nombrem
     */
    public Nombrem() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NOMBRE MASCOTA");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameJTextField.setBackground(new java.awt.Color(255, 255, 255));
        nameJTextField.setFont(new java.awt.Font("Arial", 2, 36)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        nameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameJTextFieldKeyPressed(evt);
            }
        });
        jPanel1.add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 410, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FN_MASCOTA.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 646, 669));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameJTextFieldKeyPressed
        
        try {
            
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.dispose();

                final Tamagochi tamagochi = new Tamagochi();
                tamagochi.setNombre(nameJTextField.getText());
                tamagochi.setBaño(100);
                tamagochi.setHambre(50);
                tamagochi.setSueño(60);
                tamagochi.setEnergia(100);
                tamagochi.setMuerte(false);
                tamagochi.setTipo(tipo);

                final TamagochiDAO tamagochiDAO = new TamagochiDAO();
                tamagochiDAO.insert(tamagochi);

                // Si se presiona Enter, abre la otra ventana aquí
                Iniciop nuevaVentana = new Iniciop();
                nuevaVentana.setIdTamagochi(tamagochi.getId());
                nuevaVentana.loadTamagochi();
                nuevaVentana.setVisible(true);
            }
                      
        } catch(Exception e){
            e.printStackTrace();
        }
 

    }//GEN-LAST:event_nameJTextFieldKeyPressed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameJTextField;
    // End of variables declaration//GEN-END:variables
}
