package com.bwie.test.nsgshop.home.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.test.nsgshop.MyWebView;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.home.bean.HomeBean;
import com.bwie.test.nsgshop.home.view.Item_aBanner;
import com.bwie.test.nsgshop.home.view.Item_b;
import com.bwie.test.nsgshop.home.view.Item_c;
import com.bwie.test.nsgshop.home.view.Item_d;
import com.bwie.test.nsgshop.home.view.Item_e;
import com.bwie.test.nsgshop.liebiao.view.ShangpinActivity;
import com.bwie.test.nsgshop.utils.GlideImaGlideImageLoader;
import com.youth.banner.BannerConfig;
import com.youth.banner.transformer.ZoomOutSlideTransformer;

import java.util.ArrayList;

/**
 * Created by admin on 2017/11/8.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    HomeBean.DataBean list;
    ArrayList<User> a5list;
    ArrayList<User> golist;
    ArrayList<User> zulist;
    Context context;
    ArrayList<String> slist;
    ArrayList<String> klist;
    private  enum  Item_Type{

        Typeone ,Typetwo,Typethree,Typefour

    }
    public HomeAdapter(HomeBean.DataBean list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if(viewType==Item_Type.Typeone.ordinal()) {
            View mView = LayoutInflater.from(context).inflate(R.layout.recycle_item_a, null);
            Item_aBanner viewHolder = new Item_aBanner(mView);
            return viewHolder;
        }else if(viewType==Item_Type.Typetwo.ordinal()) {
            View mView=LayoutInflater.from(context).inflate(R.layout.recycle_item_b,null);
            Item_b vb=new Item_b(mView);
            return vb;
        }else if(viewType==Item_Type.Typethree.ordinal()){
            View mView=LayoutInflater.from(context).inflate(R.layout.recycle_item_c,null);
            Item_c vb=new Item_c(mView);
            return vb;
        }else if(viewType==Item_Type.Typefour.ordinal()){
            View mView=LayoutInflater.from(context).inflate(R.layout.recycle_item_d,null);
            Item_d vb=new Item_d(mView);
            return vb;
        }else{
            View mView=LayoutInflater.from(context).inflate(R.layout.recycle_item_e,null);
            Item_e vb=new Item_e(mView);
            return vb;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof Item_aBanner){
            slist=new ArrayList();
            klist=new ArrayList<String>();
            for(int i=0;i<list.getAd1().size();i++){
                slist.add(list.getAd1().get(i).getImage());
                klist.add(list.getAd1().get(i).getTitle());
            }
            ((Item_aBanner) holder).mybanner.setImageLoader(new GlideImaGlideImageLoader());
            ((Item_aBanner) holder).mybanner.setBannerAnimation(ZoomOutSlideTransformer.class);
            ((Item_aBanner) holder).mybanner
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                    .setBannerTitles(klist);
            ((Item_aBanner) holder).mybanner.setImages(slist);
            ((Item_aBanner) holder).mybanner.start();

        }else if(holder instanceof Item_b){
            a5list=new ArrayList<User>();
            for (int i=0;i<list.getAd5().size();i++){
                a5list.add(new User(list.getAd5().get(i).getImage(),list.getAd5().get(i).getTitle(),list.getAd5().get(i).getAd_type_dynamic_data()));
            }
            Qiandao_adapter i2=new Qiandao_adapter(a5list,context);
            ((Item_b) holder).rc.setItemAnimator(new DefaultItemAnimator());
            ((Item_b) holder).rc.setLayoutManager(new GridLayoutManager(context,4));
            ((Item_b) holder).rc.setAdapter(i2);
            i2.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener()
            {

                @Override
                public void onItemClick(View view, int position)
                {
                    String data_url = a5list.get(position).getData_url();
                    Intent inten = new Intent(context, MyWebView.class);
                    inten.putExtra("url", data_url);
                    context.startActivity(inten);
                }

                @Override
                public void onItemLongClick(View view, int position)
                {
                    Toast.makeText(context, position + " long click",
                            Toast.LENGTH_SHORT).show();
               /* mAdapter.removeData(position);*/
                }
            });
        }else if(holder instanceof Item_d){
            golist=new ArrayList<User>();
            for (int i=0;i<list.getSubjects().size();i++){
                golist.add(new User(list.getSubjects().get(i).getDescImage(),list.getSubjects().get(i).getTitle(),list.getSubjects().get(i).getUrl()));
            }
            ((Item_d) holder).rc2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
            ((Item_d) holder).rc2.setAdapter(new Item2Adapter(golist,context));
        }else if(holder instanceof Item_c){
            View paomadeng_item = View.inflate(context,R.layout.paomadeng_item, null);
            ((Item_c) holder).vf.addView(paomadeng_item);
            ((Item_c) holder).countdownView.start(9000000);
        }else if(holder instanceof Item_e){
            zulist=new ArrayList<User>();
            for (int i=0;i<list.getDefaultGoodsList().size();i++){
                zulist.add(new User(list.getDefaultGoodsList().get(i).getGoods_img(),list.getDefaultGoodsList().get(i).getGoods_name(),list.getDefaultGoodsList().get(i).getGoods_img()));
            }
           /* ((Item_e) holder).tv.setText(zulist.get(position).getTitle());
            String url = zulist.get(position).getImg();
            Uri uri =  Uri.parse(url);
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(uri)
                    .setAutoPlayAnimations(true)
                    .build();
            ((Item_e) holder).img.setController(controller);*/
            ((Item_e) holder).rc3.setLayoutManager(new GridLayoutManager(context,2));
            Shangpingliebiao shangpingliebiao = new Shangpingliebiao(zulist, context);
            ((Item_e) holder).rc3.setAdapter(shangpingliebiao);
            shangpingliebiao.setOnItemClickLitener(new OnItemClickLitener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent inte=new Intent(context, ShangpinActivity.class);
                    context.startActivity(inte);
                }
                @Override
                public void onItemLongClick(View view, int position) {

                }
            });

        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return Item_Type.Typeone.ordinal();
        }else if (position == 1) {
            return Item_Type.Typetwo.ordinal();
        } else if (position == 2) {
            return Item_Type.Typethree.ordinal();
        }else if (position == 3) {
            return Item_Type.Typefour.ordinal();
        }
        return -1;
    }

    @Override
    public int getItemCount()
    {
        return 5;
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;

    }

}