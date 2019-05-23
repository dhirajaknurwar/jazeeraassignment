package com.master.agameofthrones.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.master.agameofthrones.R;
import com.master.agameofthrones.model.BooksDataModel;
import com.master.agameofthrones.ui.BaseActivity;
import com.master.agameofthrones.ui.character.CharactersActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements DataContract.View, HomeBooksDataAdapter.Callbacks {


    @BindView(R.id.home_screen_recyclerView)
    RecyclerView mHomeBooksRecyclerView;

    @BindView(R.id.api_progress)
    ProgressBar api_progress;

    @Inject
    DataContract.Presenter mPresenter;

    private List<BooksDataModel> dataModelArrayList = new ArrayList<>();
    private HomeBooksDataAdapter mHomeBooksDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);

        mHomeBooksDataAdapter = new HomeBooksDataAdapter(dataModelArrayList);
        mHomeBooksDataAdapter.setCallbacks(this);
        mHomeBooksRecyclerView.setAdapter(mHomeBooksDataAdapter);

        mHomeBooksRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        mPresenter.loadData(true);
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

    private void showData(boolean b) {
        if (b) {
            api_progress.setVisibility(View.GONE);
        }
        int recyclerViewVisibility = b ? View.VISIBLE : View.GONE;
        mHomeBooksRecyclerView.setVisibility(recyclerViewVisibility);
    }


    @Override
    public void showLoading(boolean active) {

        if (active) {
            api_progress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showData(@NonNull List<BooksDataModel> homeBooksDataModel) {

        dataModelArrayList.addAll(homeBooksDataModel);
        mHomeBooksDataAdapter.notifyDataSetChanged();
        showData(true);

    }

    @Override
    public void showNoData() {
        showData(false);
    }

    @Override
    public void onBookDataClick(@NonNull BooksDataModel dataModel) {
        CharactersActivity.launchActivity(MainActivity.this,dataModel.getCharacters(),dataModel.getName());

    }
}
