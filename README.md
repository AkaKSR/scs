# scs
SCS(Server Control Service) 서버 및 서비스 관제 시스템



**프로젝트 설명**
서버와 서비스를 통합적으로 관리하기 위한 서비스 제공

**프로젝트 스택**
[IDE]
Visual Studio Code(vscode)

[Framework]
SpringBoot
Thymeleaf
Thymeleaf Layout Dialect

[DataBase]
MariaDB 10.6.5
MyBatis
Flyway

[Annotation]
Lombok

[Logger]
Log4j 2.17.1
Slf4j 1.7.25

[SSH]
JSch 0.1.55

**프로젝트 설정**

```properties
## /src/main/resources/application.properties

## DB 설정
spring.datasource.url=jdbc:mysql://DB서버 주소:포트/DB명?autoReconnect=true&characterEncoding=UTF-8&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

## Flyway 설정
# Flyway를 통하여 초기 DB 구조를 구성을 하기에 반드시 설정하여야 합니다.
spring.flyway.url=jdbc:mysql://DB서버 주소:포트/
spring.flyway.schemas=DB명
spring.flyway.user=DB 계정
spring.flyway.password=DB 계정 비밀번호
spring.flyway.locations=filesystem:src/main/resources/db/migration/

## HikariPool 설정
# ConnectionPool 방식을 채용하고 있으므로 해당 항목도 필히 설정하여야 합니다.
spring.datasource.hikari.username=DB 계정
spring.datasource.hikari.password=DB 계정 비밀번호
spring.datasource.hikari.maximum-pool-size=Pool 사이즈(정수)
# 연결 확인을 위한 테스트 쿼리
spring.datasource.hikari.connection-test-query=SELECT 1

## Mapper 설정
mybatis.type-aliases-package=xyz.akaksr.scs.vo
mybatis.mapper-locations=mybatis/**/*.xml

## LiveReload 설정
# Java 코드를 수정 시 자동으로 개발환경에 반영하는 기능
# 필요없으신분은 false로 변경하시면 됩니다.
spring.devtools.livereload.enabled=true

## Session 설정
# 로그인 정보를 담는 세션의 유효시간 설정
# 원하는 시간으로 설정가능 (단위: ms)
# 기본값 600ms(5분)
server.servlet.session.timeout=600
```

**프로젝트 실행**
/src/main/java/xyz/akaksr/scs/SpringbootApplication.java의 main 메소드 실행