package com.zhoujing.neihan.fragments;

import java.util.LinkedList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhoujing.neihan.R;
import com.zhoujing.neihan.R.id;

import android.R.integer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TextListFragment extends Fragment implements OnClickListener,OnScrollListener,OnRefreshListener2<ListView>{

	private View quickTools;
	private TextView textNotify;

	public TextListFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_textlist, container,
				false);
		//获取标题控件，增加点击，进行新消息悬浮框显示的功能
		View titleView=view.findViewById(R.id.textlist_title);
		titleView.setOnClickListener(this);
		// TODO 获取listview 并且设置数据
		PullToRefreshListView refreshListView=(PullToRefreshListView) view.findViewById(R.id.textlist_listview);
		refreshListView.setMode(Mode.BOTH);
		//设置上拉与下拉的事件监听
    //	OnRefreshListener2<>
		refreshListView.setOnRefreshListener(this);
//		ListView listView = (ListView) view.findViewById(R.id.textlist_listview);
		ListView listView=refreshListView.getRefreshableView();
		List<String> strings=new LinkedList<String>();
		strings.add("jjj");
		strings.add("qqq");
		strings.add("www");
		strings.add("eee");
		strings.add("rrr");
		strings.add("ttt");
		strings.add("ggg");
		strings.add("nbb");
		strings.add("fff");
		strings.add("lll");
		strings.add("jjj");
		strings.add("qqq");
		strings.add("www");
		strings.add("eee");
		strings.add("rrr");
		strings.add("ttt");
		strings.add("ggg");
		strings.add("nbb");
		strings.add("fff");
		strings.add("lll");
		strings.add("jjj");
		strings.add("qqq");
		strings.add("www");
		strings.add("eee");
		strings.add("rrr");
		strings.add("ttt");
		strings.add("ggg");
		strings.add("nbb");
		strings.add("fff");
		strings.add("lll");
		strings.add("jjj");
		strings.add("qqq");
		strings.add("www");
		strings.add("eee");
		strings.add("rrr");
		strings.add("ttt");
		strings.add("ggg");
		strings.add("nbb");
		strings.add("fff");
		strings.add("lll");
		strings.add("jjj");
		strings.add("qqq");
		strings.add("www");
		strings.add("eee");
		strings.add("rrr");
		strings.add("ttt");
		strings.add("ggg");
		strings.add("nbb");
		strings.add("fff");
		strings.add("lll");
		header = inflater.inflate(R.layout.text_header_tools, listView, false);
		listView.addHeaderView(header);
		View quickPublish=header.findViewById(R.id.quick_tools_publish);
		quickPublish.setOnClickListener(this);
		View quickReView=header.findViewById(R.id.quick_tools_review);
		quickReView.setOnClickListener(this);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,strings);
		listView.setAdapter(adapter);
		listView.setOnScrollListener(this);
		
		quickTools = view.findViewById(R.id.textlist_quick_tools);
		quickTools.setVisibility(View.INVISIBLE);
		//设置 悬浮的工具条 两个 命令事件
	    quickPublish=quickTools.findViewById(R.id.quick_tools_publish);
		quickPublish.setOnClickListener(this);
		quickReView=quickTools.findViewById(R.id.quick_tools_review);
		quickReView.setOnClickListener(this);
		//新消息提醒
		// TODO 获取 新条目通知控件，每次有新数据要显示，过一段时间后隐藏
		textNotify = (TextView) view.findViewById(R.id.textlist_new_notify);
		textNotify.setVisibility(View.INVISIBLE);
	
		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	private Handler handler=new Handler()
	{
		public void handleMessage(android.os.Message msg) {
			int what=msg.what;
			if (what==1) {
				//TODO what=1 代表有新消息提醒
				textNotify.setVisibility(View.INVISIBLE);
				
			}
		};
	};
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.textlist_title:
			textNotify.setVisibility(View.VISIBLE);
			handler.sendEmptyMessageDelayed(1, 2000);
			break;

//		case R.id.textlist_title:
//			textNotify.setVisibility(View.VISIBLE);
//			break;
//		case R.id.textlist_title:
//			textNotify.setVisibility(View.VISIBLE);
//			break;
		default:
			break;
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////

	//列表滚动显示工具条
	private int lastIndex=0;
	private View header;
	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		int offset=lastIndex-arg1;
		if (offset<0||arg1==0) {
			//证明现在移动是向上移动
			if (quickTools!=null) {
				quickTools.setVisibility(View.INVISIBLE);
				
			}
			
		}else if (offset>0) {
			if (quickTools!=null) {
				quickTools.setVisibility(View.VISIBLE);
			}
			
		}
		lastIndex=arg1;
	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	//////////////////////////////////////////////////////////////////////////////////////

	//列表下拉刷新与上拉加载
	/**
	 * 从上向下拉动列表，那么就要进行刷新数据的操作
	 */
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 从下往上拉动，那么就要考虑是否加载旧的数据
	 */
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
}
