package com.bjpowernode.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranscriptionController {

    @Resource
    private OpenAiAudioTranscriptionClient openAiAudioTranscriptionClient;

    @RequestMapping(value = "/ai/transcription")
    public Object transcription() {
        //org.springframework.core.io.Resource audioFile = new ClassPathResource("jfk.flac");
        org.springframework.core.io.Resource audioFile = new ClassPathResource("cat.mp3");
        String called = openAiAudioTranscriptionClient.call(audioFile);
        System.out.println(called);

        return called;
    }
}
