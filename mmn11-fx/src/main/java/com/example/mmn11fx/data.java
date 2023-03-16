package com.example.mmn11fx;


import java.util.*;

public class data {
    /**
     * a map to hold the year and values together, keys are years and values are list of values.
     */
    public static Map<String, List<Integer>> avgTemp = new HashMap<>() {{
        put("2017", new ArrayList<>(Arrays.asList(
                5, 21, 19, 9, 20, 15, 2, 15, 15, 18, 8, 2)));
        put("2018", new ArrayList<>(Arrays.asList(
                 16, 21, 2, 8, 6, 20, 15, 12, 11, 17, 19, 14)));
        put("2019", new ArrayList<>(Arrays.asList(
                21, 5, 10, 2, 23, 7, 12, 21, 0, 11, 14, 9)));
        put("2020", new ArrayList<>(Arrays.asList(
                9, 13, 17, 4, 5, 21, 9, 2, 10, 8, 22, 12)));
        put("2021", new ArrayList<>(Arrays.asList(
        4, 5, 6, 7, 8, 9, 10, 11, 12, 23, 14, 15)));
    }};
    /**
     * a static param that holds current year
     */
    public static String currentYear;

    /**
     * a method that returns a list of a year from the map
     * @param year gets the current year known to main
     * @return the list of avg temps in a year
     */
    public static List<Integer> getCurrentYear(String year){
        if (year != ""){ // if was initialized
            List<String> l = new ArrayList<String>(data.avgTemp.keySet());
            int i = l.indexOf(year);
            if (i + 1 == l.size()){ // the loop end becomes begining
                currentYear = l.get(0);
                return data.avgTemp.get(l.get(0));
            }
            currentYear = l.get(i+1); // if not the end
            return data.avgTemp.get(l.get(i+1));
        } // init process from map
        Optional<String> keyOPtional = data.avgTemp.keySet().stream().findFirst();
        if (keyOPtional.isPresent()) {
            String key = keyOPtional.get();
            data.currentYear = key;
            return data.avgTemp.get(key);
        }
        // default
        return List.of();
    }
}
