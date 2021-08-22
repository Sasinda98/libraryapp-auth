FROM openjdk:11
COPY /build/libs/libraryapp-auth-*-SNAPSHOT.jar /app/libauth.jar
WORKDIR /app
CMD java -jar libauth.jar
EXPOSE 8080