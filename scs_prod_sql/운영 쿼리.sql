## 로그인 정보 확인
SELECT 
  * 
FROM
  user_info 
WHERE USER_ID = "admin" 
  AND USER_PWD = PASSWORD("admin") ;

## 회원가입
INSERT INTO user_info (USER_ID, USER_PWD, USER_NM) 
VALUES
  ("", PASSWORD(""), "") ;

## 서버 리스트 불러오기
SELECT 
  * 
FROM
  server_list ;

## 서버 로그 확인을 위한 서버 정보 선택
SELECT 
  list.SERVER_IDX,
  list.SERVER_NM,
  list.SERVER_DESC,
  list.STATUS_CD,
  detail.SERVER_IP,
  detail.COMMAND
FROM
  server_list AS `list` 
  LEFT JOIN server_list_detail AS detail 
    ON list.SERVER_IDX = detail.SERVER_IDX 
WHERE list.SERVER_IDX = 2 ;