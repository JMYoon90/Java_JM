package recipelist.controller;

import java.util.List;
import recipelist.model.RecipeIngre;

public interface RecipeIngreDao {
	
	List<RecipeIngre> select();
	List<RecipeIngre> select(String ProductName);
	int insert(RecipeIngre recipeingre);
	int delete(Integer iIndex);
	


}
