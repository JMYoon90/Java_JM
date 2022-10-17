package recipelist.model;

public class RecipeIngre {
	
	public interface Entity {
		String TBL_RECIPEINGRE = "RECIPEINGREDIENT";
		String COL_INGRE_INDEX = "IINDEX";
		String COL_INGRE_NAME = "INAME";
		String COL_INGRE_WEIGHT = "IWEIGHT";
		String COL_PRODUCT_NAME = "PNAME";
	}
	
	
	private Integer iIndex;
	private String ingreName;
	private Integer ingreWeight;
	private String pName;
	
	public RecipeIngre() {}

	public RecipeIngre(Integer iIndex, String ingreName, Integer ingreWeight, String pName) {
		this.iIndex = iIndex;
		this.ingreName = ingreName;
		this.ingreWeight = ingreWeight;
		this.pName = pName;
	}

	public Integer getiIndex() {
		return iIndex;
	}

	public String getIngreName() {
		return ingreName;
	}

	public Integer getIngreWeight() {
		return ingreWeight;
	}

	public String getpName() {
		return pName;
	}
	
	

	
	

}
