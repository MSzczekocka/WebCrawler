package com.example.webcrawler.entity;

import com.example.webcrawler.services.VisitedUrlService;
import lombok.RequiredArgsConstructor;

import java.util.*;


@RequiredArgsConstructor
public class GraphImplementation {
    private final Queue<String> nodesQueue;
    private long urlNo;

    public GraphImplementation() {
        this.nodesQueue = new LinkedList<>();
        this.urlNo = 0L;
    }

    public List<VisitedUrl> getVisitedUrl() {
        return VisitedUrlService.getAllVisitedUrl();
    }

    public long getUrlNo() {
        return urlNo;
    }
    public void setUrlNo(long urlNo) {
        this.urlNo = urlNo;
    }

    public void addUrlToQueue(String url){
        nodesQueue.add(url);
    }

    public String removeUrlForQueue() {
        return nodesQueue.poll();
    }

    public void addUrlToSet(String url) {
        VisitedUrlService.addVisitedUrl(new VisitedUrl(1, url));
        this.urlNo++;
    }

    public boolean isQueueEmpty() {
        return this.nodesQueue.isEmpty();
    }

    public boolean isSetContainUrl(String url) {
        return VisitedUrlService.getVisitedUrlByNam(url).isPresent();
    }
}
