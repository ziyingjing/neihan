package com.zhoujing.neihan.bean;
import org.json.JSONException;
import org.json.JSONObject;
public class ImageEntity extends TextEntity{


	private ImageUrlList largeList;
	private ImageUrlList middleList;

	public void parseJson(JSONObject item) throws JSONException
	{
		super.parseJson(item);
		JSONObject group = item.getJSONObject("group");
		
		JSONObject largeImage = group.optJSONObject("large_image");
		JSONObject middleImage = group
				.optJSONObject("middle_image");
		largeList = new ImageUrlList();
		if (largeImage!=null) {
			largeList.parseJson(largeImage);
		}
		
		middleList = new ImageUrlList();
		if (middleImage!=null) {
			middleList.parseJson(middleImage);
		}
	
	}
	public ImageUrlList getLargeList() {
		return largeList;
	}

	public ImageUrlList getMiddleList() {
		return middleList;
	}
}
