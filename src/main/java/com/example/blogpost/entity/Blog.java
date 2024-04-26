package com.example.blogpost.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog")
public class Blog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "content")
  private String content;
  @Column(name = "id_author")
  private Long idAuthor;
}
