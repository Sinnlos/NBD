var mapF2 = function(){
    this.credit.forEach(credit => {
        var key = credit.currency;
        var value = parseFloat(credit.balance);
        emit(key, value);
    })
};

var reduceF2 = function(currencies, balances){
    return Array.sum(balances);
};

db.people.mapReduce(
    mapF2,
    reduceF2,
    {out: "money_per_acc"}
)

printjson(db.money_per_acc.find().toArray())