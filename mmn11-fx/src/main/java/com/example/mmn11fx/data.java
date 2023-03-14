package com.example.mmn11fx;


import java.util.*;

public class data {
    public static Map<String, List<Integer>> avgTemp = new HashMap<>() {{
        put("2017", new ArrayList<>(Arrays.asList(
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        put("2018", new ArrayList<>(Arrays.asList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        put("2019", new ArrayList<>(Arrays.asList(
        2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)));
        put("2020", new ArrayList<>(Arrays.asList(
        3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)));
        put("2021", new ArrayList<>(Arrays.asList(
        4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
    }};
    public static String currentYear;

    public static List<Integer> getCurrentYear(){
        Optional<String> keyOPtional = data.avgTemp.keySet().stream().findFirst();
        if (keyOPtional.isPresent()) {
            String key = keyOPtional.get();
            data.currentYear = key;
            return data.avgTemp.get(key);
        }
        // default
        data.currentYear = "2021";
        return data.avgTemp.get("2021");

    }
}
