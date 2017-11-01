package com.walker.restfulapi.util;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.*;

/**
 * 说明：参数封装Map
 * 创建人：walker
 * 修改时间：2017-10-27
 */
public class PageData extends HashMap implements Map {
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private Map map=null;

    public PageData(){
        map=new HashMap();
    }

    @SuppressWarnings("unchecked")
    public PageData(HttpServletRequest request){
        this.request=request;

        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name;
        String value;

        while (entries.hasNext()){
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null==valueObj){
                value="";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                value = StringUtils.join(values,",");
            }else {
                value=valueObj.toString();
            }
            returnMap.put(name,value);
        }
        map=returnMap;
    }

    public String getString(Object key) {
        return (String)get(key);
    }

    @Override
    public Object get(Object key) {
        Object obj;
        if(map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])map.get(key);
            obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        if(value instanceof ClobProxyImpl){ 			//读取oracle Clob类型数据
            try {
                ClobProxyImpl cpi = (ClobProxyImpl)value;
                Reader is = cpi.getCharacterStream(); 	//获取流
                BufferedReader br = new BufferedReader(is);
                String str = br.readLine();
                StringBuffer sb = new StringBuffer();
                while(str != null){						//循环读取数据拼接到字符串
                    sb.append(str);
                    sb.append("\n");
                    str = br.readLine();
                }
                value = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.put(key, value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(Map m) {
        map.putAll(m);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Entry> entrySet() {
        return map.entrySet();
    }
}
