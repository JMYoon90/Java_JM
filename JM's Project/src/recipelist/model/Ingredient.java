package recipelist.model;

public class Ingredient {

	public interface Entity {
		String TBL_INGREDIENT = "INGREDIENT_INFO";
		String COL_INGREDIENT_NO = "INO";
		String COL_INGREDIENT_NAME = "INAME";
		String COL_INGREDIENT_COST = "ICOST";
		String COL_INGREDIENT_WEIGHT = "IWEIGHT";
		String COL_BUY_DATE = "BUY_DATE";
	}
	
	private Integer ingredientNo;
	private String ingredientName;
	private String ingredientCost;
	private String ingredientWeight;
	private String buyDate;
	
	public Ingredient() {}

	public Ingredient(Integer ingredientNo, String ingredientName, String ingredientCost, String ingredientWeight,
			String buyDate) {
		super();
		this.ingredientNo = ingredientNo;
		this.ingredientName = ingredientName;
		this.ingredientCost = ingredientCost;
		this.ingredientWeight = ingredientWeight;
		this.buyDate = buyDate;
	}

	public Integer getIngredientNo() {
		return ingredientNo;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public String getIngredientCost() {
		return ingredientCost;
	}

	public String getIngredientWeight() {
		return ingredientWeight;
	}

	public String getBuyDate() {
		return buyDate;
	}
	
	
}
