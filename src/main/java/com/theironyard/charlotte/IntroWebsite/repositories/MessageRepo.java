package com.theironyard.charlotte.IntroWebsite.repositories;

import com.theironyard.charlotte.IntroWebsite.entities.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jake on 6/26/17.
 */
public interface MessageRepo extends CrudRepository <Message, Integer>{
    List<Message> findAll();
    List<Message> findFirst5ByOrderByIdDesc();
}
