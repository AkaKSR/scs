/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.6.5-MariaDB : Database - scs
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`scs` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;

USE `scs`;

TRUNCATE user_info;

INSERT INTO user_info (`GROUP_IDX`,`USER_ID`,`USER_PWD`,`USER_NM`) VALUES ('0000','admin',PASSWORD('admin'),'관리자');
INSERT INTO user_info (`GROUP_IDX`,`USER_ID`,`USER_PWD`,`USER_NM`) VALUES ('0001','test',PASSWORD('test'),'테스트');