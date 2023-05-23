clean: docker-build
	
docker-clean:
	docker stop redis
	docker rm redis
	docker rmi redis

docker-build: 
	docker build --platform=linux/arm64/v8 -t redis .
	docker images

redis-local:
	docker run --platform=linux/arm64/v8 --name redis --network cashier -td -p 6379:6379 redis

redis-official:
	docker run --platform=linux/arm64/v8 --name redis-official --network cashier -td -p 6379:6379 redis:4.0


