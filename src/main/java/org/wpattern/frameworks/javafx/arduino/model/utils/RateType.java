package org.wpattern.frameworks.javafx.arduino.model.utils;

import java.util.HashMap;
import java.util.Map;

public enum RateType {

	RATE_300(300),

	RATE_600(600),

	RATE_1200(1200),

	RATE_2400(2400),

	RATE_4800(4800),

	RATE_9600(9600),

	RATE_14400(14400),

	RATE_19200(19200),

	RATE_28800(28800),

	RATE_38400(38400),

	RATE_57600(57600),

	RATE_115200(115200);

	private final int value;

	private static final Map<Integer, RateType> mapRates = new HashMap<Integer, RateType>();

	static {
		for (RateType rate : values()) {
			mapRates.put(rate.value, rate);
		}
	}

	private RateType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static RateType parse(int value) {
		return mapRates.get(value);
	}

}
