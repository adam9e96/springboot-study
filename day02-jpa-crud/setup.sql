# 데이터베이스 생성
CREATE DATABASE spring;

# 로컬 계정 생성
CREATE USER 'springuser'@'localhost' IDENTIFIED BY '303326';
GRANT ALL PRIVILEGES ON spring.* TO 'springuser'@'localhost';
FLUSH PRIVILEGES;

# day02 에서 사용할 테이블
CREATE TABLE MEMBER (
 idx INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 user_id VARCHAR(30) NOT NULL,
 user_pw VARCHAR(255) NOT NULL,
 user_name VARCHAR(20) NOT NULL,
 reg_date DATETIME NULL DEFAULT (NOW())
);

SELECT * FROM member;