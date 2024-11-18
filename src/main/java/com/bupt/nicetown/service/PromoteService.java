package com.bupt.nicetown.service;

import com.bupt.nicetown.pojo.PageBean;
import com.bupt.nicetown.pojo.Promote;

public interface PromoteService {
    void create(Promote promote);

    PageBean<Promote> list(int pageNum, int pageSize, String promoteType);

    PageBean<Promote> listmy(int pageNum, int pageSize, String promoteType, int userID);

    void update(Promote promote);

    void delete(Promote promote);

    Promote findByID(int promoteID);
}
