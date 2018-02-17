docker build -t jozimar/core-singleton ./core-singleton
docker run -p 8080:8080 -p 3700:3700 -d --name core-singleton jozimar/core-singleton
docker build -t jozimar/web-singleton ./web-singleton
docker run -p 8081:8080 -d --name web-singleton --link core-singleton:host-core jozimar/web-singleton
docker build -t jozimar/jsf-singleton ./jsf-singleton
docker run -p 8082:8080 -d --name jsf-singleton --link core-singleton:host-core jozimar/jsf-singleton





