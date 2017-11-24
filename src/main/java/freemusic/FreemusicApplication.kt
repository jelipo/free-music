package freemusic

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class FreemusicApplication

fun main(args: Array<String>) {
    SpringApplication.run(FreemusicApplication::class.java, *args)
}
