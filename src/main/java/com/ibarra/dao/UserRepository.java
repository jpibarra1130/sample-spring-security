package com.ibarra.dao;

import com.ibarra.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paoloibarra on 22/8/15.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
