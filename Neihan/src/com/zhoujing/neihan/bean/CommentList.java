package com.zhoujing.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;

/**
 * 评论接口返回的 data:{} 数据部分的实体定义
 * 包含了 top_comments 和recent_comments 两个数组
 * JSON格式如下
 * "data": {
 *    "top_comments": [],
 *    "recent_comments": []
 *    }
 * @author zhoujing
 *
 */
public class CommentList {

	private List<Comment> topcComments;
	private List<Comment> recentComments;
	private long groupId;
	private int totalNumber;
	private boolean hasMore;

	public void parseJson(JSONObject json) throws JSONException
	{
		if (json!=null) {
			groupId=json.getLong("group_id");
			totalNumber=json.getInt("total_number");
			hasMore=json.getBoolean("has_more");
			JSONObject data=json.getJSONObject("data");
			JSONArray tArray=data.optJSONArray("top_comments");
			JSONArray aArray=data.optJSONArray("recent_comments");
			if (tArray!=null) {
				topcComments=new LinkedList<Comment>();
				int len=tArray.length();
				if (len>0) {
					for (int i = 0; i < len; i++) {
						JSONObject obj=tArray.getJSONObject(i);
						Comment comment=new Comment();
						comment.parseJson(obj);
						topcComments.add(comment);
					}
				}
			}
			if (aArray!=null) {
				recentComments=new LinkedList<Comment>();
				int len=aArray.length();
				if (len>0) {
					for (int i = 0; i < len; i++) {
						JSONObject obj=aArray.getJSONObject(i);
						Comment comment=new Comment();
						comment.parseJson(obj);
						recentComments.add(comment);
					}
				}
			}
		}
	}
	
	/**
	 * 10-05 17:05:13.030: I/TestActivity(24698): ---------JSON key------------data
10-05 17:05:13.030: I/TestActivity(24698): ---------JSON key------------group_id
10-05 17:05:13.030: I/TestActivity(24698): ---------JSON key------------message
10-05 17:05:13.030: I/TestActivity(24698): ---------JSON key------------total_number
10-05 17:05:13.030: I/TestActivity(24698): ---------JSON key------------has_more

	 * @return
	 */
	public long getGroupId() {
		return groupId;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public List<Comment> getTopcComments() {
		return topcComments;
	}
	public List<Comment> getRecentComments() {
		return recentComments;
	}
}
