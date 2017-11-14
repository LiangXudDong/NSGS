package com.bwie.test.nsgshop.classfity.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.BaseFragment;
import com.bwie.test.nsgshop.base.MyBaseFragment;
import com.bwie.test.nsgshop.classfity.bean.DataleftBean;
import com.bwie.test.nsgshop.classfity.bean.DatarightBean;
import com.bwie.test.nsgshop.classfity.bean.Datebeanitem;
import com.bwie.test.nsgshop.classfity.model.MyAdapter_left;
import com.bwie.test.nsgshop.classfity.model.MyAdapter_right;
import com.bwie.test.nsgshop.classfity.present.PresenterUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/11/8.
 */

public class Classfity_fragemnt extends MyBaseFragment implements Iview, BaseFragment {
    TextView mtv;
    @BindView(R.id.type_rvleft)
    RecyclerView rv_left;
    @BindView(R.id.type_rvright)
    RecyclerView rv_right;
    Unbinder unbinder;
    PresenterUser pu = new PresenterUser(this);
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fclass_fragment_layout, null);
        unbinder = ButterKnife.bind(this, view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
        rv_left.setLayoutParams(params);
        //得到RecyclerView布局管理器
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        rv_left.setLayoutManager(leftLayoutManager);
        //得到RecyclerView布局管理器
        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        rv_right.setLayoutManager(rightLayoutManager);
        //获取后台数据，添加适配器
        pu.setliftadapter();
        pu.setitemadapter();
        return view;
    }


    public void getServerData(final DataleftBean dataleftBean, int a) {
        //适配器
        final MyAdapter_left myAdapter_left = new MyAdapter_left(getActivity(), dataleftBean.getDatas().getClass_list());
        rv_left.setAdapter(myAdapter_left);
        pu.setrightdapter(dataleftBean.getDatas().getClass_list().get(0).getGc_id());
        //第一个子条目显示其二级数据
        //子条目点击监听
        myAdapter_left.setRecycleViewItemClickListener(new MyAdapter_left.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {
                myAdapter_left.setTagPosition(position);
                myAdapter_left.notifyDataSetChanged();
                //请求二级数据
                pu.setrightdapter(dataleftBean.getDatas().getClass_list().get(position).getGc_id());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnGetServerDateLisnter {
        void getData(String string);
    }

    OnGetServerDateLisnter onGetServerDateLisnter;

    public void getServerData(Datebeanitem datebeanitem) {
        onGetServerDateLisnter.getData(datebeanitem.getDatas().toString());
    }

    //请求二级数据
    public void getServerTypeData(DatarightBean datarightBean) {

        MyAdapter_right myAdapter_right = new MyAdapter_right(getActivity(), datarightBean.getDatas().getClass_list());
        rv_right.setAdapter(myAdapter_right);

    }
}
