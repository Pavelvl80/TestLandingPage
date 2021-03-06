CREATE TABLE XML_RESPONSE
(
ID NUMBER NOT NULL,
CONSTRAINT XML_RESPONSE_PK PRIMARY KEY (ID),
NAME NVARCHAR2(30) NOT NULL,
MESSAGE CLOB NOT NULL
);

CREATE SEQUENCE XML_RESPONSE_SEQ MINVALUE 1000 MAXVALUE 10000000000 START WITH 1001 INCREMENT BY 1;

CREATE TABLE XML_REQUEST
(
ID NUMBER NOT NULL,
CONSTRAINT XML_REQUEST_PK PRIMARY KEY (ID),
META_ELEMENT_VALUE NVARCHAR2(30) NOT NULL,
FULL_REQUEST XMLTYPE NOT NULL
);

CREATE SEQUENCE XML_REQUEST_SEQ MINVALUE 1000 MAXVALUE 10000000000 START WITH 1001 INCREMENT BY 1;


INSERT INTO XML_RESPONSE (ID, NAME, MESSAGE)
VALUES (1000, 'Not found', 'your element call nothing');

INSERT INTO XML_RESPONSE (ID, NAME, MESSAGE)
VALUES (1001, 'one', 'YOU CHOSE ONE');

INSERT INTO XML_RESPONSE (ID, NAME, MESSAGE)
VALUES (1002, 'two', 'YOU CHOSE TWO');

INSERT INTO XML_RESPONSE (ID, NAME, MESSAGE)
VALUES (1003, 'three', 'YOU CHOSE THREE');

