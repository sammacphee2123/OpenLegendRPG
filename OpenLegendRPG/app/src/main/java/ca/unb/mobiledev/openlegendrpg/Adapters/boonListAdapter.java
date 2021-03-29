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

import ca.unb.mobiledev.openlegendrpg.Items.Boon;
import ca.unb.mobiledev.openlegendrpg.R;

public class boonListAdapter extends ListAdapter<Boon, boonListAdapter.boonViewHolder>{
    private static final String TAG = "RecyclerAdapter (Boon)";

    public boonListAdapter(@NonNull DiffUtil.ItemCallback<Boon> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public boonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.boons_row_item, parent, false);
        return new boonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull boonViewHolder holder, int position)
    {
        Boon boon = getItem(position);
        holder.boonNameTV.setText(boon.getName());
        holder.boonPowerLevelTV.setText(boon.getPowerLevel());
        holder.boonDescriptionTV.setText(boon.getDescription());
        holder.boonInvocationTV.setText(boon.getInvocationTime());
        holder.boonDurationTV.setText(boon.getDuration());
        holder.boonAttributesTV.setText(boon.getAttributes());
        holder.boonEffectTV.setText(boon.getEffect());

        boolean isExpanded = boon.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    public static class boonDiff extends DiffUtil.ItemCallback<Boon> {

        @Override
        public boolean areItemsTheSame(@NonNull Boon oldItem, @NonNull Boon newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Boon oldItem, @NonNull Boon newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    public class boonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView boonNameTV, boonPowerLevelTV, boonDescriptionTV, boonInvocationTV,
                boonDurationTV, boonAttributesTV, boonEffectTV;
        public LinearLayout expandableLayout;

        public boonViewHolder(@NonNull final View itemView) {
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
        public void onClick(View v) {
            Boon boon = getItem(getAdapterPosition());
            boon.setExpanded(!boon.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}