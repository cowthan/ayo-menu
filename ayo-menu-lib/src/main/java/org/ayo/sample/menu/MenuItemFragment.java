package org.ayo.sample.menu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.ayo.component.Master;
import org.ayo.component.MasterFragment;


public class MenuItemFragment extends MasterFragment {

	private MenuItem menuItem;

	public void setMenu(MenuItem menuItem){
		this.menuItem = menuItem;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable("menuItem", menuItem);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.frag_menu_item2;
	}

	@Override
	protected void onCreate2(View contentView, @Nullable Bundle savedInstanceState) {
		if(savedInstanceState != null){
			menuItem = (MenuItem) savedInstanceState.getSerializable("menuItem");
		}
		ll_root = (LinearLayout) findViewById(R.id.ll_root);
		for(Leaf leaf: menuItem.subMenus){
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


	private void addButton(final Leaf leaf){
		Button btn = new Button(getActivity());
		btn.setText(leaf.name);
		btn.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		btn.setBackgroundResource(R.drawable.sel_menu2);
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
				if(leaf.attacherClass != null){
					Master.startPage(getActivity(), leaf.attacherClass, null);
				}else if(leaf.activityClass != null){
					Intent intent = new Intent(getActivity(), leaf.activityClass);
					getActivity().startActivity(intent);
				}else{
					Toast.makeText(getActivity(), "sorry，此功能尚未实现", Toast.LENGTH_SHORT).show();
				}
			}
		});

		if(leaf.attacherClass == null && leaf.activityClass == null){

		}else{
			btn.setBackgroundResource(R.drawable.sel_menu3);
		}

	}


}
