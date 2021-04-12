-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Quiz
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Quiz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Quiz` ;
USE `Quiz` ;

-- -----------------------------------------------------
-- Table `Quiz`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(45) NOT NULL,
  `us_email` VARCHAR(45) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Quiz`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`question` (
  `qt_id` INT NOT NULL AUTO_INCREMENT,
  `qt_text` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`qt_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Quiz`.`options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`options` (
  `op_id` INT NOT NULL AUTO_INCREMENT,
  `op_qt_id` INT NULL,
  `op_score` DOUBLE NULL,
  `op_text` VARCHAR(100) NULL,
  PRIMARY KEY (`op_id`),
  INDEX `op_qt_id_fkey_idx` (`op_qt_id` ASC) VISIBLE,
  CONSTRAINT `op_qt_id_fkey`
    FOREIGN KEY (`op_qt_id`)
    REFERENCES `Quiz`.`question` (`qt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Quiz`.`attempt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`attempt` (
  `at_id` INT NOT NULL AUTO_INCREMENT,
  `at_date` DATE NULL,
  `at_us_id` INT NULL,
  `at_score` DOUBLE NULL,
  PRIMARY KEY (`at_id`),
  INDEX `at_us_id_fkey_idx` (`at_us_id` ASC) VISIBLE,
  CONSTRAINT `at_us_id_fkey`
    FOREIGN KEY (`at_us_id`)
    REFERENCES `Quiz`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Quiz`.`attempt_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`attempt_question` (
  `aq_id` INT NOT NULL AUTO_INCREMENT,
  `aq_at_id` INT NULL,
  `aq_qt_id` INT NULL,
  PRIMARY KEY (`aq_id`),
  INDEX `qz_at_id_fkey_idx` (`aq_at_id` ASC) VISIBLE,
  INDEX `ad_qt_id_idx` (`aq_qt_id` ASC) VISIBLE,
  CONSTRAINT `aq_at_id_fk`
    FOREIGN KEY (`aq_at_id`)
    REFERENCES `Quiz`.`attempt` (`at_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `aq_qt_id_fk`
    FOREIGN KEY (`aq_qt_id`)
    REFERENCES `Quiz`.`question` (`qt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Quiz`.`attempt_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quiz`.`attempt_option` (
  `ao_id` INT NOT NULL AUTO_INCREMENT,
  `ao_op_id` INT NULL,
  `ao_aq_id` INT NULL,
  `ao_selected` BIT NULL,
  PRIMARY KEY (`ao_id`),
  INDEX `ao_aq_fk_idx` (`ao_aq_id` ASC) VISIBLE,
  INDEX `ao_op_fk_idx` (`ao_op_id` ASC) VISIBLE,
  CONSTRAINT `ao_aq_fk`
    FOREIGN KEY (`ao_aq_id`)
    REFERENCES `Quiz`.`attempt_question` (`aq_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ao_op_fk`
    FOREIGN KEY (`ao_op_id`)
    REFERENCES `Quiz`.`options` (`op_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Quiz`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`user` (`us_id`, `us_name`, `us_email`) VALUES (1, 'Akilan', 'akilan@gmail.com');
INSERT INTO `Quiz`.`user` (`us_id`, `us_name`, `us_email`) VALUES (2, 'Tom', 'tom@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Quiz`.`question`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`question` (`qt_id`, `qt_text`) VALUES (1, 'What is the extendsion of the hyper text markup language file?');
INSERT INTO `Quiz`.`question` (`qt_id`, `qt_text`) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO `Quiz`.`question` (`qt_id`, `qt_text`) VALUES (3, 'The HTML document itself begins with <html> and  ends </html>. State True of False');
INSERT INTO `Quiz`.`question` (`qt_id`, `qt_text`) VALUES (4, 'Choose the right option to store text value in a variable');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Quiz`.`options`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (1, 1, 0, '.ht');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (2, 1, 0, '.xhtm');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (3, 1, 1, '.html');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (4, 1, 0, '.htmx');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (5, 2, 0, '3');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (6, 2, 1, '6');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (7, 2, 0, '4');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (8, 2, 0, '5');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (9, 3, 1, 'true');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (10, 3, 0, 'false');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (11, 4, 0.5, '\"John\"');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (12, 4, 0, '/John/');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (13, 4, 0, 'John');
INSERT INTO `Quiz`.`options` (`op_id`, `op_qt_id`, `op_score`, `op_text`) VALUES (14, 4, 0.5, '\'John\'');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Quiz`.`attempt`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`attempt` (`at_id`, `at_date`, `at_us_id`, `at_score`) VALUES (1, '2019-10-18', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Quiz`.`attempt_question`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`attempt_question` (`aq_id`, `aq_at_id`, `aq_qt_id`) VALUES (1, 1, 1);
INSERT INTO `Quiz`.`attempt_question` (`aq_id`, `aq_at_id`, `aq_qt_id`) VALUES (2, 1, 2);
INSERT INTO `Quiz`.`attempt_question` (`aq_id`, `aq_at_id`, `aq_qt_id`) VALUES (3, 1, 3);
INSERT INTO `Quiz`.`attempt_question` (`aq_id`, `aq_at_id`, `aq_qt_id`) VALUES (4, 1, 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Quiz`.`attempt_option`
-- -----------------------------------------------------
START TRANSACTION;
USE `Quiz`;
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (1, 1, 1, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (2, 2, 1, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (3, 3, 1, 1);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (4, 4, 1, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (5, 5, 2, 1);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (6, 6, 2, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (7, 7, 2, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (8, 8, 2, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (9, 9, 3, 1);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (10, 10, 3, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (11, 11, 4, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (12, 12, 4, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (13, 13, 4, 0);
INSERT INTO `Quiz`.`attempt_option` (`ao_id`, `ao_op_id`, `ao_aq_id`, `ao_selected`) VALUES (14, 14, 4, 1);

COMMIT;

