package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@NoArgsConstructor
public class WebScraper {
    private static final String FASHIONDAYS_MAIN_PAGE = "https://www.fashiondays.hu/";
    private static final String WOMEN_ALL_CLOTHS = FASHIONDAYS_MAIN_PAGE + "g/női-/ruházat";
    private static final String MEN_ALL_CLOTHS = FASHIONDAYS_MAIN_PAGE + "g/férfi-/ruházat";
    private static final String GIRL_ALL_CLOTHS = FASHIONDAYS_MAIN_PAGE + "g/lány-/ruházat";
    private static final String BOY_ALL_CLOTHS = FASHIONDAYS_MAIN_PAGE + "g/fiú-/ruházat";

    public List<List<Map<String,String>>> startWebScraping() throws IOException, InterruptedException {
        String[] mainTags = {WOMEN_ALL_CLOTHS, MEN_ALL_CLOTHS, GIRL_ALL_CLOTHS, BOY_ALL_CLOTHS};
        List<List<Map<String,String>>> all = new ArrayList<>();
        all.add(getPageAllProduct(Jsoup.connect(WOMEN_ALL_CLOTHS).get()));


        /*
        for (String mainTag : mainTags) {
            for (int j = 1; j < getAllClothPageNumberByTag(Jsoup.connect(mainTag).get()); j++) {
                all.add(getPageAllProduct(Jsoup.connect(mainTag + "?page=" + j).get()));
                System.out.println(j);
                Thread.sleep(10000);
            }
        }

         */

        return all;
    }

    private int getAllClothPageNumberByTag(Document doc) {
        int pageNavigationBarLength = doc
                .selectFirst(".pagination")
                .select("li").size();

        int prosuctsPageNumber = Integer.parseInt(doc
                .selectFirst(".pagination")
                .select("li")
                .get(pageNavigationBarLength - 2)
                .selectFirst("a")
                .attr("data-page"));
        return Math.min(prosuctsPageNumber, 10);
    }

    private List<Map<String, String>> getPageAllProduct(Document doc) throws IOException {
        String genderHUN = doc.selectFirst(".active").text();
        String genderENG = getGenderByGenderHUN(genderHUN);

        Element productsPage = doc.getElementById("products-listing");
        Elements productsLinkList = productsPage.select("ul li");
        List<Map<String, String>> productList = new ArrayList<>();

        for (Element productLink : productsLinkList) {
            Map<String, String> product = new HashMap<>();

            product.put("genderHUN", genderHUN);
            product.put("genderENG", genderENG);
            product.put("productId", productLink.attributes().dataset().get("vrecom-productid"));
            product.put("similarProductsLink", productLink.attributes().dataset().get("vrecom-url"));
            String fullProductLink = productLink.getElementsByTag("a").attr("href");
            product.put("productMainPageLink", fullProductLink.substring(0, fullProductLink.indexOf("?")));
            product.put("title", productLink.getElementsByTag("a").attr("title"));
            product.put("priceHUF", productLink.getElementsByTag("a").attr("data-gtm-price"));
            product.put("priceEUR", productLink.getElementsByTag("a").attr("data-gtm-price-eur"));
            product.put("brand", productLink.getElementsByTag("a").attr("data-gtm-brand-name"));
            product.put("classificationENG", productLink.getElementsByTag("a").attr("data-gtm-classification"));
            product.put("subclassificationENG", productLink.getElementsByTag("a").attr("data-gtm-subclassification"));
            product.put("stockStatusENG", productLink.getElementsByTag("a").attr("data-gtm-status"));

            Document secondDoc = Jsoup.connect(fullProductLink.substring(0, fullProductLink.indexOf("?"))).get();
            Element imageListContainer = secondDoc.getElementById("carousel-thumb");
            Elements images = imageListContainer.select("li");
            for (Element image : images) {
                System.out.println(image.selectFirst("a").attr("rel").lastIndexOf("largeimage: '"));
            }

            System.out.println(imageListContainer);

            productList.add(product);
            break;
        }

        return productList;
    }

    private String getGenderByGenderHUN(String genderHUN) {
        switch (genderHUN) {
            case "Női":
                return "Women";
            case "Férfi":
                return "Man";
            case "Fiú":
                return "Boy";
            case "Lány":
                return "Girl";
            default:
                return "Unisex";
        }
    }

}
