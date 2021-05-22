var mapF4 = function(){
    var key = this.nationality;
    var value = {
        minBmi: parseFloat(this.weight),
        avgBmi: parseFloat(this.weight),
        maxBmi: parseFloat(this.weight),
        count: 1
    };
    return emit(key, value);
};

var reduceF4 = function(key, values){
    var bmi = values.map(values => values.avgBmi);
    return{
        minBmi: Math.min.apply(Math, bmi),
        avgBmi: Array.sum(bmi),
        maxBmi: Math.max.apply(Math, bmi),
        count: Array.sum(values.map(x=> x.count))
    };
};

var finalizeF4 = function(key, redVal){
    return{
        minBmi: redVal.minBmi,
        avgBmi: redVal.avgBmi / redVal.count,
        maxBmi: redVal.maxBmi,
        count: redVal.count,
    }
};

db.people.mapReduce(
    mapF4,
    reduceF4,
    {
        out: "bmi",
        finalize: finalizeF4
    }
)

printjson(db.bmi.find().toArray())