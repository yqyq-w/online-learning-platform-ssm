package com.yq.controller;

import com.github.pagehelper.PageInfo;
import com.yq.domain.Resource;
import com.yq.domain.ResourseVo;
import com.yq.domain.ResponseResult;
import com.yq.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage(@RequestBody ResourseVo resourseVo){

        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourseVo);

        return  new ResponseResult(true,200,"资源信息分页多条件查询成功",pageInfo);

    }



}
