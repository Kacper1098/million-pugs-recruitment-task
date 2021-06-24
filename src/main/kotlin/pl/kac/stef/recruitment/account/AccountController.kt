package pl.kac.stef.recruitment.account

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("account")
class AccountController(val service: AccountService) {

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long): AccountDTO {
        return service.findById(id)
    }

    @PostMapping
    fun saveOne(@RequestBody dto: AccountDTO): Long? {
        return service.saveOne(dto)
    }

    @GetMapping
    fun getAll(): List<AccountDTO> {
        return service.getAll()
    }
}