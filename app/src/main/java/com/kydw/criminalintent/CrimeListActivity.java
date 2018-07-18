package com.kydw.criminalintent;

import android.support.v4.app.Fragment;

/**
 * @author liuqian
 * @date 2018/7/17 9:36
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
