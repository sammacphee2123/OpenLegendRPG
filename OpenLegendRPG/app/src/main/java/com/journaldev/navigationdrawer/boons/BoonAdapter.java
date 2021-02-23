package com.journaldev.navigationdrawer.boons;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.R;

public class BoonAdapter extends RecyclerView.Adapter<BoonAdapter.ViewHolder>
{
    private static final String TAG = "RecyclerAdapter (Boon)";
    List<Boon> boonsList;

    public BoonAdapter(List<Boon> boonsList)
    {
        this.boonsList = boonsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boons_row_item, parent, false);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Boon boon = boonsList.get(position);
        holder.boonNameTV.setText(boon.getName());
        holder.boonPowerLevelTV.setText(boon.getPowerLevel());
        holder.boonDescriptionTV.setText(boon.getDescription());
        holder.boonInvocationTV.setText(boon.getInvocationTime());
        holder.boonDurationTV.setText(boon.getDuration());
        holder.boonAttributesTV.setText(boon.getAttributes());
        holder.boonEffectTV.setText(boon.getEffect());

        boolean isExpanded = boonsList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount()
    {
        return boonsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private static final String TAG = "boon view holder";

        TextView boonNameTV, boonPowerLevelTV, boonDescriptionTV, boonInvocationTV,
                boonDurationTV, boonAttributesTV, boonEffectTV;
        LinearLayout expandableLayout;

        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            boonNameTV = itemView.findViewById(R.id.boonNameTV);
            boonPowerLevelTV = itemView.findViewById(R.id.boonPowerLevelTV);
            boonDescriptionTV = itemView.findViewById(R.id.boonDescriptionTV);
            boonInvocationTV = itemView.findViewById(R.id.boonInvocationTV);
            boonDurationTV = itemView.findViewById(R.id.boonDurationTV);
            boonAttributesTV = itemView.findViewById(R.id.boonAttributesTV);
            boonEffectTV = itemView.findViewById(R.id.boonEffectTV);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            boonNameTV.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Boon boon = boonsList.get(getAdapterPosition());
            boon.setExpanded(!boon.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}
