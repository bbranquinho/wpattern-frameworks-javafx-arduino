SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wpattern_javafx_arduino
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wpattern_javafx_arduino` ;
CREATE SCHEMA IF NOT EXISTS `wpattern_javafx_arduino` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `wpattern_javafx_arduino` ;

-- -----------------------------------------------------
-- Table `wpattern_javafx_arduino`.`tb_rate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wpattern_javafx_arduino`.`tb_rate` ;

CREATE TABLE IF NOT EXISTS `wpattern_javafx_arduino`.`tb_rate` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `value` INT NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `value_UNIQUE` (`value` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wpattern_javafx_arduino`.`tb_device`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wpattern_javafx_arduino`.`tb_device` ;

CREATE TABLE IF NOT EXISTS `wpattern_javafx_arduino`.`tb_device` (
  `pk_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(127) NULL,
  `port` VARCHAR(6) NOT NULL,
  `rate_id` INT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `fk_tb_device_tb_rate1_idx` (`rate_id` ASC),
  CONSTRAINT `fk_tb_device_tb_rate1`
    FOREIGN KEY (`rate_id`)
    REFERENCES `wpattern_javafx_arduino`.`tb_rate` (`pk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wpattern_javafx_arduino`.`tb_rate`
-- -----------------------------------------------------
START TRANSACTION;
USE `wpattern_javafx_arduino`;
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (1, 300);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (2, 600);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (3, 1200);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (4, 2400);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (5, 4800);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (6, 9600);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (7, 14400);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (8, 19200);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (9, 28800);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (10, 38400);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (11, 57600);
INSERT INTO `wpattern_javafx_arduino`.`tb_rate` (`pk_id`, `value`) VALUES (12, 115200);

COMMIT;

