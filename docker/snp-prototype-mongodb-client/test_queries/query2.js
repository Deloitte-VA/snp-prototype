function contains(a, obj) {
    for (var i = 0; i < a.length; i++) {
        if (a[i] === obj) {
            return true;
        }
    }
    return false;
}

var getUnique = function(arrayIn) {
    var o = {}, returnVal = [], i, currObj;
    for (i = 0; currObj = arrayIn[i]; i=i+1) {
        o[currObj] = 1;
    };
    for (currObj in o) {
        returnVal.push(currObj);
    };
    return returnVal;
};

//assuming there is at least one object and this applies only to the right arm
var findMinMaxObservation = function(observations) {
    var i, max, min;
    for (i = 0; i < observations.length; i=i+1) {
        if (contains([5695930304], observations[i].name)) {
            if (max == null || observations[i].value > max) {
                max = observations[i].value;
            }
            if (min == null || observations[i].value < min) {
                min = observations[i].value;
            }
        }
    }
    return {
        min: min,
        max: max
    };
};

var patient_ids = [];
var myRightArmEncounters = db.encounters.find(
    {
        "observations.name": {$in: [5695930304]}, 
        "observations.name_type": 1
    }, {
        _id: true,
        "observations.value": true,
        "observations.name": true,
        patient_id: true,
        date: true
    }
).toArray();

for (var i = 0; i < myRightArmEncounters.length; i++) {
 //query for all left arm encounters that have the same patient for a right arm encounter and a value difference of +-10  
    var minMaxObservation, minObservationValue, maxObservationValue;

    minMaxObservation = findMinMaxObservation(myRightArmEncounters[i].observations);
    minObservationValue = minMaxObservation.min;
    maxObservationValue = minMaxObservation.max;
    var myLeftArmEncounters = db.encounters.find(
        { $and: [
            {
                "observations.name": {$in: [5695930310]}, 
                "observations.name_type": 1, 
                patient_id: myRightArmEncounters[i].patient_id,
                date: myRightArmEncounters[i].date
            }, 
            { $or: [
                    {"observations.value": { $gt: maxObservationValue+10}}, 
                    {"observations.value": { $lt: minObservationValue-10}}
            ]}
        ]}, 
    {patient_id: true}).toArray();

    myLeftArmEncounters.forEach(function(obj) { patient_ids.push(obj.patient_id); });
}

print(
getUnique(patient_ids).length);



 