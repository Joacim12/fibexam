package view;

import java.util.Observable;
import java.util.Observer;
import control.Control;
import model.Timer;

/**
 *
 * @author Joacim
 */
public class JFrame extends javax.swing.JFrame implements Observer {

    private boolean running = true;
    public JFrame() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addTimer = new javax.swing.JToggleButton();
        getFibo = new javax.swing.JButton();
        val = new javax.swing.JTextField();
        time = new javax.swing.JLabel();
        result = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addTimer.setText("Add timer");
        addTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTimerActionPerformed(evt);
            }
        });

        getFibo.setText("Get fibonacci");
        getFibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getFiboActionPerformed(evt);
            }
        });

        result.setText("Result:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getFibo)
                            .addComponent(addTimer)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(result)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addTimer)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getFibo)
                    .addComponent(val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(result)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    Control c = new Control();
    private void addTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTimerActionPerformed
        c.timerAddObserver(this);
        new Thread(() -> {
            while (running) {
                c.getTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Timer got interrupted!");
                }
            }
        }).start();
    }//GEN-LAST:event_addTimerActionPerformed

    private void getFiboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getFiboActionPerformed
        c.fibAddObserver(this);
        result.setText("Result: Calculating!");
        new Thread(() -> {
            c.getFibResult(Integer.parseInt(val.getText()));
        }
        ).start();
    }//GEN-LAST:event_getFiboActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addTimer;
    private javax.swing.JButton getFibo;
    private javax.swing.JLabel result;
    private javax.swing.JLabel time;
    private javax.swing.JTextField val;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
       if(o instanceof Timer){
           time.setText(o1.toString());
        } else{
           result.setText(o1.toString());
       }
//        String check = o1.toString();
//        if (check.contains(":")) {
//            time.setText(check);
//        } else {
//            result.setText("Result: " + check);
//        }
    }
}
