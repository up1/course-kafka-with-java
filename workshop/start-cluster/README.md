# Create Kafka Cluster
* [Step from official website](https://kafka.apache.org/quickstart)
* Working with Docker
  * [Image from confluentinc](https://hub.docker.com/u/confluentinc)

## Working with Docker

Create Kafka cluster
* Zookeeper
* Kafka
```
$docker compose up -d zookeeper
$docker compose up -d kafka
```

See status
```
$docker compose ps

NAME                COMMAND                  SERVICE             STATUS              PORTS
kafka               "/etc/confluent/dock…"   kafka               running             0.0.0.0:9092->9092/tcp, 0.0.0.0:9999->9999/tcp
zookeeper           "/etc/confluent/dock…"   zookeeper           running             0.0.0.0:2181->2181/tcp
```

Other tools
```
$docker compose up -d schema-registry
$docker compose up -d kafka-manager
$docker compose up -d kafkacat
```

List of URLs
* Schema Registry => http://localhost:8081
* Kafka Manager => http://localhost:9000