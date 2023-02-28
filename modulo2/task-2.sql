CREATE TABLE VEM_SER.ENDERECO(
	ID_ENDERECO NUMBER(38,0) NOT NULL PRIMARY KEY,
	ID_BAIRRO NUMBER (38,0),
	ID_CIDADE NUMBER(38,0) NOT NULL,
	LOGRADOURO VARCHAR2(255) NOT NULL,
	NUMERO NUMBER(38,0) NOT NULL,
	COMPLEMENTO VARCHAR2(100),
	CEP CHAR(9),
	CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
);
	
CREATE TABLE VEM_SER.BAIRRO(
	ID_BAIRRO NUMBER(38,0) NOT NULL,
	ID_CIDADE NUMBER(38,0) NOT NULL,
	ID_ESTADO NUMBER(38,0) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY(ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
);

CREATE TABLE VEM_SER.CIDADE(
	ID_CIDADE NUMBER(38,0) NOT NULL,
	ID_ESTADO NUMBER(38,0) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO (ID_ESTADO)
);

CREATE TABLE VEM_SER.ESTADO(
	ID_ESTADO NUMBER(38,0) NOT NULL PRIMARY KEY,
	ID_PAIS NUMBER(38,0) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	CONSTRAINT FK_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES PAIS (ID_PAIS)
);

CREATE TABLE VEM_SER.PAIS(
	ID_PAIS NUMBER(38,0) NOT NULL PRIMARY KEY,
	nome VARCHAR2(50) NOT NULL
);

-----------------------------------------------------------------------
-- Sequences

CREATE SEQUENCE VEM_SER.seq_pais
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_estado
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_cidade
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_bairro
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_logradouro
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

----------------------------------------------------------------------------
-- Inserts

INSERT INTO VEM_SER.PAIS
VALUES (seq_pais.nextval, 'Brasil');

INSERT INTO VEM_SER.PAIS
VALUES (seq_pais.nextval, 'Argentina');

INSERT INTO VEM_SER.ESTADO
VALUES (seq_estado.nextval, 1, 'Rio Grande do Sul');

INSERT INTO VEM_SER.ESTADO
VALUES (seq_estado.nextval, 1, 'Santa Catarina');

INSERT INTO VEM_SER.ESTADO
VALUES (seq_estado.nextval, 2, 'Cordoba');

INSERT INTO VEM_SER.ESTADO
VALUES (seq_estado.nextval, 2, 'Santa fe');

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 1, 'Porto Alegre')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 1, 'Cachoeirinha')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 2, 'Florianópolis')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 2, 'São José')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 3, 'Buenos Aires')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 3, 'Cordova')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 4, 'Rosario')

INSERT INTO VEM_SER.CIDADE
VALUES (seq_cidade.nextval, 4, 'Santa fe de la vera cruz')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 1, 1, 'Centro histórico')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 1, 1, 'Floresta')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 2, 1, 'Veranópolis')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 2, 1, 'Parque Brasilia')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 3, 2, 'Barra da lagoa')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 3, 2,  'Campeche')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 4, 2,  'Ponta de baixo')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 4, 2, 'Fazenda Santo Antonio')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 5, 3, 'San Telmo')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 5, 3, 'Puerto madero')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 6, 3, 'Guemes')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 6, 3, 'Nueva Córdoba')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 7, 4, 'La Tablada')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 7, 4, 'Parque Casado')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 8, 4, 'Bariloche')

