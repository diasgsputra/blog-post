package com.example.blogpost.repository;

import com.example.blogpost.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BlogRepository extends JpaRepository<Blog,Long> {
}
