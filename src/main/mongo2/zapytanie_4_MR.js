var mapF4 = function(){
    var key = this.nationality;
    var value = {
        minBmi: (parseFloat(this.weight))/(parseFloat(this.height)*parseFloat(this.height)/10000),
        avgBmi: (parseFloat(this.weight))/(parseFloat(this.height)*parseFloat(this.height)/10000),
        maxBmi: (parseFloat(this.weight))/(parseFloat(this.height)*parseFloat(this.height)/10000),
        count: 1
    };
    return emit(key, value);
};

var reduceF4 = function(key, values){
    var bmi = values.map(values => values.avgBmi);
    var bmi1 = values.map(values => values.minBmi);
    var bmi2 = values.map(values => values.maxBmi);
    return{
        minBmi: Math.min.apply(Math, bmi1),
        avgBmi: Array.sum(bmi),
        maxBmi: Math.max.apply(Math, bmi2),
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