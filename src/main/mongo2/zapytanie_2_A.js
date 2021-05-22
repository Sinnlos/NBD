printjson(db.people.aggregate([{
    $project: {
        "curr": {
            "$map": {
                "input": "$credit",
                "in": {"currency": "$$this.currency", "balance": "$$this.balance"}
            }
        }
    }
}, {$unwind: "$curr"}, {
    $group: {
        _id: {currency: "$curr.currency"},
        sum: {$sum: {"$toDouble": "$curr.balance"}}
    }
}, {$sort: {_id: 1}}]).toArray())