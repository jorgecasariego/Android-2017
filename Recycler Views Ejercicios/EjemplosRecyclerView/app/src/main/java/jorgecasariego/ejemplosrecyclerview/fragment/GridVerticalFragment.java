package jorgecasariego.ejemplosrecyclerview.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.R;
import jorgecasariego.ejemplosrecyclerview.adapter.AdapterExample;
import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 *
 * ¿Cuales son los pasos para cargar las fotos en el fragment?
 *  1. Se inicializa el fragment en BaseFragment
 *  2. Una vez cargada la vista del BaseFragment se inicializa el Presentador (PicturePresenter)
 *  3. El constructor del Picture presenter inicializa el interactor (el cual es el proveedor de los
 *     datos que queremos mostrar)
 *  4. En el metodo onResume() del presenter se llama al metodo loadItems() del interactor el cual
 *     simula una llamada a un servidor remoto o carga en una BD. Una vez terminada la llamada se llama
 *     al metodo onFinished() el cual vuelve al Presenter y es aquí donde se hace la llamada al metodo
 *     setItems() el cual se encuentra implementado en el BaseFragment y ésta de vuelta envía la lista
 *     ya cargada a los distintos fragments (en este caso recibimos en el metodo getAdapter() de este
 *     fragment la lista ya cargada
 *
 */
public class GridVerticalFragment extends BaseFragment {

    public static GridVerticalFragment newInstance() {
        return new GridVerticalFragment();
    }

    @Override protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override protected RecyclerView.LayoutManager getLayoutManager() {
        return getGridLayoutManager();
    }


    @Override protected RecyclerView.Adapter getAdapter(ArrayList<Picture> pictureList) {
        return new AdapterExample(pictureList,R.layout.item_type_two);
    }


    private GridLayoutManager getGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(),
                2,
                GridLayoutManager.VERTICAL,
                false);

        return gridLayoutManager;
    }
}