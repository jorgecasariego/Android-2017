package jorgecasariego.ejemplosrecyclerview.presenter;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public interface Presenter<V> {
    void attachedView(V view);

    void detachView();

    void onResume();

    void onItemSelected(int position);
}
