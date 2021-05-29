package com.dashboard.repositories;

import com.dashboard.models.JPA.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
