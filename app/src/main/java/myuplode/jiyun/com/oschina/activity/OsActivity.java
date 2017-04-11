package myuplode.jiyun.com.oschina.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import myuplode.jiyun.com.oschina.R;
import myuplode.jiyun.com.oschina.fragment.DongTanFragment;
import myuplode.jiyun.com.oschina.fragment.FindFragment;
import myuplode.jiyun.com.oschina.fragment.MineFragment;
import myuplode.jiyun.com.oschina.fragment.ZongHeFragment;

/**
 * Created by Administrator on 2017/4/11.
 */

public class OsActivity extends FragmentActivity implements View.OnClickListener{
    private Button zonghe_btn,dongtan_btn,tianjia_btn,find_btn,mine_btn;
    private ZongHeFragment zongHeFragment;
    private DongTanFragment dongTanFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private FragmentTransaction transaction;
    private FrameLayout frameLayout;
    private FragmentManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oschinaactivity_view);
        init();
    }
    public void init(){
        zonghe_btn= (Button) findViewById(R.id.zonghe_btn);
        dongtan_btn= (Button) findViewById(R.id.dongtan_btn);
        tianjia_btn= (Button) findViewById(R.id.tianjia_btn);
        find_btn= (Button) findViewById(R.id.find_btn);
        mine_btn= (Button) findViewById(R.id.mine_btn);
        frameLayout= (FrameLayout) findViewById(R.id.oschina_fragment);

        zonghe_btn.setOnClickListener(this);
        dongtan_btn.setOnClickListener(this);
        tianjia_btn.setOnClickListener(this);
        find_btn.setOnClickListener(this);
        mine_btn.setOnClickListener(this);

        zongHeFragment=new ZongHeFragment();
        dongTanFragment=new DongTanFragment();
        findFragment=new FindFragment();
        mineFragment=new MineFragment();
        add_fragment();
    }

    public void add_fragment(){
        manager=getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.oschina_fragment,zongHeFragment);
        transaction.add(R.id.oschina_fragment,dongTanFragment);
        transaction.add(R.id.oschina_fragment,findFragment);
        transaction.add(R.id.oschina_fragment,mineFragment);
        transaction.replace(R.id.oschina_fragment,zongHeFragment);
        transaction.commit();
    }
    @Override
    public void onClick(View v) {
        Fragment fragment = manager.findFragmentById(R.id.oschina_fragment);
        switch (v.getId()){
            case R.id.zonghe_btn:
                transaction.hide(fragment);
                if(zongHeFragment==null){
                    zongHeFragment=new ZongHeFragment();
                }
                transaction.replace(R.id.oschina_fragment,zongHeFragment);
                break;
            case R.id.dongtan_btn:
                if(dongTanFragment==null){
                    dongTanFragment=new DongTanFragment();
                }
                transaction.replace(R.id.oschina_fragment,dongTanFragment);
                transaction.commit();
                break;
            case R.id.tianjia_btn:

                break;
            case R.id.find_btn:
                if(findFragment == null){
                    findFragment=new FindFragment();
                }
                transaction.replace(R.id.oschina_fragment,findFragment);
                break;
            case R.id.mine_btn:
                if(mineFragment==null){
                    mineFragment=new MineFragment();
                }
                transaction.replace(R.id.oschina_fragment,mineFragment);
                break;
        }
        //transaction.commit();
    }
}
