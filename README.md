# Infrastructure Automation
[WIP]

## How to run all things

### Before you start
* Install docker and docker compose

### Production
In production mode, all images will be pulled from docker hub. 
```bash
docker-compose up -d
```


### Development 
For development mode, all source code will be compiled and packaged as a jar. These jar files will be used later for 
creating the image for every service. To build, use this command:
```$xslt
docker-compose -f "docker/docker-movies-board/docker-compose.yml" up 
```

### Important Endpoint *
* [http://localhost:8762](http://localhost:8762) - Gateway
* [http://localhost:8761](http://localhost:8761) - Eureka Dashboard
* [http://localhost:5000](http://localhost:5000) - Movies service: /movies using Zuul gateway 
* [http://localhost:5001](http://localhost:5001) - Actors service: /actors using Zuul gateway 
* [http://localhost:5005](http://localhost:5005) - Rating service
* [http://localhost:3005](http://localhost:3005) - Payment service
* [http://localhost:5006](http://localhost:5006) - Booking service