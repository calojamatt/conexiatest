--
-- Create user `conexiauser`
--
CREATE USER 'conexiauser'@'%' IDENTIFIED WITH mysql_native_password;
SET PASSWORD FOR 'conexiauser'@'%' = PASSWORD ('C0nex1aT3st');
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DROP, EVENT, EXECUTE, GRANT OPTION, INDEX, LOCK TABLES, REFERENCES, SHOW VIEW, TRIGGER ON conexiatest.* TO 'conexiauser'@'%';