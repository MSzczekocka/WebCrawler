package com.example.webcrawler.repositories;

import com.example.webcrawler.entity.VisitedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitedUrlRepository extends JpaRepository<VisitedUrl, Long> {
}
