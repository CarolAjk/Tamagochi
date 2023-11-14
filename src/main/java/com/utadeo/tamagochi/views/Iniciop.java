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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        comidaDerechaJLabel.setVisible(false);
        comidaIzquierdaJLabel.setVisible(false);
        lamparapaJLabel.setVisible(false);
        xboxJLabel.setVisible(false);
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
        javax.swing.Timer timerBaño = new javax.swing.Timer(60000, bañoListener);// mil milisegundos
        timerBaño.setInitialDelay(0);
        timerBaño.start();
        
         ActionListener comidaListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
              updateComida();     
            }
        };
        javax.swing.Timer timerComida = new javax.swing.Timer(60000, comidaListener);// mil milisegundos
        timerComida.setInitialDelay(0);
        timerComida.start();
        
        ActionListener sueñoListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
              updateSueño();     
            }
        };
        javax.swing.Timer timerSueño = new javax.swing.Timer(6000, sueñoListener);// mil milisegundos
        timerSueño.setInitialDelay(0);
        timerSueño.start();  
        
        ActionListener energiaListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
              updateEnergia();     
            }
        };
        javax.swing.Timer timerEnergia = new javax.swing.Timer(6000, energiaListener);// mil milisegundos
        timerEnergia.setInitialDelay(0);
        timerEnergia.start();
    }
    
    private void updateBaño() {
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        if(tamagochi.getBaño()==0){
            if (tamagochi.getTipo().compareTo("PA")==0){
                tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_muerto.PNG"))); // NOI18N
            }else if (tamagochi.getTipo().compareTo("PI")==0){
                tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_muerto.PNG"))); // NOI18N
            }
            
        }else{
            
            tamagochi.setBaño(tamagochi.getBaño()-10);
            tamagochiDAO.update(tamagochi);
            
        }
    }
    
    private void updateEnergia() {
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        if(tamagochi.getEnergia()==0){
            if (tamagochi.getTipo().compareTo("PA")==0){
               tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_muerto.PNG"))); // NOI18N
            }else if (tamagochi.getTipo().compareTo("PI")==0){
                tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_muerto.PNG"))); // NOI18N
            }
           
        }else{
            
            tamagochi.setEnergia(tamagochi.getEnergia()-10);
            tamagochiDAO.update(tamagochi);
            
        }
    }
    
    private void updateSueño() {
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        tamagochi = tamagochiDAO.read(idTamagochi);
        if (tamagochi.getDormido()){
            if (tamagochi.getSueño()==100){
            } else {
                tamagochi.setSueño(tamagochi.getSueño()+10);
                tamagochiDAO.update(tamagochi);
              
            }
        } else {
          if(tamagochi.getSueño()==0){
              if (tamagochi.getTipo().compareTo("PA")==0){
                tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_muerto.PNG"))); // NOI18N
            }else if (tamagochi.getTipo().compareTo("PI")==0){
                tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_muerto.PNG"))); // NOI18N
            }
            
          } else{
            tamagochi.setSueño(tamagochi.getSueño()-10);
            tamagochiDAO.update(tamagochi);
          }  
        }
    }
   
    
    private void updateComida() {
        final TamagochiDAO tamagochiDAO = new TamagochiDAO();
        if(tamagochi.getHambre()==0){
            if (tamagochi.getTipo().compareTo("PA")==0){
               tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_muerto.PNG"))); // NOI18N
            }else if (tamagochi.getTipo().compareTo("PI")==0){
               tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_muerto.PNG"))); // NOI18N
            }
            
        }else{
            
            tamagochi.setHambre(tamagochi.getHambre()-10);
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
        lamparapaJLabel = new javax.swing.JLabel();
        comidaDerechaJLabel = new javax.swing.JLabel();
        comidaIzquierdaJLabel = new javax.swing.JLabel();
        esponjaJLabel = new javax.swing.JLabel();
        sueñoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        bañoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        juegoJLabel = new javax.swing.JLabel("", SwingConstants.CENTER);
        BCOMIDA = new javax.swing.JButton();
        xboxJLabel = new javax.swing.JLabel();
        BDORMIR = new javax.swing.JButton();
        lamparapiJLabel = new javax.swing.JLabel();
        BBAÑO = new javax.swing.JButton();
        BJUEGOS = new javax.swing.JButton();
        tamagochiJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO PANDA-PINGUINO");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJLabel.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        nombreJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJLabel.setText("jLabel2");
        jPanel2.add(nombreJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 290, 70));

        hambreJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(hambreJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 110, 80));

        lamparapaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_lampara.png"))); // NOI18N
        lamparapaJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lamparapaJLabelMouseClicked(evt);
            }
        });
        jPanel2.add(lamparapaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 120, 250));

        comidaDerechaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_tacos.png"))); // NOI18N
        comidaDerechaJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comidaDerechaJLabelMouseClicked(evt);
            }
        });
        jPanel2.add(comidaDerechaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 150, 140));

        comidaIzquierdaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_bambu.png"))); // NOI18N
        comidaIzquierdaJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comidaIzquierdaJLabelMouseClicked(evt);
            }
        });
        jPanel2.add(comidaIzquierdaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 170, 110));

        esponjaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/esponjab.png"))); // NOI18N
        jPanel2.add(esponjaJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 130));

        sueñoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(sueñoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 100, 90));

        bañoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(bañoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 120, 80));

        juegoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel2.add(juegoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 120, 80));

        BCOMIDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BCOMIDA.PNG"))); // NOI18N
        BCOMIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCOMIDAActionPerformed(evt);
            }
        });
        jPanel2.add(BCOMIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 80, 80));

        xboxJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/xbox.png"))); // NOI18N
        xboxJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xboxJLabelMouseClicked(evt);
            }
        });
        jPanel2.add(xboxJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 160, 170));

        BDORMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BDORMIR3.PNG"))); // NOI18N
        BDORMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDORMIRActionPerformed(evt);
            }
        });
        jPanel2.add(BDORMIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 80, 80));

        lamparapiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_lampara.png"))); // NOI18N
        jPanel2.add(lamparapiJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 170, 210));

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
        jPanel2.add(tamagochiJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 430, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_i.PNG"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 700));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCOMIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCOMIDAActionPerformed
        comidaIzquierdaJLabel.setVisible(true);
        comidaDerechaJLabel.setVisible(true);
        lamparapaJLabel.setVisible(false);
        xboxJLabel.setVisible(false);
        
        if (tamagochi.getTipo().compareTo("PA")==0){
            comidaDerechaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_tacos.PNG"))); // NOI18N
            comidaIzquierdaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_bambu.PNG"))); // NOI18N
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/cocina_p.PNG"))); // NOI18N
        } else{
            comidaDerechaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_tamales.PNG"))); // NOI18N
            comidaIzquierdaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_pez.PNG"))); // NOI18N
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_c.PNG"))); // NOI18N
        }
    

       
      
    }//GEN-LAST:event_BCOMIDAActionPerformed

    private void BBAÑOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBAÑOActionPerformed
        comidaIzquierdaJLabel.setVisible(false);
        comidaDerechaJLabel.setVisible(false);
        lamparapaJLabel.setVisible(false);
        xboxJLabel.setVisible(false);
        
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_b.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_b.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BBAÑOActionPerformed

    private void BDORMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDORMIRActionPerformed
        comidaIzquierdaJLabel.setVisible(false);
        comidaDerechaJLabel.setVisible(false);
        lamparapaJLabel.setVisible(true);
        xboxJLabel.setVisible(false);
        
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_c.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_p.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BDORMIRActionPerformed

    private void BJUEGOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJUEGOSActionPerformed
        comidaIzquierdaJLabel.setVisible(false);
        comidaDerechaJLabel.setVisible(false);
        lamparapaJLabel.setVisible(false);
        xboxJLabel.setVisible(true);
        
        if (tamagochi.getTipo().compareTo("PA")==0){
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/panda/panda_i.PNG"))); // NOI18N
        } else{
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondos/pinguino/pinguino_i.PNG"))); // NOI18N
        }
    }//GEN-LAST:event_BJUEGOSActionPerformed

    private void comidaDerechaJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comidaDerechaJLabelMouseClicked

        TamagochiDAO tamagochiDAO = new TamagochiDAO();
        try {
            tamagochiDAO.feed(this.idTamagochi);
        } catch (Exception ex) {
            Logger.getLogger(Iniciop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_comidaDerechaJLabelMouseClicked

    private void comidaIzquierdaJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comidaIzquierdaJLabelMouseClicked
    TamagochiDAO tamagochiDAO = new TamagochiDAO();
        try {
            tamagochiDAO.feed(this.idTamagochi);
        } catch (Exception ex) {
            Logger.getLogger(Iniciop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comidaIzquierdaJLabelMouseClicked

    private void lamparapaJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamparapaJLabelMouseClicked
       TamagochiDAO tamagochiDAO = new TamagochiDAO();
        try {
            if (tamagochi.getDormido()){
                tamagochiDAO.sleep(this.idTamagochi,false);
                if (tamagochi.getTipo().compareTo("PA")==0){
                   tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_feliz.PNG"))); // NOI18N
                }else if (tamagochi.getTipo().compareTo("PI")==0){
                   tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_feliz.PNG"))); // NOI18N
                }
                 
            } else {
                tamagochiDAO.sleep(this.idTamagochi,true);
                if (tamagochi.getTipo().compareTo("PA")==0){
                  tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/panda/panda_dormir.PNG"))); // NOI18N
                }else if (tamagochi.getTipo().compareTo("PI")==0){
                  tamagochiJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pinguino/pinguino_dormir.PNG"))); // NOI18N
                }
                 
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Iniciop.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_lamparapaJLabelMouseClicked

    private void xboxJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xboxJLabelMouseClicked
        TamagochiDAO tamagochiDAO = new TamagochiDAO();
        try {
             tamagochiDAO.sumaEnergia(this.idTamagochi);
            
        } catch (Exception ex) {
            Logger.getLogger(Iniciop.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_xboxJLabelMouseClicked

    public void setIdTamagochi(Long idTamagochi) {
        this.idTamagochi = idTamagochi;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBAÑO;
    private javax.swing.JButton BCOMIDA;
    private javax.swing.JButton BDORMIR;
    private javax.swing.JButton BJUEGOS;
    private javax.swing.JLabel bañoJLabel;
    private javax.swing.JLabel comidaDerechaJLabel;
    private javax.swing.JLabel comidaIzquierdaJLabel;
    private javax.swing.JLabel esponjaJLabel;
    private javax.swing.JLabel hambreJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel juegoJLabel;
    private javax.swing.JLabel lamparapaJLabel;
    private javax.swing.JLabel lamparapiJLabel;
    private javax.swing.JLabel nombreJLabel;
    private javax.swing.JLabel sueñoJLabel;
    private javax.swing.JLabel tamagochiJLabel;
    private javax.swing.JLabel xboxJLabel;
    // End of variables declaration//GEN-END:variables
}
