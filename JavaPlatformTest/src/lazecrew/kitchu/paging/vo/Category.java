package lazecrew.kitchu.paging.vo;

public class Category {

	private int id;
	private String categoryGubun;
	private String categoryName;
	
	public Category() {}
	
	public Category(int id, String categoryGubun, String categoryName) {
		this.id = id;
		this.categoryGubun = categoryGubun;
		this.categoryName = categoryName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryGubun() {
		return categoryGubun;
	}
	public void setCategoryGubun(String categoryGubun) {
		this.categoryGubun = categoryGubun;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", categoryGubun=");
		builder.append(categoryGubun);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append("]");
		return builder.toString();
	}
	
}
