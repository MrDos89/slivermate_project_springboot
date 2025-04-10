#!주의) 빌드 도커 배포용 코드 + mac 용이니 실행 하지 마세요.
#!/bin/bash

# 에러 발생 시 스크립트 중단
set -e 

# Maven 빌드
echo "Running Maven build..."
mvn clean package || { echo "Maven build failed"; exit 1; }

docker rmi -f mrdos89/slivermateserver:latest
docker rmi -f $(docker images -f "dangling=true" -q)

docker build --platform linux/amd64 -t slivermateserver .

docker tag slivermateserver mrdos89/slivermateserver

# docker에서 push 올림
docker push mrdos89/slivermateserver