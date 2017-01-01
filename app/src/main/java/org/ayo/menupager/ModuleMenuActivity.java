package org.ayo.menupager;

import android.view.View;

import org.ayo.sample.menu.DemoMenuActivityAttacher;
import org.ayo.sample.menu.notify.Toaster;

/**
 * Created by Administrator on 2017/1/1.
 */

public class ModuleMenuActivity extends DemoMenuActivityAttacher {

    @Override
    public String getDemoName() {
        return "1111";
    }
    @Override
    public DemoInfo[] getDemoMenus() {
        return new DemoInfo[]{
                new DemoInfo("示例1", new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toaster.toastShort("示例1");
                    }
                }),
                new DemoInfo("示例2", new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toaster.toastShort("示例2");
                    }
                })
        };
    }


}
