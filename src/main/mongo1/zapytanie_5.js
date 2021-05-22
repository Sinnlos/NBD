printjson(db.people.find({"birth_date": {"$gte": "2001", "$lte": "2100"}}, {
    first_name: 1,
    last_name: 1,
    "location.city": 1
}).toArray())