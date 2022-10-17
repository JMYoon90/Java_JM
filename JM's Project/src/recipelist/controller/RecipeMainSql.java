package recipelist.controller;

import static recipelist.model.RecipeMain.Entity.*;

public interface RecipeMainSql {

	
	// 전체 검색
	String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s",
			TBL_RECIPEMAIN, COL_PRODUCT_NO);
	
	// 레시피 글 번호로 검색.
	String SQL_SELECT_BY_NO = String.format(
			"select * from %s where %s = ?",
			TBL_RECIPEMAIN, COL_PRODUCT_NO);
	
	// 레시피 제품명으로 검색(재료테이블용).
		String SQL_SELECT_BY_PNAME = String.format(
				"select * from %s where %s = ?",
				TBL_RECIPEMAIN, COL_PRODUCT_NAME);
	
	// 새 레시피 저장.(제품명, 분류, 저장일, 기타재료, 판서순)
	String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s, %s) values (?, ?, ?, ?)",
			TBL_RECIPEMAIN, COL_PRODUCT_NAME, COL_PRODUCT_CLASS, COL_ETC_INGRE, COL_MAIN_CONTENT);
	// 레시피 글 업데이트.(제품명, 분류, 저장일, 기타재료, 판서순)
	String SQL_UPDATE = String.format(
			"update %s set %s = ?, %s = ?, %s = sysdate, %s = ?, %s = ? where %s = ?",
			TBL_RECIPEMAIN, COL_PRODUCT_NAME, COL_PRODUCT_CLASS, COL_MODIFIED_DATE,
			COL_ETC_INGRE, COL_MAIN_CONTENT, COL_PRODUCT_NO);
	
	// 레시피 삭제.
	String SQL_DELETE = String.format(
			"delete from %s where %s = ?",
			TBL_RECIPEMAIN, COL_PRODUCT_NO);
	
}
