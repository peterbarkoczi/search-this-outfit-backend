package com.codecool.mastery.showthisoutfitbackend.showthisoutfit.respository;

import com.codecool.mastery.showthisoutfitbackend.showthisoutfit.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ClothingRepository extends JpaRepository<Clothing, Long> {

    Set<Clothing> findTop20ByClassificationENG(String classificationENG);

    Set<Clothing> findTop10ByClassificationENGAndColor(String classificationENG, String color);

    @Query("select c.classificationENG from Clothing c")
    Set<String> getAllClassificationENG();
}
