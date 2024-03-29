SELECT P.ID_PESSOA "ID",
	   NOME "Nome",
	   NUMERO "Telefone"
	   FROM VEM_SER.PESSOA p 
	   RIGHT JOIN VEM_SER.CONTATO c ON (P.ID_PESSOA = C.ID_PESSOA)
	   
SELECT P.ID_PESSOA "ID",
	   NOME "Nome",
	   LOGRADOURO "Endereço",
	   NUMERO "Número",
	   CEP "Cep"
	   FROM PESSOA p 
	   RIGHT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
	   RIGHT JOIN VEM_SER.ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)
	   
SELECT P.ID_PESSOA "ID",
	   NOME "Nome",
	   c.NUMERO "Telefone",
	   LOGRADOURO "Endereço",
	   ep.NUMERO "Número",
	   CEP "Cep"
	   FROM PESSOA p 
	   RIGHT JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA)
	   RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA = PXPE.ID_PESSOA)
	   RIGHT JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = ep.ID_ENDERECO)	 
	   
SELECT P.ID_PESSOA "ID",
	   NOME "Nome",
	   C.NUMERO "Telefone"
	   FROM VEM_SER.PESSOA p 
	   FULL JOIN VEM_SER.CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA)
	   
SELECT P.ID_PESSOA "ID",
	   NOME "Nome",
	   LOGRADOURO "Endereço",
	   NUMERO "Número",
	   CEP "Cep"
	   FROM PESSOA p 
	   FULL JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
	   FULL JOIN VEM_SER.ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)
	   
SELECT p.ID_PESSOA "ID",
	   NOME "Nome",
	   c.NUMERO "Telefone",
	   LOGRADOURO "Endereço",
	   ep.NUMERO "Número",
	   CEP "Cep"
	   FROM PESSOA p 
	   FULL JOIN CONTATO c ON (p.ID_PESSOA = c.ID_PESSOA)
	   FULL JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (p.ID_PESSOA = PXPE.ID_PESSOA)
	   FULL JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = ep.ID_ENDERECO)
	   
	   
SELECT P.ID_PESSOA "ID",
	   NOME "Nome"
	   FROM VEM_SER.PESSOA p 
	   WHERE EXISTS 
	   (SELECT PXPE.ID_ENDERECO 
	   FROM PESSOA_X_PESSOA_ENDERECO pxpe 
	   WHERE PXPE.ID_PESSOA = P.ID_PESSOA)
	   
SELECT p.ID_PESSOA "ID",
	   P.NOME "Nome"
	   FROM VEM_SER.PESSOA p 
	   UNION
	   SELECT ep.ID_ENDERECO "ID",
	   EP.LOGRADOURO "Endereço"
	   FROM VEM_SER.ENDERECO_PESSOA ep;
	   

	   
	   