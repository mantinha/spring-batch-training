create database mydatabase;
use mydatabase;

create database extradatabase;
use extradatabase;

select * from BATCH_JOB_EXECUTION_CONTEXT;
select * from BATCH_JOB_EXECUTION_PARAMS;
select * from BATCH_JOB_EXECUTION_SEQ;

select * from BATCH_STEP_EXECUTION_CONTEXT;
select * from BATCH_STEP_EXECUTION_SEQ;
select * from BATCH_STEP_EXECUTION;

select * from BATCH_JOB_EXECUTION;
select * from BATCH_JOB_INSTANCE;
select * from BATCH_JOB_SEQ;

CREATE TABLE cliente (
	nome TEXT,
	sobrenome TEXT,
	idade TEXT,
	email TEXT
);
INSERT INTO cliente VALUES ("Joao", "Silva", "30", "joao@test.com");
INSERT INTO cliente VALUES ("Maria", "Silva", "30", "maria@test.com");
INSERT INTO cliente VALUES ("Zeca 1", "Silva", "30", "zeca1@test.com");
INSERT INTO cliente VALUES ("Zeca 2", "Silva", "30", "zeca2@test.com");
INSERT INTO cliente VALUES ("Zeca 3", "Silva", "30", "zeca3@test.com");
INSERT INTO cliente VALUES ("Zeca 4", "Silva", "30", "zeca4@test.com");
INSERT INTO cliente VALUES ("Zeca 5", "Silva", "30", "zeca5@test.com");
INSERT INTO cliente VALUES ("Zeca 6", "Silva", "30", "zeca6@test.com");
INSERT INTO cliente VALUES ("Zeca 7", "Silva", "30", "zeca7@test.com");
INSERT INTO cliente VALUES ("Zeca 8", "Silva", "30", "zeca8@test.com");
INSERT INTO cliente VALUES ("Zeca 9", "Silva", "30", "zeca9@test.com");
select * from cliente;


delete from BATCH_JOB_EXECUTION_CONTEXT;
delete from BATCH_JOB_EXECUTION_PARAMS;
delete from BATCH_JOB_EXECUTION_SEQ;

delete from BATCH_STEP_EXECUTION_CONTEXT;
delete from BATCH_STEP_EXECUTION_SEQ;
delete from BATCH_STEP_EXECUTION;

delete from BATCH_JOB_EXECUTION;
delete from BATCH_JOB_INSTANCE;
delete from BATCH_JOB_SEQ;

drop database mydatabase;
drop database extradatabase;