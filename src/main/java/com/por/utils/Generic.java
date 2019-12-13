package com.por.utils;

import com.por.ui.Controls;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author bharat.vatrapu@gmail.com
 */

public class Generic {


    public static String removeSpecialChars(String string){
        String str;
        str = string.trim().replaceAll("\\s+","");
        //str = str.replaceAll("[-'`~!@#$%&()_;:,<>.?/+^|]*", "");
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        return str;
    }


    public static String getDate(){
        String DateNow=null;
        try {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            DateNow = dateFormat.format(date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return DateNow;
    }
    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("kk_mm_ss");
        String TimeNow = dateFormat.format(date);
        return TimeNow;
    }
    public static String choosefolderPath(){
        // JOptionPane.showMessageDialog(null,"Select Project Directory upto 'src' Path!");
        String strPath = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose Path");
//        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            strPath = chooser.getSelectedFile().toString();

        } else {
            JOptionPane.showMessageDialog(null,"Select Project Directory Path only!");
        }
        return strPath;
    }
    public static boolean isFileExist(String filePath){
        boolean fvar = true;
        try{
            File file = new File(filePath);
            if (file.exists()) {
                fvar = true;
            } else {
                fvar = false;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return fvar;
    }

    public static boolean createFolder(String dirPath){
        boolean fvar = false;
        try {
            File file = new File(dirPath);
            if (file.exists()) {
                fvar = true;
            } else {
                fvar = file.mkdir();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fvar;
    }
    public static String readConfigProp() {
        ClassLoader loader = null;

        String path = null;
        try {
            File file = new File(System.getProperty("user.home"));
            URL[] urls = {file.toURI().toURL()};
            loader = new URLClassLoader(urls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResourceBundle rbTestdata = ResourceBundle.getBundle("smartspy", Locale.getDefault(), loader);
        return rbTestdata.getString("drivers.path");
    }

    public static String getXpath(String selectedIdentifier,String value,String xpath){
        String status=null;
        switch (selectedIdentifier.toLowerCase()){
            case "id":
                status = "id = '"+value+"'";
                break;
            case "name":
                status = "name = '"+value+"'";
                break;
            case "xpath relative":
                status=xpath;
                break;
            case "xpath absolute":
                status=xpath;
                break;
            case "tagname":
                status ="tagname ='"+value+"'";
                break;
            case "css":
                status = "css = '"+value+"'";
                break;
            case "classname":
                status = "classname ='"+value+"'";
                break;
        }
        return status;
    }

    public static void getPageObjectStructure(String tagname,String type, String identifier,String value){
        String xpath=null;
        System.out.println("value:"+value+">>tagname:"+tagname+">> type:"+type+">> identifier:"+identifier);
        String selectedIdentifier = Controls.getIdentifier();
        if(identifier.equalsIgnoreCase("text")){
            identifier = "text()";
        } else{
            identifier = "@"+identifier;
        }
        switch (tagname.toLowerCase()){
            case "input":
                if(type.equalsIgnoreCase("text") || type.equalsIgnoreCase("password") || type.equalsIgnoreCase("input") || type.equalsIgnoreCase("email") || type.equalsIgnoreCase("number") || type.equalsIgnoreCase("search") || type.equalsIgnoreCase("url") || type.equalsIgnoreCase("tel")){
                    xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                    Controls.inputXpathRelative.setText(xpath);
                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"input_"+value,"Input Box",getXpath(selectedIdentifier,value,xpath)});
                }
//                if(identifier.equalsIgnoreCase("formcontrolname")){
//                    xpath = "//"+tagname+"["+identifier+"='"+value+"']";
//                    Controls.inputXpathRelative.setText(xpath);
//                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
//                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"input_"+value,"Input Box",getXpath(selectedIdentifier,value,xpath)});
//                }
                if(type.equalsIgnoreCase("image") || type.equalsIgnoreCase("submit")){
                    xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                    Controls.inputXpathRelative.setText(xpath);
                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"btn_"+value,"Button",getXpath(selectedIdentifier,value,xpath)});
                }
                if(type.equalsIgnoreCase("checkbox")){
                    xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                    Controls.inputXpathRelative.setText(xpath);
                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"chkbox_"+value,"CheckBox",getXpath(selectedIdentifier,value,xpath)});
                }
                if(type.equalsIgnoreCase("radio")){
                    xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                    Controls.inputXpathRelative.setText(xpath);
                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"radio_"+value,"RadioButton",getXpath(selectedIdentifier,value,xpath)});
                }
//                if(type.equalsIgnoreCase("radio")){
//                    x
//                    GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
//                    Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"radio_"+value,"RadioButton","//"+tagname+"["+identifier+"='"+value+"']"});
//                }
                break;
            case "button":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"btn_"+value,"Button",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "span":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"btn_"+value,"Button",getXpath(selectedIdentifier,value,xpath)});
                break;

            case "a":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"lnk_"+value,"Link",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "select":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"list_"+value,"ComboBox",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h1":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h2":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h3":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h4":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h5":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
            case "h6":
                xpath = "//"+tagname+"["+identifier+"='"+value+"']";
                Controls.inputXpathRelative.setText(xpath);
                GlobalConstants.tblRowno_incrementor = GlobalConstants.tblRowno_incrementor+1;
                Controls.tblRecordmodel.addRow(new Object[]{GlobalConstants.tblRowno_incrementor,"txt_"+value,"Text",getXpath(selectedIdentifier,value,xpath)});
                break;
        }

    }

}
