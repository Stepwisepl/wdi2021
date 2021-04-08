# Quickstart
1. Run`docker-compose -f docker-compose.yml`
2. Run `./gradlew bootRun` or run `SpringDemoApplication.kt` from IDE
3. Test it by running:
```shell
curl -X POST -w '\nTime connect: %{time_connect}s \nTime starttransfer: %{time_starttransfer}s \nTotal: %{time_total}s' http://localhost:8080/users

```
