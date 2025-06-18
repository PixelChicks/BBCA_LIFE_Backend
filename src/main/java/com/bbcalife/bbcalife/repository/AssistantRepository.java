package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, Long> {
}

