# Getting Started
Data generator microservice to send data to Kafka topics

### Requirements
Install and setup kafka zookeeper locally
Install and setup kafka server locally
https://kafka.apache.org/quickstart

## Commands to run kafka (windows)
(run them from installed kafka folder)
* bin\windows\zookeeper-server-start.bat config\zookeeper.properties
* bin\windows\kafka-server-start.bat config\server.properties

## to view Kafka messages
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic data-temperature --from-beginning   

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

