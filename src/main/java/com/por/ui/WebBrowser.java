package com.por.ui;

import com.por.utils.Generic;
import com.por.utils.GlobalConstants;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;

public class WebBrowser extends Application {

    public static ProgressBar progressBar;
    public static Controls controls;

//    public static void main(String[] args) {
//        launch(args);
//    }

    public void browserLaunch(String url){
        launch(url);
    }


    public void start(Stage primaryStage) {



        primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();

        WebEngine engine = webView.getEngine();
         progressBar= new ProgressBar(0);

        webView.getEngine().titleProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov,
                                final String oldvalue, final String newvalue){
                GlobalConstants.PAGE_TITLE = oldvalue;
                // Set the Title of the Stage
                primaryStage.setTitle(newvalue);
                if(!StringUtils.isEmpty(GlobalConstants.PAGE_TITLE)){
                    Controls.saveJson();
                }
            }
        });
        engine.getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                GlobalConstants.PAGE_SOURCE = (String) engine.executeScript("document.documentElement.outerHTML");
            }
        });

        engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(newValue.intValue());

                    }
                });
            }
        });

        engine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {

                //if the page is loaded
                engine.setJavaScriptEnabled(true);
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("app", this);
//                engine.executeScript("document.addEventListener('click', function(event) { " +
//                        "if(event.target.id === ''){" +
//                        "if(event.target.name === ''){"+
//                        "app.getIdentifier(event.target.outerText,'text',event.target.type,event.target.nodeName);" +
//
//                        "} else{"+
//                        "app.getIdentifier(event.target.name,'name',event.target.type,event.target.nodeName);" +
//                        "}"+
//                        "}else{" +
//                        "app.getIdentifier(event.target.id,'id',event.target.type,event.target.nodeName);" +
//                        "} " +
//                        "}, false);");

                engine.executeScript("document.addEventListener('click', function(event) { " +
                        "app.getId(event.target.id);},false);"
                );
                engine.executeScript("document.addEventListener('click', function(event) { " +
                        "app.getName(event.target.name);},false);"
                );
                engine.executeScript("document.addEventListener('click', function(event) { " +
                        "app.getText(event.target.outerText);},false);"
                );
//                engine.executeScript("document.addEventListener('click', function(event) { " +
//                        "app.getData(event.target.nodeName,event.target.type);},false);"
//                );
                engine.executeScript("var allInputs = document.getElementsByTagName('INPUT');" +
                        "for(var i = 0; i < allInputs.length; i++) {" +
                        "allInputs[i].addEventListener('blur',function(event){" +
                        "app.getData(event.target.value);" +
                        "})" +
                        "}");
                engine.executeScript("document.addEventListener('click', function(event) { " +
                        "app.action(event.target.nodeName,event.target.type);},false);"
                );
            }


        });

        String homePageUrl = "http://newtours.demoaut.com/";
//        String homePageUrl = "http://10.62.65.229:81/sugarcrm/index.php?action=Login&module=Users";
        engine.load(homePageUrl);

        NavigationBar navigationBar = new NavigationBar(webView, homePageUrl, true);

        VBox vBox = new VBox(navigationBar,webView);
        Scene scene = new Scene(vBox, 1200, 660);

        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            Thread.sleep(30);
            controls=new Controls();
            controls.setVisible(false);
            Controls.init_Load();
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    public void getId(String id){
        GlobalConstants.ID=id;
    }

    public void getText(String text){
        GlobalConstants.TEXT=text;
    }
    public void getName(String name){
        GlobalConstants.NAME=name;
    }

    public void action(String tagname,String type){
        Controls.init_Load();
        if(StringUtils.isEmpty(GlobalConstants.ID)){
            if(StringUtils.isEmpty(GlobalConstants.NAME)){
                if(StringUtils.isEmpty(GlobalConstants.TEXT)){

                } else{
                    Generic.getPageObjectStructure(tagname,type,"text",GlobalConstants.TEXT);
                }

            } else{
                Generic.getPageObjectStructure(tagname,type,"name",GlobalConstants.NAME);
            }

        } else {
            Generic.getPageObjectStructure(tagname,type,"id",GlobalConstants.ID);
        }
    }
    public void cleardata(){
        GlobalConstants.ID="";
        GlobalConstants.TEXT="";
        GlobalConstants.NAME="";
    }
    public void getIdentifier(String value,String By,String type,String tagname) {
        //System.out.println("value:"+value+">>By:"+By+">>type:"+type+">>tagname:"+tagname);
        switch (By.toLowerCase()){
            case "id":
                GlobalConstants.ID = "";
                GlobalConstants.ID=value;
                break;
            case "name":
                GlobalConstants.NAME = "";
                GlobalConstants.NAME=value;
                break;
            case "text":
                GlobalConstants.TEXT = "";
                GlobalConstants.TEXT=value;
                break;

        }

        Controls.init_Load();

    }
}
