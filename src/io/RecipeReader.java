package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import data.Recipe;
import list.List;

/**
 * RecipeReader processes input CSV files that contain 
 * recipe information
 * 
 * Input CSV files should be in the following format:
 *      NAME,ORIGIN,NUM_OF_INGREDIENTS,PREP,COOK,URL,INGREDIENTS 
 * 
 */
public class RecipeReader {
    

    /**
     * Process the inputs in the CSV file as an Array of Recipe Objects
     * which represent each line, we call processLine to actually process
     * the attributes of the Recipe individually
     * @param filePath - the path to the input CSV file
     * @return an array of Recipe Objects
     */
    public static Recipe[] readInputAsArray(String filePath) {
        Recipe[] list = new Recipe[10];
		try(Scanner scan = new Scanner(new FileInputStream(filePath), "UTF8")) {
            scan.nextLine(); // Skipping the header line
            int index = 0;
            while(scan.hasNextLine()){
                if(index >= list.length){
                    list = Arrays.copyOf(list, list.length * 2 + 1);
                }
                list[index] = processLine(scan.nextLine());
                index++;
            } 
            list = Arrays.copyOf(list, index);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File no found: " + e.getMessage());
        }

        return list;
    }

    private static Recipe processLine(String line) {
        Recipe newRecipe; // Create new recipe object
        // Initialize variables
        String name;
        String origin;
        int numOfIngredients;
        int prep;
        int cook;
        String url;
        String lineIngredients;
        List<String> ingredients;

        // Empty Variables for object initialization
        List<String> matchingIngredients;
        int numOfMatchIngredients;
        
        // Scan line
        try (Scanner scan = new Scanner(line)) {
            scan.useDelimiter(",");
            if (scan.hasNext()) {
                name = scan.next();
            }

            if (scan.hasNext()) {
                origin = scan.next();
            }

            if (scan.hasNextInt()) {
                numOfIngredients = scan.nextInt();
            }

            if (scan.hasNextInt()) {
                prep = scan.nextInt();
            }

            if (scan.hasNextInt()) {
                cook = scan.nextInt();
            }

            if (scan.hasNext()) {
                url = scan.next();
            }

            if (scan.hasNext()) {
                lineIngredients = scan.next(); // Scan the line of ingredients
                if(lineIngredients != null){
                    ingredients = processIngredients(lineIngredients);
                }             
            }
            



        } catch (NoSuchElementException e) {
            // Handle the exception, throw log
            e.printStackTrace();
        }

        newRecipe = new Recipe(name, origin, ingredients, matchingIngredients, numOfIngredients, numOfMatchIngredients
        ,prep, cook, url);

        return newRecipe;
    }


    private static String[] processIngredients(String line) {
        String[] ingredients = new String[10];
    }
}
