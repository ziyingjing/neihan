package com.zhoujing.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EntityList {

	private boolean hasMore;
	private long minTime;
	private String tip;
	private long maxTime;
	private List<TextEntity> entities;

	public void parseJson(JSONObject json) throws JSONException
	{
		if (json!=null) {
			hasMore = json.getBoolean("has_more");//是否可已经加载更多
			if (hasMore==true) {
				minTime = json.getLong("min_time");
			}
			
			tip = json.getString("tip");
			maxTime = json.optLong("max_time");
			// 从data对象中，获取名称为data的数组，它代表的是段子列表的数据
			JSONArray array = json.getJSONArray("data");
			int len = array.length();
			if (len > 0) {
				entities=new LinkedList<TextEntity>();
				// 遍历数组中的每一条图片的段子信息
				for (int i = 0; i < len; i++) {

					JSONObject item = array.getJSONObject(i);
					int type=item.getInt("type");//获取类型，1是段子，5是广告
					if (type==5) {
						//TODO 处理广告内容
						AdEntity entity=new AdEntity();
						entity.parseJson(item);
						String url=entity.getDownloadUrl();
						Log.i("TestActivity", "---------------------" + url+"广告-----------------");
						
					}else if (type==1) {
						//TODO 处理段子内容
						JSONObject group=item.getJSONObject("group");
						int cid=group.getInt("category_id");
						TextEntity entity=null;
						if (cid==1) {
							//TODO 解析文本段子
							entity=new TextEntity();
							
						}
						else if (cid==2) {
							//TODO 解析图片段子
							entity=new ImageEntity();
						}
						entity.parseJson(item);
						entities.add(entity);
						long groupId=entity.getGroupId();
						Log.i("TestActivity", "---------------------" + groupId+"段子-----------------"+cid);
					}			

				}
		}
	}
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public long getMinTime() {
		return minTime;
	}

	public String getTip() {
		return tip;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public List<TextEntity> getEntities() {
		return entities;
	}
}
