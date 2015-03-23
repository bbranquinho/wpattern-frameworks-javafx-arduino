package org.wpattern.frameworks.javafx.arduino.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.wpattern.frameworks.javafx.arduino.configs.ScreensConfiguration;
import org.wpattern.frameworks.javafx.arduino.interfaces.IController;
import org.wpattern.frameworks.javafx.arduino.model.DeviceEntity;
import org.wpattern.frameworks.javafx.arduino.model.RateEntity;
import org.wpattern.frameworks.javafx.arduino.repositories.IDeviceRepository;
import org.wpattern.frameworks.javafx.arduino.repositories.IRateRepository;
import org.wpattern.frameworks.javafx.arduino.utils.JavaFXUtils;

public class DeviceController implements IController {

	@FXML
	private TableView<DeviceEntity> deviceTable;

	@FXML
	private TableColumn<DeviceEntity, Number> identifierColumn;

	@FXML
	private TableColumn<DeviceEntity, String> nameColumn;

	@FXML
	private Label identifierLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label descriptionLabel;

	@FXML
	private Label portLabel;

	@FXML
	private ComboBox<RateEntity> rateCombo;

	@Inject
	private ScreensConfiguration screensConfiguration;

	@Inject
	private IDeviceRepository deviceRepository;

	@Inject
	private IRateRepository rateRepository;

	private ObservableList<DeviceEntity> deviceData;

	private ObservableList<RateEntity> rateData;

	@PostConstruct
	private void load() {
		this.deviceData = FXCollections.observableArrayList(this.deviceRepository.findAll());
		this.rateData = FXCollections.observableArrayList(this.rateRepository.findAll());
	}

	@FXML
	private void initialize() {
		// Initialize the device table with the two columns.
		this.identifierColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

		// Clear device details.
		this.showDeviceDetails(null);

		// Listen for selection changes and show the device details when changed.
		this.deviceTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.showDeviceDetails(newValue));

		this.deviceTable.setItems(this.deviceData);
		this.rateCombo.setItems(this.rateData);
	}

	private void showDeviceDetails(DeviceEntity device) {
		if (device != null) {
			// Fill the labels with info from the device object.
			this.identifierLabel.setText(device.getId() + "");
			this.nameLabel.setText(device.getName());
			this.descriptionLabel.setText(device.getDescription());
			this.portLabel.setText(device.getPort());
			this.rateCombo.setValue(device.getRate());
		} else {
			// Device is null, remove all the text.
			this.identifierLabel.setText("");
			this.nameLabel.setText("");
			this.descriptionLabel.setText("");
			this.portLabel.setText("");
			this.rateCombo.setValue(null);
		}
	}

	@FXML
	private void handleDeleteDevice() {
		DeviceEntity selectedDevice = this.deviceTable.getSelectionModel().getSelectedItem();

		if (selectedDevice != null) {
			try {
				this.deviceRepository.delete(selectedDevice);
			} catch (Exception e) {
				JavaFXUtils.showDialog("Error", "Error to Delete the Device", String.format("Error to delete device [%s].", e.getMessage()));
				return;
			}
			this.deviceTable.getItems().remove(selectedDevice);
		} else {
			JavaFXUtils.showDialog("No Selection", "No Device Selected", "Please select a device in the table.");
		}
	}

	@FXML
	private void handleNewDevice() {
		this.screensConfiguration.loadDeviceEdit();
	}

	@FXML
	private void handleEditDevice() {
		DeviceEntity selectedDevice = this.deviceTable.getSelectionModel().getSelectedItem();

		if (selectedDevice != null) {
			this.screensConfiguration.loadDeviceEdit(selectedDevice);
		} else {
			JavaFXUtils.showDialog("No Selection", "No Device Selected", "Please select a device in the table.");
		}
	}
}
