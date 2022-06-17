package com.example.reposirory.contract;

import com.example.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {

//    AttachService findAttachServiceByAttachServiceId

    AttachService findByAttachServiceId(int id);
}
