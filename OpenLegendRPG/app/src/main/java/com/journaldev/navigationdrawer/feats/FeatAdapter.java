package com.journaldev.navigationdrawer.feats;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.unb.mobiledev.openlegendrpg.R;

public class FeatAdapter extends RecyclerView.Adapter<FeatAdapter.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    List<Feat> featsList;

    public FeatAdapter(List<Feat> featsList){
        this.featsList = featsList;
    }
    @NonNull
    @Override
    public FeatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatAdapter.ViewHolder holder, int position) {
       Feat feat = featsList.get(position);
       holder.nameTV.setText(feat.getName());
       holder.costTV.setText(feat.getCost());
       holder.preReqTV.setText(feat.getPreReq());
       holder.descTV.setText(feat.getDesc());
       holder.effectTV.setText(feat.getEffect());
       holder.specialTV.setText(feat.getSpecial());

       boolean isExpanded = featsList.get(position).isExpanded();
       holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return featsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private static final String TAG = "feat view holder";

        TextView nameTV, costTV, preReqTV, descTV, effectTV, specialTV;
        LinearLayout expandableLayout;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTV);
            costTV = itemView.findViewById(R.id.costTV);
            preReqTV = itemView.findViewById(R.id.preReqTV);
            descTV = itemView.findViewById(R.id.descTV);
            effectTV = itemView.findViewById(R.id.effectTV);
            specialTV = itemView.findViewById(R.id.specialTV);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            nameTV.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Feat feat = featsList.get(getAdapterPosition());
            feat.setExpanded(!feat.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}

