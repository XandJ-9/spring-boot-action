package com.xujia.demo.bean;

import lombok.Data;

@Data
public class GenerateImagesRequest {
    private String prompt;
    private float temperature;
    private int maxTokens;
    private String stop;
    private int logprobs;
    private boolean echo;
    private int n;
    // getters and setters
}