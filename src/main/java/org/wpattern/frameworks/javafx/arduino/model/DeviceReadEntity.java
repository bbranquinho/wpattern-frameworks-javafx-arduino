package org.wpattern.frameworks.javafx.arduino.model;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wpattern.frameworks.javafx.arduino.utils.BaseEntity;

@Entity
@Table(name = "tb_device_read")
@AttributeOverride(name = "id", column = @Column( name = "pk_id"))
public class DeviceReadEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201503091746L;

	@Column(name = "value", length = 45, nullable = false, unique = false)
	private String value;

	@Column(name = "date", length = 45, nullable = false, unique = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "device_id")
	private DeviceEntity device;

	public DeviceReadEntity() {
	}

	public DeviceReadEntity(String value, Date date, DeviceEntity device) {
		super();
		this.value = value;
		this.date = date;
		this.device = device;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DeviceEntity getDevice() {
		return this.device;
	}

	public void setDevice(DeviceEntity device) {
		this.device = device;
	}

}
