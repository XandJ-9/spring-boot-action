package com.xujia.demo.controller;

import com.xujia.demo.bean.GenerateImagesRequest;
import com.xujia.demo.bean.OpenAi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 一个调用openAI来生成图像的样例
 */
@RestController
public class OpenAiController {
    @Autowired
    private final OpenAi openAi;
    public OpenAiController(OpenAi openAi) {
        this.openAi = openAi;
    }
    @PostMapping("/generateImages")
    public String generateImages(@RequestBody GenerateImagesRequest request) {
        return openAi.generateImages(request.getPrompt(), request.getTemperature(), request.getMaxTokens(), request.getStop(),
                request.getLogprobs(), request.isEcho(), request.getN());
    }
}