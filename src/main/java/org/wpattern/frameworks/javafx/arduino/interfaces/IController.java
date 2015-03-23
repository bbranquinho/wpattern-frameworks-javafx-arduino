package org.wpattern.frameworks.javafx.arduino.interfaces;

import javafx.stage.Stage;

import org.wpattern.frameworks.javafx.arduino.configs.FXMLDialog;

public interface IController {

	public default void setDialog(FXMLDialog fxmlDialog) { }

	public default void setPrimaryStage(Stage primaryStage) { }

}
