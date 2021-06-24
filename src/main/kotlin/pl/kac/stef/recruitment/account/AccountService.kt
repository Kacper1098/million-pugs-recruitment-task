package pl.kac.stef.recruitment.account

import org.springframework.stereotype.Service
import pl.kac.stef.recruitment.npb.Currency
import pl.kac.stef.recruitment.npb.CurrencyCode
import pl.kac.stef.recruitment.npb.NbpFeignClient
import pl.kac.stef.recruitment.npb.Rate
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Comparator
import java.util.stream.Collectors
import javax.persistence.EntityNotFoundException

@Service
class AccountService(val repository: AccountRepository, val mapper: AccountMapper, val nbpFeignClient: NbpFeignClient) {
    fun findById(id: Long): AccountDTO {
        var account: Account = repository
                .findById(id)
                .orElseThrow {EntityNotFoundException("Account with id $id could not be found")}
        return mapper.toDto(account, mapPLNtoUSDBalance(account.balance));
    }

    fun saveOne(dto: AccountDTO): Long? {
        return repository.save(mapper.toEntity(dto)).id
    }

    fun getAll(): List<AccountDTO> {
        return repository.findAll()
                .stream()
                .map { account -> mapper.toDto(account, mapPLNtoUSDBalance(account.balance)) }
                .collect(Collectors.toList())
    }

    fun mapPLNtoUSDBalance(plnBalance: BigDecimal): BigDecimal {
        var usdCurrency: Currency = nbpFeignClient.getCurrencyRate("A", CurrencyCode.USD.name)
        return plnBalance.divide(getMostProfitableRate(usdCurrency).mid, 2, RoundingMode.HALF_EVEN)
    }

    fun getMostProfitableRate(currency: Currency): Rate {
        return currency.rates.stream().min(Comparator.comparing { rate -> rate.mid }).get();
    }
}