package com.xujia.demo.bean;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenAi {
    private static final String OPENAI_URL = "https://api.openai.com/v1/images/generations";
    private final String apiKey = "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";
    private final RestTemplate restTemplate = new RestTemplate();
    public String generateImages(String prompt, float temperature, int maxTokens, String stop, final int logprobs, final boolean echo, final int n) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);
        // We are including only some of the parameters to the json request
        String requestJson = "{\"prompt\":\"" + prompt + "\",\"n\":" + n + "}";
        HttpEntity< String > request = new HttpEntity < > (requestJson, headers);
        ResponseEntity< String > response = restTemplate.postForEntity(OPENAI_URL, request, String.class);
        return response.getBody();
    }
}