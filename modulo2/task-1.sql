CREATE TABLE VEM_SER.ESTUDANTE(
	id NUMBER,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL UNIQUE,
	ativo CHAR(1), -- ("S" = ativo, "N" = não ativo)
	PRIMARY KEY(id)
);

--------------------------------------------------------
-- sequence

CREATE SEQUENCE VEM_SER.SEQ_ESTUDANTE
START WITH 1
INCREMENT BY 1
NOCACHE 
NOCYCLE;

--------------------------------------------------------

-- inserts

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'Bruno', TO_DATE('07-07-1993', 'dd-mm-yyyy'), 1234511111, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Alasca', TO_DATE('01-11-2014', 'dd-mm-yyyy'), 54321, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Ritiele', TO_DATE('13-07-1989', 'dd-mm-yyyy'), 11111, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Viviana', TO_DATE('08-09-1974', 'dd-mm-yyyy'), 22222, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Israel', TO_DATE('19-03-2008', 'dd-mm-yyyy'), 33333, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Julio', TO_DATE('02-10-1974', 'dd-mm-yyyy'), 44444, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Guilherme', TO_DATE('10-11-2002', 'dd-mm-yyyy'), 55555, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Inacio', TO_DATE('07-07-1993', 'dd-mm-yyyy'), 99999, 'N');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Fernanda', TO_DATE('13-02-1974', 'dd-mm-yyyy'), 77777, 'S');

INSERT INTO VEM_SER.ESTUDANTE
(ID, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES(VEM_SER.SEQ_ESTUDANTE.nextval, 'Mel', TO_DATE('11-06-1970', 'dd-mm-yyyy'), 88888, 'N');

-----------------------------------------------------------------------
-- selects
SELECT * FROM VEM_SER.ESTUDANTE