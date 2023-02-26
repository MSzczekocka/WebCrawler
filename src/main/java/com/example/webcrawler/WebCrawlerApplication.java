package com.example.webcrawler;

import com.example.webcrawler.bfs.BfsImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Set;

@SpringBootApplication
public class WebCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCrawlerApplication.class, args);
        String firstWebsite = "https://www.w3schools.com/java/java_lambda.asp";

        BfsImplementation myCrawler = new BfsImplementation(firstWebsite, 25);

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
