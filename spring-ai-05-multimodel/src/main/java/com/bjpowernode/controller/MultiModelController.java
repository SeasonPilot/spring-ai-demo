package com.bjpowernode.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MultiModelController {

    @Resource
    private ChatClient chatClient;

    @RequestMapping(value = "/ai/multi")
    public Object multi(String msg, String imageUrl) {

        UserMessage userMessage = new UserMessage(msg, List.of(new Media(MimeTypeUtils.IMAGE_PNG, imageUrl)));

        ChatResponse response = chatClient.call(new Prompt(userMessage, OpenAiChatOptions.builder()
                .withModel(OpenAiApi.ChatModel.GPT_4_VISION_PREVIEW.getValue())
                .build()));

        System.out.println(response.getResult().getOutput());
        return response.getResult().getOutput().getContent();
    }
}
