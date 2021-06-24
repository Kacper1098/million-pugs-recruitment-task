# MillionPugs recruitment task

## REST API

### Add new Account
#### Request
``POST /account``

```localhost:8080/account```

##### Request Body
```
{
    "balance": 350.50
    "currency": "PLN"
}
```
##### Response Body
Id of created entity
```
1
```
### Get one Account
#### Request
``GET /account/{id}``

```localhost:8080/account/1```
##### Response Body
```
{
    "id": 1,
    "balance": 91.27,
    "currency": "USD"
}
```

### Get all Accounts
#### Request
``GET /account``

```localhost:8080/account```
##### Response Body
```
[
    {
        "id": 1,
        "balance": 92.27,
        "currency": "USD"
    },
    {
        "id": 2,
        "balance": 92.27,
        "currency": "USD"
    },
    {
        "id": 3,
        "balance": 131.72,
        "currency": "USD"
    }   
]
```