package org.wpattern.frameworks.javafx.arduino.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.wpattern.frameworks.javafx.arduino.utils.BaseEntity;

@Entity
@Table(name = "tb_device")
@AttributeOverride(name = "id", column = @Column( name = "pk_id"))
public class DeviceEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201503091609L;

	@Column(name = "name", length = 45, nullable = false, unique = false)
	private String name;

	@Column(name = "description", length = 127, nullable = true, unique = false)
	private String description;

	@Column(name = "port", length = 6, nullable = false, unique = false)
	private String port;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rate_id", nullable = true)
	private RateEntity rate;

	public DeviceEntity() {
	}

	public DeviceEntity(String name, String description, String port,
			RateEntity rate) {
		super();
		this.name = name;
		this.description = description;
		this.port = port;
		this.rate = rate;
	}

	public LongProperty idProperty() {
		return new SimpleLongProperty(this.getId());
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getName() {
		return this.name;
	}

	public StringProperty nameProperty() {
		return new SimpleStringProperty(this.getName());
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RateEntity getRate() {
		return this.rate;
	}

	public Integer getRateValue() {
		return (this.rate == null) ? null : this.rate.value();
	}

	public void setRate(RateEntity rate) {
		this.rate = rate;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
