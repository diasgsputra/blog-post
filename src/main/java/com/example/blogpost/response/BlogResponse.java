package com.example.blogpost.response;

import com.example.blogpost.entity.Blog;
import lombok.Data;

@Data
public class BlogResponse {
  private String title;
  private String blog;
  public BlogResponse(Blog blog){
    this.title = blog.getTitle();
    this.blog = blog.getContent();
  }
}
