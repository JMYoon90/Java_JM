package recipelist.controller;

import static recipelist.model.FoodCost.Entity.*;

public interface FoodCostSql {


	// 전체 검색
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s",
			TBL_FOODCOST, COL_FOOD_NO);
	// 단가표 제품명으로 검색.
	String SQL_SELECT_BY_INAME = String.format(
			"select * from %s where lower(%s) like ?",
			TBL_FOODCOST,COL_FOOD_NAME); 
	// 새 재료 저장(품목번호, 품목명, 중량, 단가, g당 가격)
	String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)",
			TBL_FOODCOST, COL_FOOD_NAME, COL_FOOD_WEIGHT, COL_FOODCOST, COL_PRICE_FOR_G);
	// 재료 업데이트(중량, 단가, g당 가격)
	String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ?, %s = ? where %s = ?",
			TBL_FOODCOST, COL_FOOD_WEIGHT, COL_FOODCOST, COL_PRICE_FOR_G, COL_FOOD_NAME);
	// 레시피 삭제
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?",
			TBL_FOODCOST, COL_FOOD_NO);

}
