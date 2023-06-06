package com.spring.shortdomain.service;

import com.spring.shortdomain.entity.URL;

public interface URLService {

  boolean save(String originURL);

  URL findByShortenURL(String shortenURL) throws Exception;

  int queryCounter(String shortenURL) throws Exception;

  String makeShortenURL();

}
