package com.por.ui;

import com.por.ex.FxWebViewExample4;
import com.por.utils.Generic;
import com.por.utils.GlobalConstants;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author E005397
 * Bharath Kumar Reddy V
 */
public class SetBaseURL extends JFrame {


    public SetBaseURL() {
        initComponents();
    }


    private void initComponents() {

        pnlHeader = new JPanel();
        txtSetBaseURL = new JLabel();
        lblClose = new JLabel();
        txtHeader1 = new JLabel();
        inputBaseURL = new JTextField();
        txtBASEURL = new JLabel();
        btnStartRecording = new JButton();
        btnCancel = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1,new Color(0,92,151) ));

        pnlHeader.setBackground(new Color(0, 92, 151));

        txtSetBaseURL.setFont(new Font("Calibri", 1, 25));
        txtSetBaseURL.setForeground(new Color(255, 255, 255));
        txtSetBaseURL.setText("Set you project's base URL");

        lblClose.setForeground(new Color(255, 255, 255));
        lblClose.setIcon(new ImageIcon(getClass().getResource("/icons/multiply_18px.png")));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        GroupLayout pnlHeaderLayout = new GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
                pnlHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtSetBaseURL)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblClose, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
        );
        pnlHeaderLayout.setVerticalGroup(
                pnlHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addComponent(lblClose, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtSetBaseURL)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        txtHeader1.setFont(new Font("Tahoma", 0, 15));
        txtHeader1.setText("Before you can start recording, you must specify a valid base URL for your project. Your tests will start by navigating to this URL.");

        inputBaseURL.setFont(new Font("Tahoma", 0, 17));
        inputBaseURL.setForeground(new Color(0, 101, 202));
     //   inputBaseURL.setText("http://newtours.demoaut.com/");
        inputBaseURL.setText("");
        inputBaseURL.setBorder(BorderFactory.createLineBorder(new Color(0, 162, 232)));

        txtBASEURL.setFont(new Font("Tahoma", 0, 13));
        txtBASEURL.setText("BASE URL");

        btnStartRecording.setText("START RECORDING");
        btnStartRecording.setFocusPainted(false);
        btnStartRecording.setBackground(new Color(240, 240, 240));
        btnStartRecording.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartRecordingActionPerformed(evt);
            }
        });


        btnCancel.setText("CANCEL");
        btnCancel.setFocusPainted(false);
        btnCancel.setBackground(new Color(240, 240, 240));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnStartRecording, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtBASEURL)
                                                        .addComponent(txtHeader1)
                                                        .addComponent(inputBaseURL, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtHeader1)
                                .addGap(18, 18, 18)
                                .addComponent(txtBASEURL)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputBaseURL, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(btnStartRecording, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {
        System.exit(0);

    }
    private void btnStartRecordingActionPerformed(java.awt.event.ActionEvent evt) {
        GlobalConstants.BASE_URL = inputBaseURL.getText();
        this.setVisible(false);
        GlobalConstants.JSON_FILE_PATH = Generic.choosefolderPath();
        Thread t = new Thread() {
            public void run() {
//                WebBrowser webBrowser = new WebBrowser();
//                webBrowser.browserLaunch(GlobalConstants.BASE_URL);
                FxWebViewExample4 fxWebViewExample4=new FxWebViewExample4();
                fxWebViewExample4.browserLaunch(GlobalConstants.BASE_URL);
            }
        };
        t.start();



    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetBaseURL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnCancel;
    private JButton btnStartRecording;
    private JTextField inputBaseURL;
    private JLabel lblClose;
    private JPanel pnlHeader;
    private JLabel txtBASEURL;
    private JLabel txtHeader1;
    private JLabel txtSetBaseURL;
    // End of variables declaration
}

