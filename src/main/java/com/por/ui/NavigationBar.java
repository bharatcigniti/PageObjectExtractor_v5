//package com.por.ui;
//
//import com.por.ex.FxWebViewExample4;
//import com.por.utils.GlobalConstants;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//import javafx.stage.FileChooser;
//
//public class NavigationBar extends HBox
//{
//	// Create the FileChooser
//	private FileChooser fileChooser = new FileChooser();
//
//
//
//	public NavigationBar(WebView webView, String homePageUrl, boolean goToHomePage)
//	{
//		// Set Spacing
//		this.setSpacing(4);
//
//		// Create the Label
//		Label label = new Label("URL:");
//
//
//		// Create the WebEngine
//		WebEngine webEngine = webView.getEngine();
//
//		// Create the TextField
//		TextField pageUrl = new TextField();
//		pageUrl.setText(GlobalConstants.BASE_URL);
//		// Create the Buttons
//		Button goButton = new Button("Go");
//		Button controlsButton = new Button("Controls");
//		goButton.setStyle("-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 );");
//		//Button openButton = new Button("Open");
//
//		// Let the TextField grow horizontallly
//		HBox.setHgrow(pageUrl, Priority.ALWAYS);
//		//HBox.setHgrow(progressBar,Priority.ALWAYS);
//
//		// Add an ActionListener to navigate to the entered URL
//		pageUrl.setOnAction(new EventHandler<ActionEvent>()
//		{
//			@Override
//			public void handle(ActionEvent event)
//			{
//				webEngine.load(pageUrl.getText());
//			}
//		});
//
//		// Update the stage title when a new web page title is available
//		webEngine.locationProperty().addListener(new ChangeListener<String>()
//		{
//		    public void changed(ObservableValue<? extends String> ov,
//		            final String oldvalue, final String newvalue)
//		    {
//		    	// Set the Title of the Stage
//		    	pageUrl.setText(newvalue);
//		    }
//		});
//
//
//
//		// Add an ActionListener for the Go Button
//		goButton.setOnAction(new EventHandler<ActionEvent>()
//		{
//			@Override
//			public void handle(ActionEvent event)
//			{
//				webEngine.load(pageUrl.getText());
//			}
//		});
//
//		// Add an ActionListener for the Home Button
//		controlsButton.setOnAction(new EventHandler<ActionEvent>()
//		{
//			@Override
//			public void handle(ActionEvent event)
//			{
////				new Controls();
//			//	WebBrowser.controls=new Controls();
//				FxWebViewExample4.controls.setVisible(true);
//				Controls.init_Load();
//			}
//		});
//
//
////		Button openButton = new Button("Open");
//		// Add the Children to the Navigation Bar
//		this.getChildren().addAll(label, pageUrl,goButton,  controlsButton,WebBrowser.progressBar);
//
//		if (goToHomePage)
//		{
//			// Load the URL
//			webEngine.load(homePageUrl);
//		}
//	}
//}
