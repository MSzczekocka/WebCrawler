package com.example.webcrawler.services;

import com.example.webcrawler.database.DatabaseController;
import com.example.webcrawler.entity.VisitedUrl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VisitedUrlService {

    public static List<VisitedUrl> getAllVisitedUrl() {
        List<VisitedUrl> allVisitedUrls = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DatabaseController.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM VISITEDURL");
            while (rs.next()) {
                allVisitedUrls.add(new VisitedUrl(rs.getInt("ID_VISITEDURL"), rs.getString("URL_NAME")));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return allVisitedUrls;
    }

    public static void addVisitedUrl(VisitedUrl visitedUrl) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DatabaseController.getConnection();
            if (getVisitedUrlByNam(visitedUrl.getVisitedUrl()).isEmpty()) {
                statement = connection.prepareStatement("INSERT INTO VISITEDURL(URL_NAME) VALUES (?)");
                statement.setString(1, visitedUrl.getVisitedUrl());
                statement.executeUpdate();
                statement.close();
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Optional<VisitedUrl> getVisitedUrlByNam(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        Optional<VisitedUrl> result;
        try {
            connection = DatabaseController.getConnection();
            statement = connection.prepareStatement("SELECT * FROM VISITEDURL WHERE URL_NAME = ?");
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() ) {
                result = Optional.empty();
            } else {
                rs.next();
                result = Optional.of(new VisitedUrl(rs.getInt("ID_VISITEDURL"), rs.getString("URL_NAME")));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;

    }
}
