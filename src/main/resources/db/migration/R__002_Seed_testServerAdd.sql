/*테스트 서버 리스트 추가*/
USE `scs`;

/*데이터 초기화*/
TRUNCATE server_list;
TRUNCATE server_list_detail;

/*서버 정보 추가*/
INSERT INTO server_list (`USER_IDX`, `SERVER_NM`, `SERVER_IP`, `SERVER_DESC`) VALUES (2,'테스트 서버','192.168.10.110','서버 목록 테스트 - 1');

/*상세 정보 추가*/
INSERT INTO server_list_detail (`SERVER_IDX`,`SERVER_IP`,`COMMAND`) VALUES (1,'192.168.10.110','ls -al');