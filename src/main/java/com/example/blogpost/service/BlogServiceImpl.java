package com.example.blogpost.service;

import com.example.blogpost.entity.Blog;
import com.example.blogpost.repository.BlogRepository;
import com.example.blogpost.request.BlogRequest;
import com.example.blogpost.response.BlogResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService{
  @Autowired
  private ObjectMapper objectMapper;
  private UriComponentsBuilder builder;
  private HttpEntity<String> entity;
  @Autowired
  private BlogRepository blogRepository;

  @Override
  public List<BlogResponse> getAllBlog(){

    List<Blog> blogs = blogRepository.findAll();

    return blogs.stream()
        .map(BlogResponse::new)
        .collect(Collectors.toList());
  }

  @Override
  public String addBlog(BlogRequest blogRequest){
    Blog blog = new Blog();
    blog.setTitle(blogRequest.getTitle());
    blog.setContent(blogRequest.getContent());
    blog.setIdAuthor(blogRequest.getIdAuthor());
    blogRepository.save(blog);

    return "Blog posted successfully";
  }

  @Override
  public String updateBlog(Long id, BlogRequest blogRequest) {
    Optional<Blog> blogOptional = blogRepository.findById(id);
    if (blogOptional.isPresent()) {
      Blog blog = blogOptional.get();
      blog.setTitle(blogRequest.getTitle());
      blog.setContent(blogRequest.getContent());
      blogRepository.save(blog);
      return "Dog name updated";
    } else {
      return null;
    }
  }

  @Override
  public String deleteBlog(Long id) {
    Optional<Blog> blogOptional = blogRepository.findById(id);
    if (blogOptional.isPresent()) {
      blogRepository.deleteById(id);
      return "Delete successfully";
    } else {
      return null;
    }
  }
}
