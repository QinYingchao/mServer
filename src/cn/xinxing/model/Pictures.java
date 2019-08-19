package cn.xinxing.model;

/**
 */
public class Pictures {
	private int id;
	private String  name;
	private String imgSrc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgSrc(){
		return imgSrc;
	}
	
	public void setImgSrc(String imgSrc){
		this.imgSrc=imgSrc;
	}
	
	
	
	@Override
	public String toString() {
		return "Pictures [id=" + id + ", name=" + name +",imgSrc="+imgSrc+"]";
	}
	
	
	
	

}
