package recipelist.model;

public class JoinTable {

	private Integer productNo;
	private String productName;
	private Integer ingredientNo;
	private String ingredientName;
	private String ingredientCost;
	private String ingredientWeight;
	
	public JoinTable() {}
	
	
	public JoinTable(Integer productNo, String productName, Integer ingredientNo, String ingredientName,
			String ingredientCost, String ingredientWeight) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.ingredientNo = ingredientNo;
		this.ingredientName = ingredientName;
		this.ingredientCost = ingredientCost;
		this.ingredientWeight = ingredientWeight;
	}


	public Integer getProductNo() {
		return productNo;
	}
	public String getProductName() {
		return productName;
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
	
	
}
