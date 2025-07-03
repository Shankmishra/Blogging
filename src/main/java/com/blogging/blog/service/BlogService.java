package com.blogging.blog.service;

import com.blogging.blog.dto.ArticleRequest;
import com.blogging.blog.model.Article;
import com.blogging.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void postBlog(ArticleRequest ar){
        Article article = new Article();
        article.setTitle(ar.getTitle());
        article.setBody(ar.getBody());
        article.setPublishDate(LocalDate.now());
        article.setPublishTime(LocalDateTime.now());
        blogRepository.save(article);

    }

    public List<Article> getBlog() {
        return blogRepository.findAll();
    }
    public List<Article> getBlogByPublishDate(LocalDate ld) {
       return blogRepository.findByPublishDate(ld);
    }
    public void deleteBlogById(String ld) {
      blogRepository.deleteById(ld);
    }

    public void patchBlogById(String ld,ArticleRequest ar) {
       Optional<Article> article = blogRepository.findById(ld);
       if(article.isPresent()){
          article.get().setTitle(ar.getTitle());
          article.get().setBody(ar.getBody());
       }
        blogRepository.save(article.get());
    }

}
