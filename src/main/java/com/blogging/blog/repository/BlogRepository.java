package com.blogging.blog.repository;

import com.blogging.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<Article,String> {
    List<Article> findByPublishDate (LocalDate localDate);
}
