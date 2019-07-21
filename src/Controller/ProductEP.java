package Controller;

import Entity.Product;
import Service.Frequency;
import Service.Search;
import Utility.readFromFile;

import java.util.List;
import java.util.Map;


public class ProductEP {

    private List<Product> fileContents;
    private String fileLocation;

    ProductEP(String fileLocation) {
        this.fileLocation = fileLocation;
        this.fileContents = readFromFile.parseFile(fileLocation);
    }

    //endpoint for autocomplete
    public List<String> autocomplete(String type, String prefix) {
        return Search.prefixSearch(type,prefix,fileContents);
    }

    //endpoint for search
    public List<Product> search(List<Map<String,Object>> conditions, Map<String, Integer> page) {
        return Search.search(conditions,page,fileContents);
    }

    //endpoint for keywords
    public Map<String,List<Map<String,Integer>>> keywords(List<String> keywords) {
        return Frequency.getFrequency(keywords,fileContents);
    }
}
