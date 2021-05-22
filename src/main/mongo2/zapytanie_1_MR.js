var mapF1 = function(){
    var key = this.sex;
    var value = {
        avgHeight: parseFloat(this.weight),
        avgWeight: parseFloat(this.height),
        count: 1
    };
    return emit(key, value);
};

var reduceF1 = function(key, value){
    return{
        avgHeight: Array.sum(value.map(x => x.avgHeight)),
        avgWeight: Array.sum(value.map(x => x.avgWeight)),
        count: Array.sum(value.map(x => x.count))
    };
};

var finalizeF1 = function(key, redVal){
    return{
        avgHeight: redVal.avgHeight / redVal.count,
        avgWeight: redVal.avgWeight / redVal.count,
        count: redVal.count
    };
};

db.people.mapReduce(
    mapF1,
    reduceF1,
    {out:"height_weight_per_sex",
        finalize: finalizeF1}
)

printjson(db.height_weight_per_sex.find().toArray())