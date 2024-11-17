package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.TownMapper;
import com.bupt.nicetown.pojo.Town;
import com.bupt.nicetown.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    TownMapper townMapper;

    @Override
    public Town findTownByID(int townID) {
        Town t = townMapper.findTownByID(townID);;
        return t;
    }
}
