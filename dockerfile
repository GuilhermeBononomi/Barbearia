FROM openjdk:24-jdk
WORKDIR /user/local/app
COPY bin/ /app/
EXPOSE 3333
CMD ["java", "-cp", "/app", "App"]