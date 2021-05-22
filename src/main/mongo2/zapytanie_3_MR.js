var mapF3 = function(){
    emit(this.job, 1);
};

var reduceF3 = function(jobs, numbers){
    return Array.sum(numbers);
};

db.people.mapReduce(
    mapF3,
    reduceF3,
    {out:"mr_jobs"}
)

printjson(db.mr_jobs.find().toArray())