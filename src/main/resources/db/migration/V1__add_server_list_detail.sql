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

/*Table structure for table `server_list_detail` */

DROP TABLE IF EXISTS `server_list_detail`;

CREATE TABLE `server_list_detail` (
  `SERVER_IDX` int(100) NOT NULL COMMENT '서버 키값',
  `SERVER_IP` varchar(90) NOT NULL COMMENT '서버 IP',
  `COMMAND` longtext DEFAULT NULL COMMENT '실행 명령',
  PRIMARY KEY (`SERVER_IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `server_list_detail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
