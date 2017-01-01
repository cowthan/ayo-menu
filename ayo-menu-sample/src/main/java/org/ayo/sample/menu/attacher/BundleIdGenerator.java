package org.ayo.sample.menu.attacher;

/**
 * Created by Administrator on 2016/1/19.
 */
public class BundleIdGenerator {
    public int getNext(){
        return (int) (System.currentTimeMillis()/1000) + 1;
    }
}
