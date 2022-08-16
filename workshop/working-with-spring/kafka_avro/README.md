## Step to run

### 1. Config file `pom.xml`

Add dependency of `kafka-avro-serializer`
```
<dependencies>
    <dependency>
        <groupId>io.confluent</groupId>
        <artifactId>kafka-avro-serializer</artifactId>
        <version>5.5.0</version>
    </dependency>
</dependencies>


<repositories>
    <!-- Confluent maven repo, required to Confluent Kafka Avro Dependencies -->
    <repository>
        <id>confluent</id>
        <url>https://packages.confluent.io/maven/</url>
    </repository>
</repositories>
```

Add plugin to generate Java Class from Avro
```
<plugin>
    <groupId>org.apache.avro</groupId>
    <artifactId>avro-maven-plugin</artifactId>
    <version>1.8.2</version>
    <executions>
        <execution>
            <id>schemas</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>schema</goal>
                <goal>protocol</goal>
                <goal>idl-protocol</goal>
            </goals>
            <configuration>
                <sourceDirectory>${project.basedir}/src/main/resources/avro/</sourceDirectory>
                <outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
            </configuration>
        </execution>
    </executions>
</plugin>
```


### 2. Gennerate Java class from schema
```
$./mvnw generate-sources
$./mvnw spring-boot:run
```

### 3. List all subjects from the Schema Register

```
$http -v :8081/subjects
```

### 4. Manage the Schema Register

Create a new subject
```
$http -v POST :8081/subjects/NewUser/versions \
  Accept:application/vnd.schemaregistry.v1+json \
  schema=@src/main/resources/avro/newuser-v1.avsc
```

List all subjects
```
$http -v :8081/subjects
```

Delete subjects
```
$http -v DELETE :8081/subjects/NewUser
```