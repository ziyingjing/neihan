package com.zhoujing.neihan.bean;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class ImageUrlList {

	private List<String> largeImageUrls;
	private String uri;
	private int height;
	private int width;
	public void parseJson(JSONObject json) throws JSONException
	{
		largeImageUrls = parseImageUrlList(json);
		uri = json.getString("uri");
		height = json.getInt("height");
		width = json.getInt("width");
	}
	private List<String> parseImageUrlList(JSONObject largeImage)
			throws JSONException {
		JSONArray urls = largeImage.getJSONArray("url_list");
		// 大图片的网址全部在这里
		List<String> largeImageUrls = new ArrayList<String>();
		int ulen = urls.length();
		for (int j = 0; j < ulen; j++) {
			JSONObject uobj = urls.getJSONObject(j);
			String url = uobj.getString("url");
			largeImageUrls.add(url);

		}
		return largeImageUrls;
	}
	public List<String> getLargeImageUrls() {
		return largeImageUrls;
	}
	public String getUri() {
		return uri;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
