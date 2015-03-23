package org.wpattern.frameworks.javafx.arduino.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.wpattern.frameworks.javafx.arduino.model.utils.RateType;
import org.wpattern.frameworks.javafx.arduino.model.utils.RateTypeConverter;
import org.wpattern.frameworks.javafx.arduino.utils.BaseEntity;

@Entity
@Table(name = "tb_rate")
@AttributeOverride(name = "id", column = @Column( name = "pk_id"))
public class RateEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201503091724L;

	@Column(name = "value")
	@Convert(converter = RateTypeConverter.class)
	private RateType rate;

	public RateEntity() {
	}

	public RateType getRate() {
		return this.rate;
	}

	public void setRate(RateType rate) {
		this.rate = rate;
	}

	public Integer value() {
		return (this.rate == null) ? null : this.rate.getValue();
	}

	@Override
	public String toString() {
		return this.value() + "";
	}

}
