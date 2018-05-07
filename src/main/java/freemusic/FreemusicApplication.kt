package freemusic

import okhttp3.OkHttpClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class FreemusicApplication {
    @Bean
    fun okHttpClient(): OkHttpClient = OkHttpClient()
}

fun main(args: Array<String>) {
    runApplication<FreemusicApplication>(*args)
}
