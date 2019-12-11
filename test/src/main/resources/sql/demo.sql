CREATE TABLE test.IMAGE (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  SEARCH_VALUE VARCHAR(100) not null,
  TITLE VARCHAR(500) DEFAULT NULL,
  NAME VARCHAR(100) DEFAULT NULL,
  BASE_64_ENCODING varchar(500) DEFAULT NULL,
  CREATE_DATE timestamp NULL DEFAULT NULL,
  HEIGHT int(11) DEFAULT NULL,
  THUMBNAIL varchar(500) DEFAULT NULL,
  THUMBNAIL_HEIGHT int(11) DEFAULT NULL,
  THUMBNAIL_WIDTH int(11) DEFAULT NULL,
  UPDATE_DATE timestamp NULL DEFAULT NULL,
  URL varchar(500) DEFAULT NULL,
  WIDTH int(11) DEFAULT NULL,
  IS_DELETED SMALLINT DEFAULT 0,
  PRIMARY KEY (ID)
) ;


CREATE TABLE test.APP_EXCEPTION_LOG(
 	ID BIGINT NOT NULL AUTO_INCREMENT,
 	CLASSPATH VARCHAR(500) NOT NULL,
 	UNIQUE_ID VARCHAR(50),
 	STACK_TRACE longtext,
 	IS_DELETED SMALLINT DEFAULT 0,
	CREATE_DATE TIMESTAMP NOT NULL,
	UPDATE_DATE TIMESTAMP,
    SERVER_NAME VARCHAR(80),
	PRIMARY KEY(ID)
);