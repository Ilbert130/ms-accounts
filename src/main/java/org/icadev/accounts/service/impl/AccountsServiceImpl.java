package org.icadev.accounts.service.impl;

import lombok.RequiredArgsConstructor;
import org.icadev.accounts.constants.AccountsConstants;
import org.icadev.accounts.dto.CustomerDto;
import org.icadev.accounts.entity.Accounts;
import org.icadev.accounts.entity.Customer;
import org.icadev.accounts.entity.exception.CustomerAlreadyExistsException;
import org.icadev.accounts.mapper.CustomerMapper;
import org.icadev.accounts.repository.AccountsRepository;
import org.icadev.accounts.repository.CustomerRepository;
import org.icadev.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

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
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with mobile number: " + customerDto.getMobileNumber());
        }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        customer.setUpdatedAt(LocalDateTime.now());
        customer.setUpdatedBy("Anonymous");
        Customer saveCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(saveCustomer));
    }

    /**
     * Creates a new account for the customer
     * @param customer - Customer object
     * @return - Newly created account object
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        newAccount.setUpdatedAt(LocalDateTime.now());
        newAccount.setUpdatedBy("Anonymous");
        return accountsRepository.save(newAccount);
    }

    /**
     *
     * @param mobileNumber - Customer mobile number
     * @return - Customer DTO object
     */
    @Override
    public CustomerDto fetchCustomer(String mobileNumber) {
        return null;
    }
}
