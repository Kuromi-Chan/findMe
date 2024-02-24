package by.biziuk.dictionaries;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LocationData {
    
    public static final Map<String, String[]> districtStreetMap = new HashMap<>();
    
    static {
        districtStreetMap.put("Ленинский район", new String[]{
            "Улица Малинина",
            "Улица Ленина",
            "Улица Кирова",
            "Улица Плеханова"
        });
        districtStreetMap.put("Советский район", new String[]{
            "Улица Мележа",
            "Улица Ломоносова",
            "Улица Беды",
            "Улица Тиражная"
        });
        districtStreetMap.put("Московский район", new String[]{
            "Улица Алибегова",
            "Улица Волоха",
            "Улица Минина",
            "Улица Матросова",
        });
        districtStreetMap.put("Партизанский район", new String[]{
            "Улица Буденного",
            "Улица Ванеева",
            "Улица Васнецова",
            "Улица Солтыса"
        });
        districtStreetMap.put("Заводской район", new String[]{
            "Улица Автозаводская",
            "Улица Корицкого",
            "Улица Кулешова",
            "Улица Плеханова"
        });
    }
}



    

