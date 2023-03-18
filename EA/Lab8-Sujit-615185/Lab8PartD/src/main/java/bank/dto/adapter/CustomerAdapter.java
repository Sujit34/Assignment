package bank.dto.adapter;

import bank.domain.Customer;
import bank.dto.CustomerDto;

public class CustomerAdapter {

    public static CustomerDto convertCustomerToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        //customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        return customerDto;
    }

    public static Customer convertCustomerDtoToCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        //customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        return customer;
    }
}
