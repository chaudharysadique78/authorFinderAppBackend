package com.authorFinder.authentication_service.repo;

import com.authorFinder.authentication_service.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends JpaRepository<Credential,Integer> {

    public Credential findByEmailAndPassword(String email,String password);

}
