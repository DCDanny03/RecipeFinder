package data;

import list.List;
import java.util.Objects;

/** 
 * Recipe Class 
 * A recipe is comparable and identifiable
 * The characteristics for Recipes 
 * name, origin, ingredients, numOfIngredients, prep, cook, url
 * 
 * @author Daniel Cao 
 */
public class Recipe {

    /** Recipe Name */
    private String name;

    /** Origin of dish/recipe */
    private String origin;

    /** List of Ingredients */
    private List<String> ingredients; // Testing for push and pulling

    /** List of Matching Ingredients */
    private List<String> matchingIngredients;

    /** Number of Ingredients */
    private int numberOfIngredients;

    /** Number of Ingredients */
    private int numOfMatchingIngredients;

    /** Prep Time */
    private int prep;

    /** Cook Time */
    private int cook;

    /** Link to Webstie */
    private String url; 

    /**
     * Recipe object constructor
     * @param name of recipe
     * @param origin of recipe
     * @param ingredients list of ingredients
     * @param matchingIngredients list of matching ingredients
     * @param numberOfIngredients number of ingredients
     * @param numOfMatchingIngredients number of ingredients
     * @param prep prep time
     * @param cook cook time
     * @param url url to recipe steps
     */
    public Recipe(String name, String origin, List<String> ingredients, List<String> matchingIngredients, int numberOfIngredients,
         int numOfMatchingIngredients, int prep, int cook, String url) {
        
        /** Intialize variables */
        this.name = name;
        this.origin = origin;
        this.ingredients = ingredients;
        this.matchingIngredients = matchingIngredients;
        this.numberOfIngredients = numberOfIngredients;
        this.numOfMatchingIngredients = numOfMatchingIngredients;
        this.prep = prep;
        this.cook = cook;
        this.url = url;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
    }

    public List<String> getMatchingIngredients() {
        return matchingIngredients;
    }

    public void setMatchingIngredients(List<String> matchingIngredients) {
        this.matchingIngredients = matchingIngredients;
    }

    public int getNumOfMatchingIngredients() {
        return numOfMatchingIngredients;
    }

    public void setNumOfMatchingIngredients(int numOfMatchingIngredients) {
        this.numOfMatchingIngredients = numOfMatchingIngredients;
    }

    public int getPrep() {
        return prep;
    }

    public void setPrep(int prep) {
        this.prep = prep;
    }

    public int getCook() {
        return cook;
    }

    public void setCook(int cook) {
        this.cook = cook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    


    

}


