package com.alykhaled.gdgproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<LearnerAdapter.ExampleViewHolder> {
    private Context mContext;
    private List<LearnerItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position, ArrayList<LearnerItem> t, ImageView image);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public LearnerAdapter(Context context, List<LearnerItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.learning_item, parent, false);
        return new ExampleViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        LearnerItem currentItem = mExampleList.get(position);
        String badgeUrl = currentItem.getBadgeUrl();
        String name = currentItem.getName();
        int hours = currentItem.getHours();
        String country = currentItem.getCountry();
        holder.mLearnerName.setText(name);
        holder.mLearnerHours.setText(Integer.toString(hours)+ " Learning Hours, " + country);
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mLearnerName;
        public TextView mLearnerHours;
        public ExampleViewHolder(View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.learnerName);
            mLearnerHours = itemView.findViewById(R.id.learnerHours);

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