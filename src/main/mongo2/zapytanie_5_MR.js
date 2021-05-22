var mapF5 = function(){
    this.credit.forEach(credit => {
        var key = credit.currency;
        var value = {
            totalBalance: parseFloat(credit.balance),
            avgBalance: parseFloat(credit.balance),
                count: 1
        }
        emit(key, value)
    });
};

var reduceF5 = function (key, values){
    var bal = values.map(values => values.totalBalance);
    var total = Array.sum(bal);
    return{
        totalBalance: total,
        avgBalance: total,
        count: Array.sum(values.map(values => values.count))
    };
};

var finalizeF5 = function (key, redVal){
    return{
        totalBalance: redVal.totalBalance,
        avgBalance: redVal.totalBalance / redVal.count
    };
};

db.people.mapReduce(
    mapF5,
    reduceF5,
    {
        out: "balance_woman_poland",
        query:{
            sex:"Female",
            nationality:"Poland"
        },
        finalize: finalizeF5
    }
)

printjson(db.balance_woman_poland.find().toArray())