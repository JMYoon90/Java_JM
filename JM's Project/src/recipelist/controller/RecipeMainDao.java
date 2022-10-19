package recipelist.controller;

import java.util.List;

import recipelist.model.RecipeMain;

public interface RecipeMainDao {
	
	List<RecipeMain> select();
	RecipeMain select(Integer productNo);
	int insert(RecipeMain reciperemain);
	int update(RecipeMain recipremain);
	int delete(Integer productNo);
	
	
	List<RecipeMain> select(int type, String keyword);
}
