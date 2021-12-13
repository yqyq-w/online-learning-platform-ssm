package com.yq.service;

import com.yq.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryService {

    /*
    查询所有资源分类
    */
    public List<ResourceCategory> findAllResourceCategory();

    /*
    添加资源分类接口
     */
    public void saveResourceCategory(ResourceCategory resourceCategory);

    /*
    更新资源分类接口
     */
    public void updateResourceCategory(ResourceCategory resourceCategory);

    /*
    根据id查询资源分类
     */
    public ResourceCategory findResourceCategoryById(Integer id);

    /*
    删除资源分类接口
     */
    public void deleteResourceCategory(Integer id);

}

