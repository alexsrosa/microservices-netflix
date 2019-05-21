FROM openjdk:10
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY ./build/libs/*.jar ./app.jar
EXPOSE 9090
CMD ["java","-jar","app.jar"]