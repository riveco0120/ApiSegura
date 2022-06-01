package com.DEMOJWT.demo.repository;


import com.DEMOJWT.demo.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * RepositoryUser Repository
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public interface RepositoryUser extends MongoRepository<User, String> {
}
