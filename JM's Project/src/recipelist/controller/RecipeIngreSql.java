package recipelist.controller;

import static recipelist.model.RecipeIngre.Entity.*;

public interface RecipeIngreSql {

	
	// 전체 검색
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s",
			TBL_RECIPEINGRE, COL_INGRE_INDEX);
	
	// 레시피 글 번호로 검색.
	String SQL_SELECT_BY_NO = String.format(
			"select * from %s where %s = ?",
			TBL_RECIPEINGRE, COL_INGRE_INDEX);
	
	// 레시피 제품명으로 검색(재료테이블용).
	String SQL_SELECT_BY_PNAME = String.format(
			"select * from %s where lower(%s) like ?",
			TBL_RECIPEINGRE, COL_PRODUCT_NAME);
		
	// 레시피 제품명, 재료명으로 검색
	String SQL_SELECT_BY_PNAME_AND_INAME = String.format(
			"select * from %s where %s = ? and %s = ?",
			TBL_RECIPEINGRE, COL_PRODUCT_NAME, COL_INGRE_NAME);
				
				
	// 새 레시피 저장.(제품명, 재료명, 재료중량)
	String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)",
			TBL_RECIPEINGRE, COL_PRODUCT_NAME, COL_INGRE_NAME, COL_INGRE_WEIGHT);
	
	// 레시피 업데이트.(재료명, 재료중량)
	String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ? where %s = ? and %s = ?",
			TBL_RECIPEINGRE, COL_INGRE_NAME, COL_INGRE_WEIGHT, COL_PRODUCT_NAME, COL_INGRE_NAME);
	
	// 레시피 삭제.
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?",
			TBL_RECIPEINGRE, COL_INGRE_INDEX);
	
}
