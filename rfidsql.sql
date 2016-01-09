-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`employeeInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employeeInfo` (
  `RFIDid` CHAR(20) NOT NULL,
  `empName` CHAR(20) NULL,
  PRIMARY KEY (`RFIDid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '员工信息';


-- -----------------------------------------------------
-- Table `mydb`.`positionInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`positionInfo` (
  `MACid` CHAR(20) NOT NULL,
  `posName` CHAR(20) NULL,
  PRIMARY KEY (`MACid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '位置信息';


-- -----------------------------------------------------
-- Table `mydb`.`needtoAdd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`needtoAdd` (
  `id` CHAR(20) NOT NULL,
  `type` CHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '未加入';


-- -----------------------------------------------------
-- Table `mydb`.`nowPos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nowPos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `RFIDid` CHAR(20) NOT NULL,
  `MACid` CHAR(20) NOT NULL,
  `d` CHAR(20) NOT NULL,
  `t` CHAR(20) NOT NULL,
  INDEX `fk_nowPos_positionInfo1_idx` (`MACid` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_nowPos_employeeInfo`
    FOREIGN KEY (`RFIDid`)
    REFERENCES `mydb`.`employeeInfo` (`RFIDid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nowPos_positionInfo1`
    FOREIGN KEY (`MACid`)
    REFERENCES `mydb`.`positionInfo` (`MACid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '现在位置';

insert into employeeInfo values("1","A"),("2","B"),("3","C"),("4","D");
insert into positionInfo values("1","1A"),("2","1B"),("3","1C");
insert into positionInfo values("4","2A"),("5","2B"),("6","2C");
insert into positionInfo values("7","3A"),("8","3B"),("9","3C");
insert into positionInfo values("10","4A"),("11","4B"),("12","4C");
insert into positionInfo values("13","5A"),("14","5B"),("15","5C");
insert into positionInfo values("16","6A"),("17","6B"),("18","6C");

CREATE USER ben_29@localhost IDENTIFIED BY '1329';
GRANT ALL PRIVILEGES ON mydb.* TO ben_29@localhost;
FLUSH PRIVILEGES;

create view Event as SELECT employeeInfo.RFIDid,employeeInfo.empName,positionInfo.MACid,positionInfo.posName,nowPos.d,nowPos.t  FROM employeeInfo,nowPos,positionInfo WHERE employeeInfo.RFIDid=nowPos.RFIDid and nowPos.MACid=positionInfo.Macid;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
