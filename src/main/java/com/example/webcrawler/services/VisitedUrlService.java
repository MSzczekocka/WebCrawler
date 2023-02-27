package com.example.webcrawler.services;

import com.example.webcrawler.entity.VisitedUrl;
import com.example.webcrawler.repositories.VisitedUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitedUrlService {

    private final VisitedUrlRepository visitedUrlRepository;

    public List<VisitedUrl> getAllVisitedUrl() {
        return visitedUrlRepository.findAll();
    }

    public VisitedUrl addVisitedUrl(VisitedUrl visitedUrl) {
        return visitedUrlRepository.save(visitedUrl);
    }
}
