package com.ovwvwvo.pullwave.logic;

import com.ovwvwvo.jkit.utils.DateFormatUtil;
import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.repo.DetailRepo;
import com.ovwvwvo.pullwave.repoimpl.DetailRepoImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Copyright ©2017 by rawer
 */

public class DetailLogic {

    private DetailRepo detailRepo;

    public DetailLogic() {
        detailRepo = new DetailRepoImpl();
    }

    public Observable<DataResponse> loadData(String query) {
        String[] str = query.trim().split(" ");
        Map<String, String> param = new HashMap<>();
        for (int i = 0; i < str.length; i++)
            if (!StringUtil.isBlank(str[i]))
                param.put("w" + (i + 1), str[i]);
        return detailRepo.fetchData(param, DateFormatUtil.formatDate(new Date(), "yyyy-MM-dd"));
    }

}
