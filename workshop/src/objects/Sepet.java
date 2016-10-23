package objects;

public class Sepet {
	private int productId;//
	private int customerId;//
	private int categoryId;
	private String productName;
	private int saledProductPrice;

	public Sepet(int productId, int customerId, int categoryId, String productName, int saledProductPrice) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.saledProductPrice = saledProductPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSaledProductPrice() {
		return saledProductPrice;
	}

	public void setSaledProductPrice(int saledProductPrice) {
		this.saledProductPrice = saledProductPrice;
	}

	public Sepet() {

	}

}
