package com.bupt.nicetown.service;

import com.bupt.nicetown.pojo.Promote;
import com.bupt.nicetown.pojo.Support;

import java.util.List;

public interface SupportService {
    Support findByPromoteID(int promoteID);

    void create(Support support);

    List<Support> list(int promoteID);

    List<Support> listmy(int userID);

    Support findByID(int supportID);

    void update(Support support);

    void delete(Support support);

    void accept(int promoteID, int promoterID, int supportID, int supporterID);

    void deny(int supportID);
}
