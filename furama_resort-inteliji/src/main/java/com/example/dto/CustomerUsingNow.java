package com.example.dto;

public interface CustomerUsingNow {

    Integer getContractId();
    String getCustomerName();
    String getServiceName();
    String getDescriptionOtherConvenience();
    String getServiceCost();
    String getAttachServiceName();
    String getTotalQuantity();
    String getTotalMoney();
}

//        select contract.contract_id, customer.customer_name, service.service_name, service.description_other_convenience, service.service_cost,
//        group_concat(attach_service.attach_service_name) as attach_service_name, sum(contract_detail.quantity) as total_quantity, if (contract_detail.quantity is null, service.service_cost, service.service_cost + sum((contract_detail.quantity * attach_service.attach_service_cost))) as total_money
//        from customer
//        inner join contract on customer.customer_id = contract.customer_id
//        inner join service on contract.service_id = service.service_id
//        left join contract_detail on contract.contract_id = contract_detail.contract_id
//        left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id
//        where now() between contract.contract_start_date and contract.contract_end_date
//        group by contract.contract_id;