package com.ebiz.user.commons.util;

import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author 汶泽
 * @date 2021/8/15-22:22
 */

@Component
public class DozerUtils {

    private static Mapper dozerMapper;

    @Autowired
    public void setDozerMapper(Mapper dozerMapper) {
        DozerUtils.dozerMapper = dozerMapper;
    }

    /**
     * 构造新的destinationClass实例对象，通过source对象中的字段内容
     * 映射到destinationClass实例对象中，并返回新的destinationClass实例对象。
     *
     * @param source           源数据对象
     * @param destinationClass 要构造新的实例对象Class
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozerMapper.map(source, destinationClass);
    }

    /**
     * 将对象source的所有属性值拷贝到对象destination中.
     *
     * @param source            对象source
     * @param destinationObject 对象destination
     */
    public static void map(Object source, Object destinationObject) {
        dozerMapper.map(source, destinationObject);
    }

    /**
     * List数据源映射
     *
     * @param sourceList
     * @param destinationClass
     * @param <T>
     * @return List<T>
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List destinationList = new ArrayList<>();
        for (Iterator iterator = sourceList.iterator(); iterator.hasNext(); ) {
            Object sourceObject = iterator.next();
            Object destinationObject = dozerMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}