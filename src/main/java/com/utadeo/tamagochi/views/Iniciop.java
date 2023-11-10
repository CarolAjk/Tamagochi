/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.utadeo.tamagochi.views;

import com.utadeo.tamagochi.database.daos.TamagochiDAO;
import com.utadeo.tamagochi.database.entities.Tamagochi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

/**
 *
 * @author LENOVO
 */
public class Iniciop extends javax.swing.JFrame {
    
    private Long idTamagochi; 
    private Tamagochi tamagochi;

    /**
     * Creates new form Iniciop
     */
    public Iniciop() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        initLabels();
        
    }
    
    private void initLabels() {
        hambreJLabel.setBackground(Color.white);
        hambreJLabel.setOpaque(false);
        
        
        sueñoJLabel.setBackground(Color.white);
        sueñoJLabel.setOpaque(false);
        
        
        juegoJLabel.setBackground(Color.white);
        juegoJLabel.setOpaque(false);
        
        
        bañoJLabel.setBackground(Color.white);
        bañoJLabel.setOpaque(false);
        
        
        
    }
    
    public void loadTamagochi(){
        
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        tamagochi = tamagochiDAO.read(this.idTamagochi);
        
        hambreJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getHambre())  + ".PNG"))); // NOI18N
        bañoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getBaño())  + ".PNG"))); // NOI18N
        juegoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getEnergia())  + ".PNG"))); // NOI18N
        sueñoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getSueño())  + ".PNG"))); // NOI18N
        
        nombreJLabel.setText(tamagochi.getNombre());
        
       
        if (tamagochi.getTipo().compareTo("PA")==0){
          jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_i.PNG"))); // NOI18N
          tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_feliz.PNG"))); // NOI18N
        }else if (tamagochi.getTipo().compareTo("PI")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_i.PNG"))); // NOI18N
            tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_feliz.PNG"))); // NOI18N
        }
        
        ActionListener porcentajesListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
               loadTamagochiPorcentajes();             
            }
        };
        javax.swing.Timer timerPorcentajes = new javax.swing.Timer(1000, porcentajesListener);// mil milisegundos
        timerPorcentajes.setInitialDelay(0);
        timerPorcentajes.start();
        
        ActionListener bañoListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
              updateBaño();       
            }
        };
        javax.swing.Timer timerBaño = new javax.swing.Timer(3000, bañoListener);// mil milisegundos
        timerBaño.setInitialDelay(0);
        timerBaño.start();
    }
    
    private void updateBaño() {
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        if(tamagochi.getBaño()==0){
            tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_muerto.PNG"))); // NOI18N
        }else{
            
            tamagochi.setBaño(tamagochi.getBaño()-10);
            tamagochiDAO.update(tamagochi);
            
        }
    }
    
    private void loadTamagochiPorcentajes(){
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        tamagochi = tamagochiDAO.read(this.idTamagochi);
        
        hambreJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getHambre())  + ".PNG"))); // NOI18N
        bañoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getBaño())  + ".PNG"))); // NOI18N
        juegoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getEnergia())  + ".PNG"))); // NOI18N
        sueñoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porcentajes/" + String.valueOf(tamagochi.getSueño())  + ".PNG"))); // NOI18N
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nombreJLabel = new javax.swing.JLabel();
        hambreJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        sueñoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        bañoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        juegoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        BCOMIDA = new javax.swing.JButton();
        BDORMIR = new javax.swing.JButton();
        BBAÑO = new javax.swing.JButton();
        BJUEGOS = new javax.swing.JButton();
        tamagochiJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO PANDA-PINGUINO");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJLabel.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        nombreJLabel.setForeground(new java.awt.Color(0, 0, 0));
        nombreJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJLabel.setText("jLabel2");
        jPanel2.add(nombreJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 290, 70));

        hambreJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        hambreJLabel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(hambreJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 110, 80));

        sueñoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sueñoJLabel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(sueñoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 100, 90));

        bañoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bañoJLabel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(bañoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 120, 80));

        juegoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        juegoJLabel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(juegoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 120, 80));

        BCOMIDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BCOMIDA.PNG"))); // NOI18N
        BCOMIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCOMIDAActionPerformed(evt);
            }
        });
        jPanel2.add(BCOMIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 80, 80));

        BDORMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDORMIR3.PNG"))); // NOI18N
        BDORMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDORMIRActionPerformed(evt);
            }
        });
        jPanel2.add(BDORMIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 80, 80));

        BBAÑO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BBAÑO3.PNG"))); // NOI18N
        BBAÑO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBAÑOActionPerformed(evt);
            }
        });
        jPanel2.add(BBAÑO, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 80, 80));

        BJUEGOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BJUEGOS.PNG"))); // NOI18N
        BJUEGOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJUEGOSActionPerformed(evt);
            }
        });
        jPanel2.add(BJUEGOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, 80, 80));

        tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_feliz.png"))); // NOI18N
        jPanel2.add(tamagochiJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, 340));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_i.PNG"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 700));

        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 560, -1, -1));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCOMIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCOMIDAActionPerformed
        
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/cocina_p.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_c.PNG"))); // NOI18N
        }
    

       
      
    }//GEN-LAST:event_BCOMIDAActionPerformed

    private void BBAÑOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBAÑOActionPerformed
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_b.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_b.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BBAÑOActionPerformed

    private void BDORMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDORMIRActionPerformed
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_c.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_p.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BDORMIRActionPerformed

    private void BJUEGOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJUEGOSActionPerformed
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_i.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_i.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BJUEGOSActionPerformed

    public void setIdTamagochi(Long idTamagochi) {
        this.idTamagochi = idTamagochi;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBAÑO;
    private javax.swing.JButton BCOMIDA;
    private javax.swing.JButton BDORMIR;
    private javax.swing.JButton BJUEGOS;
    private javax.swing.JLabel bañoJLabel;
    private javax.swing.JLabel hambreJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel juegoJLabel;
    private javax.swing.JLabel nombreJLabel;
    private javax.swing.JLabel sueñoJLabel;
    private javax.swing.JLabel tamagochiJLabel;
    // End of variables declaration//GEN-END:variables
}
