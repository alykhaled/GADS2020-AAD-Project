package com.alykhaled.gdgproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ExampleViewHolder> {
    private Context mContext;
    private List<SkillItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position, ArrayList<LearnerItem> t, ImageView image);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public SkillAdapter(Context context, List<SkillItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.skill_item, parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        SkillItem currentItem = mExampleList.get(position);
        String badgeUrl = currentItem.getBadgeUrl();
        String name = currentItem.getName();
        int hours = currentItem.getScore();
        String country = currentItem.getCountry();
        holder.mSKillName.setText(name);
        holder.mSkillScore.setText(Integer.toString(hours)+ " Learning Hours, " + country);
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mSKillName;
        public TextView mSkillScore;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mSKillName = itemView.findViewById(R.id.skillName);
            mSkillScore = itemView.findViewById(R.id.skillScore);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position,mExampleList);
                        }
                    }
                }
            });*/
        }
    }
}