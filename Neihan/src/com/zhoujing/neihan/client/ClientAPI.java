package com.zhoujing.neihan.client;

import android.util.Log;

import com.android.volley.Request;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.zhoujing.neihan.test.TestActivity;

/**
 * 所有和客户端接口对接的方法，全部在这个类里面
 * 
 * @author zhoujing
 * 
 */
public class ClientAPI {

	/**
	 * 获取段子列表的内容
	 * 
	 * @param queue
	 *            Volley 请求的队列
	 * @param categaryType
	 *            要获取的参数的类型
	 * @param itemCount
	 *            服务器一次传回来的条目数
	 * @param minTime 用于分页加载数据，或者是下拉刷新时用，代表的上一次服务器返回时的时间信息
	 * @param responseListener
	 *            用于获取段子列表的回调接口，任何调用 getList方法时，此参数用于更新段子列表
	 * @see TestActivity#CATEGORY_TEXT
	 * @see TestActivity#CATEGORY_IMAGE
	 */
	public static void getList(
			RequestQueue queue, 
			int categaryType,
			int itemCount, 
			long minTime,
			Response.Listener<String> responseListener) {
		String CATEGORY_LIST_API = "http://ic.snssdk.com/2/essay/zone/category/data/";
		// 分类参数,根据类型获取不同的数据
		String categoryParam = "category_id=" + categaryType;
		String countParam = "count=" + itemCount;
		String deviceTypeParam = "device_type=KFTT";
		String openUDID = "openudid=b90ca6a3a19a78d6";

		String url = CATEGORY_LIST_API
				+ "?"
				+ categoryParam
				+ "&"
				+ countParam
				+ "&"
				+ deviceTypeParam
				+ "&"
				+ openUDID
				+ "&level=6&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&os_api=15&os_version=4.0.3";
        if (minTime>0) {
			url=url+"&minTime"+minTime;
		}
		queue.add(new StringRequest(Request.Method.GET, url, responseListener,
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub

					}
				}));
	}

	public static void getComment(RequestQueue queue,long groupId, int offset,Response.Listener<String> responseListener) {
		String COMMENT_API="http://isub.snssdk.com/2/data/get_essay_comments/";
		String groupIdParam="group_id="+groupId;
		String offsetParam="offset="+offset;
		
		String url=COMMENT_API+"?"+groupIdParam+"&"+offsetParam+"&count=20&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&device_type=KFTT&os_api=15&os_version=4.0.3&openudid=b90ca6a3a19a78d6";
		queue.add(new StringRequest(Request.Method.GET, url,responseListener, new Response.ErrorListener() {
			
			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				
			}
		}));
	}

}
