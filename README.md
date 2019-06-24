##This repo contains the source code of a Twitter Message Broker application.

The back-end was written using Java with Spring Boot.

### Running the Application
 
First create a docker network:
 
  ```bash
 $ docker network create twitter
  ```
  
Then check if was successfully created:
 
  ```bash
 $ docker network ls
  ```
  
Download Redis image

 ```bash
$ docker pull redis:4.0.9-alpine
 ``` 

Then check if was successfully downloaded:
 
  ```bash
 $ docker images
  ```
 
 Run the container:
 
  ```bash
 $ docker run -d --name redis --net twitter -p 6379:6379 redis:4.0.9-alpine
  ```

### Install the Windows Subsystem for Linux to install redis-cli on it.

Open PowerShell as Administrator and run:

  ```bash
 $ Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux
  ```

Restart your computer when prompted.

### Install your Linux Distribution of Choice

Install Ubuntu 18.04 from [Microsoft Store](https://www.microsoft.com/store/apps/9N9TNGVNDL3Q) or from the [command-line](https://docs.microsoft.com/en-us/windows/wsl/install-manual).

### Install redis-cli

Download and install using WSL

 ```bash
 $ sudo apt install redis-tools -y
  ```

Connect with the server. First discover docker machine ip:

```bash
 $ docker-machine ip
  ```
 
Then connect: 
 
 ```bash
 $ redis-cli -h _MACHINE_IP_
  ```

In the src/main/resources directory you can find a file called ```application.yaml```.

Open this file and enter your Redis server host and port string as directed in the comment. This is the information the driver will use to connect.

```yml
host: 192.168.99.100
port: 6379
```

Run the application with maven:

```bash
$ mvn spring-boot:run
```

Create the docker image

```bash
$ mvn clean install docker:build
```

Check for image:

```bash
$ docker images
```

Run the container

```bash
$ docker run -d --name tracked-hashtag --net twitter -p 9090:9090 filipebezerra/tracked-hashtag
```

Now we can test the API using Postman or curl.

Using curl to POST something:

```bash
$ curl -H "Content-Type: application/json" -X POST -d '{"hashTag": "go", "queue": "go"}' http://_MACHINE_IP_:9090/api/tracked-hash-tag
```

Using curl and jq to GET something:

```bash
$ curl http://_MACHINE_IP_:9090/api/tracked-hash-tag | jq '.'
```