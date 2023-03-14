package com.example.mmn11fx;


import java.util.*;

public class data {
    /**
     * a map to hold the year and values together, keys are years and values are list of values.
     */
    public static Map<String, List<Integer>> avgTemp = new HashMap<>() {{
        put("2017", new ArrayList<>(Arrays.asList(
                20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        put("2018", new ArrayList<>(Arrays.asList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        put("2019", new ArrayList<>(Arrays.asList(
        2, 3, 4, 5, 6, 7, 8, 19, 10, 11, 12, 13)));
        put("2020", new ArrayList<>(Arrays.asList(
        3, 4, 5, 6, 7, 28, 9, 10, 11, 12, 13, 14)));
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
