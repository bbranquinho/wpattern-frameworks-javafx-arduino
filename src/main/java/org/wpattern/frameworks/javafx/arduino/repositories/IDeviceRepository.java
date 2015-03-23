package org.wpattern.frameworks.javafx.arduino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.frameworks.javafx.arduino.model.DeviceEntity;

public interface IDeviceRepository extends JpaRepository<DeviceEntity, Long> {

}
