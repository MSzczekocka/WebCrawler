package com.example.webcrawler;

import com.example.webcrawler.bfs.BfsImplementation;
import com.example.webcrawler.database.DatabaseController;
import com.example.webcrawler.entity.VisitedUrl;
import com.example.webcrawler.export.Exporter;

import java.util.List;

public class WebCrawlerApplication {

    public static void main(String[] args) {
        String firstWebsite = "https://www.w3schools.com/java/java_lambda.asp";

        BfsImplementation myCrawler = new BfsImplementation(firstWebsite, 25);

        try{
            DatabaseController.createDB();
            List<VisitedUrl> urlsCrawled = myCrawler.bfs();
            Exporter.exportData(urlsCrawled);
        }catch(Exception e){
            System.out.println("IOException: " + e);
        }
    }

}
