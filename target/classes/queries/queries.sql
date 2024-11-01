CREATE TABLE EMPLOYEE(
  FIRSTNAME VARCHAR(255),
  LASTNAME VARCHAR(255),
  ID VARCHAR(50) PRIMARY KEY
  );

  ALTER TABLE EMPLOYEE ADD COLUMN IS_ACTIVE BOOLEAN DEFAULT FALSE;

  INSERT INTO EMPLOYEE (FIRSTNAME, LASTNAME, ID) VALUES ('John', 'Smith', 'X00000');

  UPDATE EMPLOYEE SET IS_ACTIVE=TRUE WHERE ID='X00000';

  INSERT INTO EMPLOYEE (FIRSTNAME, LASTNAME, ID) VALUES ('Ashok', 'Kumar', 'X00001');

  SELECT * FROM EMPLOYEE WHERE IS_ACTIVE=FALSE;

  DELETE FROM EMPLOYEE WHERE IS_ACTIVE=FALSE;