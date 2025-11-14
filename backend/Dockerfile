# 1. 베이스 이미지 설정
FROM gradle:9.2-jdk17

# 2. 작업 디렉토리 설정
WORKDIR /app

COPY . /app

EXPOSE 8080

# 5. 컨테이너 시작 시 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]