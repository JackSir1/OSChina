package myuplode.jiyun.com.oschina.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myuplode.jiyun.com.oschina.R;

/**
 * Created by Administrator on 2017/4/11.
 */

public class ZongHeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.zonghe_view, null);
        return inflate;
    }
}
