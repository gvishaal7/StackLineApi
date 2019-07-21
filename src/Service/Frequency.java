package Service;

import Entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the following class finds the frequency of each keyword in each product's name
 */
public class Frequency {

    /**
     * the following function finds the number of times a given keyword has occurred in the given product's title
     * @param keyWords the list of keywords for which the frequency needs to be calculated
     * @param products the list of products read from the file
     * @return a frequency map, returned in the desired format
     */
    public static Map<String,List<Map<String,Integer>>> getFrequency(List<String> keyWords, List<Product> products) {
        Map<String,List<Map<String,Integer>>> response = new HashMap<>();
        int frequency = 0;
        List<Map<String,Integer>> frequencyList = new ArrayList<>();
        for(String keyWord : keyWords) {
            Map<String, Integer> frequencyMap = new HashMap<>();
            for(Product product : products) {
                frequency += (product.getTitle().split(keyWord).length - 1);
            }
            frequencyMap.put(keyWord,frequency);
            frequency = 0;
            frequencyList.add(frequencyMap);
        }
        response.put("keywordFrequencies",frequencyList);

        return response;
    }
}
