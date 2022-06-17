package com.example.reposirory.customer;

import com.example.dto.CustomerUsingNow;
import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String searchName, String searchAddress, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId(String searchName, String searchAddress, int searchCategory, Pageable pageable);

    @Query (value = "select * from customer_service_now",
            countQuery = "select * from customer_service_now",
            nativeQuery = true)
    Page<CustomerUsingNow> get(Pageable pageable);


//    @Query(value = "update customer set flag = 0 where customer_id = ?", nativeQuery = true)
//    void updateFlag(int id);

}