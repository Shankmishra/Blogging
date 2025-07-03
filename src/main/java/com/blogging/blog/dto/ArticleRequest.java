package com.blogging.blog.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ArticleRequest {
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArticleRequest() {
    }

    public ArticleRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
