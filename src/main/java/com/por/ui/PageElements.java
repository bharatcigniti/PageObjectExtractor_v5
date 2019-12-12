package com.por.ui;

import com.por.utils.DomExtractor;
import com.por.utils.GlobalConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author E005397
 */
public class PageElements extends JFrame {

  //  public static WebBrowserCapture webBrowserCapture;

    public PageElements() {
        initComponents();

    }

    public void loadInit(){
        chkSelectAll.setSelected(false);
    }


    private void initComponents() {

        chkSelectAll = new JCheckBox();
        jPanel1 = new JPanel();
        txtPageElements = new JLabel();
        lblClose = new JLabel();
        pnlPageObjects = new JPanel();
        chkLink = new JCheckBox();
        chkButton = new JCheckBox();
        chkInput = new JCheckBox();
        chkRadioButton = new JCheckBox();
        chkComboBox = new JCheckBox();
        chkCheckBox = new JCheckBox();
        chkText = new JCheckBox();
      //  btnStart = new JButton();
        btnCapture = new JButton();
        //chkSelectAll2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2,new Color(0,122,181) ));

        jPanel1.setBackground(new Color(0, 122, 181));
        chkSelectAll.setFont(new Font("Tahoma", 0, 14));
        chkSelectAll.setSelected(true);
        chkSelectAll.setText("Select All");

        chkSelectAll.addActionListener(actionListener);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      //  jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        txtPageElements.setFont(new Font("Tahoma", 1, 15));
        txtPageElements.setForeground(new Color(255, 255, 255));
        txtPageElements.setText("Select Page Elements");

        lblClose.setForeground(new Color(255, 255, 255));
        lblClose.setIcon(new ImageIcon(getClass().getResource("/icons/multiply_18px.png")));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtPageElements)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblClose, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPageElements)
                                        .addComponent(lblClose, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlPageObjects.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 0)));

        chkLink.setFont(new Font("Tahoma", 0, 14));
        chkLink.setText("Link");

        chkButton.setFont(new Font("Tahoma", 0, 14));
        chkButton.setText("Button");

        chkInput.setFont(new Font("Tahoma", 0, 14));
        chkInput.setText("Input");

        chkRadioButton.setFont(new Font("Tahoma", 0, 14));
        chkRadioButton.setText("RadioButton");

        chkComboBox.setFont(new Font("Tahoma", 0, 14));
        chkComboBox.setText("ComboBox");

        chkCheckBox.setFont(new Font("Tahoma", 0, 14));
        chkCheckBox.setText("CheckBox");

        chkText.setFont(new Font("Tahoma", 0, 14));
        chkText.setText("Text (Headers)");

        GroupLayout pnlPageObjectsLayout = new GroupLayout(pnlPageObjects);
        pnlPageObjects.setLayout(pnlPageObjectsLayout);
        pnlPageObjectsLayout.setHorizontalGroup(
                pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(chkLink)
                                        .addComponent(chkInput))
                                .addGap(70, 70, 70)
                                .addGroup(pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                                .addComponent(chkButton)
                                                .addGap(127, 127, 127)
                                                .addComponent(chkComboBox))
                                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                                .addComponent(chkRadioButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(chkCheckBox)))
                                .addGap(80, 80, 80)
                                .addComponent(chkText)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlPageObjectsLayout.setVerticalGroup(
                pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlPageObjectsLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(chkComboBox)
                                                .addComponent(chkText)
                                                .addComponent(chkButton))
                                        .addComponent(chkLink))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(pnlPageObjectsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(chkInput)
                                        .addComponent(chkRadioButton)
                                        .addComponent(chkCheckBox))
                                .addGap(26, 26, 26))
        );


//        btnStart.setFont(new Font("Calibri", 1, 15));
////        btnFind.setForeground(new java.awt.Color(0, 153, 102));
////        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
//        btnStart.setFocusPainted(false);
//        btnStart.setBackground(new Color(240, 240, 240));
//        btnStart.setText("OK");
//        btnStart.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                btnStartActionPerformed(evt);
//            }
//        });


        btnCapture.setFont(new Font("Calibri", 1, 15));
//        btnCapture.setForeground(new java.awt.Color(0, 153, 102));
//        btnCapture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnCapture.setFocusPainted(false);
        btnCapture.setBackground(new Color(240, 240, 240));
        btnCapture.setText("CAPTURE");
        btnCapture.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

//        chkSelectAll2.setFont(new java.awt.Font("Tahoma", 0, 14));
//        chkSelectAll2.setSelected(true);
//        chkSelectAll2.setText("Select All");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(chkSelectAll)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                               // .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                .addComponent(btnCapture, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(pnlPageObjects, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(28, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(chkSelectAll)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                     //   .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCapture, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(pnlPageObjects, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(110, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void btnStartActionPerformed(ActionEvent evt) {

