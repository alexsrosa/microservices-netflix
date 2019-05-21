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
docker build --build-arg build/libs/*.jar -t fundacred/zuul-service .

```
Checar imagens criadas:
```
docker images
```
Rodar a image:
```
docker run -p 8080:8080 fundacred/zuul-service
```


