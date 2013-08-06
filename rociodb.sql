SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rociodb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `rociodb` ;

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
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`profile`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`profile` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `description` VARCHAR(45) NULL ,
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
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


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
-- Table `rociodb`.`module`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`module` (
  `id` INT NOT NULL ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`user_has_profile`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`user_has_profile` (
  `user_id` INT NOT NULL ,
  `profile_id` INT NOT NULL ,
  `enable` TINYINT(1) NULL ,
  PRIMARY KEY (`user_id`, `profile_id`) ,
  INDEX `fk_user_has_profile_profile1_idx` (`profile_id` ASC) ,
  INDEX `fk_user_has_profile_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user_has_profile_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `rociodb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_profile_profile1`
    FOREIGN KEY (`profile_id` )
    REFERENCES `rociodb`.`profile` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`module_has_app`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`module_has_app` (
  `module_id` INT NOT NULL ,
  `app_id` INT NOT NULL ,
  `enable` VARCHAR(45) NULL ,
  PRIMARY KEY (`module_id`, `app_id`) ,
  INDEX `fk_module_has_app_app1_idx` (`app_id` ASC) ,
  INDEX `fk_module_has_app_module1_idx` (`module_id` ASC) ,
  CONSTRAINT `fk_module_has_app_module1`
    FOREIGN KEY (`module_id` )
    REFERENCES `rociodb`.`module` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_module_has_app_app1`
    FOREIGN KEY (`app_id` )
    REFERENCES `rociodb`.`app` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`function_has_module`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`function_has_module` (
  `function_id` INT NOT NULL ,
  `module_id` INT NOT NULL ,
  `enable` TINYINT(1) NULL ,
  PRIMARY KEY (`function_id`, `module_id`) ,
  INDEX `fk_function_has_module_module1_idx` (`module_id` ASC) ,
  INDEX `fk_function_has_module_function1_idx` (`function_id` ASC) ,
  CONSTRAINT `fk_function_has_module_function1`
    FOREIGN KEY (`function_id` )
    REFERENCES `rociodb`.`function` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_function_has_module_module1`
    FOREIGN KEY (`module_id` )
    REFERENCES `rociodb`.`module` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rociodb`.`profile_has_app`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `rociodb`.`profile_has_app` (
  `profile_id` INT NOT NULL ,
  `app_id` INT NOT NULL ,
  `enable` TINYINT(1) NULL ,
  PRIMARY KEY (`profile_id`, `app_id`) ,
  INDEX `fk_profile_has_app_app1_idx` (`app_id` ASC) ,
  INDEX `fk_profile_has_app_profile1_idx` (`profile_id` ASC) ,
  CONSTRAINT `fk_profile_has_app_profile1`
    FOREIGN KEY (`profile_id` )
    REFERENCES `rociodb`.`profile` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_has_app_app1`
    FOREIGN KEY (`app_id` )
    REFERENCES `rociodb`.`app` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `rociodb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
