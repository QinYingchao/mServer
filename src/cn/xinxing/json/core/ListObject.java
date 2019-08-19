package cn.xinxing.json.core;

import java.util.List;

public class ListObject extends AbstractJsonObject {

	// 列表对象
	private List<?> items;//定义了一个列表对象，用来返回列表对象

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

}
