package com.theironyard.charlotte.IntroWebsite.repositories;

import com.theironyard.charlotte.IntroWebsite.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 6/26/17.
 */
public interface UserRepo extends CrudRepository<User, Integer> {
    User findFirstByUsername(String username);
}
