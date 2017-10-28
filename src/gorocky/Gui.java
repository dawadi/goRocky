/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gorocky;

import static gorocky.FlappyBird.goRocky;
import javax.swing.ImageIcon;

/**
 *
 * @author dawadi
 */
public class Gui extends javax.swing.JFrame {

    /**
     * Creates new form Gui
     */
    //goRocky = new FlappyBird();
    
    public Gui() {
        initComponents();
        //FlappyBird.main(new String[0]);
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
        NewGame = new javax.swing.JButton();
        HighScore = new javax.swing.JButton();
        Exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        NewGame.setBackground(new java.awt.Color(255, 255, 255));
        NewGame.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        NewGame.setForeground(new java.awt.Color(255, 255, 255));
        NewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gorocky/purple_button.png"))); // NOI18N
        NewGame.setText("New Game");
        NewGame.setToolTipText("");
        NewGame.setBorderPainted(false);
        NewGame.setContentAreaFilled(false);
        NewGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NewGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewGameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewGameMouseExited(evt);
            }
        });
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        HighScore.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        HighScore.setForeground(new java.awt.Color(255, 255, 255));
        HighScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gorocky/purple_button.png"))); // NOI18N
        HighScore.setText("High Score");
        HighScore.setBorderPainted(false);
        HighScore.setContentAreaFilled(false);
        HighScore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HighScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Exit.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gorocky/purple_button.png"))); // NOI18N
        Exit.setText("Exit");
        Exit.setBorderPainted(false);
        Exit.setContentAreaFilled(false);
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(HighScore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(HighScore, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        //FlappyBird();
        
        String[] args = null;
        goRocky.main(args);
        //flappyBird.show();
        //new FlappyBird().setVisible(true);
        //flappyBird.FlappyBird();
        //FlappyBird fb = new FlappyBird();

    }//GEN-LAST:event_NewGameActionPerformed

    private void NewGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseClicked
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/purple_button_hover.png"));
        NewGame.setIcon(II);
    }//GEN-LAST:event_NewGameMouseClicked

    private void NewGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseEntered
        // TODO add your handling code here:
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/purple_button_hover.png"));
        NewGame.setIcon(II);
    }//GEN-LAST:event_NewGameMouseEntered

    private void NewGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseExited
        ImageIcon II = new ImageIcon(getClass().getResource("/Images/purple_button.png"));
        NewGame.setIcon(II);
        // TODO add your handling code here:
    }//GEN-LAST:event_NewGameMouseExited

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton HighScore;
    private javax.swing.JButton NewGame;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
