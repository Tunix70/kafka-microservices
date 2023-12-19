# Getting Started
Data generator microservice to send data to Kafka topics

## Samples of bodies' requests

* localhost:8081/api/v1/data/send

{
"sensorId": 777,
"timestamp": "2023-09-13T12:12:05",
"measurement": 17.5,
"measurementType": "TEMPERATURE"
}

* localhost:8081/api/v1/data/test/send

{
"delaySeconds" : 3,
"measurementTypes" : [
"POWER",
"VOLTAGE",
"TEMPERATURE"
]
}

