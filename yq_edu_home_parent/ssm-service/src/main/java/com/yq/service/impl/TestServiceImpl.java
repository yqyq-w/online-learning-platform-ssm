package com.yq.service.impl;

import com.yq.dao.TestMapper;
import com.yq.domain.Test;
import com.yq.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public List<Test> findAllTest() {

        List<Test> allTest = testMapper.findAllTest();
        return allTest;
    }
}
