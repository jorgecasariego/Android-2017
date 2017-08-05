package jorgecasariego.ejemplosrecyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExample;
import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridHorizontalFragment extends BaseFragment {

    public static GridHorizontalFragment newInstance() {
        Bundle args = new Bundle();

        GridHorizontalFragment fragment = new GridHorizontalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return getGridLayoutManager();
    }

    private RecyclerView.LayoutManager getGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(),
                2,
                GridLayoutManager.HORIZONTAL,
                false
        );

        return gridLayoutManager;
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList) {
        return new AdapterExample(pictureList, R.layout.item_type_three);
    }
}
