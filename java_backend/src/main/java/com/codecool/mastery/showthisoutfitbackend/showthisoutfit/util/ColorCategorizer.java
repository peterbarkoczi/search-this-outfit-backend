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

}
