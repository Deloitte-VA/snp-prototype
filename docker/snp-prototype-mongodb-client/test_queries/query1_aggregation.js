print(
db.encounters.aggregate([
    {
        $match: {
            "observations.name": {$in: [5695930304, 5695930310]},
            "observations.name_type": 1,
            "observations.value": {$gt: 140}    
        }
    },
    {
        $group: {
            _id: "$patient_id",
            patientsum: { $sum: 1 }
        }
    },
    {
        $group: {
            _id: 1,
            sum: { $sum: 1 }
        }
    }
]).next().sum);