package com.spring.shortdomain.entity;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor @Builder
public class URL {
  private long id;
  private String originURL;
  private String shortenURL;
  private Date created;
  private int counter;
}
