application.properties 내 정보를 본인에 맞게 수정하여 사용해야 합니다.
# Schedule

### API 명세서
| 기능       | Method | URL                        | request | response | 상태코드                     |
|----------|--------|----------------------------|---------|----------|--------------------------|
| 환전 요청    | POST   | /user-currency             | 요청 body | 등록 정보    | 201 Created, 400 실패      |
| 환전 요청 조회 | GET    | /user-currency/{user_id}   |         | 다건 응답 정보 | 200 정상 조회, 400 실패        |
| 환전 요청 취소 | PATCH  | /user-currency{request_id} | 요청 body | 수정 정보    | 200 정상 수정, 404 Not Found |
| 고객 삭제    | DELETE | /user-currency/{user_id}   | 요청 body |          | 200 정상 삭제, 404 Not Found |


#### 1. 일정 생성
/user-currency
+ Request
    + Header : Content-Type:application/json
    + Body :

```
{
    "user_id": "요청 고객 id",
    "to_currency_id": "환전 대상 통화",
    "amount_in_kw": "환전 요청 금액"
}
```

| 이름             | 타입   | 설명       | 필수 | 
|----------------|------|----------|----|
| user_id        | Long | 요청 고객 id | O  |
| to_currency_id | Long | 환전 대상 통화 | O  |
| amount_in_kw   | Long | 환전 요청 금액 | O  |

+ Response
    + Body :

```
{
    "user_name": "요청 고객 이름",
    "to_curency_id": "환전 대상 통화",
    "amount_in_kw": "환전 요청 금액"
    "amount_after_exchange": "환전 후 금액"
}
```

| 이름                    | 타입     | 설명       |
|-----------------------|--------|----------|
| user_name             | String | 요청 고객 이름 |
| to_currency_id        | Long   | 환전 대상 통화 |
| amount_in_kw          | Long   | 환전 요청 금액 |
| amount_after_exchange | Long   | 환전 후 금액  |


#### 2. 환전 요청 조회
/user-currency/{user_id}
+ Request
    + Parameters :

| 이름      | 타입   | 설명       | 필수 | 
|---------|------|----------|----|
| user_id | Long | 요청 고객 id | O  |      


+ Response
    + Body :

```
[
  {
    "amount_in_kw": "환전 요청 금액"
    "amount_after_exchange": "환전 후 금액",
    "createdDate": "YYYY-MM-DD HH:mm:ss"
    
  },
  {
    "amount_in_kw": "환전 요청 금액"
    "amount_after_exchange": "환전 후 금액",
    "createdDate": "YYYY-MM-DD HH:mm:ss"
      
  }
]
```

| 이름                    | 타입       | 설명       |
|-----------------------|----------|----------|
| amount_in_kw          | Long     | 환전 요청 금액 |
| amount_after_exchange | Long     | 환전 후 금액  |
| createdDate           | Datetime | 요청 일자    |


#### 3. 환전 요청 수정
/user-currency{request_id}

+ Request
    + Parameters :

| 이름         | 타입   | 설명       | 필수 | 
|------------|------|----------|----|
| request_id | Long | 환전 요청 id | O  |      

    + Body :
{
    "status": "환전 요청 상태"
}

| 이름     | 타입   | 설명    | 필수 | 
|--------|------|-------|----|
| status | enum | 요청 상태 | O  |


+ Response
    + Body :

```
{}
```


#### 5. 선택 일정 삭제
/user-currency{user_id}

+ Request
    + Parameters :

| 이름      | 타입   | 설명       | 필수 | 
|---------|------|----------|----|
| user_id | Long | 요청 고객 id | O  |      


+ Response
    + Body :

```
{}
```
