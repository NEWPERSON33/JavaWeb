package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParameterToBean( Map<String , String[]> map, T bean){
        try {
            BeanUtils.populate(bean , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean ;
    }

    public static int paseInt(String key , int defaultValue ){
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue ;

    }

}
