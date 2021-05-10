package com.example.saveqq;

import com.example.saveqq.bean.AccountBean;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private static final List<AccountBean> sAccountList = new ArrayList<>();

    /**
     * 根据id查找账户
     *
     * @param id
     * @return
     */
    private static AccountBean findAccount(String id) {
        for (AccountBean bean : sAccountList) {
            if (id.equals(bean.getId())) {
                return bean;
            }
        }
        return null;
    }

    /**
     * 根据用户id，检索账号是否存在
     *
     * @param id
     * @return
     */
    public static boolean isAccountExist(String id) {
        return findAccount(id) != null;
    }

    /**
     * 判断用户名和密码是否匹配
     *
     * @param id
     * @param password
     * @return
     */
    public static boolean checkPassword(String id, String password) {
        AccountBean accountBean = findAccount(id);
        if (accountBean == null) {
            return false;
        }
        return accountBean.getPassword().equals(password);
    }

    /**
     * 添加一个账户
     * @param id
     * @param password
     */
    public static void addAccount(String id, String password) {
        sAccountList.add(new AccountBean(id, password));
    }
}
