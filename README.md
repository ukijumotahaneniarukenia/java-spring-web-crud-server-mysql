

```
$ psql -U postgres -d testdb
psql (12.4)
Type "help" for help.

testdb=# select * from employee;
 id |     name      |  role   
----+---------------+---------
  1 | Bilbo Baggins | burglar
  2 | Frodo Baggins | thief
(2 rows)

testdb=# \q


$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar"
  },
  {
    "id": 2,
    "name": "Frodo Baggins",
    "role": "thief"
  }
]


$ curl -X POST -H 'Content-Type:application/json' localhost:8080/api/add -d'{"name":"まりこ","role":"Chef"}'
Saves

$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar"
  },
  {
    "id": 2,
    "name": "Frodo Baggins",
    "role": "thief"
  },
  {
    "id": 3,
    "name": "まりこ",
    "role": "Chef"
  }
]


$ curl -X GET -H 'Content-Type:application/json' -s localhost:8080/api/employees/5 | jq
null

$ curl -X GET -H 'Content-Type:application/json' -s localhost:8080/api/employees/2 | jq
{
  "id": 2,
  "name": "Frodo Baggins",
  "role": "thief"
}

$ curl -X GET -H 'Content-Type:application/json' -s localhost:8080/api/employees/3 | jq
{
  "id": 3,
  "name": "まりこ",
  "role": "Chef"
}



$ curl -X PUT -H 'Content-Type:application/json' -s localhost:8080/api/employees/2 -d '{"name":"ぽるこ","role":"ぶた"}'
{"timestamp":"2020-08-21T18:49:59.600+00:00","status":404,"error":"Not Found","message":"","path":"/api/employees/2"}
 

$ psql -U postgres -d testdb
psql (12.4)
Type "help" for help.

testdb=# select * from employee;
 id |     name      |  role   
----+---------------+---------
  1 | Bilbo Baggins | burglar
  3 | まりこ        | Chef
  2 | ぽるこ        | ぶた
(3 rows)

testdb=# 



$ curl -X DELETE -H 'Content-Type:application/json' -s localhost:8080/api/employees/2
{"timestamp":"2020-08-21T18:51:00.436+00:00","status":404,"error":"Not Found","message":"","path":"/api/employees/2"}

$ psql -U postgres -d testdb
psql (12.4)
Type "help" for help.

testdb=# select * from employee;
 id |     name      |  role   
----+---------------+---------
  1 | Bilbo Baggins | burglar
  3 | まりこ        | Chef
(2 rows)

testdb=# 



mysqlでも出ていたので、データベースの違いによる問題ではないことがわかった。実装の問題。。。

HTTPレスポンスを上書きすることで解消できた


$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar"
  },
  {
    "id": 2,
    "name": "Frodo Baggins",
    "role": "thief"
  }
]



$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar"
  },
  {
    "id": 2,
    "name": "ぽるこ",
    "role": "ぶた"
  }
]


$ curl -X POST -H 'Content-Type:application/json' localhost:8080/api/add -d'{"name":"まりこ","role":"Chef"}'
{"id":3,"name":"まりこ","role":"Chef"}

$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar"
  },
  {
    "id": 2,
    "name": "ぽるこ",
    "role": "ぶた"
  },
  {
    "id": 3,
    "name": "まりこ",
    "role": "Chef"
  }
]


$ curl -X DELETE -H 'Content-Type:application/json' -s localhost:8080/api/employees/1
{"id":1,"name":"Bilbo Baggins","role":"burglar"}


$ curl -X GET -s http://localhost:8080/api/all | jq
[
  {
    "id": 2,
    "name": "ぽるこ",
    "role": "ぶた"
  },
  {
    "id": 3,
    "name": "まりこ",
    "role": "Chef"
  }
]


$ curl -X DELETE -H 'Content-Type:application/json' -s localhost:8080/api/employees/2
{"id":2,"name":"ぽるこ","role":"ぶた"}

$ curl -X DELETE -H 'Content-Type:application/json' -s localhost:8080/api/employees/3
{"id":3,"name":"まりこ","role":"Chef"}

$ curl -X GET -s http://localhost:8080/api/all | jq
[]


$ curl -X DELETE -H 'Content-Type:application/json' -s localhost:8080/api/employees/1
Could not find employee 1


$ curl -X PUT -H 'Content-Type:application/json' -s localhost:8080/api/employees/2 -d '{"name":"ぽるこ","role":"ぶた"}'
Could not find employee 2


```
