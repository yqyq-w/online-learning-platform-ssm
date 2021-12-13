package com.yq.controller;

import com.yq.domain.ResourceCategory;
import com.yq.domain.ResponseResult;
import com.yq.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /*
    assn604 查询资源分类信息
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);

    }

     /*
    添加&修改资源分类接口
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory) {

        // 判断是否携带了分类ID
        if(resourceCategory.getId() == null){
            // 新增
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return  new ResponseResult(true,200,"新增分类成功",null);
        }else {
            // 更新
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return  new ResponseResult(true,200,"更新分类成功",null);
        }
    }

    /*
    删除资源分类接口
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteRole(Integer id){

        resourceCategoryService.deleteResourceCategory(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除分类成功", null);
        return  responseResult;

    }

}
