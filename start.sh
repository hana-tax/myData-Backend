#!/usr/bin/env bash

# 경로 설정
PROJECT_ROOT="/home/ubuntu/myData-Backend"  # 배포할 프로젝트 루트 경로
JAR_FILE="$PROJECT_ROOT/spring-webapp.jar"  # 실행할 JAR 파일 경로

# 로그 파일 경로 설정
APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

# 현재 시간
TIME_NOW=$(date +%c)

# 이전 실행 중인 애플리케이션 종료
echo "$TIME_NOW > 기존 실행 중인 애플리케이션 종료 시도" >> $DEPLOY_LOG
CURRENT_PID=$(pgrep -fl $JAR_FILE | grep java | awk '{print $1}')

if [ -z "$CURRENT_PID" ]; then
    echo "$TIME_NOW > 현재 실행 중인 애플리케이션이 없습니다." >> $DEPLOY_LOG
else
    echo "$TIME_NOW > 실행 중인 프로세스 $CURRENT_PID 종료" >> $DEPLOY_LOG
    kill -15 "$CURRENT_PID"
    sleep 5
fi

# 새로운 빌드 파일 복사
echo "$TIME_NOW > 새로운 빌드 파일 복사 시도" >> $DEPLOY_LOG
if [ -f "$PROJECT_ROOT/build/libs/mydata-0.0.1-SNAPSHOT.jar" ]; then
    echo "$TIME_NOW > 빌드 파일이 발견되었습니다." >> $DEPLOY_LOG
    cp $PROJECT_ROOT/build/libs/mydata-0.0.1-SNAPSHOT.jar $JAR_FILE
else
    echo "$TIME_NOW > 빌드 파일이 없습니다. 배포를 중지합니다." >> $DEPLOY_LOG
    exit 1
fi

# 새로운 애플리케이션 실행
echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
nohup java -jar $JAR_FILE --spring.profiles.active=prod > $APP_LOG 2> $ERROR_LOG &

# 실행된 애플리케이션 PID 확인
CURRENT_PID=$(pgrep -fl $JAR_FILE | grep java | awk '{print $1}')
echo "$TIME_NOW > 새로 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG
