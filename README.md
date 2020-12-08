# MensaTalkBackend
Deployed on:
https://mensatalk.herokuapp.com/

## Schnittstellen
### Auth
- /register
```JSON
{
    "username": "exampleUser",
    "passwword": "examplePw"
}
```
- /authenticate
```JSON
{
    "username": "exampleUser",
    "passwword": "examplePw"
}
```
returns JwtToken

Token is used as HTTP header
```
Authorization: Bearer eyJhFssf3fs...
```

### ChatRooms
- /chatrooms, NoAuth

- /chatrooms/{id}, with Auth Header 


### ChatMessages
- /chatmessages, with Auth Header

- /chatmessages/{id}, with Auth Header 

- /chatrooms/{roomId}/chatmessages