# placeholder


## USER

GET			https://35.168.138.236/placeholder/api/users/

GET			https://35.168.138.236/placeholder/api/users/{id}

POST 		https://35.168.138.236/placeholder/api/users/



 ` { `
 
` "name": "nombre", `

`    "username": "username", `

` "email": "email", `

` "address_street": "calle", `

` "address_suite": "sute", `

` "address_city": "ciudad", `

` "address_zipcode": "zip", `

` "address_geo_lat": "123456", `

` "adress_geo_lng": "123456", `

` "phone": "123456", `

` "website": "www", `

` "company_name": "compañia", `

` "company_catchphrase": "abcde", `

` "company_bs": "abc" `

` } `


PUT			https://35.168.138.236/placeholder/api/users/{id}



 ` { `
 
` "name": "nombre", `

`    "username": "username", `

` "email": "email", `

` "address_street": "calle", `

` "address_suite": "sute", `

` "address_city": "ciudad", `

` "address_zipcode": "zip", `

` "address_geo_lat": "123456", `

` "adress_geo_lng": "123456", `

` "phone": "123456", `

` "website": "www", `

` "company_name": "compañia", `

` "company_catchphrase": "abcde", `

` "company_bs": "abc" `

` } `


DELETE			https://35.168.138.236/placeholder/api/users/{id}







## POSTS

GET			https://35.168.138.236/placeholder/api/posts

GET			https://35.168.138.236/placeholder/api/posts/{id}

GET			https://35.168.138.236/placeholder/api/posts/{id}/comments

POST    https://35.168.138.236/placeholder/api/posts

` { `

` "userid":2, `

` "title": "titulo", `

` "body": "cuerpo" `

` } `



PUT			https://35.168.138.236/placeholder/api/posts/{id}

` { `

` "userid":2, `

` "title": "titulo", `

` "body": "cuerpo" `

` } `




DELETE			https://35.168.138.236/placeholder/api/posts/{id}


## COMMENTS


GET			https://35.168.138.236/placeholder/api/comments?postId={id}

GET			https://35.168.138.236/placeholder/api/comments/{id}

POST    https://35.168.138.236/placeholder/api/comments

` { `

` "body": "cuerpo", `

` "email": "email", `

` "name": "nombre", `

` "postid": 5 `

` } `


PUT    https://35.168.138.236/placeholder/api/comments/{id}

` { `

` "body": "cuerpo", `

` "email": "email", `

` "name": "nombre", `

` "postid": 5 `

` } `


DELETE			https://35.168.138.236/placeholder/api/comments/{id}










