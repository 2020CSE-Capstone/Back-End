# Capstone-Server API 명세서

<br/>

BASE URL : http://13.125.162.225/api/

<br/>

<br/>

<br/>

# 목차

<br/>

+ 커뮤니티 API

  [1 최신순 게시물 리스트](#1-최신순-게시물-리스트)

  [2 인기순 게시물 리스트](#2-인기순-게시물-리스트)

  [3 내가 작성한 게시물 리스트](#3-내가-작성한-게시물-리스트)

  [4 게시글 자세히 보기](#4-게시글-자세히-보기)

  [5 게시글 작성](#5-게시글-작성)

  [6 게시글 수정](#6-게시글-수정)

  [7 게시글 삭제](#7-게시글-삭제)
  
  <br/>
  
+ 댓글 API

  [1 댓글 리스트](#1-댓글-리스트)

  [2 부모 댓글에 대한 대댓글 리스트](#2-부모-댓글에-대한-대댓글-리스트)

  [3 댓글 작성](#3-댓글-작성)

  [4 대댓글 작성](#4-대댓글-작성)

  [5 댓글 수정](#5-댓글-수정)
  
  <br/>
  
+ 측정 API

  [1 음주 측정값 리스트](#1-음주-측정값-리스트)

  [2 음주 측정값 저장](#2-음주-측정값-저장)

---

<br/>

<br/>

<br/>

# 커뮤니티 API

<br/>

## 1 최신순 게시물 리스트

[목차로 이동](#목차)

| Method | Path             | Description                             |
| ------ | ---------------- | --------------------------------------- |
| GET    | community/recent | 가장 최근에 작성된 글부터 항목 불러오기 |

##### Response Body

````
{
    "status": "200",
    "message": "최신 게시글 리스트 조회 성공",
    "data": [
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        },
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        }
        ...
    ]
}
````

<br/>

<br/>

## 2 인기순 게시물 리스트

[목차로 이동](#목차)

| Method | Path              | Description                                  |
| ------ | ----------------- | -------------------------------------------- |
| GET    | community/popular | 좋아요를 가장 많이 받은 글부터 항목 불러오기 |

##### Response Body

````
{
    "status": "200",
    "message": "인기 게시글 리스트 조회 성공",
    "data": [
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        },
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        }
        ...
    ]
}
````

<br/>

<br/>

## 3 내가 작성한 게시물 리스트

[목차로 이동](#목차)

| Method | Path                       | Description                           |
| ------ | -------------------------- | ------------------------------------- |
| GET    | community/mypage/{user_id} | 내가 작성한 게시물 항목 모두 불러오기 |

##### Request URL

```
"user_id" : INT
```

##### Response Body

````
{
    "status": "200",
    "message": "내가 작성한 게시글 리스트 조회 성공",
    "data": [
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        },
        {
            "board_no" : INT			// 게시글 번호
            "title" : VARCHAR			// 제목
            "write_date" : VARCHAR		// 작성 날짜
            "like_count" : INT			// 좋아요 개수
            "user_id" : INT				// 유저 번호
            "nickname" : VARCHAR		// 닉네임
            "comment_count" : INT		// 댓글 개수
        }
        ...
    ]
}
````

<br/>

<br/>

## 4 게시글 자세히 보기

[목차로 이동](#목차)

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
    "status": "200",
    "message": "최신 게시글 리스트 조회 성공",
    "data": {
        "board_no" : INT			// 게시글 번호
        "title" : VARCHAR			// 제목
        "content" : VARCHAR			// 내용
        "write_date" : VARCHAR		// 작성 날짜
        "like_count" : INT			// 좋아요 개수
        "user_id" : INT				// 유저 번호
        "nickname" : VARCHAR		// 닉네임
        "comment_count" : INT		// 댓글 개수
    }
}
````

<br/>

<br/>

## 5 게시글 작성

[목차로 이동](#목차)

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

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "게시글 삽입 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "게시글 삽입 실패",
    "data": false
}
```

<br/>

<br/>

## 6 게시글 수정

[목차로 이동](#목차)

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

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "게시글 수정 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "게시글 수정 실패",
    "data": false
}
```

<br/>

<br/>

## 7 게시글 삭제

[목차로 이동](#목차)

| Method | Path                 | Description     |
| ------ | -------------------- | --------------- |
| DELETE | community/{board_no} | 게시글 삭제하기 |

##### Request URL

```
"board_no" : INT			// 게시글 번호
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "게시글 삭제 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "게시글 삭제 실패",
    "data": false
}
```

<br/>

<br/>

<br/>

# 댓글 API

<br/>

## 1 댓글 리스트

[목차로 이동](#목차)

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
    "status": "200",
    "message": "댓글 리스트 조회 성공",
    "data": [
        {
            "comment_no" : INT			// 댓글 번호
            "content" : VARCHAR			// 내용
            "parent_comment_no" : INT	// 부모 댓글 번호
            "seq" : INT					// 부모 댓글에 대한 대댓글 순서 (부모 : 1)
            "comment_date" : VARCHAR	// 작성 날짜
            "user_id" : INT				// 유저 번호
            "community_board_no" : INT	// 커뮤니티 게시글 번호
            "nickname" : VARCHAR		// 닉네임
        },
        {
            "comment_no" : INT			// 댓글 번호
            "content" : VARCHAR			// 내용
            "parent_comment_no" : INT		// 부모 댓글 번호
            "seq" : INT					// 부모 댓글에 대한 대댓글 순서 (부모 : 1)
            "comment_date" : VARCHAR	// 작성 날짜
            "user_id" : INT				// 유저 번호
            "community_board_no" : INT	// 커뮤니티 게시글 번호
            "nickname" : VARCHAR		// 닉네임
        }
        ...
    ]
}
````

<br/>

<br/>

## 2 부모 댓글에 대한 대댓글 리스트

[목차로 이동](#목차)

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
    "status": "200",
    "message": "대댓글 리스트 조회 성공",
    "data": [
        {
            "comment_no" : INT			// 댓글 번호
            "content" : VARCHAR			// 내용
            "parent_comment_no" : INT	// 부모 댓글 번호
            "seq" : INT					// 부모 댓글에 대한 대댓글 순서 (부모 : 1)
            "comment_date" : VARCHAR	// 작성 날짜
            "user_id" : INT				// 유저 번호
            "community_board_no" : INT	// 커뮤니티 게시글 번호
            "nickname" : VARCHAR		// 닉네임
        },
        {
            "comment_no" : INT			// 댓글 번호
            "content" : VARCHAR			// 내용
            "parent_comment_no" : INT	// 부모 댓글 번호
            "seq" : INT					// 부모 댓글에 대한 대댓글 순서 (부모 : 1)
            "comment_date" : VARCHAR	// 작성 날짜
            "user_id" : INT				// 유저 번호
            "community_board_no" : INT	// 커뮤니티 게시글 번호
            "nickname" : VARCHAR		// 닉네임
        }
        ...
    ]
}
````

<br/>

<br/>

## 3 댓글 작성

[목차로 이동](#목차)

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

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "댓글 삽입 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "댓글 삽입 실패",
    "data": false
}
```

<br/>

<br/>

## 4 대댓글 작성

[목차로 이동](#목차)

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

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "대댓글 삽입 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "대댓글 삽입 실패",
    "data": false
}
```

<br/>

<br/>

## 5 댓글 수정

[목차로 이동](#목차)

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

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "댓글 수정 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "댓글 수정 실패",
    "data": false
}
```

<br/>

<br/>

<br/>

# 측정 API

<br/>

## 1 음주 측정값 리스트

[목차로 이동](#목차)

| Method | Path             | Description                             |
| ------ | ---------------- | --------------------------------------- |
| GET    | record/{user_id} | 해당 유저의 음주 측정값 리스트 불러오기 |

##### Request URL

```
"user_id" : INT
```

##### Response Body

```
{
    "status": "200",
    "message": "기록 리스트 조회 성공",
    "data": [
        {
            "id": INT,					// 기록 번호
            "figure": DOUBLE,			// 측정값
            "glass": INT,				// 잔 수
            "drink_date": VARCHAR,		// 마신 날짜
            "drink_name": VARCHAR		// 마신 술 종류
        },
        {
            "id": INT,					// 기록 번호
            "figure": DOUBLE,			// 측정값
            "glass": INT,				// 잔 수
            "drink_date": VARCHAR,		// 마신 날짜
            "drink_name": VARCHAR		// 마신 술 이름
        }
        ...
    ]
} 
```

<br/><br/>

## 2 음주 측정값 저장

[목차로 이동](#목차)

| Method | Path    | Description                    |
| ------ | ------- | ------------------------------ |
| POST   | record/ | 유저가 측정한 음주 측정값 저장 |

##### Request Body

```
{
	"figure" : DOUBLE			// 측정값
	"glass" : INT				// 잔 수
	"drink_date" : VARCHAR		// 마신 날짜
	"drink_name" : VARCHAR		// 마신 술 이름
	"user_id" : INT				// 유저 번호
}
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "기록 삽입 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "기록 삽입 실패",
    "data": false
}
```

<br/>

<br/>