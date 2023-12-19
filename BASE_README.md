# Getting Started
Two separate spring boot application which run as producer and consumer to exchange messages using Kafka.

# Getting Started

In order to run application locally you have to create '.env' file in the root of project
and put variable:
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
KAFKA_SUBSCRIBER_TOPICS=data-temperature,data-power,data-voltage

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