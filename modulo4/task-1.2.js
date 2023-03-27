//DADOS

//Grupo - Bruno Rodrigues, Gabriel de Jesus e Gabriel Meira


/* TASK-1.2 */
//Criando coleção usuario

use vemserdbc
db.createCollection("usuario")

//Inserindo 4 registros de usuario

db.usuario.insert(
    {
        "login" : "gabriel@gmail.com",
        "senha" : "123456",
        "nome" : "Gabriel de Jesus",
        "tipo" : "ADMIN",
        "ativo" : 1
    }
)

db.usuario.insert(
    {
        "login" : "bruno.rodrigues@gmail.com",
        "senha" : "123456",
        "nome" : "Bruno Rodrigues",
        "tipo" : "COMPRADOR",
        "ativo" : 0
    }
)

db.usuario.insert(
    {
        "login" : "meira@gmail.com",
        "senha" : "123456",
        "nome" : "Gabriel Meira",
        "tipo" : "COMPANHIA",
        "ativo" : 1
    }
)

db.usuario.insert(
    {
        "login" : "joelma@gmail.com",
        "senha" : "123456",
        "nome" : "Joelma de Costa Oliveira Santana",
        "tipo" : "ADMIN",
        "ativo" : 1
    }
)


//Fazendo quatro operações de busca

//buscando todos
db.usuario.find({})

//buscar todos "gabriel" que nasceram acima de 1993
db.usuario.find({
    $or : [
    {"nome" : /Gabriel/},
    {"data_nascimento" : {$gt: new Date (1993,07,07)}}
    ]
})

//trazer todos usuarios ativos organizados em ordem alfabética pelo tipo
db.usuario.find({"ativo" : 1}).sort({tipo: 1})

//trazer nome, tipo e login de todos usuarios ativos
db.usuario.find({"ativo": 1},{nome: 1, tipo: 1, login:1, _id:0})