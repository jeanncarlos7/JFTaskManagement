# JFTaskManagement

API Rest do Projeto JF Task Management - Controle de Gerenciamento de Tarefas 

Feito por: Jean Carlos e Felipe Torlai

## Requisitos

- [ ] CRUD de Usuários
- [ ] Autenticação 
- [ ] CRUD de Tarefas
- [ ] CRUD de Movimentações 
- [ ] Dashboard

## Documentação 

### Endpoints 

- [Listar Tarefas](#listar-tarefas) 
- [Cadastrar Tarefa](#cadastrar-tarefa) 
- [Apagar Tarefa](#apagar-tarefa) 
- [Detalhar Tarefas](#detalhar-tarefas)
- [Atualizar Tarefas](#atualizar-tarefas)

### Listar Tarefas

`GET` /tarefa

Retorna um array com todas as tarefas cadastradas pelo usuário atual. 

### Exemplo de Resposta 

```js
[
    {
        "id da tarefa": 1,
        "nome": "adicionar tarefas",
        "nível": "importante",
        "data": "01/01/2030",
        "icone": "caderno"
    }
]
```

#### Códigos de Resposta 

| código | descrição | 
|--------|-----------|
|200| Tarefa retornada com sucesso
|401| Não autorizado. Realize a autenticação em /login

---

### Cadastrar Tarefa    

`POST` /tarefa

Cadastra uma tarefa com os dados enviados no corpo da requisição. 

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅ | Nome da tarefa
|nome|string|✅ | Nível de importância 
|nome|int |✅ | Data da tarefa  
|icone|img|❌ | Caderno 

```js

{
        "nome": "adicionar tarefa",
        "icone": "caderno"
}
```
#### Exemplo de Resposta

```js
{
        "id da tarefa": 1,
        "nome": "adicionar tarefa",
        "icone": "caderno"
}
```
#### Código de Resposta

| código | descrição | 
|--------|-----------|
|201| Tarefa cadastrada com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login

--- 
### Apagar Tarefa

`DELETE` /tarefa/`{id}` informado no parâmentro de path. 

#### Código de Resposta 

| código | descrição | 
|--------|-----------|
|204| Tarefa apagada com sucesso
|401| Não autorizado. Realize a autenticação em /login

--- 
### Detalhar tarefas  

`GET` /tarefas/`{id}`

Retorna os dados da tarefa com o `id` informado no parâmetro de path.

```js
// requisição /categoria/1
{
        "id da tarefa": 1,
        "nome": "adicionar tarefas",
        "icone": "caderno"
}
```
#### Código de Resposta 

| código | descrição | 
|--------|-----------|
|200| Tarefa retornada com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe tarefa com o `id` informado 

--- 
### Atualizar tarefas

`PUT` /tarefa/`{id}`

Atualiza os dados da tarefa com o `id` informado no path

### Cadastrar tarefa

`POST` /tarefa

Cadastra uma tarefa com os dados enviados no corpo da requisição. 

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição
|-----|----|:-----------:|---------
|nome|string|✅ | Nome da tarefa
|nome|string|✅ | Nível de importância 
|nome|int |✅ | Data da tarefa  
|icone|img|❌ | Caderno 

```js
{
        "nome": "adicionar tarefas",
        "icone": "caderno"
}
```
#### Exemplo de Resposta

```js
{
        "id da tarefa": 1,
        "nome": "adicionar tarefas",
        "icone": "caderno"
}
```
#### Código de Resposta

| código | descrição | 
|--------|-----------|
|200| Tarefa cadastrada com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe tarefa com o `id` informado 

--- 

