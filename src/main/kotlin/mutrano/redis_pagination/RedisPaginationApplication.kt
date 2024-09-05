package mutrano.redis_pagination

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisPaginationApplication

fun main(args: Array<String>) {
	runApplication<RedisPaginationApplication>(*args)
}
