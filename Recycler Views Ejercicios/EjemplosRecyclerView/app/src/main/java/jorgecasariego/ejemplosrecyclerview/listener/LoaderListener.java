package jorgecasariego.ejemplosrecyclerview.listener;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.model.Picture;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public interface LoaderListener {
    void onFinished(ArrayList<Picture> pictureList);
}
