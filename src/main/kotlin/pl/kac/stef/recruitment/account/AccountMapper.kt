package pl.kac.stef.recruitment.account

import org.springframework.stereotype.Component
import pl.kac.stef.recruitment.npb.CurrencyCode
import java.math.BigDecimal
import java.util.*

@Component
class AccountMapper(val repository: AccountRepository) {
    fun toEntity(dto: AccountDTO): Account {
        return Optional.ofNullable(dto.id)
                .flatMap { id -> repository.findById(id) }
                .orElseGet { Account(id = dto.id, balance = dto.balance, currency = CurrencyCode.valueOf(dto.currency)) }
    }

    fun toDto(entity: Account, usdBalance: BigDecimal): AccountDTO {
        return AccountDTO(id = entity.id, balance = usdBalance, currency = CurrencyCode.USD.name)
    }
}