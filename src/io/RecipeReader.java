package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import data.Recipe;

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


    /**
     * Helper method to process a line into a new Recipe object
     * @param line - line to process the recipe
     * @return Recipe object
     */
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
        String[] ingredients;

        // Empty Variables for object initialization
        String[] matchingIngredients = null;
        int numOfMatchIngredients = 0;
        
        // Scan line
        try (Scanner scan = new Scanner(line)) {
            scan.useDelimiter(",");
            if (scan.hasNext()) {
                name = scan.next();
            } else {
                name =  null;
            }

            if (scan.hasNext()) {
                origin = scan.next();
            } else {
                origin = null;
            }

            if (scan.hasNextInt()) {
                numOfIngredients = scan.nextInt();
            } else {
                numOfIngredients = 0;
            }

            if (scan.hasNextInt()) {
                prep = scan.nextInt();
            } else {
                prep = 0;
            }

            if (scan.hasNextInt()) {
                cook = scan.nextInt();
            } else {
                cook = 0;
            }

            if (scan.hasNext()) {
                url = scan.next();
            } else {
                url = null;
            }

            if (scan.hasNext()) {
                lineIngredients = scan.next(); // Scan the line of ingredients
                if(lineIngredients != null){
                    ingredients = processIngredients(lineIngredients);
                } else {
                    throw new IllegalArgumentException("File Reading Error: Ingredients not found");
                }             
            } else {
                throw new IllegalArgumentException("File Reading Error: Ingredients not found");
            }

            // Create the Recipe object only if ingredients are initialized
            try {
                newRecipe = new Recipe(name, origin, ingredients, matchingIngredients, numOfIngredients, numOfMatchIngredients, prep, cook, url);
            } catch (NoSuchElementException en) {
                en.printStackTrace();
                throw new IllegalArgumentException("Unable to create Recipe: " + en.getMessage());
            }
            


        } catch (NoSuchElementException e) {
            // Handle the exception, throw log
            e.printStackTrace();
            throw new IllegalArgumentException("Unable to read file: " + e.getMessage());
        }

        

        return newRecipe;
    }



    /**
     * Helper method to process the list of ingredients
     * @param line - line that contains list of ingredients
     * @return return an array list of ingredients for that Recipe
     */
    private static String[] processIngredients(String line) {
        String[] ingredients = new String[10]; // Initialize Array to hold list of ingredients
        // Try catch for the scanner
        try(Scanner scan = new Scanner(line)) {
            scan.useDelimiter(",");
            int index = 0;
            while(scan.hasNext()){
                if(index >= ingredients.length){
                    ingredients = Arrays.copyOf(ingredients, ingredients.length * 2 + 1);
                }
                String item = scan.next();
                ingredients[index] = item;
                index++;
            }
            ingredients = Arrays.copyOf(ingredients, index);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unable to read file: " + e.getMessage());
        }


        return ingredients;
    }
}
