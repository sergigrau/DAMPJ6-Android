package edu.fje.dam2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa scrolling infinit (paginació automàtica) amb RecyclerView.
 * @author sergi.grau@fje.edu
 * @version 1.0, 1/11/2026
 */
public class M39_ScrollingInfinitActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private InfiniteAdapter adapter;
    private List<String> itemList;
    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m39_scrolling_infinit);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        itemList = new ArrayList<>();
        loadInitialData();

        adapter = new InfiniteAdapter(itemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == itemList.size() - 1) {
                        loadMoreData();
                    }
                }
            }
        });
    }

    private void loadInitialData() {
        for (int i = 1; i <= 20; i++) {
            itemList.add("Element nombre " + i);
        }
    }

    private void loadMoreData() {
        isLoading = true;
        progressBar.setVisibility(View.VISIBLE);

        // Simulació de càrrega asíncrona (per exemple, petició de xarxa o BD)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            int start = itemList.size();
            for (int i = 1; i <= 10; i++) {
                itemList.add("Element nombre " + (start + i));
            }
            adapter.notifyItemRangeInserted(start, 10);
            isLoading = false;
        }, 1500);
    }

    private static class InfiniteAdapter extends RecyclerView.Adapter<InfiniteAdapter.ViewHolder> {
        private final List<String> data;

        public InfiniteAdapter(List<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.m39_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.itemTextView);
            }
        }
    }
}
