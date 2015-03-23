package org.wpattern.frameworks.javafx.arduino.controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.wpattern.frameworks.javafx.arduino.interfaces.IController;
import org.wpattern.frameworks.javafx.arduino.utils.JavaFXUtils;

public class RootLayoutController implements IController {

	private Stage primaryStage;

	public RootLayoutController() {
	}

	@Override
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	private void handleExportDevices() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");

		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showSaveDialog(this.primaryStage);

		if (file != null) {
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}

			this.exportDataToFile(file);
		}
	}

	@FXML
	private void handleAbout() {
		JavaFXUtils.showDialog("WPattern JavaFX Arduino", "About", "Author: Augusto Branquinho\nWebsite: http://wpattern.com\nGithut: http://github.com/bbranquinho"
				+ "\n\nThank you Marco Jakob for tutorial: http://code.makery.ch/library/javafx-8-tutorial/");
	}

	@FXML
	private void handleExit() {
		System.exit(0);
	}

	private void exportDataToFile(File file) {
		// TODO: Develop this method.
	}

}
