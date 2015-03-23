package org.wpattern.frameworks.javafx.arduino.model.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RateTypeConverter implements AttributeConverter<RateType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(RateType rate) {
		return rate.getValue();
	}

	@Override
	public RateType convertToEntityAttribute(Integer value) {
		return RateType.parse(value);
	}

}
