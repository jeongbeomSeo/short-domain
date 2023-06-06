package com.spring.shortdomain.repository;


import com.spring.shortdomain.entity.URL;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;


// Component 등록, Autowired를 하는게 맞는건지 조차 명확히 판단이 안선다.
@Component
public class URLRepository {

  private final ArrayList<URL> URLList;
  static int PRIMARY_ID = 1;
  static final int INITIAL_COUNTER_VALUE = 0;

  @Autowired
  URLRepository() {
    URLList = new ArrayList<>();
  }

  /*
  public ArrayList<URL> getURLList() {
    return URLList;
  }
  */

  // 이미 존재하는 Original URL은 생성 X
  // 같은 URL이 있건 없건 무조건 생성 (사용자들이 같은 URL을 입력하는 상황을 고려하면 이 방식이 맞지만 객체에 추가적인 정보를 요구하게됨 (counter)
  // 따라서 하나의 사용자만을 위해서 구현 했다고 생각하고 이미 만들어 놓은 URL이 있는지 체크 한 후 Return 해주기
  public boolean save(String originURL, String shortenURL) {

    for (URL url : URLList) {
      if (url.getOriginURL().equals(originURL)) return false;
    }

    URL url = URL.builder()
            .id(PRIMARY_ID++)
            .originURL(originURL)
            .shortenURL(shortenURL)
            .created(new Date())
            .counter(INITIAL_COUNTER_VALUE)
            .build();

    URLList.add(url);
    return true;
  }

  // ShortenURL로 URL 객체 가져오기
  public URL findByShortenURL(String shortenURL) throws Exception {
    for (URL url : URLList) {
      if (url.getShortenURL().equals(shortenURL)) {
        incrementCounter(url);
        return url;
      }
    }
    throw new Exception("Can not find this url");
  }

  // counter 조회하기
  public int queryCounter(String shortenURL) throws Exception {

    for (URL url : URLList) {
      if (url.getShortenURL().equals(shortenURL)) return url.getCounter();
    }

    throw new Exception("This URL does not saved");
  }

  // 조회 횟수 + 1
  private void incrementCounter(URL url) {
    url.setCounter(url.getCounter() + 1);
  }

}
