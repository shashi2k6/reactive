## `Mongodb Commands :`

- `use test;`
- `db.info;`
- `db.getCollectionNames()`
  
--  `count / insert commands :`
  
  - `db.info.count()`
  - `db.info.insert({name:'shashi',product:'iphone13'})`
- `db.info.find().forEach(printjson);`

- `db.employee.find().forEach(printjson); - here employee is the collection name`


- http://localhost:8080/rest/employee/all
- http://localhost:8080/rest/employee/e5bd6603-18bb-47a2-89ef-e2eb5be65289
- http://localhost:8080/rest/employee/e5bd6603-18bb-47a2-89ef-e2eb5be65289/events