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
public class GridSpanSizeVerticalFragment extends BaseFragment {

    public static GridSpanSizeVerticalFragment newInstance() {
        
        Bundle args = new Bundle();
        
        GridSpanSizeVerticalFragment fragment = new GridSpanSizeVerticalFragment();
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
                GridLayoutManager.VERTICAL,
                false
        );

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //Calculamos la extension(span) que tendra cada vista dentro del RV
                // position = 0 --> extension 2
                // position = 1 --> extension 1
                // position = 2 --> extension 1
                // position = 3 --> extension 2
                return (position % 3 == 0 ? 2 : 1);
            }
        });

        return gridLayoutManager;
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList) {
        return new AdapterExample(pictureList, R.layout.item_type_two);
    }
}
