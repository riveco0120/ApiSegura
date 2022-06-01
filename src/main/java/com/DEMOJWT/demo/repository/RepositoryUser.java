package com.DEMOJWT.demo.repository;


import com.DEMOJWT.demo.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends MongoRepository<User,String> {
}
