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
  `RFIDid` CHAR(20) NOT NULL,
  `MACid` CHAR(20) NOT NULL,
  `Date_` DATE NOT NULL,
  `Time_` TIME NOT NULL,
  INDEX `fk_nowPos_positionInfo1_idx` (`MACid` ASC),
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

CREATE VIEW Event AS
SELECT employeeInfo.empName,nowPos.Date_,nowPos.Time_
FROM employeeInfo,nowPos
WHERE employeeInfo.RFIDid=nowPos.RFIDid;

SELECT @rownum:=@rownum+1 as id,employeeInfo.empName,nowPos.Date_,nowPos.Time_ FROM (select @rownum:=0) r,employeeInfo,nowPos WHERE employeeInfo.RFIDid=nowPos.RFIDid;

<!-- 	<td>${c.empName }</td>
	<td>${c.Date_ }</td>
	<td>${c.Time_ }</td> -->

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

CREATE USER ben_29@localhost IDENTIFIED BY '1329';
GRANT ALL PRIVILEGES ON RFID.* TO ben_29@localhost;
FLUSH PRIVILEGES;
