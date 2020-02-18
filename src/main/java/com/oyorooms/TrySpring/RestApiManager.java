package com.oyorooms.TrySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class RestApiManager {

  @Autowired
  private RestTemplate restTemplate;

  public <T> T postWithForm(String url, MultiValueMap<String, String> map,
                            HttpHeaders requestHeaders, Class<T> responseClassType) {
    ResponseEntity<T> responseEntity = null;
    try {
      HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, requestHeaders);
      responseEntity =
              restTemplate.exchange(url, HttpMethod.POST, entity, responseClassType);
      if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
        return responseEntity.getBody();
      }

    } catch (Exception e) {

    }
    return null;
  }

}
