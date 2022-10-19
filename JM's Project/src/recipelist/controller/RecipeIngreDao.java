package recipelist.controller;

import java.util.List;
import recipelist.model.RecipeIngre;

public interface RecipeIngreDao {
	
	List<RecipeIngre> select();
	List<RecipeIngre> select(String productName);
	List<RecipeIngre> select(String productName, String ingreName);
	int insert(RecipeIngre recipeingre);
	int update(RecipeIngre recipeingre);
	int delete(Integer iIndex);
	


}
