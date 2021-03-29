package ca.unb.mobiledev.openlegendrpg.Adapters;

import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import ca.unb.mobiledev.openlegendrpg.Items.Character;
import ca.unb.mobiledev.openlegendrpg.R;
import ca.unb.mobiledev.openlegendrpg.UI.characterViewModel;
import ca.unb.mobiledev.openlegendrpg.dao.characterDao;

public class characterListAdapter extends ListAdapter<Character, characterListAdapter.characterViewHolder>
{
    private static final String TAG = "RecyclerAdapter (Character)";
    private characterViewModel mCharacterViewModel;
    private characterDao characterDao;
    private Button deleteCharButton;
    private Button editCHarButton;

    public characterListAdapter(@NonNull DiffUtil.ItemCallback<Character> diffCallback)
    {
        super(diffCallback);
    }

    @NonNull
    @Override
    public characterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Log.i(TAG, "onCreateViewHolder");

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.character_row_item, parent, false);
        return new characterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull characterViewHolder holder, int position)
    {
        Character character = getItem(position);
        holder.charNameTV.setText(character.getCharName());
        holder.deleteCharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String charName = character.getCharName();
                mCharacterViewModel.deleteCharacter(charName); //this terminates the app because of a null object reference
            }
        });

        holder.editCharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //launch edit activity
            }
        });
    }


    public static class characterDiff extends DiffUtil.ItemCallback<Character>
    {
        @Override
        public boolean areItemsTheSame(@NonNull Character oldChar, @NonNull Character newChar)
        {
            return oldChar == newChar;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Character oldChar, @NonNull Character newChar)
        {
            return oldChar.getCharName().equals(newChar.getCharName());
        }
    }

    public class characterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView charNameTV;
        public Button editCharButton, deleteCharButton;

        public characterViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            charNameTV = itemView.findViewById(R.id.charNameTV);

            //deal with these two buttons after add char functionality works
            editCharButton = itemView.findViewById(R.id.editCharButton);
            deleteCharButton = itemView.findViewById(R.id.deleteCharButton);

        }

        @Override
        public void onClick(View v)
        {

        }
    }
}























