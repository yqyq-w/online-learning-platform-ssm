package com.yq.service.impl;

import com.yq.dao.ResourceCategoryMapper;
import com.yq.domain.ResourceCategory;
import com.yq.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    /*
    assn604
    */
    @Override
    public List<ResourceCategory> findAllResourceCategory() {

        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();

        return allResourceCategory;
    }

    /*
    添加资源分类接口
     */
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {

        // 1.补全信息
        Date date = new Date();
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);

        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");

        //2.调resourceCategoryMapper方法
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    /*
    更新资源分类接口
     */
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {

        // 1.补全信息
        Date date = new Date();
        resourceCategory.setUpdatedTime(date);
        resourceCategory.setUpdatedBy("system");

        //2.调resourceCategoryMapper方法
        resourceCategoryMapper.updateResourceCategory(resourceCategory);

    }

    /*
    根据id查询资源分类
     */
    @Override
    public ResourceCategory findResourceCategoryById(Integer id) {
        return resourceCategoryMapper.findResourceCategoryById(id);
    }

    /*
    删除资源分类接口
     */
    @Override
    public void deleteResourceCategory(Integer id) {
        resourceCategoryMapper.deleteResourceInResourceCategory(id);
        resourceCategoryMapper.deleteResourceCategory(id);
    }
}
