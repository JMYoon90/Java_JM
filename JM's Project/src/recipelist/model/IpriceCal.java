package recipelist.model;

public class IpriceCal {

	public interface Entity {
		String COL_PRODUCT_NAME = "PNAME";
		String COL_INGRE_NAME = "INAME";
		String COL_INGRE_WEIGHT = "IWEIGHT";
		String COL_PRICE = "PRICE";
	}
	
	private String ingrename;
	private String productname;
	private Integer weight;
	private Integer price;
	
	public IpriceCal() {}

	public IpriceCal(String ingrename, String productname, Integer weight, Integer price) {
		this.ingrename = ingrename;
		this.productname = productname;
		this.weight = weight;
		this.price = price;
	}

	public String getIngrename() {
		return ingrename;
	}

	public String getProductname() {
		return productname;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getPrice() {
		return price;
	}
	
}
