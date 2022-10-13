package recipelist.controller;

import static recipelist.model.RecipeList.Entity.*;

public interface RecipeListSql {

	
	// 전체 검색
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s",
			TBL_RECIPELIST, COL_RECIPE_NO);
	
	// 레시피 글 번호로 검색.
	String SQL_SELECT_BY_NO = String.format(
			"select * from %s where %s = ?",
			TBL_RECIPELIST, COL_RECIPE_NO);
	
	// 새 레시피 저장.(제품명, 분류, 저장일, 재료명, 제품중량, 기타재료, 판서순)
	String SQL_INSERT = String.format(
			"insert all into %s (%s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?)",
			TBL_RECIPELIST, COL_PRODUCT_NAME, COL_GROUP, COL_INGREDIENT_NAME, 
			COL_PRODUCT_WEIGHT, COL_ETC_TEXT, COL_COOKING_METHOD);
	// 레시피 글 업데이트.(제품명, 분류, 저장일, 재료명, 제품중량, 기타재료, 판서순)
	String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ?, %s = sysdate, %s = ?, %s = ?, %s = ?, %s = ? where %s = ?",
			TBL_RECIPELIST, COL_PRODUCT_NAME, COL_GROUP, COL_MODIFIED_DATE, 
			COL_INGREDIENT_NAME, COL_PRODUCT_WEIGHT, COL_ETC_TEXT, COL_COOKING_METHOD, COL_RECIPE_NO);
	
	// 레시피 삭제.
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?",
			TBL_RECIPELIST, COL_RECIPE_NO);
	
}
