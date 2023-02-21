package com.example.webcrawler;

import com.example.webcrawler.bfs.BFS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Set;

@SpringBootApplication
public class WebCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlerApplication.class, args);
        String firstWebsite = "http://www.alimirjalili.com";
        String patterns = "http[s]*://(\\w+\\.)*(\\w+)";

        BFS myCrawler = new BFS(firstWebsite, 30, patterns);

        try{
            Set<String> urlsCrawled = myCrawler.bfs();

            System.out.println(urlsCrawled.size() + " web sites crawled!");
            System.out.println("Here is the list: ");
            for(String s : urlsCrawled){
                System.out.println(s);

            }
        }catch(IOException e){
            System.out.println("IOException: " + e);
        }
    }

}
