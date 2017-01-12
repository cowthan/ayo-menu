
package org.ayo.sample.menu.notify;

import android.app.Application;
import android.widget.Toast;


/**
 * 只会显示一个toast  不会有延迟的toast
 * 
 * @author pengjun
 */
public class ToasterDebug {

    private static Application app;

    public static void init(Application a){
        app = a;
    }

    /**
     * 唯一的toast
     */
    private static Toast mToast = null;

    private ToasterDebug() {
    }

    public static void toastLong(final String tip){
    	showToast(tip, Toast.LENGTH_LONG);
    }
    
    public static void toastShort(final String tip){
    	showToast(tip, Toast.LENGTH_SHORT);
    }
    
    private static void showToast(final int stringid, final int lastTime) {
    	 if (mToast != null) {
             // mToast.cancel();
         } else {
             mToast = Toast.makeText(app, stringid, lastTime);
         }
         mToast.setText(stringid);
         mToast.show();
    }

    private static void showToast(final String tips, final int lastTime) {
    	if (mToast != null) {
            // mToast.cancel();
        } else {
            mToast = Toast.makeText(app, tips, lastTime);
        }
        mToast.setText(tips);
        mToast.show();
    }


}
