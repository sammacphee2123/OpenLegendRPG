package ca.unb.mobiledev.openlegendrpg.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import ca.unb.mobiledev.openlegendrpg.Items.Feat;
import ca.unb.mobiledev.openlegendrpg.R;

public class featListAdapter extends ListAdapter<Feat, featListAdapter.featViewHolder>{
    private static final String TAG = "RecyclerAdapter (Feat)";

    public featListAdapter(@NonNull DiffUtil.ItemCallback<Feat> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public featViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.feats_row_item, parent, false);
        return new featViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull featViewHolder holder, int position)
    {
        Feat feat = getItem(position);
        holder.featNameTV.setText(feat.getName());
        holder.featCostTV.setText(feat.getCost());
        holder.featPreReqTV.setText(feat.getPreReq());
        holder.featDescTV.setText(feat.getDesc());
        holder.featEffectTV.setText(feat.getEffect());

        boolean isExpanded = feat.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    public static class featDiff extends DiffUtil.ItemCallback<Feat> {

        @Override
        public boolean areItemsTheSame(@NonNull Feat oldItem, @NonNull Feat newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Feat oldItem, @NonNull Feat newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    public class featViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView featNameTV, featCostTV, featPreReqTV, featDescTV, featEffectTV;
        public LinearLayout expandableLayout;

        public featViewHolder(@NonNull final View itemView) {
            super(itemView);

            featNameTV = itemView.findViewById(R.id.featNameTV);
            featCostTV = itemView.findViewById(R.id.featCostTV);
            featPreReqTV = itemView.findViewById(R.id.featPreReqTV);
            featDescTV = itemView.findViewById(R.id.featDescTV);
            featEffectTV = itemView.findViewById(R.id.featEffectTV);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            featNameTV.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Feat feat = getItem(getAdapterPosition());
            feat.setExpanded(!feat.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}
