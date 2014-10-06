package com.zhoujing.neihan.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class Comment {
	private long uid;
	private String platform;
	private String text;
	private int diggCount;
	private int userDigg;
	private boolean userVerified;
	private int buryCount;
	private String userProfileUrl;
	private long id;
	private String userName;
	private int userBury;
	private String userProfileImageUrl;
	private String description;
	private long createTime;
	private long userId;

	public void parseJson(JSONObject json) throws JSONException
	{
		if (json!=null) {
			uid = json.getLong("uid");
			platform = json.getString("platform");
			text = json.getString("text");
			diggCount = json.getInt("digg_count");
			userDigg = json.getInt("user_digg");
			userVerified = json.getBoolean("user_verified");
			buryCount = json.getInt("bury_count");
			userProfileUrl = json.getString("user_profile_url");
			id = json.getLong("id");
			userName = json.getString("user_name");
			userBury = json.getInt("user_bury");
			userProfileImageUrl = json.getString("user_profile_image_url");
			description = json.optString("description");
			createTime = json.getLong("create_time");
			userId = json.getLong("user_id");
		}
	}
	/**
	 * {
10-05 16:30:01.790: I/TestActivity(16763):                 "uid": 0,
10-05 16:30:01.790: I/TestActivity(16763):                 "platform": "feifei",
10-05 16:30:01.790: I/TestActivity(16763):                 "text": "p",
10-05 16:30:01.790: I/TestActivity(16763):                 "digg_count": 0,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_digg": 0,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_verified": false,
10-05 16:30:01.790: I/TestActivity(16763):                 "bury_count": 0,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_profile_url": "",
10-05 16:30:01.790: I/TestActivity(16763):                 "id": 3061505830,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_name": "迈克4673557",
10-05 16:30:01.790: I/TestActivity(16763):                 "user_bury": 0,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_profile_image_url": "http:\/\/p2.pstatp.com\/thumb\/471\/2027400682",
10-05 16:30:01.790: I/TestActivity(16763):                 "description": "这个用户很懒，神马都木有写",
10-05 16:30:01.790: I/TestActivity(16763):                 "create_time": 1391265702,
10-05 16:30:01.790: I/TestActivity(16763):                 "user_id": 3009869355
10-05 16:30:01.790: I/TestActivity(16763):             },
	 */

	public long getUid() {
		return uid;
	}

	public String getPlatform() {
		return platform;
	}

	public String getText() {
		return text;
	}

	public int getDiggCount() {
		return diggCount;
	}

	public int getUserDigg() {
		return userDigg;
	}

	public boolean isUserVerified() {
		return userVerified;
	}

	public int getBuryCount() {
		return buryCount;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserBury() {
		return userBury;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public long getCreateTime() {
		return createTime;
	}

	public long getUserId() {
		return userId;
	}

}
