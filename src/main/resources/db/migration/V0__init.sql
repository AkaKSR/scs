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

/*Table structure for table `accnt_group` */

DROP TABLE IF EXISTS `accnt_group`;

CREATE TABLE `accnt_group` (
  `GROUP_IDX` varchar(4) NOT NULL COMMENT '계정 그룹 키값',
  `GROUP_NM` varchar(30) NOT NULL COMMENT '계정 그룹명',
  `DESCRIPTION` longtext DEFAULT NULL COMMENT '그룹 설명',
  PRIMARY KEY (`GROUP_IDX`),
  UNIQUE KEY `UNIQUE_ID` (`GROUP_IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `accnt_group` */

insert  into `accnt_group`(`GROUP_IDX`,`GROUP_NM`,`DESCRIPTION`) values ('0000','Administrator','관리자'),('0001','User','일반 사용자');

/*Table structure for table `flyway_schema_history` */

DROP TABLE IF EXISTS `flyway_schema_history`;

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `flyway_schema_history` */

/*Table structure for table `server_group` */

DROP TABLE IF EXISTS `server_group`;

CREATE TABLE `server_group` (
  `GROUP_IDX` varchar(4) NOT NULL COMMENT '계정 그룹 키값',
  `GROUP_NM` varchar(30) NOT NULL COMMENT '계정 그룹 명칭',
  `DESCRIPTION` longtext DEFAULT NULL COMMENT '계정 그룹 설명',
  PRIMARY KEY (`GROUP_IDX`),
  UNIQUE KEY `UNIQUE_ID` (`GROUP_IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `server_group` */

insert  into `server_group`(`GROUP_IDX`,`GROUP_NM`,`DESCRIPTION`) values ('0000','관리 서버',NULL),('0001','일반 서버',NULL);

/*Table structure for table `server_list` */

DROP TABLE IF EXISTS `server_list`;

CREATE TABLE `server_list` (
  `SERVER_IDX` int(100) NOT NULL AUTO_INCREMENT COMMENT '서버 키값',
  `GROUP_IDX` varchar(4) NOT NULL DEFAULT '0001' COMMENT '서버 그룹 키값',
  `USER_IDX` int(100) NOT NULL COMMENT '사용자 키값',
  `SERVER_NM` varchar(60) CHARACTER SET utf8mb3 NOT NULL COMMENT '서버 명칭',
  `SERVER_IP` varchar(90) CHARACTER SET utf8mb3 NOT NULL COMMENT '서버 IP',
  `SERVER_DESC` text CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '서버 설명',
  `CREATED_DT` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '생성 일자',
  `STATUS_CD` int(1) NOT NULL DEFAULT 0 COMMENT '상태 코드(0:종료/1:시동/9:에러)',
  PRIMARY KEY (`SERVER_IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `server_list` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `USER_IDX` int(100) NOT NULL AUTO_INCREMENT COMMENT '사용자 키값',
  `GROUP_IDX` varchar(4) NOT NULL DEFAULT '0001' COMMENT '계정 그룹',
  `USER_ID` varchar(12) NOT NULL COMMENT '사용자 ID',
  `USER_PWD` varchar(255) NOT NULL COMMENT '사용자 비밀번호',
  `USER_NM` varchar(12) DEFAULT NULL COMMENT '사용자 이름',
  `CREATED_DT` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '계정 생성일시',
  `CONFIRM` tinyint(1) NOT NULL DEFAULT 1 COMMENT '계정 사용여부(0:사용불가/1:사용가능)',
  PRIMARY KEY (`USER_IDX`),
  UNIQUE KEY `UNIQUE_ID` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_info` */

insert  into `user_info`(`USER_IDX`,`GROUP_IDX`,`USER_ID`,`USER_PWD`,`USER_NM`,`CREATED_DT`,`CONFIRM`) values (1,'0000','admin','*4ACFE3202A5FF5CF467898FC58AAB1D615029441','관리자','2022-02-03 16:45:10',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
