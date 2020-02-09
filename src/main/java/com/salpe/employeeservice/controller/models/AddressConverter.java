package com.salpe.employeeservice.controller.models;

import com.salpe.employeeservice.repository.nosql.cassandra.salpe.AddressDAO;
import org.springframework.stereotype.Service;

@Service
public class AddressConverter {

    Address toApiModel(AddressDAO repoAddress) {
        return Address.builder().
                lines(repoAddress.getLines()).
                city(repoAddress.getCity()).
                state(repoAddress.getState()).
                country(repoAddress.getCountry()).
                build();
    }

    AddressDAO toDAO(Address apiModel) {
        return AddressDAO.builder().
                lines(apiModel.getLines()).
                city(apiModel.getCity()).
                state(apiModel.getState()).
                country(apiModel.getCountry()).
                build();

    }
}
