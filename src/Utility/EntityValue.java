package Utility;

import Entity.Product;

/**
 * helper class to keep the code clean
 */
public class EntityValue {

    /**
     * the following function takes in a column name and returns its corresponding value for a given product
     * @param product The ProductEP object
     * @param type column for which we need the value
     * @return the resulting column value
     */
    public static String getEntityValue(Product product, String type) {
        /*
         * since the prefix endpoint just sprcifics the search value as 'brand' or 'category',
         * the following block of code helps in generalizing it
         */
        if(!type.contains("Name") && !type.contains("Id")) {
            type = type.concat("Name");
        }

        switch (type) {
            case "titleName": {
                return product.getTitle();
            }
            case "brandName": {
                return product.getBrandName();
            }
            case "categoryName": {
                return product.getCategoryName();
            }
            case "brandId": {
                return product.getBrandId();
            }
            case "categoryId": {
                return product.getCategoryId();
            }
            case "productId": {
                return product.getProductId();
            }
            default: {
                System.err.println("Enter a valid search type");
                return "";
            }
        }
    }
}
