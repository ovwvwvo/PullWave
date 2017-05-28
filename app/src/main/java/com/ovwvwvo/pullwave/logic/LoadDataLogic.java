package com.ovwvwvo.pullwave.logic;

import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.repo.LoadRepo;
import com.ovwvwvo.pullwave.repoimpl.LoadRepoImpl;
import com.ovwvwvo.pullwave.utils.DataFormatUtil;
import com.ovwvwvo.pullwave.utils.StringUtil;

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
        return loadRepo.fetchData(NAME, param, DataFormatUtil.formatDate(new Date(),"yyyy-MM-dd"));
    }

}
