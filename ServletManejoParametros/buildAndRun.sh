#!/bin/sh
mvn clean package && docker build -t com.mycompany/ServletManejoParametros .
docker rm -f ServletManejoParametros || true && docker run -d -p 9080:9080 -p 9443:9443 --name ServletManejoParametros com.mycompany/ServletManejoParametros