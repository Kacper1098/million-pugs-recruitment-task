package pl.kac.stef.recruitment.account

import pl.kac.stef.recruitment.npb.CurrencyCode
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val balance: BigDecimal,
        @Enumerated(value = EnumType.STRING)
        val currency: CurrencyCode
)