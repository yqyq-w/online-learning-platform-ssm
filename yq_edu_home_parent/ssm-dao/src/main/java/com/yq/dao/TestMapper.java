package com.yq.dao;

import com.yq.domain.Test;

import java.util.List;

public interface TestMapper {

    /*
        对test表进行查询所有
     */
    public List<Test> findAllTest();


}
