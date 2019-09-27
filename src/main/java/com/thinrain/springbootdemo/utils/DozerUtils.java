package com.thinrain.springbootdemo.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.List;

public class DozerUtils {

    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> List mapList(Collection sourceList, Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            Object destinationObject = dozerBeanMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}