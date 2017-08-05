package jorgecasariego.ejemplosrecyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExample;
import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinearHorizontalFragment extends BaseFragment {


    public static LinearHorizontalFragment newInstance() {

        Bundle args = new Bundle();

        LinearHorizontalFragment fragment = new LinearHorizontalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return getLinearLayoutManager();
    }

    private RecyclerView.LayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList) {
        return new AdapterExample(pictureList, R.layout.item_type_two);
    }
}
