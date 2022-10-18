package recipelist.controller;

public interface IpriceCalSql {
	
	// 레시피 제품명으로 검색
		String SQL_SELECT_BY_PNAME =
				"SELECT i.iname, i.iweight, (i.iweight * f.priceforg) as price"
				+ " from recipemain m"
				+ " left join recipeingredient i on m.pname = i.pname"
				+ " left join foodcost f on i.iname = f.iname"
				+ " where m.pname like ?";

}
