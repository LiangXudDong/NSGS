package com.bwie.test.nsgshop.cart.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.nsgshop.MyApp;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.BaseFragment;
import com.bwie.test.nsgshop.base.MyBaseFragment;
import com.bwie.test.nsgshop.cart.bean.CartBean;
import com.bwie.test.nsgshop.cart.bean.Child;
import com.bwie.test.nsgshop.cart.bean.Group;
import com.bwie.test.nsgshop.cart.model.MyAdapter;
import com.bwie.test.nsgshop.cart.present.PresentUser;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/11/8.
 */

public class Cart_fragment extends MyBaseFragment implements Iview, BaseFragment {
    ArrayList<Group> groups = new ArrayList<>();//数据源集合
    MyAdapter adapter;//自定义baseExpandable适配器
    View view;
    @BindView(R.id.main_num)
    TextView num;
    @BindView(R.id.expand_able_view)
    ExpandableListView expandableListView;
    @BindView(R.id.main_check_all)
    CheckBox checkAll;
    @BindView(R.id.main_price)
    TextView price;
    /*@BindView(R.id.btn_delete)
    Button btnDel;*/
    @BindView(R.id.btn_buy)
    Button btnBuy;
    Unbinder unbinder;
    PresentUser pu = new PresentUser(this);
    private String uid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cart_fragment_layout, null);
        unbinder = ButterKnife.bind(this, view);
        String param = (String) SharedPreferencesUtils.getParam(getActivity(), "uid", "meiyou");
        if (param.equals("meiyou")) {
            Toast.makeText(getActivity(), "用户id获取错误", Toast.LENGTH_SHORT).show();
        } else {
            uid = param;
        }
        pu.getgclist(uid);//数据初始化
        expandableListView.setGroupIndicator(null);
        changeGoodsNum();//初始化当前商品个数。
        return view;
    }

    private void initlis() {

        /**
         * 自定义加减按钮回调
         * params: groupID:商铺id  childID:商品在当前商铺的id isADD:非加即减
         */
        adapter.setOnNumChangeListener(new MyAdapter.onNumChangeListener() {
            @Override
            public void onNumChange(int groupID, int childID, boolean isAdd) {
                //获得当前点击商品的数量
                int num = groups.get(groupID).getChildren().get(childID).getNum();
                if (isAdd){//加
                    //在数据源中该商品数量自增1
                    groups.get(groupID).getChildren().get(childID).setNum(++num);
                }else{//减
                    if (num == 1){//数量为1给出提示
                        Toast.makeText(getActivity(), "受不了了，不能再少了", Toast.LENGTH_SHORT).show();
                    }else{//在数据源中该商品数量自减1
                        groups.get(groupID).getChildren().get(childID).setNum(--num);
                    }
                }
                //更新UI
                adapter.notifyDataSetChanged();
                changeMoney();//更新价格显示
            }
        });
        //自定义商铺和商品多选框点击回调
        adapter.setmOnCheckChangeListener(new MyAdapter.onCheckChangeListener() {
            @Override
            public void onGroupClick(int groupID) {//组点击
                //将数据源置反，以保持同步
                groups.get(groupID).setCheck(!(groups.get(groupID).isCheck()));
                //获取当前选中状态
                boolean flag = groups.get(groupID).isCheck();
                //更新其下所有商品CheckBox
                for (int i = 0 ; i < groups.get(groupID).getChildren().size(); i++){
                    groups.get(groupID).getChildren().get(i).setCheck(flag);
                }
                //更新UI
                adapter.notifyDataSetChanged();
                //更新价格显示
                changeMoney();
            }

            @Override
            public void onChildClick(int groupID, int childID) {//商品点击
                //将数据源置反以保持同步
                groups.get(groupID).getChildren().get(childID).setCheck(!(groups.get(groupID).getChildren().get(childID).isCheck()));
                //判断该条目及所有兄弟条目是否全部选中，以及时更新商铺CheckBox
                int flag = 0;
                for (int i = 0 ; i < groups.get(groupID).getChildren().size() ; i++){
                    if (groups.get(groupID).getChildren().get(i).isCheck()){
                        flag++;
                    }
                }
                //如果该组下的选中数量与该集合长度相等，说明全部选中，更新组CheckBox
                if (flag == groups.get(groupID).getChildren().size()){
                    groups.get(groupID).setCheck(true);
                }else{
                    groups.get(groupID).setCheck(false);
                }
                //更新UI
                adapter.notifyDataSetChanged();
                //更新价格显示
                changeMoney();
            }
        });
        //删除按钮点击
       /* btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Group> toBeDeleteGroups = new ArrayList<Group>();// 待删除的组元素列表
                for (int i = 0; i < groups.size(); i++) {
                    Group group = groups.get(i);
                    if (group.isCheck()) {

                        toBeDeleteGroups.add(group);
                    }
                    List<Child> toBeDeleteChildren = new ArrayList<Child>();// 待删除的子元素列表
                    List<Child> childs = group.getChildren();
                    for (int j = 0; j < childs.size(); j++) {
                        if (childs.get(j).isCheck()) {
                            toBeDeleteChildren.add(childs.get(j));
                        }
                    }
                    childs.removeAll(toBeDeleteChildren);
                }
                groups.removeAll(toBeDeleteGroups);
                //更新UI
                adapter.notifyDataSetChanged();
                //更新当前商品数量显示
                changeGoodsNum();
                //更新当前价格显示
                changeMoney();

            }
        });*/
        //购买按钮，点击提示当前选中金额
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String money = price.getText().toString();
                Toast.makeText(getActivity(), "当前总金额:"+money, Toast.LENGTH_SHORT).show();
            }
        });
        //全选按钮，点击更新视图所有CheckBox
        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0 ; i< groups.size() ; i++){
                    groups.get(i).setCheck(checkAll.isChecked());
                    for (int j = 0 ; j < groups.get(i).getChildren().size() ; j ++){
                        groups.get(i).getChildren().get(j).setCheck(checkAll.isChecked());
                    }
                }
                //更新UI
                adapter.notifyDataSetChanged();
                //更新总价显示
                changeMoney();
            }
        });
        //自定义回调更新总价
        adapter.setmOnShouldChangeMoneyListener(new MyAdapter.onShouldChangeMoneyListener() {
            @Override
            public void onShouldChnageMoney() {
                //更新总价显示
                changeMoney();
            }
        });

    }


    //获得控件资源
    private void initView() {
    }

    private void changeGoodsNum(){
        int currentNum = 0;
        for (int i = 0 ; i < groups.size(); i++){
            for (int j = 0 ; j < groups.get(i).getChildren().size(); j++){
                currentNum++;
            }
        }
        num.setText(currentNum+"");
    }
    //更新总价
    private void changeMoney(){
        int money = 0;
        int allMoney = 0;//获得当前全部商品价格
        for (int i = 0 ; i < groups.size(); i++){
            for (int j = 0 ; j < groups.get(i).getChildren().size(); j++){
                if (groups.get(i).getChildren().get(j).isCheck()){
                    money += groups.get(i).getChildren().get(j).getNum() * groups.get(i).getChildren().get(j).getPrice();
                }
                allMoney += groups.get(i).getChildren().get(j).getNum() * groups.get(i).getChildren().get(j).getPrice();
            }
        }
        //当选中价格与全部价格相等，更新全选框
        if (money == allMoney){
            checkAll.setChecked(true);
        }else{
            checkAll.setChecked(false);
        }
        price.setText(money + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void gegclist(CartBean cartBean) {
        Log.d("MAIn", "gegclist: " + cartBean.getData().get(0).getList().get(0).getTitle() + "zhegeshi");
        List<CartBean.DataBean> list1 = cartBean.getData();
        groups.clear();
        for(int i=0;i<list1.size();i++){
            List<CartBean.DataBean.ListBean> list = list1.get(i).getList();
            ArrayList<Child> children = new ArrayList<>();
            for (int j=0;j<list.size();j++){
                int price = (int) list.get(j).getPrice();
                String[] split = list.get(j).getImages().split("\\|");
                children.add(new Child("店铺" + list1.get(i).getSellerName() + "的商品:" + list.get(j).getTitle(),split[0], 1, false,price));
            }
            groups.add(new Group(list1.get(i).getSellerName(),false,children));
        }
        /*for (CartBean.DataBean cd : list1) {
            List<CartBean.DataBean.ListBean> list = cd.getList();
            int j = 0;
            for (CartBean.DataBean.ListBean cdl : list) {
                children.add(new Child("店铺" + cd.getSellerName() + "的商品:" + cdl.getTitle(), "", 1, false, j+1));
            }

        }*/
        adapter = new MyAdapter(MyApp.getContext(),groups);
        expandableListView.setAdapter(adapter);
        for (int i = 0; i < groups.size(); i++) {
            expandableListView.expandGroup(i);// 初始化时，将ExpandableListView以展开的方式呈现
        }
        initlis();
    /*//初始化数据，设置适配器
    private void initData() {
        for (int i = 0; i < 5; i++) {
            ArrayList<Child> children = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                children.add(new Child("店铺" + i + "的商品:" + j, "", 2, false, j + 1));
            }
            groups.add(new Group("商铺:" + i, false, children));
        }

    }*/
    }
}
