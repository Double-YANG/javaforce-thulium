package server;

/**
 *
 * @author pquiring
 *
 * Created : Mar 15, 2014
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javaforce.*;
import javaforce.jna.*;

public class Server extends javax.swing.JFrame implements ActionListener {

  /**
   * Creates new form Server
   */
  public Server() {
    initComponents();
    //create tray icon to open app
    JFImage img = new JFImage();
    img.load(getClass().getResourceAsStream("/jrdp.png"));
    setIconImage(img.getImage());
    img.load(getClass().getResourceAsStream("/jrdp-tray.png"));
    PopupMenu popup = new PopupMenu();
    show = new MenuItem("Show");
    show.addActionListener(this);
    popup.add(show);
    popup.addSeparator();
    exit = new MenuItem("Exit");
    exit.addActionListener(this);
    popup.add(exit);
    icon = new TrayIcon(img.getImage(), "RDP", popup);
    icon.addActionListener(this);
    tray = SystemTray.getSystemTray();
    try { tray.add(icon); } catch (Exception e) { JFLog.log(e); }
    //start service
    JF.initHttps();
    readConfig();
    JF.centerWindow(this);
    if (sslValid()) {
      service = new RDP();
      service.start(webPassword.getText(), rdpPassword.getText());
    } else {
      setVisible(true);
    }
  }

  public void readConfig() {
    try {
      Properties p = new Properties();
      FileInputStream fis = new FileInputStream(JF.getUserPath() + "/.jrdp.cfg");
      p.load(fis);
      fis.close();
      String wpass = p.getProperty("webPassword");
      webPassword.setText(wpass);
      String rpass = p.getProperty("rdpPassword");
      rdpPassword.setText(rpass);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void writeConfig() {
    try {
      Properties p = new Properties();
      p.setProperty("webPassword", webPassword.getText());
      p.setProperty("rdpPassword", rdpPassword.getText());
      FileOutputStream fos = new FileOutputStream(JF.getUserPath() + "/.jrdp.cfg");
      p.store(fos, "#jfRDP");
      fos.close();
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void restart() {
    if (service != null) {
      service.close();
      service = null;
      JF.sleep(1000);
    }
    if (sslValid()) {
      service = new RDP();
      service.start(webPassword.getText(), rdpPassword.getText());
    }
  }

  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (o == exit) {
      System.exit(0);
    }
    if (o == show) {
      readConfig();
      setVisible(true);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    save = new javax.swing.JButton();
    Cancel = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    webPassword = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    rdpPassword = new javax.swing.JTextField();
    generateSSL = new javax.swing.JButton();
    status = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();

    setTitle("jfRDP Server");

    save.setText("Save and Restart");
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveActionPerformed(evt);
      }
    });

    Cancel.setText("Cancel");
    Cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        CancelActionPerformed(evt);
      }
    });

    jLabel1.setText("RDP Configuration:");

    jLabel2.setText("Web Password");

    jLabel3.setText("RDP Password");

    generateSSL.setText("Generate SSL Certificate");
    generateSSL.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        generateSSLActionPerformed(evt);
      }
    });

    status.setText("Status : ...");

    jButton1.setText("Donate");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(generateSSL)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
            .addComponent(Cancel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(save))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(rdpPassword)
              .addComponent(webPassword)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(webPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(rdpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(save)
          .addComponent(Cancel)
          .addComponent(generateSSL)
          .addComponent(jButton1))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    writeConfig();
    restart();
    setVisible(false);
  }//GEN-LAST:event_saveActionPerformed

  private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
    setVisible(false);
  }//GEN-LAST:event_CancelActionPerformed

  private void generateSSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateSSLActionPerformed
    generateSSL();
  }//GEN-LAST:event_generateSSLActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    JF.showMessage("Donate", "If you find this program useful, please send $5 USD or more via paypal to pquiring@gmail.com");
  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    initSSL();
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Server();  //NOTE:Do NOT make it visible (it places icon in tray)
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Cancel;
  private javax.swing.JButton generateSSL;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField rdpPassword;
  private javax.swing.JButton save;
  private javax.swing.JLabel status;
  private javax.swing.JTextField webPassword;
  // End of variables declaration//GEN-END:variables

  public SystemTray tray;
  public TrayIcon icon;
  public MenuItem exit, show;
  public RDP service;

  private static String getSSLfile() {
    return JF.getUserPath() + "/.jrdp.key";
  }

  private void generateSSL() {
    KeyMgmt.keytool(new String[] {
      "-genkey", "-keystore", getSSLfile(), "-keyalg", "RSA"
      , "-storepass", "changeme", "-keypass", "changeme"
      , "-dname", "CN=jfrdp.sourceforge.net,OU=jfRDP,O=jfRDP,C=CA"
      , "-validity", "3600"
    });
    sslValid();
  }

  private static void initSSL() {
    System.setProperty("javax.net.ssl.keyStore", getSSLfile());
    System.setProperty("javax.net.ssl.keyStorePassword", "changeme");
  }

  private boolean sslValid() {
    try {
      if (new File(getSSLfile()).exists()) {
        status.setText("Status : Ready");
        return true;
      }
    } catch (Exception e) {}
    status.setText("Status : SSL Certficate not found");
    return false;
  }
}
