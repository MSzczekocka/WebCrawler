package com.example.webcrawler.bfs;

import com.example.webcrawler.entity.GraphImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BfsImplementation {
    private final String firstUrl;
    private final long maximumUrlNo;
    private final GraphImplementation graphImplementation;

    public BfsImplementation(String firstUrl, long maximumUrlNo) {
        this.firstUrl = firstUrl;
        this.maximumUrlNo = maximumUrlNo;
        this.graphImplementation = new GraphImplementation();
    }

    public Set<String> bfs() throws IOException {
        graphImplementation.addUrlToQueue(this.firstUrl);

        while (!graphImplementation.isQueueEmpty() && graphImplementation.getUrlNo() < this.maximumUrlNo) {
            String currentUrl = graphImplementation.removeUrlForQueue();
            crawlUrl(getUrl(currentUrl));
        }
        return this.graphImplementation.getVisitedUrl();
    }

    String getUrl(String currentUrl) throws IOException {
        BufferedReader br = null;
        boolean correctURLFound = false;

        while (!correctURLFound) {
            try {
                URL url = new URL(currentUrl);
                br = new BufferedReader(new InputStreamReader(url.openStream()));
                correctURLFound = true;
            } catch (IOException e) {
                currentUrl = graphImplementation.removeUrlForQueue();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!Objects.isNull(currentUrl)) {
            sb.append(currentUrl);
            currentUrl = br.readLine();
        }
        return sb.toString();
    }

    void crawlUrl(String currentUrl) {
        Pattern pattern = Pattern.compile("http[s]?://(\\w+\\.)+(\\w+)");
        Matcher matcher = pattern.matcher(currentUrl);

        while(matcher.find()&& graphImplementation.getUrlNo() < this.maximumUrlNo){
            String urlString = matcher.group();

            if(!graphImplementation.isSetContainUrl(urlString)){
                graphImplementation.addUrlToSet(urlString);
                graphImplementation.addUrlToQueue(urlString);
            }
        }
    }

}
