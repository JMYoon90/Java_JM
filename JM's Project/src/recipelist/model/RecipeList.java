package recipelist.model;

import java.time.LocalDateTime;

public class RecipeList {
	
	public interface Entity {
		String TBL_RECIPELIST = "RECIPELIST";
		String COL_RECIPE_NO = "PNO";
		String COL_PRODUCT_NAME = "PNAME";
		String COL_GROUP = "PCLASS";
		String COL_MODIFIED_DATE = "MODIFIED_DATE";
		String COL_PRODUCT_WEIGHT = "PWEIGHT";
		String COL_ETC_TEXT = "ETCTEXT";
		String COL_COOKING_METHOD = "COOKING_METHOD";
		String COL_INGREDIENT_NAME = "INAME";
		
	}
	
	private Integer productNo;
	private String productName;
	private String productGroup;
	private Integer productWeight;
	private LocalDateTime modifiedDate;
	private String ectText;
	private String cookingMethod;
	private String ingredientName;
	
	public RecipeList() {}

	public RecipeList(Integer productNo, String productName, String productGroup, Integer productWeight,
			LocalDateTime modifiedDate, String ectText, String cookingMethod, String ingredientName) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productGroup = productGroup;
		this.productWeight = productWeight;
		this.modifiedDate = modifiedDate;
		this.ectText = ectText;
		this.cookingMethod = cookingMethod;
		this.ingredientName = ingredientName;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public Integer getProductWeight() {
		return productWeight;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public String getEctText() {
		return ectText;
	}

	public String getCookingMethod() {
		return cookingMethod;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	

	

	
	
}
