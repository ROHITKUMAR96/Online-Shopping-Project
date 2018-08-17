CREATE TABLE category (
	id NUMBER(10) NOT NULL,
	name VARCHAR2(50),
	description VARCHAR2(255),
	image_url VARCHAR2(50),
	is_active NUMBER(1),
	CONSTRAINT pk_category_id PRIMARY KEY (id) 
);
