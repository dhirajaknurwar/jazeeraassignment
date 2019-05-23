package com.master.agameofthrones.ui.character;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.master.agameofthrones.R;
import com.master.agameofthrones.model.CharacterDataModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterDataAdapter extends RecyclerView.Adapter<CharacterDataAdapter.NewsViewHolder> {

    public interface Callbacks {
        public void onCharacterDataClick(@NonNull CharacterDataModel dataModel);
    }

    private Callbacks mCallbacks;
    private List<CharacterDataModel> dataModelList;

    public CharacterDataAdapter(List<CharacterDataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_character_row, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final CharacterDataModel dataModel = dataModelList.get(position);

        holder.characterNameTv.setText(String.valueOf(dataModel.getName()));

        if (dataModel.getName() != null && dataModel.getName().length() > 0) {
            holder.characterNameTv.setText(String.valueOf(dataModel.getName()));
        } else {
            holder.characterNameTv.setText("NA");
        }

        if (dataModel.getAliases() != null && dataModel.getAliases().size() > 0) {
            StringBuilder aliseStringBuilder = new StringBuilder();
            for (String alise : dataModel.getAliases()) {

                if (aliseStringBuilder.toString().length() > 0) {
                    aliseStringBuilder.append(",");
                    aliseStringBuilder.append(alise);
                } else {
                    aliseStringBuilder.append(alise);
                }

            }
            holder.characterAlisesTv.setText(String.valueOf("Aliases: \n" + aliseStringBuilder.toString()));

        } else {
            holder.characterAlisesTv.setText(String.valueOf("Aliases: NA"));

        }



        if (dataModel.getGender() != null && dataModel.getGender().length()>0) {

            holder.characterGenderTv.setText(String.valueOf("Gender: " + dataModel.getGender()));
        } else {
            holder.characterGenderTv.setText(String.valueOf("Gender: NA"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallbacks != null)
                    mCallbacks.onCharacterDataClick(dataModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataModelList != null ? dataModelList.size() : 0);
    }

    public void setCallbacks(Callbacks callbacks) {
        this.mCallbacks = callbacks;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.characterNameTv)
        AppCompatTextView characterNameTv;

        @BindView(R.id.characterGenderTv)
        AppCompatTextView characterGenderTv;

        @BindView(R.id.characterAlisesTv)
        AppCompatTextView characterAlisesTv;

        @BindView(R.id.characterCardView)
        CardView characterCardView;


        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
