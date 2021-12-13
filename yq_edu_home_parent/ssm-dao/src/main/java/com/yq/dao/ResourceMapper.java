package com.yq.dao;

import com.yq.domain.Resource;
import com.yq.domain.ResourseVo;

import java.util.List;

public interface ResourceMapper {


    /*（
        资源分页&多条件查询
     */

    public List<Resource> findAllResourceByPage(ResourseVo resourseVo);


}
