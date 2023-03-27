//Inserindo alunos no bd

db.alunos.insert(
{
    "nome" : "Alasca",
    "data_nascimento" : new Date (2014,11,01)
}
)

db.alunos.insert(
{
    "nome" : "Bruno",
    "data_nascimento" : new Date (1993,07,07)
}
)

db.alunos.insert(
{
    "nome" : "Ritiele",
    "data_nascimento" : new Date (1989,07,13)
}
)

db.alunos.insert(
{
    "nome" : "Alberto",
    "data_nascimento" : new Date (1998,05,05)
}
)

db.alunos.insert(
{
    "nome" : "Maria",
    "data_nascimento" : new Date (2000,10,10)
}
)

db.alunos.insert(
{
    "nome" : "José",
    "data_nascimento" : new Date (2002,04,04)
}
)

//Realiazando consultas no bd

//Busca todos os alunos
db.alunos.find({})

//Busca aluno pelo nome
db.alunos.find(
{ 
  "nome" : "Alasca"
}
)

//Busca aluno pela data de nascimento
db.alunos.find(
{ 
  "data_nascimento" : new Date (1993,07,07)
}
)

//Busca alunos pelo nome e pela data de nascimento
db.alunos.find({
    $or : [
    {"nome" : "Alasca"},
    {"data_nascimento" : new Date (1993,07,07)}
    ]
})

//Buscar aluno pelo nome e com a data de nascimento inferior a data informada
db.alunos.find( 
    { nome: "Ritiele",
     data_nascimento: { $lt: new Date(1989,10,10) }
    }
)

//Buscar todos os alunos nascidos após a data informada
db.alunos.find( 
    { 
     data_nascimento: { $gt: new Date(1993,10,10) }
    }
)

//Buscar todos os alunos retornando o nome e data de nascimento (sem o campo _id), ordenando por nome Z-A
db.alunos.find(
    {},
    {nome: 1, tipo: 1, data_nascimento:1, _id:0}
).sort({ nome: -1})