create schema greenboard;
set schema greenboard;

CREATE TABLE board (
	no int primary key auto_increment,
	title varchar(50) not null,
	writer varchar(50) not null
);

INSERT INTO board(title, writer) values('디비 가짜 제목', '디비 가짜 글쓴이');