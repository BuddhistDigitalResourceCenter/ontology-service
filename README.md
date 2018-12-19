# BDRC Ontology Service 

How to start the BDRC Ontology Service application:

Download the latest relase, unzip and run:

    java -jar ontology-service-0.0.4-SNAPSHOT.jar server config.yml

or `git clone` the repository and:

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/ontology-service-0.0.4-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:18080/ontology`
