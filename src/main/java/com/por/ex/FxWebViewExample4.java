package com.por.ex;

import com.por.ui.Controls;
import com.por.utils.DomExtractor;
import com.por.utils.Generic;
import com.por.utils.GlobalConstants;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FxWebViewExample4 extends Application
{
	public static Controls controls;

	public static void main(String[] args)
	{
		Application.launch(args);
	}

	public void browserLaunch(String url){
		launch(url);
	}
	@Override
	public void start(final Stage stage)
	{
		// Create the WebView
		WebView webView = new WebView();

		// Update the stage title when a new web page title is available
//		webView.getEngine().titleProperty().addListener(new ChangeListener<String>()
//		{
//		    public void changed(ObservableValue<? extends String> ov,
//		            final String oldvalue, final String newvalue)
//		    {
//		    	// Set the Title of the Stage
//		    	stage.setTitle(newvalue);
//		    }
//		});


		webView.getEngine().titleProperty().addListener(new ChangeListener<String>()
		{
			public void changed(ObservableValue<? extends String> ov,
								final String oldvalue, final String newvalue){
				GlobalConstants.PAGE_TITLE = oldvalue;
				// Set the Title of the Stage
				stage.setTitle(newvalue);
				if(!StringUtils.isEmpty(GlobalConstants.PAGE_TITLE)){
					Controls.saveJson();
				}
			}
		});
		webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue == Worker.State.SUCCEEDED) {
				GlobalConstants.PAGE_SOURCE = (String) webView.getEngine().executeScript("document.documentElement.outerHTML");
			}
		});

//        engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        progressBar.setProgress(newValue.intValue());
//
//                    }
//                });
//            }
//        });

		webView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
					if (newState == Worker.State.SUCCEEDED) {

						//if the page is loaded
						//webView.getEngine().setJavaScriptEnabled(true);
						JSObject window = (JSObject) webView.getEngine().executeScript("window");
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


						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.getId(event.target.id);},false);"
						);
						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.getformcontrolname(event.target.placeholder);},false);"
						);
						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.getName(event.target.name);},false);"
						);
						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.getText(event.target.outerText);},false);"
						);
//                engine.executeScript("document.addEventListener('click', function(event) { " +
//                        "app.getData(event.target.nodeName,event.target.type);},false);"
//                );
						webView.getEngine().executeScript("var allInputs = document.getElementsByTagName('INPUT');" +
								"for(var i = 0; i < allInputs.length; i++) {" +
								"allInputs[i].addEventListener('blur',function(event){" +
								"app.getData(event.target.value);" +
								"})" +
								"}");
						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.action(event.target.nodeName,event.target.type);},false);"
						);
						webView.getEngine().executeScript("document.addEventListener('click', function(event) { " +
								"app.getData(event.target.nodeName,event.target.type);},false);"
						);
					}
		});





		// Load the Google web page
		String homePageUrl = GlobalConstants.BASE_URL;

		// Create the WebMenu
		MenuButton menu = new WebMenu(webView);

		// Create the Browser History
		BrowserHistory history = new BrowserHistory(webView);

		// Create the Navigation Bar
		NavigationBar navigationBar = new NavigationBar(webView, homePageUrl, true);
		// Add the Children to the Navigation Bar
		navigationBar.getChildren().addAll(menu,history);

		// Create the VBox
		VBox root = new VBox(navigationBar, webView);

		// Set the Style-properties of the VBox
//		root.setStyle("-fx-padding: 10;" +
//				"-fx-border-style: solid inside;" +
//				"-fx-border-width: 2;" +
//				"-fx-border-insets: 5;" +
//				"-fx-border-radius: 5;" +
//				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Display the Stage
		stage.show();
		try{
			controls=new Controls();
			controls.setVisible(false);
			Controls.init_Load();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void getData(String tagname,String type){
		System.out.println("getdata");
			}
	public void getId(String id){
		if(id!="undefined"){
			GlobalConstants.ID=id;
		}

	}
	public void getformcontrolname(String formcontrolname){
		if(!formcontrolname.equalsIgnoreCase("undefined")){
			GlobalConstants.getformcontrolname=formcontrolname;
		}

	}

	public void getText(String text){
		if(!text.equalsIgnoreCase("undefined")){
			GlobalConstants.TEXT = text;
		}
	}
	public void getName(String name){

		if(!name.equalsIgnoreCase("undefined")){
			System.out.println("name::"+name);
			GlobalConstants.NAME = name;
		}
	}

	public void action(String tagname,String type){
//
		System.out.println("action");
		Controls.init_Load();
		if(StringUtils.isEmpty(GlobalConstants.ID)){
			if(StringUtils.isEmpty(GlobalConstants.NAME)){
				if(StringUtils.isEmpty(GlobalConstants.getformcontrolname)){
					if(StringUtils.isEmpty(GlobalConstants.TEXT)){

					} else{
						Generic.getPageObjectStructure(tagname,type,"text",GlobalConstants.TEXT);
					}
				} else{
					Generic.getPageObjectStructure(tagname,type,"placeholder",GlobalConstants.getformcontrolname);
				}


			} else{
				Generic.getPageObjectStructure(tagname,type,"name",GlobalConstants.NAME);
			}

		} else {
			Generic.getPageObjectStructure(tagname,type,"id",GlobalConstants.ID);
		}
		//cleardata();
	}
	public void cleardata(){
		GlobalConstants.ID="";
		GlobalConstants.TEXT="";
		GlobalConstants.NAME="";
		GlobalConstants.getformcontrolname = "";
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
