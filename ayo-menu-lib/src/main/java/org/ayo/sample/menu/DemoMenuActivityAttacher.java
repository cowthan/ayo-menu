package org.ayo.sample.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.ayo.component.MasterFragment;
import org.ayo.sample.menu.widget.TitleBar;

import java.io.Serializable;


public abstract class DemoMenuActivityAttacher extends MasterFragment {

	public class DemoInfo implements Serializable {

		public String name;
		public View.OnClickListener onClickListener;
		public int iconNormal;
		public int iconPressed;

		public DemoInfo(String name, View.OnClickListener onClickListener){
			this.name = name;
			this.onClickListener = onClickListener;
		}
	}

	public abstract String getDemoName();
	public abstract DemoInfo[] getDemoMenus();

	@Override
	protected int getLayoutId() {
		return R.layout.frag_menu_item;
	}

	@Override
	protected void onCreate2(View contentView, @Nullable Bundle savedInstanceState) {
		TitleBar titlebar = (TitleBar) findViewById(R.id.titlebar);
		titlebar.callback(titlebarCallback)
				.leftButton(R.drawable.ayo_sample_menu_sel_arrow_down_red)
				.bgColor(R.color.common_top_bar_blue)
				.title(getDemoName()+"");

		ll_root = (LinearLayout) findViewById(R.id.ll_root);
		for(DemoInfo leaf: getDemoMenus()){
			addButton(leaf);
		}
	}


	@Override
	protected void onDestroy2() {

	}

	@Override
	protected void onPageVisibleChanged(boolean visible, boolean isFirstTimeVisible, @Nullable Bundle savedInstanceState) {

	}

	private LinearLayout ll_root;

	private void addButton(final DemoInfo leaf){
		Button btn = new Button(getActivity());
		btn.setText(leaf.name);
		btn.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		btn.setBackgroundResource(R.drawable.sel_menu3);
		btn.setTextSize(15);
		btn.setPadding(20, 0, 20, 0);
		btn.setTextColor(Color.WHITE);
		btn.setAllCaps(false);


		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Utils.dip2px(getActivity(), 40));
		lp.gravity = Gravity.CENTER;
		lp.topMargin = Utils.dip2px(getActivity(), 5);
		lp.bottomMargin = Utils.dip2px(getActivity(), 5);
		lp.leftMargin = Utils.dip2px(getActivity(), 5);
		lp.rightMargin = Utils.dip2px(getActivity(), 5);
		ll_root.addView(btn, lp);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(leaf.onClickListener == null){
					Toast.makeText(getActivity(), "sorry，此功能尚未实现", Toast.LENGTH_SHORT).show();
				}else{
					leaf.onClickListener.onClick(v);
				}
			}
		});

	}


	private TitleBar.Callback titlebarCallback = new TitleBar.Callback() {

		@Override
		public void onRightButtonClicked(int index, View v) {

		}

		@Override
		public void onLeftButtonClicked(View v) {
			finish();
		}
	};
}
