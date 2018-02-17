docker stop core-singleton
docker rm core-singleton
docker stop web-singleton
docker rm web-singleton
docker stop jsf-singleton
docker rm jsf-singleton
docker rmi -f jozimar/core-singleton
docker rmi -f jozimar/web-singleton
docker rmi -f jozimar/jsf-singleton
