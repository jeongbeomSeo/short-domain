package com.spring.shortdomain.service;

import com.spring.shortdomain.entity.URL;
import com.spring.shortdomain.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLServiceImpl implements URLService{

  private final static String text = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
  private final static int POW = 56;
  URLRepository urlRepository;

  @Autowired
  public URLServiceImpl(URLRepository urlRepository) {this.urlRepository = urlRepository;}


  @Override
  public boolean save(String originURL) {
    String shortenURL = makeShortenURL();
    return urlRepository.save(originURL, shortenURL);
  }

  @Override
  public URL findByShortenURL(String shortenURL) throws Exception {
    return urlRepository.findByShortenURL(shortenURL);
  }

  @Override
  public int queryCounter(String shortenURL) throws Exception{
    return urlRepository.queryCounter(shortenURL);
  }

  @Override
  public String makeShortenURL() {

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 6; i++) {
      int randomIdx = (int)(Math.random() * POW);
      sb.append(text.charAt(randomIdx));
    }
    return sb.toString();
  }
}
