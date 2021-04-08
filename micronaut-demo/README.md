# Quickstart
1. Run`docker-compose -f docker-compose.yml`
2. Run `./gradlew run` or run `Application.kt` from IDE
3. Test it by running:
```shell
curl -X POST -w '\nTime connect: %{time_connect}s \nTime starttransfer: %{time_starttransfer}s \nTotal: %{time_total}s' http://localhost:8080/users
```

4. Test it against K8s cluster:
```shell
curl -k -X POST -w '\nTime connect: %{time_connect}s \nTime starttransfer: %{time_starttransfer}s \nTotal: %{time_total}s' https://wdi-micronaut-demo.stepwise.dev/users
```

# Build Native Image
Run:  
```shell
./gradlew dockerBuildNative
```

