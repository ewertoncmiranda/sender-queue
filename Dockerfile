FROM openjdk:11
ARG JAR_FILE
VOLUME /tmp
EXPOSE 8080
COPY ./target/${JAR_FILE} app.jar
ADD ./target/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar" , "app.jar"]



