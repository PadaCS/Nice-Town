package com.bupt.nicetown.service.impl;

import com.bupt.nicetown.mapper.PromoteMapper;
import com.bupt.nicetown.pojo.PageBean;
import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.service.PromoteService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageBean<Promote> list(int pageNum, int pageSize, String promoteType) {
        //创建pageBean对象
        PageBean<Promote> pageBean = new PageBean<>();

        //开启分页查询，导入了一个pagehelper的依赖
        PageHelper.startPage(pageNum, pageSize);

        //调用mapper查询
        List<Promote> l = promoteMapper.list(promoteType);
        //类型强制转换
        Page<Promote> p = (Page<Promote>) l;

        //把数据填充到PageBean中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public PageBean<Promote> listmy(int pageNum, int pageSize, String promoteType, int userID) {
        //创建pageBean对象
        PageBean<Promote> pageBean = new PageBean<>();

        //开启分页查询，导入了一个pagehelper的依赖
        PageHelper.startPage(pageNum, pageSize);

        //调用mapper查询
        List<Promote> l = promoteMapper.listmy(promoteType,userID);
        //类型强制转换
        Page<Promote> p = (Page<Promote>) l;

        //把数据填充到PageBean中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }
}
