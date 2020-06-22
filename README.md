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
  
  [6 댓글 삭제](#6-댓글-삭제)
  
  <br/>
  
+ 측정 / 기록 API

  [1 음주 측정값 리스트](#1-음주-측정값-리스트)

  [2 음주 측정값 저장](#2-음주-측정값-저장)
  
  [3 흡연 측정값 리스트](#3-흡연-측정값-리스트)
  
  [4 흡연 측정값 저장](#4-흡연-측정값-저장)
  
  [5 음주 총 사용 금액, 마신 잔 수](#5-음주-총-사용-금액,-마신-잔-수)
  
  [6 흡연 총 사용 금액, 피운 개비 수](#6-흡연-총-사용-금액,-피운-개비-수)
  
  [7 i월 음주 기록 리스트](#7-i월-음주-기록-리스트)
  
  [8 i월 흡연 기록 리스트](#8-i월-흡연-기록-리스트)
  
  <br/>
  
+ 유저 API

  [1 로그인](#1-로그인)

  [2 회원가입](#2-회원가입)
  
  [3 이메일 중복 검사](#3-이메일-중복-검사)
  
  [4 닉네임 중복 검사](#4-닉네임-중복-검사)

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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
            "del_flag" : INT			// 삭제 여부 (삭제된 덧글 : 1)
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
            "del_flag" : INT			// 삭제 여부 (삭제된 덧글 : 1)
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

##### Request Header

````
"Authorization": token
````

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
            "del_flag" : INT			// 삭제 여부 (삭제된 덧글 : 1)
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
            "del_flag" : INT			// 삭제 여부 (삭제된 덧글 : 1)
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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

##### Request Header

````
"Authorization": token
````

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

## 6 댓글 삭제

[목차로 이동](#목차)

| Method | Path                 | Description   |
| ------ | -------------------- | ------------- |
| DELETE | comment/{comment_no} | 댓글 삭제하기 |

##### Request Header

````
"Authorization": token
````

##### Request URL

```
"comment_no" : INT
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "댓글 삭제 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "댓글 삭제 실패",
    "data": false
}
```

##### Caution

```
DEL_FLAG만 1로 바꿉니다.
※ 기존의 댓글 Response Body에 DEL_FLAG 추가하였음.
```

<br/>

<br/>

<br/>

# 측정 API

<br/>

## 1 음주 측정값 리스트

[목차로 이동](#목차)

| Method | Path                   | Description                             |
| ------ | ---------------------- | --------------------------------------- |
| GET    | record/drink/{user_id} | 해당 유저의 음주 측정값 리스트 불러오기 |

##### Request Header

````
"Authorization": token
````

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

| Method | Path          | Description                    |
| ------ | ------------- | ------------------------------ |
| POST   | record/drink/ | 유저가 측정한 음주 측정값 저장 |

##### Request Header

````
"Authorization": token
````

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

## 3 흡연 측정값 리스트

[목차로 이동](#목차)

| Method | Path                   | Description                             |
| ------ | ---------------------- | --------------------------------------- |
| GET    | record/smoke/{user_id} | 해당 유저의 흡연 측정값 리스트 불러오기 |

##### Request Header

````
"Authorization": token
````

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
            "piece": INT,				// 개비 수
            "smoke_date": VARCHAR,		// 핀 날짜
            "smoke_name": VARCHAR		// 핀 담배 종류
        },
        {
            "id": INT,					// 기록 번호
            "figure": DOUBLE,			// 측정값
            "piece": INT,				// 개비 수
            "smoke_date": VARCHAR,		// 핀 날짜
            "smoke_name": VARCHAR		// 핀 담배 종류
        }
        ...
    ]
} 
```

<br/><br/>

## 4 흡연 측정값 저장

[목차로 이동](#목차)

| Method | Path          | Description                    |
| ------ | ------------- | ------------------------------ |
| POST   | record/smoke/ | 유저가 측정한 흡연 측정값 저장 |

##### Request Header

````
"Authorization": token
````

##### Request Body

```
{
	"figure" : DOUBLE			// 측정값
	"piece" : INT				// 개비 수
	"smoke_date" : VARCHAR		// 핀 날짜
	"smoke_name" : VARCHAR		// 핀 담배 이름
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

## 5 음주 총 사용 금액, 마신 잔 수

[목차로 이동](#목차)

| Method | Path                         | Description                           |
| ------ | ---------------------------- | ------------------------------------- |
| GET    | record/drink/total/{user_id} | 술에 쓴 총합 금액과 마신 잔 수를 반환 |

##### Request Header

````
"Authorization": token
````

##### Request URL

```
"user_id" : INT
```

##### Response Body

```
{
    "status": "200",
    "message": "음주 총합 조회 성공",
    "data": {
        "total_glass": INT
        "total_price": INT
    }
}
```

<br/>

<br/>

## 6 흡연 총 사용 금액, 피운 개비 수

[목차로 이동](#목차)

| Method | Path                         | Description                               |
| ------ | ---------------------------- | ----------------------------------------- |
| GET    | record/smoke/total/{user_id} | 담배에 쓴 총합 금액과 피운 개비 수를 반환 |

##### Request Header

````
"Authorization": token
````

##### Request URL

```
"user_id" : INT
```

##### Response Body

```
{
    "status": "200",
    "message": "흡연 총합 조회 성공",
    "data": {
        "total_piece": INT
        "total_price": INT
    }
}
```

<br/>

<br/>

## 7 i월 음주 기록 리스트

[목차로 이동](#목차)

| Method | Path               | Description                      |
| ------ | ------------------ | -------------------------------- |
| POST   | record/drink/month | i월에 마신 잔 수 리스트 불러오기 |

##### Request Header

````
"Authorization": token
````

##### Request Body

```
{
	"user_id" : INT			// 유저 번호
	"month" : INT			// 조회를 원하는 월
}
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "월별 기록 리스트 조회 성공",
    "data": [
        {
            "date": "2020.06.08",
            "total_amount": 27
        },
        {
            "date": "2020.06.09",
            "total_amount": 31
        },
        {
            "date": "2020.06.10",
            "total_amount": 30
        }
        ...
    ]
}
// 올바르지 않은 달(0이하 13이상)을 조회시
{
    "status": "400",
    "message": "1월 ~ 12월만 조회해주세요.",
    "data": null
}
```

<br/>

<br/>

## 8 i월 흡연 기록 리스트

[목차로 이동](#목차)

| Method | Path               | Description                        |
| ------ | ------------------ | ---------------------------------- |
| POST   | record/smoke/month | i월에 피운 개비 수 리스트 불러오기 |

##### Request Header

````
"Authorization": token
````

##### Request Body

```
{
	"user_id" : INT			// 유저 번호
	"month" : INT			// 조회를 원하는 월
}
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "월별 기록 리스트 조회 성공",
    "data": [
        {
            "date": "2020.06.08",
            "total_amount": 27
        },
        {
            "date": "2020.06.09",
            "total_amount": 31
        },
        {
            "date": "2020.06.10",
            "total_amount": 30
        }
        ...
    ]
}
// 올바르지 않은 달(0이하 13이상)을 조회시
{
    "status": "400",
    "message": "1월 ~ 12월만 조회해주세요.",
    "data": null
}
```

<br/>

<br/>

<br/>

# 유저 API

<br/>

## 1 로그인

[목차로 이동](#목차)

| Method | Path       | Description |
| ------ | ---------- | ----------- |
| POST   | user/login | 로그인 하기 |

##### Test ID

```
"email" : "admin"
"password" : "1234"
```

##### Request URL

```
{
	"email" : String			// 측정값
	"password" : String			// 잔 수
}
```

##### Response Body

```
{
    "status": "200",
    "message": "기록 리스트 조회 성공",
    "data": "Bearer ***************.." (token)
} 
```

<br/><br/>

## 2 회원가입

[목차로 이동](#목차)

| Method | Path        | Description |
| ------ | ----------- | ----------- |
| POST   | user/signup | 회원가입    |

##### Request Body

```
{
	"email": VARCHAR			// 이메일
	"nickname": VARCHAR			// 닉네임
	"age": INT					// 나이
	"drink_average": INT		// 평균 주량
	"smoke_average": INT		// 평균 흡연량
	"password": VARCHAR			// 비밀번호
	"determination": VARCHAR	// 나의 의지
}
```

##### Response Body

```
// 성공 시
{
    "status": "200",
    "message": "회원가입 성공",
    "data": true
}
// 실패 시
{
    "status": "400",
    "message": "회원가입 실패",
    "data": false
}
```

<br/>

<br/>

## 3 이메일 중복 검사

[목차로 이동](#목차)

| Method | Path               | Description               |
| ------ | ------------------ | ------------------------- |
| GET    | user/email/{email} | 사용 중인 이메일인지 검사 |

##### Request URL

```
"email" : VARCHAR
```

##### Response Body

```
// DB에 없는 이메일인 경우
{
    "status": "200",
    "message": "사용 가능한 이메일입니다.",
    "data": true
}
// DB에 있는 이메일인 경우
{
    "status": "200",
    "message": "이미 존재하는 이메일입니다.",
    "data": false
}
```

<br/>

<br/>

## 4 닉네임 중복 검사

[목차로 이동](#목차)

| Method | Path                     | Description               |
| ------ | ------------------------ | ------------------------- |
| GET    | user/nickname/{nickname} | 사용 중인 닉네임인지 검사 |

##### Request URL

```
"nickname" : VARCHAR
```

##### Response Body

```
// DB에 없는 닉네임인 경우
{
    "status": "200",
    "message": "사용 가능한 닉네임입니다.",
    "data": true
}
// DB에 있는 닉네임인 경우
{
    "status": "200",
    "message": "이미 존재하는 닉네임입니다.",
    "data": false
}
```

<br/>

<br/>

<br/>