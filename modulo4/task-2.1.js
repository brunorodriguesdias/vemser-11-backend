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

db.alunos.insert(
    {
        "nome" : "Josefa",
        "data_nascimento" : new Date (199,03,03)
    }
    )

db.alunos.insert(
{
    "nome" : "Viviana",
    "data_nascimento" : new Date (1974,09,08)
}
)

db.alunos.insert(
{
    "nome" : "Israel",
    "data_nascimento" : new Date (2008,03,19)
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

//Buscar todos os alunos nascidos apos a data informada
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


//Buscar todos os alunos e realizar um concat de "nome" + "-" + "data_nascimento"
db.alunos.find(
    {},
    { _id: 0, nome: { $concat: [ "$nome", " - ", { $convert: { input: "$data_nascimento", to: "string" }} ]}
}
)

//Buscar todos os alunos e realizar um concat de "nome" + "-" + "data_nascimento" fomatada para o padrao dd/mm/YYYY
db.alunos.find(
    {},
    { _id: 0, nome: { $concat: [ "$nome", " - ", {$dateToString: { date: "$data_nascimento", format: "%d/%m/%Y" } } ]}
}
)

//Buscar todos os alunos com data_nascimento no intervalo de tempo - find com condicao multipla
db.alunos.find(
    {
        data_nascimento: {$gte: new Date(1989,01,01), $lte: new Date(2000,01,01)}
    }
)

db.alunos.updateOne(
    { nome: "Bruno" },
    { $set: { nome: "Bruno Rodrigues" }}
)