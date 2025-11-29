# Build stage
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu AS build
ENV JAR_FILE=produto-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
COPY mvnw* /app/
COPY .mvn /app/.mvn
COPY pom.xml /app
COPY ./src /app/src
RUN ls -la /app
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -B -Dproduction package -DskipTests

# Runtime stage
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu
COPY --from=build /app/target/produto-api-0.0.1-SNAPSHOT.jar /usr/src/myapp/
ENV DB_HOST=host.docker.internal
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "/usr/src/myapp/produto-api-0.0.1-SNAPSHOT.jar"]