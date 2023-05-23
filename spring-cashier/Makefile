all: clean

clean:
	mvn clean

compile:
	mvn compile

run: compile
	mvn spring-boot:run

build:
	mvn package

run-jar: build
	java -jar ./anjana/CMPE172/spring-cashier-1.0.jar

# Jumpbox

jumpbox:
	docker run --platform=linux/arm64/v8 --network cashier --name jumpbox -t -d ubuntu

jumpbox-shell:
	docker exec -it jumpbox bash


# Docker

docker-build: build
	docker build --platform=linux/amd64 -t spring-cashier .
	docker images

cashier-network:
	docker network create --driver bridge cashier

docker-run: docker-build
	docker run --platform=linux/amd64 --network cashier -e "MYSQL_HOST=mysql" --name spring-cashier -td -p 8080:8080 spring-cashier

docker-clean:
	docker stop spring-cashier
	docker rm spring-cashier
	docker rmi spring-cashier

docker-shell:
	docker exec -it spring-cashier bash


# Compose

network-ls:
	docker network ls

network-create:
	docker network create --driver bridge $(network)

network-prune:
	docker network prune

compose-up:
	docker-compose up --scale cashier=2 -d

lb-up:
	docker-compose up -d lb

cashier-up:
	docker-compose up -d cashier

redis-up:
	docker-compose up -d redis

mysql-up:
	docker-compose up -d mysql

compose-down:
	docker-compose down

lb-stats:
	echo "user = admin | password = admin"
	open http://localhost:1936

lb-test:
	open http://localhost
