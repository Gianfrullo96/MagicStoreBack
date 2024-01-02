package com.gf.magic.store.front.scryfall;

import com.gf.magic.store.front.scryfall.entities.Root;
import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 9/4/23
 */
@Slf4j
public class ScryFallRestClientTemplate {
    private final RestTemplate template = new RestTemplate();
    protected final String baseUrl;

    public ScryFallRestClientTemplate(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public Root getCards() throws Exception {
        try {
            ResponseEntity<Root> result = template.getForEntity(baseUrl, Root.class);
            if (result.getStatusCode().is2xxSuccessful()) {
                return result.getBody();
            } else if (result.getStatusCode() == HttpStatus.MOVED_PERMANENTLY) {
                // Handle redirection
                HttpHeaders headers = result.getHeaders();
                String newUrl = headers.getFirst(HttpHeaders.LOCATION);
                if (newUrl != null) {
                    // Make a request to the new URL
                    ResponseEntity<Root> redirectedResult = template.exchange(newUrl, HttpMethod.GET, null, Root.class);
                    if (redirectedResult.getStatusCode().is2xxSuccessful()) {
                        return redirectedResult.getBody();
                    } else {
                        throw new Exception("Redirected request failed with status code: " + redirectedResult.getStatusCodeValue());
                    }
                } else {
                    throw new Exception("Received a 301 response with no redirection URL.");
                }
            } else {
                throw new Exception("HTTP request failed with status code: " + result.getStatusCodeValue());
            }
        } catch (HttpStatusCodeException e) {
            throw new Exception("HTTP request failed with status code: " + e.getStatusCode().value(), e);
        } catch (Exception e) {
            throw new Exception("An error occurred while making the request: " + e.getMessage(), e);
        }
    }
}