//        ArrayList<String> objList=new ArrayList<String>();
//
//        if (chkLink.isSelected()) {
//            objList.add("Link");
//        }
//        if (chkButton.isSelected()) {
//            objList.add("Button");
//        }
//        if (chkCheckBox.isSelected()) {
//            objList.add("CheckBox");
//        }
//        if (chkInput.isSelected()) {
//            objList.add("EditBox");
//        }
//
//        if (chkRadioButton.isSelected()) {
//            objList.add("RadioButton");
//        }
//        if (chkComboBox.isSelected()) {
//            objList.add("ComboBox");
//        }
//        if(chkText.isSelected()){
//            objList.add("Text");
//        }
//        DomExtractor domExtractor = new DomExtractor();
//        domExtractor.smartExtractor(GlobalConstants.PAGE_SOURCE, objList);
//
//        String[] args=null;
//        String ObjectType=null;
//        String identifier=null;
//        GlobalConstants.tblRowno_incrementor = 0;
//        for (Map.Entry<String, String> entry : GlobalConstants.pageObjectsHashMap.entrySet()) {
//            args=entry.getValue().split("xpath = ");
//            identifier="xpath";
//            if(entry.getKey().contains("lnk_")){
//                ObjectType = "Link";
//            } else if(entry.getKey().contains("btn_")){
//                ObjectType = "Button";
//            } else if(entry.getKey().contains("radio_")){
//                ObjectType = "RadioButton";
//            }else if(entry.getKey().contains("input_")){
//                ObjectType = "TextBox";
//            } else if(entry.getKey().contains("chkbox_")){
//                ObjectType = "CheckBox";
//            } else if(entry.getKey().contains("list_")){
//                ObjectType = "List";
//            }
//            GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
//            Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,entry.getKey(),ObjectType,args[1].trim()});
//
//        }
//        btnStart.setVisible(false);
    }

    private void btnCaptureActionPerformed(ActionEvent evt) {
        ArrayList<String> objList=new ArrayList<String>();

        if (chkLink.isSelected()) {
            objList.add("Link");
        }
        if (chkButton.isSelected()) {
            objList.add("Button");
        }
        if (chkCheckBox.isSelected()) {
            objList.add("CheckBox");
        }
        if (chkInput.isSelected()) {
            objList.add("EditBox");
        }

        if (chkRadioButton.isSelected()) {
            objList.add("RadioButton");
        }
        if (chkComboBox.isSelected()) {
            objList.add("ComboBox");
        }
        if(chkText.isSelected()){
            objList.add("Text");
        }
        DomExtractor domExtractor = new DomExtractor();
        domExtractor.smartExtractor(GlobalConstants.PAGE_SOURCE, objList);

        String[] args=null;
        String ObjectType=null;
        String identifier=null;
        GlobalConstants.tblRowno_incrementor = 0;
        for (Map.Entry<String, String> entry : GlobalConstants.pageObjectsHashMap.entrySet()) {
            args=entry.getValue().split("xpath = ");
            identifier="xpath";
            if(entry.getKey().contains("lnk_")){
                ObjectType = "Link";
            } else if(entry.getKey().contains("btn_")){
                ObjectType = "Button";
            } else if(entry.getKey().contains("radio_")){
                ObjectType = "RadioButton";
            }else if(entry.getKey().contains("input_")){
                ObjectType = "TextBox";
            } else if(entry.getKey().contains("chkbox_")){
                ObjectType = "CheckBox";
            } else if(entry.getKey().contains("list_")){
                ObjectType = "List";
            }
            GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
            Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,entry.getKey(),ObjectType,args[1].trim()});

        }
        Controls.pageElements.setVisible(false);
    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
            boolean selected = abstractButton.getModel().isSelected();

            if(selected){
                chkLink.setSelected(true);
                chkButton.setSelected(true);
                chkCheckBox.setSelected(true);
                chkRadioButton.setSelected(true);
                chkComboBox.setSelected(true);
                chkInput.setSelected(true);
                chkText.setSelected(true);
            } else {

                chkLink.setSelected(false);
                chkButton.setSelected(false);
                chkCheckBox.setSelected(false);
                chkRadioButton.setSelected(false);
                chkComboBox.setSelected(false);
                chkInput.setSelected(false);
                chkText.setSelected(false);
            }
            // abstractButton.setText(newLabel);
        }
    };
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageElements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnCapture;
//    private JButton btnStart;
    private JCheckBox chkButton;
    private JCheckBox chkCheckBox;
    private JCheckBox chkInput;
    private JCheckBox chkLink;
    private JCheckBox chkComboBox;
    private JCheckBox chkRadioButton;
    private JCheckBox chkSelectAll;
    private JCheckBox chkText;
    private JPanel jPanel1;
    private JLabel lblClose;
    private JPanel pnlPageObjects;
    private JLabel txtPageElements;
    // End of variables declaration
}
