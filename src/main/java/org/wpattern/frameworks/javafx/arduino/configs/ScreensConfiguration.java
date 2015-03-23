package org.wpattern.frameworks.javafx.arduino.configs;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.wpattern.frameworks.javafx.arduino.controller.DeviceController;
import org.wpattern.frameworks.javafx.arduino.controller.DeviceEditController;
import org.wpattern.frameworks.javafx.arduino.controller.RootLayoutController;
import org.wpattern.frameworks.javafx.arduino.model.DeviceEntity;


@Lazy
@Configuration
@ImportResource("/ctx-wpattern-context.xml")
public class ScreensConfiguration {

	private static final String DEVICE_VIEW = "/views/DeviceView.fxml";

	private static final String DEVICE_EDIT_VIEW = "/views/DeviceEditView.fxml";

	private static final String ROOTLAYOUT_VIEW = "/views/RootLayout.fxml";

	private Stage primaryStage;

	private FXMLDialog rootLayout;

	public ScreensConfiguration() {
	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	public void show() {
		this.rootLayout = this.rootLayoutDialog();

		this.loadDevice();

		this.rootLayout.show();
		this.rootLayout.setTitle("WPattern JavaFX Arduino");
		this.rootLayout.getIcons().add(new Image("images/wpattern.png"));
	}

	//////////////////////////////////////////////////////////////////////////
	// Root View
	//////////////////////////////////////////////////////////////////////////

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public FXMLDialog rootLayoutDialog() {
		return new FXMLDialog(this.rootLayoutController(), ROOTLAYOUT_VIEW, this.primaryStage);
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public RootLayoutController rootLayoutController() {
		return new RootLayoutController();
	}

	//////////////////////////////////////////////////////////////////////////
	// Device View
	//////////////////////////////////////////////////////////////////////////

	@Bean
	@Scope("prototype")
	public FXMLDialog deviceView() {
		return new FXMLDialog(this.deviceController(), DEVICE_VIEW, this.primaryStage, StageStyle.UNDECORATED);
	}

	@Bean
	@Scope("prototype")
	public DeviceController deviceController() {
		return new DeviceController();
	}

	public void loadDevice() {
		FXMLDialog deviceView = this.deviceView();

		this.rootLayout.getBorderPane().setCenter(deviceView.getAnchorPane());
	}

	//////////////////////////////////////////////////////////////////////////
	// Device Edit View
	//////////////////////////////////////////////////////////////////////////

	@Bean
	@Scope("prototype")
	public FXMLDialog deviceEditView() {
		return new FXMLDialog(this.deviceEditController(), DEVICE_EDIT_VIEW, this.primaryStage, StageStyle.UNDECORATED);
	}

	@Bean
	@Scope("prototype")
	public DeviceEditController deviceEditController() {
		return new DeviceEditController();
	}

	public void loadDeviceEdit() {
		this.loadDeviceEdit(null);
	}

	public void loadDeviceEdit(DeviceEntity device) {
		FXMLDialog deviceView = this.deviceEditView();

		if (device != null) {
			((DeviceEditController)deviceView.getController()).setDevice(device);
		}

		this.rootLayout.getBorderPane().setCenter(deviceView.getAnchorPane());
	}

}
