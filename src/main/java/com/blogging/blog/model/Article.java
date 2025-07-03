package com.blogging.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class Article {
    @Id
    private String id;
    private String title;
    private LocalDate publishDate;
    private LocalDateTime publishTime;
    private String body;

    public Article() {
    }

    public String getId() {
        return id;
    }

    public Article(String id, String title, LocalDate publishDate, LocalDateTime publishTime, String body) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.publishTime = publishTime;
        this.body = body;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
