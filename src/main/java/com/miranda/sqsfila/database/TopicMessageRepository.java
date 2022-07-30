package com.miranda.sqsfila.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicMessageRepository extends JpaRepository<TopicMessageEntity,Long> {
}
