package br.com.marlonprado.ynab_clone_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.marlonprado.ynab_clone_api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
