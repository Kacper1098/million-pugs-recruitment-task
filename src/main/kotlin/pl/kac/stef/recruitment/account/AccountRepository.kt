package pl.kac.stef.recruitment.account

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>{
}