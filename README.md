# BookeaterRestServices
Implement Bookeater database access using REST

[Base URL](http://centaurus-4.ics.uci.edu:1025/)

Resources
```
- /books
    - GET /BookeaterRestServices/api/books/ 
    - GET /BookeaterRestServices/api/books/byBookId/{id} 
    - GET /BookeaterRestServices/api/books/byCategory/{cid} 
    - GET /BookeaterRestServices/api/books/byKeyword/{word} 
    - GET /BookeaterRestServices/api/books/suggestions/byKeyword/{word}
- /category
    - GET /BookeaterRestServices/api/category 
    - GET /BookeaterRestServices/api/category/{cid} 
- /order
    - GET /BookeaterRestServices/api/order 
    - POST /BookeaterRestServices/api/order 
- /zip
    - GET /BookeaterRestServices/api/zip/{zip}

```

Sample Response
- http://centaurus-4.ics.uci.edu:1025/BookeaterRestServices/api/books/
``` json
[
    {
        "author": "Scott Plous",
        "bookId": "978-0070504776",
        "edition": "1st edition",
        "image": "/imgs/BS-1.jpg",
        "price": 30,
        "publisher": "McGraw-Hill",
        "title": "The Psychology of Judgment and Decision Making",
        "year": 1993
    },
    {
        "author": "Inderpal Grewal, Caren Kaplan Associate Professor Women & Gender",
        "bookId": "978-0072887181",
        "edition": "2nd edition",
        "image": "/imgs/SS-10.jpg",
        "price": 55,
        "publisher": "McGraw-Hill Education",
        "title": "An Introduction to Women's Studies: Gender in a Transnational World",
        "year": 2005
    }, ...
]
```

- http://centaurus-4.ics.uci.edu:1025/BookeaterRestServices/api/category
``` json
[
    {
        "cid": "BS",
        "cname": "Biological Science"
    }, ...
]
```

- http://centaurus-4.ics.uci.edu:1025/BookeaterRestServices/api/order

Request for POST /order has the format 
``` json
{
    "address": "Address Los Angeles, CA 90012",
    "books": "Management of Information Security",
    "ccardCode": 987,
    "ccardDate": "11/11",
    "ccardName": "Peter Ant",
    "ccardNumber": "123456789987654321",
    "ccardZip": "90012",
    "firstName": "Peter",
    "lastName": "Anteater",
    "phone": "123-456-7890",
    "shipMethod": "Overnight"
}
```

- http://centaurus-4.ics.uci.edu:1025/BookeaterRestServices/api/zip/10011
```text
New York,NY
```

Requirements
1. Both home page and product list page are implemented using jsp.
    - index.jsp
    - category.jsp
2. Implemented REST services with Java Jersey