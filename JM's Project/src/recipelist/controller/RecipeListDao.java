package recipelist.controller;

import java.util.List;

import recipelist.model.RecipeList;

public interface RecipeListDao {
	
	List<RecipeList> select();
	RecipeList select(Integer productNo);
	int insert(RecipeList reciprelist);
	int update(RecipeList reciprelist);
	int delete(Integer productNo);
}
