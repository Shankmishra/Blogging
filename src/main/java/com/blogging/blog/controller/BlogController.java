package com.blogging.blog.controller;

import com.blogging.blog.dto.ArticleRequest;
import com.blogging.blog.model.Article;
import com.blogging.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/root/blogging")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void Postarticle(@RequestBody ArticleRequest ar){
        blogService.postBlog(ar);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getarticles(){
        return blogService.getBlog();

    }

    @GetMapping("/{publishDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getarticlesbypublishdate(@PathVariable("publishDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ld){
        return blogService.getBlogByPublishDate(ld);
    }

//    @GetMapping("/byDateParam")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Article> getarticlesbypublishdate(@RequestParam("publishDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishDate){
//        return blogService.getBlogByPublishDate(publishDate);
//    }

    @DeleteMapping("/{DeleteByID}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteArticleById(@PathVariable("DeleteByID") String delByID){
         blogService.deleteBlogById(delByID);
    }

    @PatchMapping("/{PatchByID}")
    @ResponseStatus(HttpStatus.OK)
    public void PatchByID(@PathVariable("PatchByID") String patchByID,@RequestBody ArticleRequest articleRequest ){
        blogService.patchBlogById(patchByID,articleRequest);
    }

}
