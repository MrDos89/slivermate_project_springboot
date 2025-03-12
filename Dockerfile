# 1. 베이스 이미지 선정
FROM eclipse-temurin:17-jdk

# 2. 작업 디렉터리 생성
WORKDIR /app

# 3. jar 파일을 컨터이너로 복사
ARG JAR_FILE=target/hbgogumaserver.jar
COPY ${JAR_FILE} .

# 4. 환경 변수 개방
ENV SPRING_DATASOURCE_URL=jdbc:mysql://192.168.0.61:3306/webdb

# 5. 포트 노출 
EXPOSE 8090

# 6. 컨테이너가 실행될 때 JAR를 실행
ENTRYPOINT ["java", "-jar", "/app/hbgogumaserver.jar"]

# build
# docker build -t hbgogumaserver .

# run
# mysql-container 먼저 실행
# docker run -d -p 18090:8090 --name hbgogumaserver -e SPRING_DATASOURCE_URL=jdbc:mysql://192.168.0.61:3306/webdb --network my-network hbgogumaserver
