package pl.kac.stef.recruitment.npb

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "nbp", url = "\${feignclient.npb.url}")
interface NbpFeignClient {
    @GetMapping("exchangerates/rates/{table}/{code}")
    fun getCurrencyRate(@PathVariable("table")table: String, @PathVariable("code") code: String): Currency
}