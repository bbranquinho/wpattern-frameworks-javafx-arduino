package org.wpattern.frameworks.javafx.arduino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.frameworks.javafx.arduino.model.RateEntity;
import org.wpattern.frameworks.javafx.arduino.model.utils.RateType;

public interface IRateRepository extends JpaRepository<RateEntity, Long> {

	public RateEntity findByRate(RateType rate);

}
