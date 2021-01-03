## Important Kafka Commands

## To list all the topics in kafka running as docker image

docker exec kafka kafka-topics --list --zookeeper zookeeper:2181

## TO Delete a topic in kafka running as docker image

docker exec kafka kafka-topics --delete --zookeeper zookeeper:2181 --topic supplyLoan-out-0

## To Remove all the messages from the topic

docker exec kafka kafka-configs --zookeeper zookeeper:2181 --entity-type topics --alter --add-config retention.ms=1000 --entity-name output

## To restore the setting after deleting messages

docker exec kafka kafka-configs --zookeeper zookeeper:2181 --alter --entity-type topics --entity-name output --delete-config retention.ms