package com.yq.service;

import com.github.pagehelper.PageInfo;
import com.yq.domain.Resource;
import com.yq.domain.ResourseVo;

public interface ResourceService {

   /*（
        资源分页&多条件查询
     */

    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo);


}
