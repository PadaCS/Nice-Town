package com.bupt.nicetown.service;

import com.bupt.nicetown.pojo.Support;

import java.util.List;

public interface SupportService {
    Support findByPromoteID(int promoteID);

    void create(Support support);

    List<Support> list(int promoteID);

    List<Support> listmy(int userID);

    Support findByID(int supportID);

    void update(Support support);
}
