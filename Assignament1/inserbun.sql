-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mydb1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb1` DEFAULT CHARACTER SET utf8 ;
USE `mydb1` ;

-- -----------------------------------------------------
-- Table `mydb1`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`admin` (
  `id` INT(11) NOT NULL,
  `nume` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `idagent` INT(11) NOT NULL,
  INDEX `fk_admin_agent1_idx` (`idagent` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb1`.`agent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`agent` (
  `idagent` INT(11) NOT NULL,
  `nume` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idagent`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb1`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`client` (
  `identity_number` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `passport` INT(11) NULL DEFAULT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`identity_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb1`.`holiday`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`holiday` (
  `idholiday` INT(11) NOT NULL,
  `destination` VARCHAR(45) NULL DEFAULT NULL,
  `hotel` VARCHAR(45) NULL DEFAULT NULL,
  `number_persons` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idholiday`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb1`.`holiday_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb1`.`holiday_schedule` (
  `id_client` INT(11) NOT NULL,
  `id_holiday` INT(11) NOT NULL,
  `total_price` INT(11) NULL DEFAULT NULL,
  `final_payment` DATE NULL DEFAULT NULL,
  `paid` TINYINT(4) NULL DEFAULT NULL,
  `idagent` INT(11) NOT NULL,
  `partial` INT(11) NOT NULL,
  `time_tranzaction` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_client`, `id_holiday`, `idagent`),
  INDEX `fk_client_has_holiday_holiday1_idx` (`id_holiday` ASC),
  INDEX `fk_client_has_holiday_client_idx` (`id_client` ASC),
  INDEX `fk_holiday_schedule_agent1_idx` (`idagent` ASC),
  CONSTRAINT `fk_client_has_holiday_client`
    FOREIGN KEY (`id_client`)
    REFERENCES `mydb1`.`client` (`identity_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_holiday_holiday1`
    FOREIGN KEY (`id_holiday`)
    REFERENCES `mydb1`.`holiday` (`idholiday`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




insert into admin values (1,"Larisa", "eu",3);
insert into admin values (1,"Larisa","eu",2);
insert into admin values(1,"Larisa","eu",1);

insert into agent values(1,"Anca","eu","Cluj");
insert into agent values(2,"Andrei","eu","Turda");
insert into agent values(3,"Marian","eu","Arad");

insert into client values(1,"Anda Adam",20402,"Iasi");
insert into client values(2,"Ilas Alexandra",43253,"Ploiesti");
insert into client values(3,"Plesa Gabriel",24124,"Cluj");
insert into client values(4,"Bianca Florian",14214,"Suceava");

insert into client values(5,"Varza Per",49212,"Panma");

insert into holiday values(1,"Paris","Miraje",1);
insert into holiday values(2,"Chicago","Ramada",2);
insert into holiday values(3,"Milano","Opar",2);
insert into holiday values(4,"New York","Andal",2);
insert into holiday values(5,"Los Angeles","Circus",2);
insert into holiday values(6,"San Francisco","Pris",2);
insert into holiday values(8,"Peru","Donde",4);
insert into holiday values(10,"Peru","Dudu",3);

insert into holiday_schedule values(1,1,490,2019-09-09,0,1,0,2018-02-01);
insert into holiday_schedule values(2,2,340,2018-10-10,0,2,0,2018-03-01);
insert into holiday_schedule values(2,3,290,2018-09-09,1,2,0,2018-01-01);
insert into holiday_schedule values(2,8,20000,2018-10-10,0,2,0,2018-03-29);
insert into holiday_schedule values(3,4,900,2018-01-01,0,2,0,2018-01-01);
insert into holiday_schedule values(3,5,800,2018-06-06,1,3,100,2018-02-03);
insert into holiday_schedule values(4,6,900,2018-03-03,0,3,20,2018-01-10);



