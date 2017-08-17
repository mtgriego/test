package com.mtg.waglabstest.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtg.waglabstest.Objects.UserObject;
import com.mtg.waglabstest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Matt on 8/17/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<UserObject> userObjectArray;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView userGravitar;
        TextView userDisplayName;
        TextView userReputation;
        TextView userGoldCount;
        TextView userSilverCount;
        TextView userBronzeCount;

        public ViewHolder(View view){
            super(view);
            userGravitar = (ImageView) view.findViewById(R.id.user_gravitar);
            userDisplayName = (TextView) view.findViewById(R.id.user_display_name);
            userReputation = (TextView) view.findViewById(R.id.user_reputation);
            userGoldCount = (TextView) view.findViewById(R.id.user_gold_count);
            userSilverCount = (TextView) view.findViewById(R.id.user_silver_count);
            userBronzeCount = (TextView) view.findViewById(R.id.user_bronze_count);
        }
    }

    public UserAdapter(ArrayList<UserObject> users, Context context) {
        this.userObjectArray = users;
        this.mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_info_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final UserAdapter.ViewHolder holder, final int position) {
        final UserObject user = userObjectArray.get(holder.getAdapterPosition());
        Picasso.with(mContext)
                .load(user.getProfile_image())
                .placeholder(R.drawable.progress_animation)
                .fit()
                .into(holder.userGravitar);
        holder.userDisplayName.setText(user.getDisplay_name());
        holder.userReputation.setText(String.valueOf(user.getReputation()));
        holder.userGoldCount.setText(String.valueOf(user.getGoldCount()));
        holder.userSilverCount.setText(String.valueOf(user.getSilverCount()));
        holder.userBronzeCount.setText(String.valueOf(user.getBronzeCount()));
    }

    @Override
    public int getItemCount() {
        return userObjectArray.size();
    }
}
