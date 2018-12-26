package com.fenglv.sell.util;

import java.util.Collection;

public class CollectionUtil {

    /**
     * 判断集合是否为空
     * 若为空或元素个数为0 返回true
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection){
        if(collection == null || collection.size() == 0){
            return true;
        }
        return  false;
    }
}
