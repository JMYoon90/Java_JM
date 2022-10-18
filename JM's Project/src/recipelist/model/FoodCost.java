package recipelist.model;

import java.time.LocalDateTime;

public class FoodCost {
	
	public interface Entity {
		String TBL_FOODCOST = "FOODCOST";
		String COL_FOOD_NO = "FNO";
		String COL_FOOD_NAME = "INAME";
		String COL_FOODCOST = "FOODCOST";
		String COL_PRICE_FOR_G = "PRICEFORG";
		String COL_MODIFIED_DATE = "MODIFIED_DATE";
		String COL_FOOD_WEIGHT = "FWEIGHT";
	}
	
	private Integer foodNo;
	private String foodName;
	private Integer foodCost;
	private double priceForG;
	private LocalDateTime modifiedDate;
	private Integer fWeight;
	
	public FoodCost() {}

	public FoodCost(Integer foodNo, String foodName, Integer foodCost, double priceForG, LocalDateTime modifiedDate,
			Integer fWeight) {
		super();
		this.foodNo = foodNo;
		this.foodName = foodName;
		this.foodCost = foodCost;
		this.priceForG = priceForG;
		this.modifiedDate = modifiedDate;
		this.fWeight = fWeight;
	}

	public Integer getFoodNo() {
		return foodNo;
	}

	public String getFoodName() {
		return foodName;
	}

	public Integer getFoodCost() {
		return foodCost;
	}

	public double getPriceForG() {
		return priceForG;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public Integer getfWeight() {
		return fWeight;
	}

	

	
	

}
