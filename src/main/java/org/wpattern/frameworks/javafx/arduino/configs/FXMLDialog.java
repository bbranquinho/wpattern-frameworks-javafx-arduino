package org.wpattern.frameworks.javafx.arduino.configs;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import org.wpattern.frameworks.javafx.arduino.interfaces.IController;

public class FXMLDialog extends Stage {

	private Object fxmlObj;

	private IController controller;

	public FXMLDialog(IController controller, String fxml, Stage owner) {
		this(controller, fxml, owner, StageStyle.DECORATED);
	}

	public FXMLDialog(final IController controller, String fxml, Stage owner, StageStyle style) {
		super(style);
		this.controller = controller;
		this.controller.setPrimaryStage(owner);
		this.initOwner(owner);
		this.initModality(Modality.WINDOW_MODAL);
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxml));
		try {
			loader.setControllerFactory(new Callback<Class<?>, Object>() {
				@Override
				public Object call(Class<?> aClass) {
					return controller;
				}
			});
			controller.setDialog(this);
			this.fxmlObj = loader.load();
			this.setScene(new Scene((Parent) this.fxmlObj));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public IController getController() {
		return this.controller;
	}

	public BorderPane getBorderPane() {
		return (BorderPane) this.fxmlObj;
	}

	public AnchorPane getAnchorPane() {
		return (AnchorPane) this.fxmlObj;
	}

}
