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

import ca.unb.mobiledev.openlegendrpg.Items.Bane;
import ca.unb.mobiledev.openlegendrpg.R;

public class baneListAdapter extends ListAdapter<Bane, baneListAdapter.baneViewHolder>{
    private static final String TAG = "RecyclerAdapter (Boon)";

    public baneListAdapter(@NonNull DiffUtil.ItemCallback<Bane> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public baneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder: ");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.banes_row_item, parent, false);
        return new baneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull baneViewHolder holder, int position)
    {
        Bane bane = getItem(position);
        holder.baneNameTV.setText(bane.getName());
        holder.banePowerLevelTV.setText(bane.getPowerLevel());
        holder.baneDescriptionTV.setText(bane.getDescription());
        holder.baneDurationTV.setText(bane.getDuration());
        holder.baneAttackTV.setText(bane.getAttack());
        holder.baneAttributesTV.setText(bane.getAtkAttributes());
        holder.baneEffectTV.setText(bane.getEffect());

        boolean isExpanded = bane.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    public static class baneDiff extends DiffUtil.ItemCallback<Bane> {

        @Override
        public boolean areItemsTheSame(@NonNull Bane oldItem, @NonNull Bane newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bane oldItem, @NonNull Bane newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    public class baneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView baneNameTV, banePowerLevelTV, baneDescriptionTV, baneDurationTV, baneAttributesTV, baneAttackTV, baneEffectTV;
        public LinearLayout expandableLayout;

        public baneViewHolder(@NonNull final View itemView) {
            super(itemView);

            baneNameTV = itemView.findViewById(R.id.baneNameTV);
            banePowerLevelTV = itemView.findViewById(R.id.banePowerLevelTV);
            baneDescriptionTV = itemView.findViewById(R.id.baneDescriptionTV);
            baneDurationTV = itemView.findViewById(R.id.baneDurationTV);
            baneAttributesTV = itemView.findViewById(R.id.baneAtkAttributesTV);
            baneAttackTV = itemView.findViewById(R.id.baneAttackTV);
            baneEffectTV = itemView.findViewById(R.id.baneEffectTV);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            baneNameTV.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Bane bane = getItem(getAdapterPosition());
            bane.setExpanded(!bane.isExpanded());
            notifyItemChanged(getAdapterPosition());
        }
    }
}