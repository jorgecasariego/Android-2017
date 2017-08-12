package jorgecasariego.ejemplosrecyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExampleTypes;
import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemTypesVerticalFragment extends BaseFragment {

    public static ItemTypesVerticalFragment newInstance() {
        Bundle args = new Bundle();

        ItemTypesVerticalFragment fragment = new ItemTypesVerticalFragment();
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
        return new GridLayoutManager(
                getActivity(),
                2,
                GridLayoutManager.VERTICAL,
                false
        );
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList) {
        return new AdapterExampleTypes(pictureList, R.layout.item_type_two);
    }
}
