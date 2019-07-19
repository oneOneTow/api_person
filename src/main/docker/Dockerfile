FROM java:8
VOLUME /temp/
ADD api_person-1.0-SNAPSHOT.jar /docker_data/api_person.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/api_person.jar"]
