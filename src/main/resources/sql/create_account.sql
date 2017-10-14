CREATE TABLE ACCOUNT_INFO(
	ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
	NAME			VARCHAR(100) NOT NULL,
	NICKNAME		VARCHAR(100) DEFAULT NULL,
	GST_TIN_NUMBER	VARCHAR(100) DEFAULT NULL,
	TRANSPORT		VARCHAR(100) DEFAULT NULL,		
	PHONE			VARCHAR(100) DEFAULT NULL,
	HOUSENUBER		VARCHAR(50)  DEFAULT NULL,
	STREET			VARCHAR(100) DEFAULT NULL,
	CITY			VARCHAR(100) NOT NULL,
	STATE			VARCHAR(100) DEFAULT NULL,
	PINCODE			VARCHAR(100) DEFAULT NULL,
	COUNTRY			VARCHAR(100) DEFAULT NULL,
	LANDMARK		VARCHAR(500) DEFAULT NULL,
	ENGAGEDATE		TIMESTAMP,
	PAN				VARCHAR(100) DEFAULT NULL,
	LICENCE			VARCHAR(100) DEFAULT NULL,
	DESCRIPTION		VARCHAR(100) DEFAULT NULL,
	IMAGEPATH		VARCHAR(500) DEFAULT NULL,
	CREATEDDATE		TIMESTAMP,
	LASTUPDATED		TIMESTAMP,
	ISENABLE		BOOLEAN DEFAULT TRUE,
	CONSTRAINT	UNIQUE_ACCOUNT_INFO		UNIQUE(NAME,CITY,STATE)
);