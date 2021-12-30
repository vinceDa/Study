package com.ohyoung.demo.ywy;

import org.junit.jupiter.api.Test;

import java.util.UUID;

class CustomerAssemblerTest {

    @Test
    public void test() {
        CustomerSaveCommand saveCommand = new CustomerSaveCommand();
        saveCommand.setCustomerGUID(UUID.randomUUID());
        saveCommand.setMobile(new Mobile("13713729067"));
        CustomerAssembler instance = CustomerAssembler.INSTANCE;
        Customer customer = instance.toEntity(saveCommand);
        Mobile mobile = customer.getMobile();

        System.out.println(customer);
    }

}