package com.bjpowernode.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    @Resource
    private OllamaChatClient ollamaChatClient;

    @RequestMapping(value = "/ai/ollama")
    public Object ollama(@RequestParam(value = "msg") String msg) {
        String called = ollamaChatClient.call(msg);
        System.out.println(called);

        return called;
    }

    @RequestMapping(value = "/ai/ollama2")
    public Object ollama2(@RequestParam(value = "msg") String msg) {
        ChatResponse chatResponse = ollamaChatClient.call(new Prompt(msg, OllamaOptions.create()
                .withModel("qwen:0.5b-chat") //使用哪个大模型
                .withTemperature(0.4F))); //温度，温度值越高，准确率下降，温度值越低，准确率会提高

        System.out.println(chatResponse.getResult().getOutput().getContent());
        return chatResponse.getResult().getOutput().getContent();
    }

    public static void main(String[] args) {
        String next = "张三";
        int i = 18;
        String sql = " insert into tbl student(name, age) values ( '" + next + "'," + i + ") ";
        System.out.println(sql);
    }
}
