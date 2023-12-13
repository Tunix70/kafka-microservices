# Getting Started
Two separate spring boot application which run as producer and consumer to exchange messages using Kafka.

# Getting Started

In order to run application locally you have to create '.env' file in the root of project
and put variable:
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
KAFKA_SUBSCRIBER_TOPICS=data-temperature,data-power,data-voltage