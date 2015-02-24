print(

db.runCommand(
    {
        distinct: "encounters",
        key: "patient_id", 
        query: { 
            "observations.name": {$in: [5695930304, 5695930310]}, 
            "observations.name_type": 1, 
            "observations.value": {$gt: 140}
        }
    }
).values.length);




