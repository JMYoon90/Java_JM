package recipelist.controller;

import java.util.List;

import recipelist.model.FoodCost;

public interface FoodCostDao {
	
	List<FoodCost> select();
	List<FoodCost> select(String foodname);
	int select_existence(String foodname);
	int insert(FoodCost foodcost);
	int delete(Integer foodNo);
	int update(FoodCost foodcost);
	
	

}
