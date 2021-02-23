package com.journaldev.navigationdrawer.banes;

import android.text.Layout;
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

public class BaneAdapter extends RecyclerView.Adapter<BaneAdapter.ViewHolder>
{
    private static final String TAG = "RecyclerAdapter (Bane)";
    List<Bane> banesList;

    public BaneAdapter(List<Bane> banesList)
    {
        this.banesList = banesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.banes_row_item, parent, false);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Bane bane = banesList.get(position);
        holder.baneNameTV.setText(bane.getName());
        holder.banePowerLevelTV.setText(bane.getPowerLevel());
        holder.baneDescriptionTV.setText(bane.getDescription());
        holder.baneDurationTV.setText(bane.getDuration());
        holder.baneAtkAttributesTV.setText(bane.getAtkAttributes());
        holder.baneAttackTV.setText(bane.getAttack());
        holder.baneEffectTV.setText(bane.getEffect());
        holder.baneSpecialTV.setText(bane.getSpecial());

        boolean isExpanded = banesList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount()
    {
        return banesList.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
    {
        private static final String TAG = "bane view holder";

        TextView baneNameTV, banePowerLevelTV, baneDescriptionTV, baneDurationTV,
                baneAtkAttributesTV, baneAttackTV, baneEffectTV, baneSpecialTV;
        LinearLayout expandableLayout;

        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            baneNameTV = itemView.findViewById(R.id.baneNameTV);
            banePowerLevelTV = itemView.findViewById(R.id.banePowerLevelTV);
            baneDescriptionTV = itemView.findViewById(R.id.baneDescriptionTV);
            baneDurationTV = itemView.findViewById(R.id.baneDurationTV);
            baneAtkAttributesTV = itemView.findViewById(R.id.baneAtkAttributesTV);
            baneAttackTV = itemView.findViewById(R.id.baneAttackTV);
            baneEffectTV = itemView.findViewById(R.id.baneEffectTV);
            baneSpecialTV = itemView.findViewById(R.id.baneSpecialTV);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            baneNameTV.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Bane bane = banesList.get(getAdapterPosition());
            bane.setExpanded(!bane.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}
