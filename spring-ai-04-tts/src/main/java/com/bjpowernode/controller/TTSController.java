package com.bjpowernode.controller;

import com.bjpowernode.util.FileUtils;
import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiAudioSpeechClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TTSController {

    @Resource
    private OpenAiAudioSpeechClient openAiAudioSpeechClient;

    @RequestMapping(value = "/ai/tts")
    public Object tts() {
        String text = "2023年全球汽车销量重回9000万辆大关，同比2022年增长11%。分区域看，西欧（14%）、中国（12%）两大市场均实现两位数增长。面对这样亮眼的数据，全球汽车行业却都对2024年的市场前景表示悲观，宏观数据和企业体感之前的差异并非中国独有，在汽车市场中，这是共性问题。";
        byte[] bytes = openAiAudioSpeechClient.call(text);
        FileUtils.save2File("D:\\SpringAI\\test.mp3", bytes);
        return "OK";
    }

    @RequestMapping(value = "/ai/tts2")
    public Object tts2() {
        String text = "Spring AI is an application framework for AI engineering. Its goal is to apply to the AI domain Spring ecosystem design principles such as portability and modular design and promote using POJOs as the building blocks of an application to the AI domain.";
        byte[] bytes = openAiAudioSpeechClient.call(text);
        FileUtils.save2File("D:\\SpringAI\\test2.mp3", bytes);
        return "OK";
    }
}
