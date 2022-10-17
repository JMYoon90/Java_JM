package recipelist.model;

import java.time.LocalDateTime;

public class RecipeMain {

	public interface Entity {
		String TBL_RECIPEMAIN = "RECIPEMAIN";
		String COL_PRODUCT_NO = "PNO";
		String COL_PRODUCT_NAME = "PNAME";
		String COL_PRODUCT_CLASS = "PCLASS";
		String COL_MODIFIED_DATE = "MODIFIED_DATE";
		String COL_ETC_INGRE = "ETCINGRE";
		String COL_MAIN_CONTENT = "MAINCONTENT";
	}
	
	private Integer productNo;
	private String productName;
	private String productClass;
	private LocalDateTime modifiedDate;
	private String ectIngre;
	private String mainContent;

	public RecipeMain() {}

	public RecipeMain(Integer productNo, String productName, String productClass, LocalDateTime modifiedDate,
			String ectIngre, String mainContent) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productClass = productClass;
		this.modifiedDate = modifiedDate;
		this.ectIngre = ectIngre;
		this.mainContent = mainContent;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductClass() {
		return productClass;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public String getEctIngre() {
		return ectIngre;
	}

	public String getMainContent() {
		return mainContent;
	}
	
	
}
