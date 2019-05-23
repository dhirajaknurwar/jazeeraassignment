package com.master.agameofthrones.ui.character;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.master.agameofthrones.R;
import com.master.agameofthrones.model.CharacterDataModel;
import com.master.agameofthrones.ui.BaseActivity;
import com.master.agameofthrones.ui.chardetails.CharacterDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class CharactersActivity extends BaseActivity implements CharacterDataContract.View, CharacterDataAdapter.Callbacks {

    public static void launchActivity(@NonNull Activity startingActivity, @NonNull List<String> name,String author) {
        Intent intent = new Intent(startingActivity, CharactersActivity.class);
        intent.putStringArrayListExtra("data", (ArrayList<String>) name);
        intent.putExtra("author", author);
        startingActivity.startActivity(intent);
    }


    @BindView(R.id.home_screen_recyclerView)
    RecyclerView mCharacterRecyclerView;

    @BindView(R.id.api_progress)
    ProgressBar api_progress;

    @Inject
    CharacterDataContract.Presenter mPresenter;

    private List<CharacterDataModel> dataModelArrayList = new ArrayList<>();
    private CharacterDataAdapter mCharacterDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);
        setActivityTitle(String.valueOf(getIntent().getStringExtra("author")+" --  Characters"));
        setDisplayHomeAsUpEnabled(true);
        mCharacterDataAdapter = new CharacterDataAdapter(dataModelArrayList);
        mCharacterDataAdapter.setCallbacks(this);
        mCharacterRecyclerView.setAdapter(mCharacterDataAdapter);

        mCharacterRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        mPresenter.loadData(true,getIntent().getStringArrayListExtra("data"));
        mPresenter.takeView(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }



    @Override
    public void showData(@NonNull List<CharacterDataModel> characterDataModelList) {

        dataModelArrayList.addAll(characterDataModelList);
        mCharacterDataAdapter.notifyDataSetChanged();
        showData(true);


    }

    private void showData(boolean b) {
        if (b) {
            api_progress.setVisibility(View.GONE);
        }
        int recyclerViewVisibility = b ? View.VISIBLE : View.GONE;
        mCharacterRecyclerView.setVisibility(recyclerViewVisibility);
    }



    @Override
    public void showNoData() {
        showData(false);
    }

    @Override
    public void showLoading(boolean active) {

        if (active) {
            api_progress.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onCharacterDataClick(@NonNull CharacterDataModel dataModel) {

        CharacterDetailsActivity.launchActivity(CharactersActivity.this,dataModel);

    }
}
