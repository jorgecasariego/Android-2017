package jorgecasariego.ejemplosrecyclerview.view;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public interface PictureMvpView {
    void setItems(ArrayList<Picture> pictureList);

    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