INSERT INTO VEM_SER.BAIRRO
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES (seq_bairro.nextval, 8, 4, 'Juan de Garay')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 1, 1,  'Rua Riachuelo', 809, '90010-270')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 1, 1, 'Rua Borges de Medeiros', 222, '90020-022')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 2, 1, 'Avenida Farrapos', 585, '90220-004')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 2, 1, 'Rua Comendador coruja', 666, '90220-180')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 3, 2, 'Av General Anapio Gomes', 1081, '94920-270')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 3, 2, 'Rua Sete de setembro', 60, '94920-630')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 4, 2, 'Rua Osorio Correa', 640, '94935-640')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 4, 2, 'Rua Esperança', 480, '94935-160')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 6, 3, 'Av Campeche', 1220, '88063-300')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 6, 3, 'Rua da Capela', 923, '88063-400')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 5, 3, 'Rua Laurindo José de Souza', 663, '88061-400')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 5, 3, 'Rua Altamiro Barcelos Dutra', 245, '88061-300')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 7, 4, 'Rua Assis Brasil', 22, '88104-200')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 7, 4, 'Rua Mario Estevão dos Santos', 09, '88104-000')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 8, 4, 'Rua Benjamin Gerlach', 507, '88104-400')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 8, 4, 'Rua Dom Afonso Niehues', 389, '88104-430')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 9, 5, 'Av San Juan', 450, 'C1147')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 9, 5, 'Rua Defensa', 1295, 'C1143')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 10, 5, 'Rua Alferez de Navio Francisco Pareja', 256, 'C1054')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 10, 5, 'Rua Benjamin Juan Lavaisse', 1771, 'C2564')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 11, 6, 'Rua Calixto Gauna', 792, 'C7589')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 11, 6, 'Rua Rafael Gobelli', 1078, 'C1082')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 12, 6, 'Rua Fructoso Rivera', 260, 'C6654')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 12, 6, 'Rua Julio A Roca', 313, 'C2569')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 13, 7, 'Rua Carlos Casado', 200, 'C5423')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 13, 7, 'Rua Bolivar', 920, 'C5467')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 14, 7, 'Rua Latzina', 3038, 'C6574')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 14, 7, 'Rua Gaboto', 313, 'C3251')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 15, 8, 'Rua Londres', 124, 'C9987')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 15, 8, 'Rua Lisboa', 856, 'C9964')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 16, 8, 'Rua Rueda', 741, 'C4468')

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP)
VALUES (seq_logradouro.nextval, 16, 8, 'Rua Omar Carrasco', 644, 'C4497')


-----------------------------------------------------------------------------
-- Selects

SELECT * FROM VEM_SER.PAIS p  ORDER BY NOME DESC;

SELECT LOGRADOURO, CEP FROM VEM_SER.ENDERECO e WHERE UPPER(LOGRADOURO) LIKE 'A%';

SELECT * FROM VEM_SER.ENDERECO e WHERE TRIM(CEP) LIKE '%0'; -- TRIM para ele preencher os espaços vazios NO tipo char

SELECT * FROM VEM_SER.ENDERECO e WHERE NUMERO BETWEEN 1 AND 100;

SELECT * FROM VEM_SER.ENDERECO e WHERE UPPER(LOGRADOURO) LIKE 'RUA%' ORDER BY CEP DESC;

SELECT COUNT(ID_ENDERECO) AS QUANTIDADE_DE_ENDERECOS FROM VEM_SER.ENDERECO;

SELECT ID_CIDADE, COUNT(ID_ENDERECO) AS QUANT_ENDER_CIDADE FROM VEM_SER.ENDERECO GROUP BY ID_CIDADE;

------------------------------------------------------------------------------
-- Exercicios aula 17/02

UPDATE VEM_SER.ENDERECO 
SET LOGRADOURO = 'Rua nova', COMPLEMENTO = 'Apartamento 302' WHERE ID_ENDERECO  = 2;

UPDATE VEM_SER.ENDERECO 
SET LOGRADOURO = 'Rua nova dois', COMPLEMENTO = 'Apartamento 404' WHERE ID_ENDERECO  = 3;

UPDATE VEM_SER.ENDERECO 
SET NUMERO  = 999999 WHERE ID_ENDERECO = 4;

DELETE FROM VEM_SER.ENDERECO e WHERE ID_ENDERECO = (SELECT MAX(ID_ENDERECO) FROM VEM_SER.ENDERECO e2) ;

DELETE FROM VEM_SER.ENDERECO e WHERE NUMERO = 999999;

DELETE FROM VEM_SER.ENDERECO e WHERE ID_ENDERECO = 5;

DELETE FROM VEM_SER.ENDERECO e WHERE ID_ENDERECO = 8;

SELECT * FROM VEM_SER.ENDERECO e 


-------------------------------------------------------------------------------
--



