package pl.kac.stef.recruitment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class RecruitmentApplication

fun main(args: Array<String>) {
	runApplication<RecruitmentApplication>(*args)
}
