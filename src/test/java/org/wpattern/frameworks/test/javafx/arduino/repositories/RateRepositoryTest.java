package org.wpattern.frameworks.test.javafx.arduino.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.javafx.arduino.model.RateEntity;
import org.wpattern.frameworks.javafx.arduino.repositories.IRateRepository;
import org.wpattern.frameworks.test.javafx.arduino.AbstractTest;

public class RateRepositoryTest extends AbstractTest {

	private static final Logger LOGGER = Logger.getLogger(RateRepositoryTest.class);

	@Inject
	private IRateRepository rateRepository;

	@Test
	public void testFindAll() {
		List<RateEntity> rates = this.rateRepository.findAll();

		LOGGER.debug(rates);
	}

}
