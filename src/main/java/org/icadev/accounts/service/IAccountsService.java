package org.icadev.accounts.service;

import org.icadev.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - Customer DTO object
     */
    void createAccount(CustomerDto customerDto);
}
