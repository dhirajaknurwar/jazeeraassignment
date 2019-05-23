package com.master.agameofthrones.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.master.agameofthrones.R;
import com.master.agameofthrones.model.BooksDataModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeBooksDataAdapter extends RecyclerView.Adapter<HomeBooksDataAdapter.NewsViewHolder> {

    public interface Callbacks {
        public void onBookDataClick(@NonNull BooksDataModel dataModel);
    }

    private Callbacks mCallbacks;
    private List<BooksDataModel> dataModelList;

    public HomeBooksDataAdapter(List<BooksDataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_book_row, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        final BooksDataModel dataModel = dataModelList.get(position);

        holder.booksNameTv.setText(String.valueOf(dataModel.getName()));

        if (dataModel.getAuthors() != null && dataModel.getAuthors().size() > 0) {
            StringBuilder authorStringBuilder = new StringBuilder();
            for (String author : dataModel.getAuthors()) {

                if (authorStringBuilder.toString().length() > 0) {
                    authorStringBuilder.append(",");
                    authorStringBuilder.append(author);
                } else {
                    authorStringBuilder.append(author);
                }

            }
            holder.booksAuthorsTv.setText(authorStringBuilder.toString());
        }

        holder.booksPublisherTv.setText(String.valueOf(dataModel.getPublisher()));
        holder.booksReleasedOnTv.setText(String.valueOf("Released On: " + dataModel.getReleased()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallbacks != null)
                    mCallbacks.onBookDataClick(dataModel);
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

        @BindView(R.id.booksNameTv)
        AppCompatTextView booksNameTv;

        @BindView(R.id.booksAuthorsTv)
        AppCompatTextView booksAuthorsTv;

        @BindView(R.id.booksPublisherTv)
        AppCompatTextView booksPublisherTv;

        @BindView(R.id.booksReleasedOnTv)
        AppCompatTextView booksReleasedOnTv;

        @BindView(R.id.bookCardView)
        CardView bookCardView;


        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
