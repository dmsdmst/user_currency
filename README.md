application.properties 내 정보를 본인에 맞게 수정하여 사용해야 합니다.
# Schedule

### API 명세서
| 기능       | Method | URL                 | exchange | response | 상태코드                     |
|----------|--------|---------------------|----------|----------|--------------------------|
| 환전 요청    | POST   | /exchange           | 요청 body  | 등록 정보    | 201 Created, 400 실패      |
| 환전 요청 조회 | GET    | /exchange/{user_id} |          | 다건 응답 정보 | 200 정상 조회, 400 실패        |
| 환전 요청 취소 | PATCH  | /exchange           | 요청 body  | 수정 정보    | 200 정상 수정, 404 Not Found |


#### 1. 환전 요청 생성
/exchange
+ Request
    + Header : Content-Type:application/json
    + Body :

```
{
    "userEmail": "요청 고객 email",
    "currencyName": "환전 대상 통화",
    "amount_in_kw": "환전 요청 금액"
}
```

| 이름           | 타입     | 설명          | 필수 | 
|--------------|--------|-------------|----|
| userEmail    | String | 요청 고객 email | O  |
| currencyName | String | 환전 대상 통화    | O  |
| amount_in_kw | Long   | 환전 요청 금액    | O  |

+ Response
    + Body :

```
{
    "user_name": "요청 고객 이름",
    "currency_name": "환전 대상 통화",
    "amount_in_kw": "환전 요청 금액"
    "amount_after_exchange": "환전 후 금액"
}
```

| 이름                    | 타입     | 설명       |
|-----------------------|--------|----------|
| user_name             | String | 요청 고객 이름 |
| currency_name         | String | 환전 대상 통화 |
| amount_in_kw          | Long   | 환전 요청 금액 |
| amount_after_exchange | Long   | 환전 후 금액  |


#### 2. 환전 요청 조회
/exchange/{user_id}
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
    "amount_in_kw": "환전 요청 금액",
    "currency_name": "환전 대상 통화",
    "amount_after_exchange": "환전 후 금액",
    "createdDate": "YYYY-MM-DD HH:mm:ss"
    
  },
  {
    "amount_in_kw": "환전 요청 금액",
    "currency_name": "환전 대상 통화",
    "amount_after_exchange": "환전 후 금액",
    "createdDate": "YYYY-MM-DD HH:mm:ss"
      
  }
]
```

| 이름                    | 타입       | 설명       |
|-----------------------|----------|----------|
| amount_in_kw          | Long     | 환전 요청 금액 |
| currency_name         | String   | 환전 대상 통화 |
| amount_after_exchange | Long     | 환전 후 금액  |
| createdDate           | Datetime | 요청 일자    |


#### 3. 환전 요청 수정
/exchange

+ Request
  + Body :
{
    "status": "환전 요청 상태",
    "exchange_id" : "환전 요청 id"
}

| 이름          | 타입   | 설명       | 필수 | 
|-------------|------|----------|----|
| status      | enum | 요청 상태    | O  |
| exchange_id | Long | 환전 요청 id | O  |      



+ Response
    + Body :

```
{}
```