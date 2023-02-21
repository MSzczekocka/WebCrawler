package com.example.webcrawler.bfs;

import com.example.webcrawler.graph.GraphImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {
    private String firstUrl;
    private long maximumUrlNo;
    private String urlPattern;
    private GraphImplementation graphImplementation;

    public BFS(String firstUrl, long maximumUrlNo, String urlPattern) {
        this.firstUrl = firstUrl;
        this.maximumUrlNo = maximumUrlNo;
        this.urlPattern = urlPattern;
        this.graphImplementation = new GraphImplementation();
    }

    public Set<String> bfs() throws IOException {
        graphImplementation.addUrlToQueue(this.firstUrl);

        while (!graphImplementation.isQueueEmpty()) {
            String currentUrl = graphImplementation.removeUrlForQueue();

            if (graphImplementation.getUrlNo() > this.maximumUrlNo) {
                return this.graphImplementation.getVisitedUrl();
            }

            BufferedReader br = skipNotCorrectUrl(currentUrl);
            StringBuilder sb = new StringBuilder();

            while((currentUrl = br.readLine()) != null) {
                sb.append(currentUrl);
            }

            currentUrl = sb.toString();
            Pattern pattern = Pattern.compile(this.urlPattern);
            Matcher matcher = pattern.matcher(currentUrl);

            while(matcher.find()){
                String urlString = matcher.group();

                if(!graphImplementation.isSetContainUrl(urlString)){
                    graphImplementation.addUrlToSet(urlString);
                    System.out.println("URL crawled just now: " + urlString);
                    graphImplementation.addUrlToQueue(urlString);
                    if(graphImplementation.getUrlNo()>this.maximumUrlNo) {
                        return this.graphImplementation.getVisitedUrl();
                    }

                }
            }

        }
        return this.graphImplementation.getVisitedUrl();
    }

    BufferedReader skipNotCorrectUrl(String currentUrl) {
        boolean correctURLFound = false;
        while (!correctURLFound) {
            try {
                URL url = new URL(currentUrl);
                return new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                currentUrl = graphImplementation.removeUrlForQueue();
            }
        }
        return null;
    }

}
