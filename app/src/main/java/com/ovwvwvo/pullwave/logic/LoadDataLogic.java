package com.ovwvwvo.pullwave.logic;

import com.ovwvwvo.jkit.utils.DateFormatUtil;
import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.repo.LoadRepo;
import com.ovwvwvo.pullwave.repoimpl.LoadRepoImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Copyright ©2017 by rawer
 */

public class LoadDataLogic {

    private static final String NAME = "rawer";

    private LoadRepo loadRepo;

    public LoadDataLogic() {
        loadRepo = new LoadRepoImpl();
    }

    public Observable<DataResponse> loadData(String query) {
        String[] str = query.trim().split(" ");
        Map<String, String> param = new HashMap<>();
        for (int i = 0; i < str.length; i++)
            if (!StringUtil.isBlank(str[i]))
                param.put("w" + i, str[i]);
        return loadRepo.fetchData(NAME, param, DateFormatUtil.formatDate(new Date(),"yyyy-MM-dd"));
    }

}
