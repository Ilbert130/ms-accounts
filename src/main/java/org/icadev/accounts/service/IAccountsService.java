package org.icadev.accounts.service;

import org.icadev.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - Customer DTO object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Customer mobile number
     * @return - Customer DTO object
     */
    CustomerDto fetchAccount(String mobileNumber);
}
