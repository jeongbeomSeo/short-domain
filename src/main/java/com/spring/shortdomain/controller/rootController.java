package com.spring.shortdomain.controller;

import com.spring.shortdomain.entity.URL;
import com.spring.shortdomain.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class rootController {

  private URLService urlService;

  @Autowired
  public rootController(URLService urlService) {this.urlService = urlService; }

  @RequestMapping(value="/", method = RequestMethod.GET)
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/{shortenURL:^[2-9A-HJ-NP-Za-km-np-z]{6}]}", method = RequestMethod.GET)
  public String shortenURL(@PathVariable String shortenURL) throws Exception {
    URL url = urlService.findByShortenURL(shortenURL);
    String originURL = url.getOriginURL();

    return "redirect:" + originURL;
  }
}
