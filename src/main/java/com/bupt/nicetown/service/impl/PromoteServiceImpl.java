package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.PromoteMapper;
import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.service.PromoteService;
import org.springframework.stereotype.Service;

@Service
public class PromoteServiceImpl implements PromoteService {
    private final PromoteMapper promoteMapper;

    public PromoteServiceImpl(PromoteMapper promoteMapper) {
        this.promoteMapper = promoteMapper;
    }

    @Override
    public void create(Promote promote) {
        promoteMapper.create(promote);
    }
}
