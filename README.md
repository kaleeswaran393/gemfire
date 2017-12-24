# Spring Boot Gemfire (server side Cache)

This spring boot application act as a client and cache the data and stores it at server side 

## Steps to install gemfire server on your local machine
1. https://gemfire.docs.pivotal.io/gemfire/getting_started/installation/install_brew.html

2.enter gfsh


kaleeswarans-MacBook-Pro:~ kaleeswarankaruppusamy$ gfsh

    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    9.2.0


Monitor and Manage Pivotal GemFire
gfsh>

###Command to Start Locator

gfsh>start locator —-name=locator --port=10336 --bind-address=localhost --hostname-for-clients=localhost 

###Start Server

gfsh>start server --hostname-for-clients=localhost --bind-address=localhost --name=server1 --server-port=40408

###create Region
We have to create Region to store our entity, we have to create region in gemfire for each entity.
In the example Peron and address entity are used. so we have to create region for that

gfsh>create region --name=Person --type=REPLICATE
gfsh>create region --name=Address --type=REPLICATE

###Deploy Jar

gfsh>deploy --jar=<PROJECT PATH>gemfire/target/gemfire-poc-client-0.1.0-domain.ja

###Query

gfsh>query --query="select * from /Person"


##Start spring boot application

Store spring boot application and store data into gemfire cluster server

###Request :

http://localhost:4040/person

{
	"id":1,
	"firstName": "kaleeswara",
	"lastName":"karuppusamy"
}



localhost:4040/address

{
	"id":1,
	"address": "YISHUN",
	"postal":"760110"
}




