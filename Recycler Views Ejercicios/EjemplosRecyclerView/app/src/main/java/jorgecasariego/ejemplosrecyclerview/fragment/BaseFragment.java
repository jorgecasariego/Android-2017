package jorgecasariego.ejemplosrecyclerview.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExample;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExampleTypes;
import jorgecasariego.ejemplosrecyclerview.listener.RecyclerItemClickListener;
import jorgecasariego.ejemplosrecyclerview.model.Picture;
import jorgecasariego.ejemplosrecyclerview.presenter.PicturePresenter;
import jorgecasariego.ejemplosrecyclerview.view.PictureMvpView;
import jorgecasariego.ejemplosrecyclerview.widget.ItemOffsetDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment implements PictureMvpView, RecyclerItemClickListener{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerView.Adapter adapter;
    private PicturePresenter picturePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        progressBar = rootView.findViewById(R.id.progress_bar);

        picturePresenter = new PicturePresenter();
        picturePresenter.attachedView(this);
        setupRecyclerView();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        picturePresenter.onResume();
    }

    @Override
    public void setItems(ArrayList<Picture> pictureArrayList){
        adapter = getAdapter(pictureArrayList);
        recyclerView.setAdapter(adapter);

        if(adapter instanceof AdapterExample){
            ((AdapterExample) adapter).setRecyclerItemClickListener(this);
        } else if(adapter instanceof AdapterExampleTypes){
            ((AdapterExampleTypes) adapter).setRecyclerItemClickListener(this);
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override public void onDestroy() {
        picturePresenter.detachView();
        super.onDestroy();
    }

    public void onItemClickListener(int position) {
        picturePresenter.onItemSelected(position);
    }

    private void setupRecyclerView() {
        if(getLayoutManager() != null){
            recyclerView.setLayoutManager(getLayoutManager());
        }

        recyclerView.addItemDecoration(new ItemOffsetDecoration(recyclerView.getContext(), R.dimen.item_decoration));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected abstract int getLayout();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList);

}
