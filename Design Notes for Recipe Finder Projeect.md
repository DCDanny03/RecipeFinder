# Design Notes for Recipe Finder Projeect


## INPUT
csv files for recipes
    - Should be able to be updated through UI or prompted
## DATA
Object Class: Recipe
    Attributes:
        - Recipe Name
        - Origin (Asian, Italian, American)
        - List for ingredients 
        - Number of ingredients
        - Length of Prep time
        - Length of Cook time
        - Link to Website

## IO
RecipeReader

## List
AbstractList - Abstract Class
ArrayBaseList - Public class implements abstractlist
List - Interface


