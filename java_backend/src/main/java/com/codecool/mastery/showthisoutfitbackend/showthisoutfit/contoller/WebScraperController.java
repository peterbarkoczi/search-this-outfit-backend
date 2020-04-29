package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.contoller;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.Labeler;
import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service.WebScraper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class WebScraperController {

    private WebScraper webScraper = new WebScraper();
    private Labeler labeler = new Labeler();


    @GetMapping("/webscraper")
    public List<List<Map<String,String>>> result() throws IOException, InterruptedException {
        return webScraper.startWebScraping();
    }

    @GetMapping("/labeler")
    public List<String> labelerResult() {
        return labeler.firstTry();
    }

}
