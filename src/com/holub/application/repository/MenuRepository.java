package com.holub.application.repository;

import com.holub.application.setting.SetUp;

public class MenuRepository {
    private static MenuRepository instance;
    private SetUp setup = SetUp.getInstance();

    private MenuRepository() {

    }

    public static synchronized MenuRepository getInstance() {
        if (instance == null) {
            instance = new MenuRepository();
        }
        return instance;
    }

    public String selectMenuAll() {
        return setup.selectMenuAll();
    }

}
