# Capstone-Server API 명세서



BASE URL : http://13.125.162.225/api/



1. 커뮤니티 API
   + 게시글 작성 및 수정, 삭제, 자세히 보기
2. 댓글 API
   - 댓글 작성

---







## 커뮤니티 API

#### 1. 최신순 게시물 리스트

| Method | Path    | Description                             |
| ------ | ------- | --------------------------------------- |
| GET    | /recent | 가장 최근에 작성된 글부터 항목 불러오기 |

##### Response Body

````
{
	"board_no" : INT
	"title" : VARCHAR
	"write_date" : DATETIME
	"like_count" : INT
	"user_id" : INT
	"nickname" : VARCHAR
	"comment_count" : INT
}
````





#### 2. 인기순 게시물 리스트

| Method | Path     | Description                                  |
| ------ | -------- | -------------------------------------------- |
| GET    | /popular | 좋아요를 가장 많이 받은 글부터 항목 불러오기 |

##### Response Body

````
{
	"board_no" : INT
	"title" : VARCHAR
	"write_date" : DATETIME
	"like_count" : INT
	"user_id" : INT
	"nickname" : VARCHAR
	"comment_count" : INT
}
````





#### 3. 내가 작성한 게시물 리스트

| Method | Path               | Description                           |
| ------ | ------------------ | ------------------------------------- |
| GET    | /popular/{user_id} | 내가 작성한 게시물 항목 모두 불러오기 |

##### Request URL

```
"user_id" : INT
```

##### Response Body

````
{
	"board_no" : INT
	"title" : VARCHAR
	"write_date" : DATETIME
	"like_count" : INT
	"user_id" : INT
	"nickname" : VARCHAR
	"comment_count" : INT
}
````





#### 4. 게시글 자세히 보기

| Method | Path        | Description               |
| ------ | ----------- | ------------------------- |
| GET    | /{board_no} | 선택한 게시글 자세히 보기 |

##### Request URL

```
"board_no" : INT
```

##### Response Body

````
{
	"board_no" : INT
	"title" : VARCHAR
	"content" : VARCHAR
	"write_date" : DATETIME
	"like_count" : INT
	"user_id" : INT
	"nickname" : VARCHAR
	"comment_count" : INT
}
````





#### 5. 게시글 작성

| Method | Path | Description     |
| ------ | ---- | --------------- |
| POST   | /    | 게시글 작성하기 |

##### Request Body

````
{
	"title" : VARCHAR
	"content" : VARCHAR
	"user_id" : INT
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```





#### 6. 게시글 수정

| Method | Path        | Description     |
| ------ | ----------- | --------------- |
| PUT    | /{board_no} | 게시글 수정하기 |

##### Request URL

```
"board_no" : INT
```

##### Request Body

````
{
	"title" : VARCHAR
	"content" : VARCHAR
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```





#### 7. 게시글 삭제

| Method | Path        | Description     |
| ------ | ----------- | --------------- |
| DELETE | /{board_no} | 게시글 삭제하기 |

##### Request URL

```
"board_no" : INT
```

##### Return

```
// 성공 시
true
// 실패 시
false
```





## 댓글 API

#### 1. 댓글 리스트

| Method | Path        | Description               |
| ------ | ----------- | ------------------------- |
| GET    | /{board_no} | 선택한 게시글 자세히 보기 |

##### Request URL

```
"board_no" : INT
```

##### Response Body

````
{
	"comment_no" : INT
	"content" : VARCHAR
	"parent_comment_no" : INT
	"seq" : INT
	"comment_date" : DATETIME
	"user_id" : INT
	"community_board_no" : INT
	"nickname" : VARCHAR
}
````





#### 2. 부모 댓글에 대한 대댓글 리스트

| Method | Path   | Description                                             |
| ------ | ------ | ------------------------------------------------------- |
| GET    | /reply | 선택한 댓글의 부모 댓글을 포함한 대댓글 리스트 불러오기 |

##### Request URL

```
"board_no" : INT, "comment_no" : INT
```

##### Response Body

````
{
	"comment_no" : INT
	"content" : VARCHAR
	"parent_comment_no" : INT
	"seq" : INT
	"comment_date" : DATETIME
	"user_id" : INT
	"community_board_no" : INT
	"nickname" : VARCHAR
}
````





#### 3. 댓글 작성

| Method | Path | Description   |
| ------ | ---- | ------------- |
| POST   | /    | 댓글 작성하기 |

##### Request Body

````
{
	"content" : VARCHAR
	"user_id" : INT
	"community_board_no" : INT
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```





#### 4. 대댓글 작성

| Method | Path   | Description     |
| ------ | ------ | --------------- |
| POST   | /reply | 대댓글 작성하기 |

##### Request Body

````
{
	"content" : VARCHAR
	"parent_comment_no" : INT
	"user_id" : INT
	"community_board_no" : INT
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```





#### 5. 댓글 수정

| Method | Path          | Description   |
| ------ | ------------- | ------------- |
| PUT    | /{comment_no} | 댓글 수정하기 |

##### Request URL

```
"comment_no" : INT
```

##### Request Body

````
{
	"content" : VARCHAR
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```

