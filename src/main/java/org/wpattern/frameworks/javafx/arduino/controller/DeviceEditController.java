package org.wpattern.frameworks.javafx.arduino.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.wpattern.frameworks.javafx.arduino.configs.ScreensConfiguration;
import org.wpattern.frameworks.javafx.arduino.interfaces.IController;
import org.wpattern.frameworks.javafx.arduino.model.DeviceEntity;
import org.wpattern.frameworks.javafx.arduino.model.RateEntity;
import org.wpattern.frameworks.javafx.arduino.repositories.IDeviceRepository;
import org.wpattern.frameworks.javafx.arduino.repositories.IRateRepository;
import org.wpattern.frameworks.javafx.arduino.utils.JavaFXUtils;

public class DeviceEditController implements IController {

	@FXML
	private TextField identifierField;

	@FXML
	private TextField nameField;

	@FXML
	private TextField descriptionField;

	@FXML
	private ComboBox<RateEntity> rateCombo;

	@FXML
	private TextField portField;

	@Inject
	private ScreensConfiguration screensConfiguration;

	@Inject
	private IRateRepository rateRepository;

	@Inject
	private IDeviceRepository deviceRepository;

	private ObservableList<RateEntity> rateData;

	private DeviceEntity device;

	@PostConstruct
	private void load() {
		this.rateData = FXCollections.observableArrayList(this.rateRepository.findAll());
	}

	@FXML
	private void initialize() {
		this.rateCombo.setItems(this.rateData);
	}

	public void setDevice(DeviceEntity device) {
		this.device = device;

		if (device != null) {
			this.identifierField.setText(this.device.getId() + "");
			this.nameField.setText(this.device.getName());
			this.descriptionField.setText(this.device.getDescription());
			this.rateCombo.setValue(this.device.getRate());
			this.portField.setText(this.device.getPort());
		}
	}

	@FXML
	private void handleOk() {
		if (this.isInputValid()) {
			if (this.device == null) {
			this.device = new DeviceEntity();
			}
			
			this.device.setName(this.nameField.getText());
			this.device.setDescription(this.descriptionField.getText());
			this.device.setRate(this.rateCombo.getValue());
			this.device.setPort(this.portField.getText());

			try {
				this.device = this.deviceRepository.save(this.device);
			} catch (Exception e) {
				JavaFXUtils.showDialog("Error", "Error to Update", String.format("Error to update the device [%s].", e.getMessage()));
			}
		}

		this.screensConfiguration.loadDevice();
	}

	@FXML
	private void handleCancel() {
		this.screensConfiguration.loadDevice();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if ((this.nameField.getText() == null) || (this.nameField.getText().length() == 0) || (this.nameField.getText().length() > 45)) {
			errorMessage += "No valid name!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			JavaFXUtils.showDialog("Invalid Fields", "Please correct invalid fields", errorMessage);
			return false;
		}
	}

}
