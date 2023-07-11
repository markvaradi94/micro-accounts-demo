FROM eclipse-temurin:17-jammy

COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

WORKDIR /app

COPY target/micro-accounts.jar /app/micro-accounts.jar

EXPOSE 9091

CMD /wait-for-it.sh config-server:8071 -- java -jar /app/micro-accounts.jar
