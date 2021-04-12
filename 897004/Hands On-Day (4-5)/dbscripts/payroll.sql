SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springlearn` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `springlearn` ;
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springlearn`.`department` ;

CREATE TABLE IF NOT EXISTS `springlearn`.`department` (
  `dp_id` INT NOT NULL AUTO_INCREMENT,
  `dp_name` VARCHAR(45) NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE INDEX `name_UNIQUE` (`dp_name` ASC))
ENGINE = InnoDB;
DROP TABLE IF EXISTS `springlearn`.`employee` ;

CREATE TABLE IF NOT EXISTS `springlearn`.`employee` (
  `em_id` INT NOT NULL AUTO_INCREMENT,
  `em_name` VARCHAR(45) NULL,
  `em_salary` DOUBLE NULL,
  `em_permanent` TINYINT(1) NULL,
  `em_date_of_birth` DATE NULL,
  `em_dp_id` INT NULL,
  PRIMARY KEY (`em_id`),
  INDEX `em_dp_fk_idx` (`em_dp_id` ASC),
  CONSTRAINT `em_dp_fk`
    FOREIGN KEY (`em_dp_id`)
    REFERENCES `springlearn`.`department` (`dp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springlearn`.`skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springlearn`.`skill` ;

CREATE TABLE IF NOT EXISTS `springlearn`.`skill` (
  `sk_id` INT NOT NULL AUTO_INCREMENT,
  `sk_name` VARCHAR(45) NULL,
  PRIMARY KEY (`sk_id`),
  UNIQUE INDEX `name_UNIQUE` (`sk_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springlearn`.`employee_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springlearn`.`employee_skill` ;

CREATE TABLE IF NOT EXISTS `springlearn`.`employee_skill` (
  `es_id` INT NOT NULL AUTO_INCREMENT,
  `es_em_id` INT NOT NULL,
  `es_sk_id` INT NOT NULL,
  PRIMARY KEY (`es_id`),
  INDEX `es_sk_fk_idx` (`es_sk_id` ASC),
  CONSTRAINT `es_em_fk`
    FOREIGN KEY (`es_em_id`)
    REFERENCES `springlearn`.`employee` (`em_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `es_sk_fk`
    FOREIGN KEY (`es_sk_id`)
    REFERENCES `springlearn`.`skill` (`sk_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `springlearn`.`department`
-- -----------------------------------------------------
START TRANSACTION;
USE `springlearn`;
INSERT INTO `springlearn`.`department` (`dp_id`, `dp_name`) VALUES (DEFAULT, 'Payroll');
INSERT INTO `springlearn`.`department` (`dp_id`, `dp_name`) VALUES (DEFAULT, 'Finance');
INSERT INTO `springlearn`.`department` (`dp_id`, `dp_name`) VALUES (DEFAULT, 'Marketing');
INSERT INTO `springlearn`.`department` (`dp_id`, `dp_name`) VALUES (DEFAULT, 'Manufacturing');

COMMIT;


-- -----------------------------------------------------
-- Data for table `springlearn`.`employee`
-- -----------------------------------------------------
START TRANSACTION;
USE `springlearn`;
INSERT INTO `springlearn`.`employee` (`em_id`, `em_name`, `em_salary`, `em_permanent`, `em_date_of_birth`, `em_dp_id`) VALUES (DEFAULT, 'John', 10000, TRUE, '1999-01-01', 1);
INSERT INTO `springlearn`.`employee` (`em_id`, `em_name`, `em_salary`, `em_permanent`, `em_date_of_birth`, `em_dp_id`) VALUES (DEFAULT, 'Jack', 12000, FALSE, '1998-01-01', 2);
INSERT INTO `springlearn`.`employee` (`em_id`, `em_name`, `em_salary`, `em_permanent`, `em_date_of_birth`, `em_dp_id`) VALUES (DEFAULT, 'Paul', 8000, TRUE, '1997-01-01', 3);
INSERT INTO `springlearn`.`employee` (`em_id`, `em_name`, `em_salary`, `em_permanent`, `em_date_of_birth`, `em_dp_id`) VALUES (DEFAULT, 'Emily', 11000, TRUE, '1999-02-01', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `springlearn`.`skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `springlearn`;
INSERT INTO `springlearn`.`skill` (`sk_id`, `sk_name`) VALUES (DEFAULT, 'Excel');
INSERT INTO `springlearn`.`skill` (`sk_id`, `sk_name`) VALUES (DEFAULT, 'Word');
INSERT INTO `springlearn`.`skill` (`sk_id`, `sk_name`) VALUES (DEFAULT, 'Tally');

COMMIT;


-- -----------------------------------------------------
-- Data for table `springlearn`.`employee_skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `springlearn`;
INSERT INTO `springlearn`.`employee_skill` (`es_id`, `es_em_id`, `es_sk_id`) VALUES (DEFAULT, 1, 1);
INSERT INTO `springlearn`.`employee_skill` (`es_id`, `es_em_id`, `es_sk_id`) VALUES (DEFAULT, 1, 2);
INSERT INTO `springlearn`.`employee_skill` (`es_id`, `es_em_id`, `es_sk_id`) VALUES (DEFAULT, 2, 1);
INSERT INTO `springlearn`.`employee_skill` (`es_id`, `es_em_id`, `es_sk_id`) VALUES (DEFAULT, 2, 3);
INSERT INTO `springlearn`.`employee_skill` (`es_id`, `es_em_id`, `es_sk_id`) VALUES (DEFAULT, 3, 1);

COMMIT;

