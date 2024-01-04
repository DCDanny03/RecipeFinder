package data;

import java.util.Comparator;

/**
 * Comparator to compare the amount of matching ingredients
 * To help list Recipes in ordered based on num of matching ingredients
 */
public class RecipeIngredientComparator implements Comparator<Recipe>{

    /**
     * Compares the amount of matching ingredients 
     * @param o1 Recipe being Comapred
     * @param o2 Recipe being Compared
     */
    @Override
    public int compare(Recipe o1, Recipe o2) {
        if (o1.getNumOfMatchingIngredients() - o2.getNumOfMatchingIngredients() < 0) {
            return -1;
        } else if (o1.getNumOfMatchingIngredients() - o2.getNumOfMatchingIngredients() > 0){
            return 1;
        }
        return 0;
    }
    
}
