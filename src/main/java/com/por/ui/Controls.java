package com.por.ui;

import com.por.utils.Generic;
import com.por.utils.GlobalConstants;
import com.por.utils.UIDesign;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author E005397
 */
public class Controls extends javax.swing.JFrame {

   static JSONArray objects = new JSONArray();
    public static DefaultTableModel tblRecordmodel = new DefaultTableModel();
    public static ButtonGroup bgSeleniumIdentifiers = new ButtonGroup();

    public static String selected_table_row_objName = null;
    public static String selected_table_row_objType = null;
    public static String selected_table_row_objPath = null;
    public static int selected_row = 0;

    public static PageElements pageElements;

    public Controls() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPageObjects = new javax.swing.JTable();
        rbID = new javax.swing.JRadioButton();
        inputID = new javax.swing.JTextField();
        rbText = new javax.swing.JRadioButton();
        inputText = new javax.swing.JTextField();
        rbName = new javax.swing.JRadioButton();
        inputName = new javax.swing.JTextField();
        rbTagName = new javax.swing.JRadioButton();
        inpuTagName = new javax.swing.JTextField();
        rbCSS = new javax.swing.JRadioButton();
        inputCSS = new javax.swing.JTextField();
        rbClassName = new javax.swing.JRadioButton();
        inputClassName = new javax.swing.JTextField();
        rbXpathRelative = new javax.swing.JRadioButton();
        InputXpathRelative = new javax.swing.JTextField();
        inputAbsolute = new javax.swing.JTextField();
        rbAbsoulte = new javax.swing.JRadioButton();
        btnCapture = new javax.swing.JButton();
        btnCaptureAll = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(0);

//        tblPageObjects.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null},
//                        {null, null, null, null}
//                },
//                new String [] {
//                        "Title 1", "Title 2", "Title 3", "Title 4"
//                }
//        ));
        tblRecordmodel.addColumn("Sno");
        tblRecordmodel.addColumn("Object Name");
        tblRecordmodel.addColumn("Object Type");
        tblRecordmodel.addColumn("xpath");
        tblPageObjects.setModel(tblRecordmodel);

        jScrollPane1.setViewportView(tblPageObjects);

        UIDesign.table_ui_style_blue(tblPageObjects);
        tblPageObjects.getSelectionModel().addListSelectionListener(new SelectionListener());
//        jScrollPane1.setViewportView(tblPageObjects);

        rbID.setText("ID: ");

        rbText.setText("Text:");

        rbName.setText("Name:");

        rbTagName.setText("TagName:");

        rbCSS.setText("CSS:");

        rbClassName.setText("ClassName:");

        rbXpathRelative.setText("Xpath Relative");

        rbAbsoulte.setText("Xpath Absolute");


        bgSeleniumIdentifiers.add(rbID);
        bgSeleniumIdentifiers.add(rbAbsoulte);
        bgSeleniumIdentifiers.add(rbClassName);
        bgSeleniumIdentifiers.add(rbCSS);
        bgSeleniumIdentifiers.add(rbName);
        bgSeleniumIdentifiers.add(rbTagName);
        bgSeleniumIdentifiers.add(rbXpathRelative);
        bgSeleniumIdentifiers.add(rbText);


        btnCapture.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnCapture.setForeground(new java.awt.Color(0, 153, 102));
//        btnCapture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnCapture.setFocusPainted(false);
        btnCapture.setBackground(new Color(240, 240, 240));
        btnCapture.setText("Capture Object");
        //        btnCapture.setToolTipText("");
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });


        btnCaptureAll.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnCaptureAll.setForeground(new java.awt.Color(0, 153, 102));
//        btnCaptureAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnCaptureAll.setFocusPainted(false);
        btnCaptureAll.setBackground(new Color(240, 240, 240));
        btnCaptureAll.setText("Capture All");
        //        btnCaptureAll.setToolTipText("");
        btnCaptureAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureAllActionPerformed(evt);
            }
        });


        btnFind.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnFind.setForeground(new java.awt.Color(0, 153, 102));
//        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnFind.setFocusPainted(false);
        btnFind.setBackground(new Color(240, 240, 240));
        btnFind.setText("Find");
        //        btnFind.setToolTipText("");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });


        btnDelete.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnDelete.setForeground(new java.awt.Color(0, 153, 102));
//        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnDelete.setFocusPainted(false);
        btnDelete.setBackground(new Color(240, 240, 240));
        btnDelete.setText("Delete");
        //        btnDelete.setToolTipText("");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });


        btnSave.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnSave.setForeground(new java.awt.Color(0, 153, 102));
//        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnSave.setFocusPainted(false);
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setText("Save");
        //        btnSave.setToolTipText("");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });


        btnClose.setFont(new java.awt.Font("Calibri", 1, 15));
