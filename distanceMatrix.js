function initMap() {

    var service = new google.maps.DistanceMatrixService();
    service.getDistanceMatrix(
        {
            origins: ['Amsterdam', 'Venlo', 'Utretch', 'Gouda'],
            destinations: ['Amsterdam', 'Venlo', 'Utretch', 'Gouda'],
            travelMode: 'DRIVING',
            unitSystem: google.maps.UnitSystem.METRIC,
            avoidHighways: false,
            avoidTolls: false,
        }, callback);

    function callback(response, status) {
        // See Parsing the Results for
        // the basics of a callback function.
        if (status == 'OK') {
            var origins = response.originAddresses;
            var destinations = response.destinationAddresses;

            for (var i = 0; i < origins.length; i++) {
                var results = response.rows[i].elements;

                for (var j = 0; j < results.length; j++) {
                    var element = results[j];
                    var distance = element.distance.text;
                    var duration = element.duration.text;
                    var from = origins[i];
                    var to = destinations[j];

                    console.log("Total Distance: " + distance + ", Total Durations: " + duration + ", From: " + from + " to " + to);
                }


            }

        }
    }


}
