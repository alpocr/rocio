SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rociodb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `rociodb` ;

-- -----------------------------------------------------
-- Table `rociodb`.`function`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`function` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `path` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`app`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`app` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL ,
  `path` VARCHAR(45) NULL ,
  `function_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_app_function1_idx` (`function_id` ASC) ,
  CONSTRAINT `fk_app_function1`
    FOREIGN KEY (`function_id` )
    REFERENCES `rociodb`.`function` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`profile`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`profile` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL ,
  `app_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_profile_app1_idx` (`app_id` ASC) ,
  CONSTRAINT `fk_profile_app1`
    FOREIGN KEY (`app_id` )
    REFERENCES `rociodb`.`app` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`user` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `lastname` VARCHAR(45) NULL ,
  `nid` VARCHAR(45) NULL ,
  `username` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `last_login` DATETIME NULL ,
  `enable` TINYINT(1) NULL ,
  `agreement` TINYINT(1) NULL ,
  `profile_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_profile1_idx` (`profile_id` ASC) ,
  CONSTRAINT `fk_user_profile1`
    FOREIGN KEY (`profile_id` )
    REFERENCES `rociodb`.`profile` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`permission`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`permission` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`profile_has_permission`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`profile_has_permission` (
  `profile_id` INT NOT NULL ,
  `permission_id` INT NOT NULL ,
  PRIMARY KEY (`profile_id`, `permission_id`) ,
  INDEX `fk_profile_has_permission_permission1_idx` (`permission_id` ASC) ,
  INDEX `fk_profile_has_permission_profile_idx` (`profile_id` ASC) ,
  CONSTRAINT `fk_profile_has_permission_profile`
    FOREIGN KEY (`profile_id` )
    REFERENCES `rociodb`.`profile` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_has_permission_permission1`
    FOREIGN KEY (`permission_id` )
    REFERENCES `rociodb`.`permission` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `rociodb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
