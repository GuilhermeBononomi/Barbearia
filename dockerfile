FROM openjdk:24-jdk
WORKDIR /user/local/app
COPY . .
EXPOSE 3333
CMD ["java", "-cp", "/bin", "App"]