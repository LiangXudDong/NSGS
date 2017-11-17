package com.bwie.test.nsgshop.xiangqing.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.MyBaseActivity;
import com.bwie.test.nsgshop.common.PlayerManager;
import com.bwie.test.nsgshop.liebiao.bean.AnyEventye;
import com.bwie.test.nsgshop.utils.GlideImaGlideImageLoader;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;
import com.bwie.test.nsgshop.widget.media.IjkVideoView;
import com.bwie.test.nsgshop.xiangqing.bean.Shangpinlx;
import com.bwie.test.nsgshop.xiangqing.presenter.Presentuser;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangqingActivity extends MyBaseActivity implements Iview, PlayerManager.PlayerStateListener {
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    @BindView(R.id.mybanner)
    Banner mbanner;
    @BindView(R.id.title)
    TextView tv;
    @BindView(R.id.yuanjia)
    TextView yuanjia;
    @BindView(R.id.xianjia)
    TextView xianjia;
    @BindView(R.id.jiarugouwuche)
    Button jiarugouwuche;
    @BindView(R.id.goumai)
    Button goumai;
    private Presentuser pu = new Presentuser(this);
    ArrayList<String> slist;
    private PlayerManager player;
    private String pid;
    private String uid;
    private String sellerid;
    private String url5 = "http://mp4.vjshi.com/2013-05-28/2013052815051372.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
        initPlayer();
        EventBus.getDefault().register(XiangqingActivity.this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getAnyEventye(AnyEventye userEvent) {
        String pid = userEvent.getPid();
        Log.d("MAIn", "getAnyEventye: " + pid);
        pu.setAdapter(pid);

    }

    public void setAdapter(Shangpinlx shangpinx) {
        Log.d("MAIn", "setAdapter: ");
        tv.setText(shangpinx.getData().getSubhead());
        String images = shangpinx.getData().getImages();
        String[] split = images.split("\\|");
        slist = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            slist.add(split[i]);
        }
        mbanner.setImageLoader(new GlideImaGlideImageLoader());
        mbanner.setImages(slist);
        mbanner.start();
        xianjia.setText("￥" + shangpinx.getData().getPrice());
        yuanjia.setText("原价：￥" + shangpinx.getData().getBargainPrice() + "");
        pid=shangpinx.getData().getPid();
        sellerid=shangpinx.getData().getSellerid();
    }

    private void initPlayer() {
        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url5);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }


    @Override
    public void onComplete() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {
    }

    @OnClick({R.id.jiarugouwuche, R.id.goumai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiarugouwuche:
                String param = (String) SharedPreferencesUtils.getParam(XiangqingActivity.this, "uid", "meiyou");
                if(param.equals("meiyou")){
                    Toast.makeText(this, "用户id获取错误", Toast.LENGTH_SHORT).show();
                }else{
                    uid=param;
                }
                pu.isadd(uid,pid,sellerid);
                break;
            case R.id.goumai:
                break;
        }
    }
    public void addsf(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void bad(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

