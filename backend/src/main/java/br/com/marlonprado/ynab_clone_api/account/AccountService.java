package br.com.marlonprado.ynab_clone_api.account;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public AccountEntity save(AccountDTO accountDTO) {
        AccountEntity account = new AccountEntity();
        modelMapper.map(accountDTO, account);

        //TODO Confirmar se essa validação faz sentido, considerandoq ue o modelMapper já faz a conversão e validação
        account.setBalanceDate(accountDTO.getBalanceDate() != null ? accountDTO.getBalanceDate() : LocalDateTime.now());
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        return accountRepository.save(account);

    }

    public List<AccountDTO> list() {
        List<AccountEntity> accountsList = accountRepository.findAll();
        return accountsList.stream()
                .map(AccountDTO::fromEntity)
                .toList();
    }

    public Optional<AccountDTO> findById(Long id) {
        Optional<AccountEntity> account = accountRepository.findById(id);
        return account.map(AccountDTO::fromEntity);
    }

    public Optional<AccountDTO> update(Long id, AccountDTO accountDTO) {
        return accountRepository.findById(id)
                .map(account -> {
                    modelMapper.map(accountDTO, account);
                    account.setUpdatedAt(LocalDateTime.now());

                    //TODO Confirmar se essa validação faz sentido, considerandoq ue o modelMapper já faz a conversão e validação
                    account.setBalanceDate(accountDTO.getBalanceDate() != null ? accountDTO.getBalanceDate() : LocalDateTime.now());
                    AccountEntity updated = accountRepository.save(account);
                    return AccountDTO.fromEntity(updated);
                });
    }

    public boolean delete(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
