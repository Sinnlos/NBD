printjson(db.people.update({"first_name": {"$eq": "Antonio"}}, {$set: {"hobby": "pingpong"}}, {
    upsert: false,
    multi: true
}))