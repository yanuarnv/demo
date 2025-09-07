# 📑 API Specification

## 🔹 Get All Articles

Request :
- Method : GET
- Endpoint : `/api/v1/articles`
- Header :
  - Accept: application/json
  
Response :

```json 
[
  {
    "id": 1,
    "title": "My First Article",
    "content": "This is the content",
    "createAt": "2025-09-06T14:02:04.983884"
  }
]

```

## 🔹 Search Articles by Title

Request :
- Method : GET
- Endpoint : `/api/v1/articles/search?title=first`
- Header :
    - Accept: application/json

Response :

```json 
[
  {
    "id": 1,
    "title": "My First Article",
    "content": "This is the content",
    "createAt": "2025-09-06T14:02:04.983884"
  }
]

```

## 🔹 Create Article

Request :
- Method : POST
- Endpoint : `/api/v1/articles`
- Header :
    - Content-Type: application/json
    - Accept: application/json
  

- Body :

```json 
{
  "title": "New Article",
  "content": "This is the content"
}
```

Response :

```json 
{
  "status": "success",
  "message": "Article created successfully",
  "data": {
    "id": 2,
    "title": "New Article",
    "content": "This is the content",
    "createAt": "2025-09-06T14:20:00.123456"
  }
}

```

## 🔹 Update Article

Request :
- Method : PUT
- Endpoint : `/api/v1/articles/1`
- Header :
    - Accept: application/json

body:
```json
{
  "title": "Updated Title",
  "content": "Updated Content"
}
```

Response :

```json 
{
  "status": "success",
  "message": "Article updated successfully",
  "data": {
    "id": 1,
    "title": "Updated Title",
    "content": "Updated Content",
    "createAt": "2025-09-06T14:02:04.983884"
  }
}

```

## 🔹 Delete Article

Request :
- Method : DELETE
- Endpoint : `/api/v1/articles/{id_article}`
- Header :
    - Accept: application/json

Response :

```json 
{
  "status": "success",
  "message": "Article deleted successfully",
  "data": {
    "id": 1,
    "title": "Updated Title",
    "content": "Updated Content",
    "createAt": "2025-09-06T14:02:04.983884"
  }
}

```

## 🐳 Useful Docker Commands
### Stop container:
```bash
docker stop articles-postgres
```
```bash
docker start articles-postgres
```
```bash
docker exec -it articles-postgres psql -U postgres -d articledb
```

