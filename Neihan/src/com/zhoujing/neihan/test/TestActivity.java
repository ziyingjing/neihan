package com.zhoujing.neihan.test;

import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.Volley;
import com.zhoujing.neihan.R;
import com.zhoujing.neihan.bean.Comment;
import com.zhoujing.neihan.bean.CommentList;
import com.zhoujing.neihan.bean.EntityList;
import com.zhoujing.neihan.client.ClientAPI;

/**
 * 这是一个测试入口，所有的测试内容都放在这里
 * 
 * @author zhoujing
 * 
 */
public class TestActivity extends Activity implements Response.Listener<String> {

	/**
	 * 分类ID 1代表文本
	 */
	public static final int CATEGORY_TEXT = 1;
	/**
	 * 分类ID 2代表图片
	 */
	public static final int CATEGORY_IMAGE = 2;
	private RequestQueue queue;
	private Button button;
	private final static int itemCount = 30;
	private long lastTime;
	private int offset = 0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		// TODO 测试内涵段子列表接口，获取文本列表

		queue = Volley.newRequestQueue(this);

		// button=(Button) this.findViewById(R.id.button1);
		// button.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// // TODO Auto-generated method stub
		// ClientAPI.getList(queue,CATEGORY_IMAGE,
		// itemCount,lastTime,TestActivity.this);
		// }
		// });
		
		button = (Button) this.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				long groupId = 3551461874l;// 文本段子的id
				ClientAPI.getComment(queue, groupId, offset, TestActivity.this);
				//Log.i("TestActivity", "---------offset------------" + offset);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	/**
	 * 列表万罗获取回调部分
	 * 
	 * @param arg0
	 *            列表JSON数据字符串
	 */
	public void listonResponse(String arg0) {
		// TODO Auto-generated method stub
		// Log.i("TestActivity", "---------------------" + arg0);
		try {
			JSONObject json = new JSONObject(arg0);
			arg0 = json.toString(4);
			Log.i("TestActivity", "---------数据------------" + arg0);
			// 获取根节点下的 data 对象
			JSONObject obj = json.getJSONObject("data");
			// 解析段子列表的完整数据
			EntityList entityList = new EntityList();
			// 这个方法是解析JSON的方法，其中包含的支持 图片、文本、广告的解析
			entityList.parseJson(obj);
			// 如果isHasMore 返回 true，代表还可以更新一次数据
			if (entityList.isHasMore()) {
				lastTime = entityList.getMinTime();// 获取更新时间标识
				// Log.i("TestActivity", "---------数据------------" + lastTime);
			} else {// 没有更多，休息一下
				String tip = entityList.getTip();
				Log.i("TestActivity", "---------数据------------" + tip);
			}
			// 获取段子内容列表

			// TODO 把entities 这个段子的数据集合体，传递给 listview之类的Adapter 即可显示

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		try {
			JSONObject json = new JSONObject(arg0);
			arg0 = json.toString(4);
			// Iterator<String> keys=json.keys();
			// while (keys.hasNext()) {
			// String key=keys.next();
			// Log.i("TestActivity", "---------JSON key------------" + key);
			// }
		Log.i("TestActivity", "---------JSON key------------" + arg0);
			//解析获取到评论列表
			CommentList commentList = new CommentList();
			
			//评论列表包含两组数据，一个是热门评论，一个是新鲜评论
			commentList.parseJson(json);
			Log.i("TestActivity", "---------commentList------------" + commentList.getTotalNumber());
		//	Log.i("TestActivity",
				//	"---------------------" + commentList.isHasMore());
			//热门评论列表（可能为空，第一次 offset为0时可能有数据）
		    List<Comment> topcComments = commentList.getTopcComments();
		    //新鲜评论，可能有数据
		    List<Comment> recentComments= commentList.getRecentComments();
		    if (topcComments!=null) {
		    	for (int i = 0; i <topcComments.size(); i++) {
			    	//Log.i("TestActivity",
						//	"------------top--------" + topcComments.get(i).getText());
				}
			}
		    if (recentComments!=null) {
		    	for (int i = 0; i <recentComments.size(); i++) {
			    	//Log.i("TestActivity",
						//	"----------recent-----------" + recentComments.get(i).getText());
				}
			}
			offset+=20;
            //TODO 直接把commentlist 提交给listview的adapter，这样可以进行是否还有内容的判断
			//利用adapter 更新数据
			//分页标识，要求服务器每次返回20条评论，通过hasmore来进行判断是否还需要分页
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
