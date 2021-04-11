#  Zian platform project
해당 프로젝트는 zian platform project로 추후, zian에서 발생하는 project의 기반이 될 것이다.

### Skill
* spring boot
* spring mvc
* spring data jpa
* querydsl
* mapstruct
* gradle project

### Server dependency
* postgresql

## Zian Repository 구성

```sh
├─zian platform
   │  README.md
   ├─http (Rest api test 파일)
   │  
   ├─docker
   │    docker-compose.yml  (local 구성 docker compose 파일 - postgresql)
   │
   ├─src/main/java
   │   │  ZianPlatformApplication
   │   ├─ com/zian/platform (허브컨트롤룸)
   │   │   │
   │   │   ├─ common (공통모듈)
   │   │   │
   │   │   ├─ config (프로젝트 java config)
   │   │   │  jpa, mastruct, message, webmvc java config
   │   │   │
   │   │   ├─ exception
   │   │   │
   │   │   ├─ controller 
   │   │   │  └─ advice (controller advice)
   │   │   │  └─ v1 (v1 controller)
   │   │   │  
   │   │   ├─ model 
   │   │   │  └─ dto
   │   │   │  └─ entity (jpa entity)
   │   │   │  └─ mapper (mapstruct mapper)
   │   │   │
   │   │   ├─ repository (jpa repository)
   │   │   │
   │   │   └─ service
   │   │    
   │   └─src/main/resources
   │       │ └─ i18n (i18n error message yaml)
   │       │ └─ templates (thymleaf html)
   │       │
   │       └─ appliation.yml, application-localhost.yml, application-develop.yml, application-staging.yml, application-producton.yml
   │      
   └─src/test/main       
       │    
       └─src/test/resources  
```

## Documentation
> 추후, 작성필요

## Requirements and Downloads

### JDK 설치
- [JDK11 amazon correto](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)

### git 설치
```
brew install git
```

### gradle  설치
```
brew install gradle
```

### Docker 설치 (도커 버전 확인 필요)

- [설치파일 Download](https://download.docker.com/mac/stable/31259/Docker.dmg)

### docker-compose설치

```bash
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

### docker 설치 확인
```bash
docker version
docker-compose version
```

## Running Zian Platform

### docker-compose local setting (postgresql 설치)
```bash
docker-compose -f ./docker/docker-compose.yml up -d
``` 

### docker-compose run check
```bash
 docker-compose -f ./docker/docker-compose.yml  ps
     Name                    Command               State                     Ports                   
-----------------------------------------------------------------------------------------------------                   
zian-postgres      docker-entrypoint.sh postgres    Up      0.0.0.0:5432->5432/tcp
```

