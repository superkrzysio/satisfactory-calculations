# Satisfactory calculator

Simple tool to calculate required intermediate production rates in Satisfactory
game based on requested output rate.

Can be also used for Factorio rates, just requires another data sheet similar 
to the already existing [items.yaml](src/main/resources/items.yaml)  

### How to use

Requires Maven and Java 11.

```shell
mvn spring-boot:run
```

Open http://localhost:8080/

### Maintenance

I am going to add more items as I progress in game ;)
Currently there are only early-mid game items configured.

I know there are dozens of similar tools and webpages
but it's rather a weekend project for the fun of programming. 
Currently I don't need any more features. 
