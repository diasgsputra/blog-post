package com.example.blogpost.controller;

import com.example.blogpost.request.BlogRequest;
import com.example.blogpost.response.BlogResponse;
import com.example.blogpost.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BlogController {
  @Autowired
  private BlogService blogService;

  @GetMapping("/blogs")
  public ResponseEntity<List<BlogResponse>> getBlogs() {
    List<BlogResponse> blogs = blogService.getAllBlog();
    return ResponseEntity.ok(blogs);
  }

  @PostMapping("/blogs")
  public ResponseEntity<String> addBlogs(@RequestBody BlogRequest blogRequest) {
    String blog = blogService.addBlog(blogRequest);
    if (blog != null) {
      return ResponseEntity.ok(blog);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/blogs/{id}")
  public ResponseEntity<String> updateBlogsById(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
    String updatedBlog = blogService.updateBlog(id, blogRequest);
    if (updatedBlog != null) {
      return ResponseEntity.ok(updatedBlog);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/delete-dog-by-breed/{id}")
  public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
    String deleted = blogService.deleteBlog(id);
    if (deleted != null) {
      return ResponseEntity.ok(deleted);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
