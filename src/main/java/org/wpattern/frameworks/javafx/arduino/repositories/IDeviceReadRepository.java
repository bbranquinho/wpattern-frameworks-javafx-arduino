package org.wpattern.frameworks.javafx.arduino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.frameworks.javafx.arduino.model.DeviceReadEntity;

public interface IDeviceReadRepository extends JpaRepository<DeviceReadEntity, Long> {

}
