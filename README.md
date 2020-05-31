# Capstone-Server API 명세서



BASE URL : http://13.125.162.225/api/



1. 커뮤니티 API
   + 게시글 작성 및 수정, 삭제, 자세히 보기
2. 댓글 API
   - 댓글 작성

---

<br/>

<br/>

<br/>

## 커뮤니티 API

#### 1. 최신순 게시물 리스트

| Method | Path             | Description                             |
| ------ | ---------------- | --------------------------------------- |
| GET    | community/recent | 가장 최근에 작성된 글부터 항목 불러오기 |

##### Response Body

````
{
	"board_no" : INT			// 게시글 번호
	"title" : VARCHAR			// 제목
	"write_date" : DATETIME		// 작성 날짜
	"like_count" : INT			// 좋아요 개수
	"user_id" : INT				// 유저 번호
	"nickname" : VARCHAR		// 닉네임
	"comment_count" : INT		// 댓글 개수
}
````

<br/>

<br/>

#### 2. 인기순 게시물 리스트

| Method | Path              | Description                                  |
| ------ | ----------------- | -------------------------------------------- |
| GET    | community/popular | 좋아요를 가장 많이 받은 글부터 항목 불러오기 |

##### Response Body

````
{
	"board_no" : INT			// 게시글 번호
	"title" : VARCHAR			// 제목
	"write_date" : DATETIME		// 작성 날짜
	"like_count" : INT			// 좋아요 개수
	"user_id" : INT				// 유저 번호
	"nickname" : VARCHAR		// 닉네임
	"comment_count" : INT		// 댓글 개수
}
````

<br/>

<br/>

#### 3. 내가 작성한 게시물 리스트

| Method | Path                        | Description                           |
| ------ | --------------------------- | ------------------------------------- |
| GET    | community/popular/{user_id} | 내가 작성한 게시물 항목 모두 불러오기 |

##### Request URL

```
"user_id" : INT
```

##### Response Body

````
{
	"board_no" : INT			// 게시글 번호
	"title" : VARCHAR			// 제목
	"write_date" : DATETIME		// 작성 날짜
	"like_count" : INT			// 좋아요 개수
	"user_id" : INT				// 유저 번호
	"nickname" : VARCHAR		// 닉네임
	"comment_count" : INT		// 댓글 개수
}
````

<br/>

<br/>

#### 4. 게시글 자세히 보기

| Method | Path                 | Description               |
| ------ | -------------------- | ------------------------- |
| GET    | community/{board_no} | 선택한 게시글 자세히 보기 |

##### Request URL

```
"board_no" : INT			// 게시글 번호
```

##### Response Body

````
{
	"board_no" : INT			// 게시글 번호
	"title" : VARCHAR			// 제목
	"content" : VARCHAR			// 내용
	"write_date" : DATETIME		// 작성 날짜
	"like_count" : INT			// 좋아요 개수
	"user_id" : INT				// 유저 번호
	"nickname" : VARCHAR		// 닉네임
	"comment_count" : INT		// 댓글 개수
}
````

<br/>

<br/>

#### 5. 게시글 작성

| Method | Path       | Description     |
| ------ | ---------- | --------------- |
| POST   | community/ | 게시글 작성하기 |

##### Request Body

````
{
	"title" : VARCHAR			// 제목
	"content" : VARCHAR			// 내용
	"user_id" : INT				// 유저 번호
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```

<br/>

<br/>

#### 6. 게시글 수정

| Method | Path                 | Description     |
| ------ | -------------------- | --------------- |
| PUT    | community/{board_no} | 게시글 수정하기 |

##### Request URL

```
"board_no" : INT			// 게시글 번호
```

##### Request Body

````
{
	"title" : VARCHAR			// 제목
	"content" : VARCHAR			// 내용
}
````

##### Return

```
// 성공 시
true
// 실패 시
false
```

<br/>

<br/>

#### 7. 게시글 삭제

| Method | Path                 | Description     |
| ------ | -------------------- | --------------- |
| DELETE | community/{board_no} | 게시글 삭제하기 |

##### Request URL

```
"board_no" : INT			// 게시글 번호
```

##### Return

```
// 성공 시
true
// 실패 시
false
```

<br/>

<br/>

<br/>

## 댓글 API

#### 1. 댓글 리스트

| Method | Path               | Description               |
| ------ | ------------------ | ------------------------- |
| GET    | comment/{board_no} | 선택한 게시글 자세히 보기 |

##### Request URL

```
"board_no" : INT			// 게시글 번호
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

<br/>

<br/>

#### 2. 부모 댓글에 대한 대댓글 리스트

| Method | Path          | Description                                             |
| ------ | ------------- | ------------------------------------------------------- |
| GET    | comment/reply | 선택한 댓글의 부모 댓글을 포함한 대댓글 리스트 불러오기 |

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

<br/>

<br/>

#### 3. 댓글 작성

| Method | Path     | Description   |
| ------ | -------- | ------------- |
| POST   | comment/ | 댓글 작성하기 |

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

<br/>

<br/>

#### 4. 대댓글 작성

| Method | Path          | Description     |
| ------ | ------------- | --------------- |
| POST   | comment/reply | 대댓글 작성하기 |

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

<br/>

<br/>

#### 5. 댓글 수정

| Method | Path                 | Description   |
| ------ | -------------------- | ------------- |
| PUT    | comment/{comment_no} | 댓글 수정하기 |

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

<br/>

<br/>