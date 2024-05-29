package com.bjpowernode.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageClient;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Resource
    private OpenAiImageClient openAiImageClient;


    @RequestMapping("/ai/image")
    private Object image(@RequestParam(value = "msg") String msg) {
        ImageResponse imageResponse = openAiImageClient.call(new ImagePrompt(msg));
        System.out.println(imageResponse);

        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        //把图片进行业务处理

        return imageResponse.getResult().getOutput();
    }

    @RequestMapping("/ai/image2")
    private Object image2(@RequestParam(value = "msg") String msg) {
        ImageResponse imageResponse = openAiImageClient.call(new ImagePrompt(msg, OpenAiImageOptions.builder()
                .withQuality("hd") //高清图像
                .withN(1)  //生成1张图片
                .withHeight(1024) //生成的图片高度
                .withWidth(1024) //生成的图片宽度
                .build()));
        System.out.println(imageResponse);

        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        //把图片进行业务处理
        return imageResponse.getResult().getOutput();
    }
}
