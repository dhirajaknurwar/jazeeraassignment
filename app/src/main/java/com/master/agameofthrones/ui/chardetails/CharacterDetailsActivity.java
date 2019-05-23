package com.master.agameofthrones.ui.chardetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.master.agameofthrones.R;
import com.master.agameofthrones.model.CharacterDataModel;
import com.master.agameofthrones.ui.BaseActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;

public class CharacterDetailsActivity extends BaseActivity {

    public static void launchActivity(@NonNull Activity startingActivity, @NonNull CharacterDataModel characterDataModel) {
        Intent intent = new Intent(startingActivity, CharacterDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", characterDataModel);
        intent.putExtras(bundle);
        startingActivity.startActivity(intent);
    }


    private CharacterDataModel characterDataModel = null;

    @BindView(R.id.characterNameTv)
    AppCompatTextView characterNameTv;

    @BindView(R.id.characterBornDataTv)
    AppCompatTextView characterBornDataTv;


    @BindView(R.id.characterDiedDataTv)
    AppCompatTextView characterDiedDataTv;


    @BindView(R.id.characterAlisesDataTv)
    AppCompatTextView characterAlisesDataTv;


    @BindView(R.id.characterGenderDataTv)
    AppCompatTextView characterGenderDataTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        if (getIntent().getExtras() != null) {

            characterDataModel = (CharacterDataModel) getIntent().getExtras().getSerializable("data");

        }
        if (characterDataModel != null) {
            setActivityTitle(String.valueOf(characterDataModel.getName()+ " -- Details"));
            setDisplayHomeAsUpEnabled(true);
            setViewData(characterDataModel);
        }
    }

    private void setViewData(CharacterDataModel characterDataModel) {

        if (characterDataModel.getName() != null && characterDataModel.getName().length() > 0) {
            characterNameTv.setText(String.valueOf(characterDataModel.getName()));
        } else {
            characterNameTv.setText("NA");
        }


        if (characterDataModel.getGender() != null && characterDataModel.getGender().length() > 0) {
            characterGenderDataTv.setText(String.valueOf(characterDataModel.getGender()));
        } else {
            characterGenderDataTv.setText("NA");
        }


        if (characterDataModel.getBorn() != null && characterDataModel.getBorn().length() > 0) {
            characterBornDataTv.setText(String.valueOf(characterDataModel.getBorn()));
        } else {
            characterBornDataTv.setText("NA");
        }

        if (characterDataModel.getDied() != null && characterDataModel.getDied().length() > 0) {

            characterDiedDataTv.setText(String.valueOf(characterDataModel.getDied()));

        } else {

            characterDiedDataTv.setText("NA");
        }

        if (characterDataModel.getAliases() != null && characterDataModel.getAliases().size() > 0) {
            StringBuilder aliseStringBuilder = new StringBuilder();
            for (String alise : characterDataModel.getAliases()) {
                if (aliseStringBuilder.toString().length() > 0) {
                    aliseStringBuilder.append(",");
                    aliseStringBuilder.append(alise);
                } else {
                    aliseStringBuilder.append(alise);
                }
            }
            characterAlisesDataTv.setText(String.valueOf(aliseStringBuilder.toString()));
        } else {

            characterAlisesDataTv.setText("NA");

        }

    }


}
