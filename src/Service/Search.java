package Service;

import Entity.Product;
import Utility.EntityValue;

import java.util.*;

/**
 * The following class contains the service response for 2 points,
 * the prefix and the product search
 */
public class Search {

    /**
     * the following method returns products whose type matches the prefix string
     * @param prefix the prefix to be searched for
     * @param type the column on which the search has to be applied
     * @param products the list of products read from the file
     * @return a list of String values that match the prefix criteria
     */
    public static List<String> prefixSearch(String type, String prefix, List<Product> products) {
        List<String> response = new ArrayList<>();

        products.forEach(product -> {
            if(EntityValue.getEntityValue(product,type).startsWith(prefix)) {
                response.add(EntityValue.getEntityValue(product,type));
            }
        });

        return response;
    }

    /**
     * the following method returns products that matches the given search criteria after applying the pagination filter on them
     * @param conditions the conditions which must be met
     * @param pagination the pagination filter
     * @param products the list of products read from the file
     * @return a list of Products that meet the given search criteria after pagination
     */
    public static List<Product> search(List<Map<String,Object>> conditions, Map<String, Integer> pagination, List<Product> products) {
        Set<Product> response = new HashSet<>();

        conditions.forEach(condition -> {
            ((List<String>)condition.get("values")).forEach(value -> {
                products.forEach(product -> {
                    if(EntityValue.getEntityValue(product,(String)condition.get("type")).equals(value)) {
                        response.add(product);
                    }
                });
            });
        });

        int size = pagination.get("size");
        /*
         * since the list is 0 indexed and
         * it ignores the last value we apply the following calculation
         */
        int from = pagination.get("from") - 1;
        return ((new ArrayList<>(response)).subList(from,(from + size)));
    }
}