//        btnClose.setForeground(new java.awt.Color(0, 153, 102));
//        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/detective_26px.png")));
        btnClose.setFocusPainted(false);
        btnClose.setBackground(new Color(240, 240, 240));
        btnClose.setText("Close");
        //        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(rbID, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(rbName, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(rbCSS, javax.swing.GroupLayout.Alignment.LEADING))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(inputCSS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(rbClassName)
                                                                                        .addGap(2, 2, 2))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                        .addGap(8, 8, 8)
                                                                                        .addComponent(rbTagName)))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addGap(26, 26, 26)
                                                                                .addComponent(rbText)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(inputClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(inpuTagName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(inputText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(rbAbsoulte)
                                                                        .addGap(36, 36, 36)
                                                                        .addComponent(inputAbsolute))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(rbXpathRelative)
                                                                        .addGap(36, 36, 36)
                                                                        .addComponent(InputXpathRelative, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(46, 46, 46)
                                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44, 44, 44)
                                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(btnCaptureAll, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(53, 53, 53)
                                                                        .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbID)
                                        .addComponent(inputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbText)
                                        .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbName)
                                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbTagName)
                                        .addComponent(inpuTagName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbCSS)
                                        .addComponent(inputCSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbClassName)
                                        .addComponent(inputClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbXpathRelative)
                                        .addComponent(InputXpathRelative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbAbsoulte)
                                        .addComponent(inputAbsolute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnCaptureAll, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void init_Load(){
        rbXpathRelative.setSelected(true);
        btnCapture.setEnabled(false);
        inputID.setText("");
        inputName.setText("");
        inputText.setText("");



        inputID.setText(GlobalConstants.ID);
        inputName.setText(GlobalConstants.NAME);
        inputText.setText(GlobalConstants.TEXT);
    }

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void btnCaptureAllActionPerformed(java.awt.event.ActionEvent evt) {
        pageElements=new PageElements();
        pageElements.loadInit();
        pageElements.setVisible(true);
    }
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
       saveJson();
    }

    public static void saveJson(){
        int rowCount = tblRecordmodel.getRowCount();
        if(rowCount>0) {

            objects.clear();

            for (int k = 0; k < rowCount; k++) {
                objects.add(getObjectInfo(tblRecordmodel.getValueAt(k, 1).toString(), tblRecordmodel.getValueAt(k, 2).toString(), tblRecordmodel.getValueAt(k, 3).toString()));
            }
            System.out.println("title::"+GlobalConstants.PAGE_TITLE);
            try (FileWriter file = new FileWriter(GlobalConstants.JSON_FILE_PATH + File.separator + Generic.removeSpecialChars(GlobalConstants.PAGE_TITLE) + "_" + Generic.getDate() + "_" + Generic.getTime() + ".json")) {
                file.write(objects.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
          //  JOptionPane.showMessageDialog(null, "Successfully Saved , File Path::" + GlobalConstants.JSON_FILE_PATH + File.separator + Generic.removeSpecialChars(GlobalConstants.PAGE_TITLE) + "_" + Generic.getDate() + "_" + Generic.getTime() + ".json", "Info", JOptionPane.INFORMATION_MESSAGE);

            clearTable();
        }
    }


    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        tblRecordmodel.removeRow(selected_row);
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        WebBrowser.controls.setVisible(false);
    }
    static JSONObject getObjectInfo(String objName, String objPath, String objType){
        JSONObject obj = new JSONObject();
        obj.put("Name", objName);
        obj.put("Value", objPath);
        obj.put("ObjType",objType);
        //obj.put("Actions", actions);
        return obj ;
    }

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controls().setVisible(true);
            }
        });
    }

    public static void clearTable(){
        int rowCount = tblRecordmodel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tblRecordmodel.removeRow(i);
        }
    }
    class SelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
                return;
            int row = tblPageObjects.getSelectedRow();
            if(row < 0)
                return;
            int col = tblPageObjects.getSelectedColumn();
            if(col < 0)
                return;

            if (tblPageObjects.getRowSorter()!=null) {
                row = tblPageObjects.getRowSorter().convertRowIndexToModel(row);
            }
            //tblProjects.clearSelection();
            selected_table_row_objName = (String) tblPageObjects.getModel().getValueAt(row, 1);
            selected_table_row_objType = (String) tblPageObjects.getModel().getValueAt(row, 2);
            selected_table_row_objPath = (String) tblPageObjects.getModel().getValueAt(row, 3);

            selected_row = row;
            //  Constants.TABLE_SELECTED = selected_table_row;

            // tblPageObjects.setSelectionBackground(Color.ORANGE);



        }
    }

    // Variables declaration - do not modify
    public static javax.swing.JTextField InputXpathRelative;
    public static javax.swing.JButton btnCapture;
    public static javax.swing.JButton btnCaptureAll;
    public static javax.swing.JButton btnClose;
    public static javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnFind;
    public static javax.swing.JButton btnSave;
    public static javax.swing.JTextField inpuTagName;
    public static javax.swing.JTextField inputAbsolute;
    public static javax.swing.JTextField inputCSS;
    public static javax.swing.JTextField inputClassName;
    public static javax.swing.JTextField inputID;
    public static javax.swing.JTextField inputName;
    public static javax.swing.JTextField inputSearch;
    public static javax.swing.JTextField inputText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JRadioButton rbAbsoulte;
    public static javax.swing.JRadioButton rbCSS;
    public static javax.swing.JRadioButton rbClassName;
    public static javax.swing.JRadioButton rbID;
    public static javax.swing.JRadioButton rbName;
    public static javax.swing.JRadioButton rbTagName;
    public static javax.swing.JRadioButton rbText;
    public static javax.swing.JRadioButton rbXpathRelative;
    public static javax.swing.JTable tblPageObjects;
    // End of variables declaration
}



