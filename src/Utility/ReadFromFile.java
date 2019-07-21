package Utility;

import Entity.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * the following class reads the .tsv file and adds it to the a list
 */
public class ReadFromFile {

    /**
     * function that reads the content of the .tsv file
     * @param fileLocation full file path
     * @return a List containing the Products read from the file
     */
    public static List<Product> parseFile(String fileLocation) {
        List<Product> fileContents = new ArrayList<>();

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(fileLocation)));
            String newLine = "";
            while((newLine = bufferedReader.readLine()) != null) {
                String[] tabSplit = newLine.split("\\t");

                Product product = new Product();
                product.setProductId(tabSplit[0]);
                product.setTitle(tabSplit[1]);
                product.setBrandId(tabSplit[2]);
                product.setBrandName(tabSplit[3]);
                product.setCategoryId(tabSplit[4]);
                product.setCategoryName(tabSplit[5]);

                fileContents.add(product);
            }
        } catch (IOException ioe) {
            System.err.println("Error while accessing the file");
            ioe.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ioe) {
                System.err.println("Unable to close the bufferedReader object");
                ioe.printStackTrace();
            }
        }

        return fileContents;
    }
}
