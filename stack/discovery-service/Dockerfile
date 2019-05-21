FROM gradle:jdk12 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:12-jre-slim
EXPOSE 8761
COPY --from=builder /home/gradle/src/discovery-service/build/distributions/easytext.web.tar /app/
WORKDIR /app
RUN tar -xvf easytext.web.tar
WORKDIR /app/easytext.web
CMD bin/easytext.web