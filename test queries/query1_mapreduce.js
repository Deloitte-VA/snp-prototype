var map1 = function() {
    var i;

    for (i=0; i < this.observations.length; i=i+1) {
        if ( this.observations[i].name == 5695930304 
                && this.observations[i].name_type == 1 
                && this.observations[i].value > 140 ) {
            emit( this.patient_id, 1 );
            return;
        }
    }
};

//to scale without issue, this requires a 2nd-pass over the collection
var map2 = function() {
    emit(1, { count: 1 });
};

//same reduce phase can be run for both
var reduce = function(key, values) {
    var count = 0;

    values.forEach( function(v) { count += v['count']; } );

    return { count: count };
};

db.encounters.mapReduce(map1, reduce, { out: "encounters_results" });

db.encounters_results.mapReduce(map2, reduce, { out: "encounters_results_distinct" });

print(db.encounters_results_distinct.findOne().value.count);

//cleanup the temporary tables
db.encounters_results.drop();
db.encounters_results_distinct.drop();
