package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.SupportMapper;
import com.bupt.nicetown.pojo.Support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportServiceImpl implements com.bupt.nicetown.service.SupportService {
    @Autowired
    private SupportMapper supportMapper;

    @Override
    public Support findByPromoteID(int promoteID) {
        return supportMapper.findByPromoteID(promoteID);
    }

    @Override
    public void create(Support support) {
        supportMapper.create(support);
    }
}
