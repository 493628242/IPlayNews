package com.wangjiyuan.iplaynews.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wangjiyuan.iplaynews.R;
import com.wangjiyuan.iplaynews.activity.WebContentActivity;
import com.wangjiyuan.iplaynews.javabean.HeadInfo;
import com.wangjiyuan.iplaynews.javabean.InfoBean;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wjy on 2016/10/8.
 */
public class RecycleAdapter extends RecyclerView.Adapter {
    private Set<InfoBean> mSet;
    private Context mContext;
    private LayoutInflater inflater;
    public static final int VH2 = R.layout.item_type_2;
    public static final int VH3 = R.layout.itme_type_3;
    public static final int VH5 = R.layout.item_type_5;
    public static final String INFO_BUNDLE = "info_bundle";
    public static final String INFO = "info";

    public RecycleAdapter(Context context, Set<InfoBean> set) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mSet = set;
    }


    public InfoBean getItem(int position) {
        Iterator<InfoBean> iterator = mSet.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            InfoBean bean = iterator.next();
            if (count == position) {
                return bean;
            }
            count++;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {


        return mSet.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        View convertView = inflater.inflate(viewType, parent, false);
        switch (viewType) {
            case VH2:
                viewHolder = new ViewHolder_2(convertView);
                break;
            case VH3:
                viewHolder = new ViewHolder_3(convertView);
                break;
            default:
                viewHolder = new ViewHolder_5(convertView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final InfoBean infoBean = getItem(position);
        switch (getItemViewType(position)) {
            case VH2:

                ViewHolder_2 viewHolder2 = (ViewHolder_2) holder;
                viewHolder2.title.setText(infoBean.getLtitle());
//                Picasso.with(mContext).load(infoBean.getImgsrc().get(0)).
//                        centerCrop().resize(1000, 324).
//                        into(viewHolder2.img);
                viewHolder2.img.setImageURI(infoBean.getImgsrc().get(0));
                //界面跳转
                viewHolder2.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OpenWebView(infoBean);
                    }
                });
                break;
            case VH3:
                ViewHolder_3 viewHolder3 = (ViewHolder_3) holder;
                viewHolder3.title.setText(infoBean.getLtitle());
                if (infoBean.getImgsrc().size() == 1) {
                    viewHolder3.imgs[1].setImageURI(infoBean.getImgsrc().get(0));
                } else if (infoBean.getImgsrc().size() == 2) {
                    viewHolder3.imgs[0].setImageURI(infoBean.getImgsrc().get(0));
                    viewHolder3.imgs[1].setImageURI(infoBean.getImgsrc().get(1));
                } else {
                    viewHolder3.imgs[0].setImageURI(infoBean.getImgsrc().get(0));
                    viewHolder3.imgs[1].setImageURI(infoBean.getImgsrc().get(1));
                    viewHolder3.imgs[2].setImageURI(infoBean.getImgsrc().get(2));
                }
//                Picasso.with(mContext).load(infoBean.getImgsrc().get(0)).into(viewHolder3.img1);
//                Picasso.with(mContext).load(infoBean.getImgsrc().get(1)).into(viewHolder3.img2);
//                Picasso.with(mContext).load(infoBean.getImgsrc().get(2)).into(viewHolder3.img3);

                //界面跳转
                viewHolder3.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OpenWebView(infoBean);
                    }
                });
                break;
            case VH5:
                ViewHolder_5 viewHolder5 = (ViewHolder_5) holder;
                viewHolder5.title.setText(infoBean.getLtitle());
//                Log.e("info.length_vh5", infoBean.getImgsrc().size() + "");
//                Log.e("info.length_vh5", infoBean.getImgextra().toString());
                if (infoBean.getImgsrc().size() != 0) {
//                Picasso.with(mContext).load(infoBean.getImgsrc().get(0)).
//                        centerCrop().resize(270, 202)
//                        .into(viewHolder5.img);
                    viewHolder5.img.setImageURI(infoBean.getImgsrc().get(0));
                } else {
                    viewHolder5.img.setVisibility(View.GONE);
                }
                //如果评论数为0则隐藏评论

                if (infoBean.getReplyCount() == 0) {
                    viewHolder5.comment.setVisibility(View.INVISIBLE);
                } else {
                    viewHolder5.comment.setText("  " + infoBean.getReplyCount());
                }
                //界面跳转
                viewHolder5.item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OpenWebView(infoBean);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        InfoBean infoBean = getItem(position);
        switch (infoBean.getShowType()) {
            case 2:
                return VH2;
            case 3:
                return VH3;
            default:
                return VH5;
        }
    }

    //界面跳转的方法
    private void OpenWebView(InfoBean infoBean) {

        Intent intent = new Intent(mContext, WebContentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(INFO, infoBean);
        intent.putExtra(INFO_BUNDLE, bundle);
        mContext.startActivity(intent);
    }

    static class ViewHolder_5 extends RecyclerView.ViewHolder {
        TextView title, comment;
        SimpleDraweeView img;
        CardView item;

        public ViewHolder_5(View convertView) {
            super(convertView);
            item = (CardView) convertView.findViewById(R.id.item_news);
            title = (TextView) convertView.findViewById(R.id.title);
            comment = (TextView) convertView.findViewById(R.id.comment);
            img = (SimpleDraweeView) convertView.findViewById(R.id.img);
        }
    }

    static class ViewHolder_2 extends RecyclerView.ViewHolder {
        TextView title;
        SimpleDraweeView img;
        CardView item;

        public ViewHolder_2(View convertView) {
            super(convertView);
            item = (CardView) convertView.findViewById(R.id.item_news);
            title = (TextView) convertView.findViewById(R.id.title);
            img = (SimpleDraweeView) convertView.findViewById(R.id.img);
        }
    }

    static class ViewHolder_3 extends RecyclerView.ViewHolder {
        TextView title;
        SimpleDraweeView[] imgs = new SimpleDraweeView[3];
        CardView item;
        final int[] IMG_ID = {R.id.img1, R.id.img2, R.id.img3};

        public ViewHolder_3(View convertView) {
            super(convertView);
            item = (CardView) convertView.findViewById(R.id.item_news);
            title = (TextView) convertView.findViewById(R.id.title);
            for (int i = 0; i < imgs.length; ++i) {
                imgs[i] = (SimpleDraweeView) convertView.findViewById(IMG_ID[i]);
            }
        }
    }

}
