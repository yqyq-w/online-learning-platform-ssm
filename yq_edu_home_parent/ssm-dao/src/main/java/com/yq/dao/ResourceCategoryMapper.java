package com.yq.dao;

import com.yq.domain.ResourceCategory;

import java.util.List;

public interface ResourceCategoryMapper {

    /*
        查询所有资源分类
     */
    public List<ResourceCategory> findAllResourceCategory();

    /*
    assn604
    添加资源分类接口
     */
    public void saveResourceCategory(ResourceCategory resourceCategory);

    /*
    修改资源分类接口
     */
    public void updateResourceCategory(ResourceCategory resourceCategory);

    /*
    根据id查询资源分类
     */
    public ResourceCategory findResourceCategoryById(Integer id);

    /*
    删除资源分类中现有资源的接口
     */
    public void deleteResourceInResourceCategory(Integer id);

    /*
    删除资源分类接口
     */
    public void deleteResourceCategory(Integer id);

}
