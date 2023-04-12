package com.example.webcrawler.entity;

import lombok.*;


@AllArgsConstructor
public class VisitedUrl {

    private int id;
    private String visitedUrl;

    public VisitedUrl() {
    }

    public VisitedUrl(String visitedUrl) {
        this.visitedUrl = visitedUrl;
    }

    public String getVisitedUrl() {
        return visitedUrl;
    }

    public void setVisitedUrl(String visitedUrl) {
        this.visitedUrl = visitedUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VisitedUrl{" +
                "id=" + id +
                ", visitedUrl='" + visitedUrl + '\'' +
                '}';
    }
}
