package org.ayo.menupager;

import android.os.Bundle;

import org.ayo.sample.menu.Leaf;
import org.ayo.sample.menu.MainPagerActivity;
import org.ayo.sample.menu.Menu;
import org.ayo.sample.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MainPagerActivity {

    private List<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }

    private void init(){
        menus = new ArrayList<Menu>();

        ///--------------------------菜单
        Menu m = new Menu("View", R.drawable.weixin_normal, R.drawable.weixin_pressed);
        menus.add(m);
        {
            MenuItem menuItem = new MenuItem("TextView", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("1111", "", ModuleMenuActivity.class));
                menuItem.addLeaf(new Leaf("2222", "", null));
                menuItem.addLeaf(new Leaf("3333", "", null));
                menuItem.addLeaf(new Leaf("44444", "", null));
                menuItem.addLeaf(new Leaf("5666", "", null));
            }

            menuItem = new MenuItem("ImageView", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("1111", "", null));
                menuItem.addLeaf(new Leaf("2222", "", null));
                menuItem.addLeaf(new Leaf("3333", "", null));
                menuItem.addLeaf(new Leaf("44444", "", null));
                menuItem.addLeaf(new Leaf("5666", "", null));
            }

        }

        ///--------------------------菜单
        m = new Menu("Layout", R.drawable.weixin_normal, R.drawable.weixin_pressed);
        menus.add(m);
        {
            MenuItem menuItem = new MenuItem("官方", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("1111", "", null));
                menuItem.addLeaf(new Leaf("2222", "", null));
                menuItem.addLeaf(new Leaf("3333", "", null));
                menuItem.addLeaf(new Leaf("44444", "", null));
                menuItem.addLeaf(new Leaf("5666", "", null));
            }

            menuItem = new MenuItem("权威第三方", R.drawable.weixin_normal, R.drawable.weixin_pressed);
            m.addMenuItem(menuItem);
            {
                menuItem.addLeaf(new Leaf("1111", "", null));
                menuItem.addLeaf(new Leaf("2222", "", null));
                menuItem.addLeaf(new Leaf("3333", "", null));
                menuItem.addLeaf(new Leaf("44444", "", null));
                menuItem.addLeaf(new Leaf("5666", "", null));
            }

        }


        /////menu finished
    }

    @Override
    public List<Menu> getMenus() {
        return menus;
    }
}