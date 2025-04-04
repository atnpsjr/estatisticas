<h1 align="center" style="font-weight: bold;">Microsserviço💻</h1>

<p align="center">
    <b>O microsserviço consome dados de uma fila RabbitMQ e persiste as informações no banco de dados MongoDB</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java
- Spring Boot
- RabbitMQ
- Docker
- SLF4J
- MongoDB

<h2 id="routes">📍 API Endpoints</h2>

​
| endpoint               | descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>/customers/{customerId}/orders</kbd>     | recupera as infomações do usuario

<h3 id="get-auth-detail">GET /autenticação</h3>

**RESPONSE**
```json
{
   "codigoPedido": 1001,
       "codigoCliente":1,
       "itens": [
           {
               "produto": "lápis",
               "quantidade": 100,
               "preco": 1.10
           },
           {
               "produto": "caderno",
               "quantidade": 10,
               "preco": 1.00
           }
       ]
}
```
