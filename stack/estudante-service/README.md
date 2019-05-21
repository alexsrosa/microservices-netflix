**Help docker with gradle**
Link:
https://medium.com/@hudsonmendes/docker-spring-boot-microservice-with-gradle-9785087e7992

Criar imagem e efetuar pull para docker hub:
```
gradle build distDocker --refresh-dependencies
```
Criar imange sem enviar para o docker hub
Criar build passando argumento build arg:
```
docker build --build-arg build/libs/*.jar -t fundacred/estudante-service .

```
Checar imagens criadas:
```
docker images
```
Rodar a image:
```
docker run -p 8080:8080 fundacred/estudante-service
```


# Acessa ao Swagger do serviço de estudante
http://localhost:9090/api/estudante-service/swagger-ui.html

Json para importação no postman:

http://localhost:9090/api/estudante-service/v2/api-docs 