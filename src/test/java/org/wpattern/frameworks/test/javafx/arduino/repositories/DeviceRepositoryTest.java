package org.wpattern.frameworks.test.javafx.arduino.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.javafx.arduino.model.DeviceEntity;
import org.wpattern.frameworks.javafx.arduino.model.utils.RateType;
import org.wpattern.frameworks.javafx.arduino.repositories.IDeviceRepository;
import org.wpattern.frameworks.javafx.arduino.repositories.IRateRepository;
import org.wpattern.frameworks.test.javafx.arduino.AbstractTest;

public class DeviceRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(DeviceRepositoryTest.class);

	@Inject
	private IDeviceRepository deviceRepository;

	@Inject
	private IRateRepository rateRepository;

	@Test
	public void testFindAll() {
		List<DeviceEntity> device = this.deviceRepository.findAll();

		LOGGER.debug(device);
	}

	@Test
	public void testInsert() {
		DeviceEntity device = new DeviceEntity();

		device.setName("Sensor " + System.currentTimeMillis());
		device.setDescription("Description of sensor.");
		device.setPort("COM" + System.currentTimeMillis() % 8);
		device.setRate(this.rateRepository.findByRate(RateType.RATE_9600));

		device = this.deviceRepository.save(device);

		LOGGER.debug(device);
	}

}
