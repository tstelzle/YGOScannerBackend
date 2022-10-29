FROM ubuntu:latest

RUN apt update -y
RUN apt upgrade -y
RUN apt autoremove -y

RUN apt install tesseract-ocr -y
RUN apt install tesseract-ocr-all -y

RUN apt install java-common -y

RUN apt install wget -y

RUN wget https://corretto.aws/downloads/latest/amazon-corretto-19-x64-linux-jdk.deb -O corretto19.deb

RUN dpkg --install corretto19.deb

COPY ./target/*.jar ./ygoscannerbackend.jar

EXPOSE 8080

CMD java -jar ygoscannerbackend.jar