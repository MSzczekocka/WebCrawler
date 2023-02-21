package com.example.webcrawler.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphImplementation {
    private Queue<String> nodesQueue = new LinkedList<>();
    private Set<String> visitedUrl = new HashSet<>();
    private long urlNo;

    public GraphImplementation() {
        this.nodesQueue = new LinkedList<>();
        this.visitedUrl = new HashSet<>();
        this.urlNo = 0L;
    }

    public Set<String> getVisitedUrl() {
        return visitedUrl;
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
        visitedUrl.add(url);
        this.urlNo++;
    }

    public boolean isQueueEmpty() {
        return this.nodesQueue.isEmpty();
    }

    public boolean isSetContainUrl(String url) {
        return this.visitedUrl.contains(url);
    }
}
