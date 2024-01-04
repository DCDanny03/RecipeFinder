package data;

/** 
 * Recipe Class 
 * The characteristics for Recipes 
 * getters and setters methods
 * 
 * @author Daniel Cao 
 */
public class Recipe {

    /** Recipe Name */
    private String name;

    /** Origin of dish/recipe */
    private String origin;

    /** List of Ingredients */
    private List ingredients; // Testing for push and pulling

    /** Number of Ingredients */
    private int numberOfIngredients;

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
     * @param numberOfIngredients number of ingredients
     * @param prep prep time
     * @param cook cook time
     * @param url url to recipe steps
     */
    public Recipe(String name, String origin, List ingredients, int numberOfIngredients,
        int prep, int cook, String url) {
        
            /** Intialize variables */
        this.name = name;
        this.origin = origin;
        this.ingredients = ingredients;
        this.numberOfIngredients = numberOfIngredients;
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

    public List getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(int numberOfIngredients) {
        this.numberOfIngredients = numberOfIngredients;
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


