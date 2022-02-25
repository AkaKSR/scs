/*테스트 계정 추가*/
USE `scs`;
insert  into `user_info`(`USER_IDX`,`GROUP_IDX`,`USER_ID`,`USER_PWD`,`USER_NM`,`CREATED_DT`,`CONFIRM`) values (2,'0001','test',PASSWORD('test'),'테스트','2022-02-03 16:45:10',1);