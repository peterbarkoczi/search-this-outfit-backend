package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.util;

import com.google.common.collect.Sets;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class ColorCategorizer {

    private Map<String, Set<String>> colorsCatalog = createColorsCatalog();


    private Map<String, Set<String>> createColorsCatalog() {
        Map<String, Set<String>> colors = new HashMap<>();
        colors.put("mutliple", Sets.newHashSet("mintás", "többszínű", "színes"));
        colors.put("black", Sets.newHashSet("fekete"));
        colors.put("white", Sets.newHashSet("szürke", "ezüst", "csont", "fehér"));
        colors.put("green", Sets.newHashSet("zöld", "khaki"));
        colors.put("blue", Sets.newHashSet("kék", "türkiz"));
        colors.put("red", Sets.newHashSet("bordó", "lazac", "rózsaszín", "fukszia", "vörös", "málna", "korall", "piros"));
        colors.put("yellow", Sets.newHashSet("sárga", "narancs", "arany", "mandarin", "barack"));
        colors.put("purple", Sets.newHashSet("lila"));
        colors.put("cream", Sets.newHashSet("bézs", "barna", "krém", "bronz", "drapp"));
        return colors;
    }

    public String getCategory(String mainColor) {
        mainColor = mainColor.trim();
        if (mainColor.isEmpty()) {
            throw new NullPointerException("The color to be categorized is empty.");
        }

        for (Map.Entry<String, Set<String>> colors : colorsCatalog.entrySet()) {
            for (String subColorName : colors.getValue()) {
                if (mainColor.contains(subColorName)) {
                    return colors.getKey();
                }

            }
        }
        return mainColor;
    }

    public List<String> getMainColors() {
        return new ArrayList<>(colorsCatalog.keySet());
    }

}
