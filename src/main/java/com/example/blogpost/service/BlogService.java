package com.example.blogpost.service;

import com.example.blogpost.request.BlogRequest;
import com.example.blogpost.response.BlogResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


public interface BlogService {
  List<BlogResponse> getAllBlog();
  String addBlog(BlogRequest blogRequest);
  String updateBlog(Long id, BlogRequest blogRequest);
  String deleteBlog(Long id);

}
