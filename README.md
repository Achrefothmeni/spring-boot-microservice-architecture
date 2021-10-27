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
docker-compose -f "docker/docker-movies-board-gateway-v2/docker-compose.yml" up 
```

### Important Endpoint *
* [http://discovery:8762](http://discovery:8762) - Gateway
* [http://discovery:8761](http://discovery:8761) - Eureka Dashboard