package org.icadev.accounts.service.impl;

import lombok.RequiredArgsConstructor;
import org.icadev.accounts.dto.CustomerDto;
import org.icadev.accounts.repository.AccountsRepository;
import org.icadev.accounts.repository.CustomerRepository;
import org.icadev.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - Customer DTO object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
