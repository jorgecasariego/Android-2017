package jorgecasariego.ejemplosrecyclerview.presenter;

import java.util.ArrayList;

import jorgecasariego.ejemplosrecyclerview.interactor.PictureInteractor;
import jorgecasariego.ejemplosrecyclerview.listener.LoaderListener;
import jorgecasariego.ejemplosrecyclerview.model.Picture;
import jorgecasariego.ejemplosrecyclerview.view.PictureMvpView;

/**
 * Created by jorgecasariego on 4/8/17.
 */

public class PicturePresenter implements Presenter<PictureMvpView>, LoaderListener {

    private PictureMvpView pictureMvpView;
    private PictureInteractor pictureInteractor;

    public PicturePresenter() {
        pictureInteractor = new PictureInteractor();
    }

    @Override
    public void attachedView(PictureMvpView view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        pictureMvpView = view;
    }

    @Override
    public void detachView() {
        pictureMvpView = null;
    }

    @Override
    public void onResume() {
        pictureMvpView.showProgress();
        pictureInteractor.loadItems(this);
    }

    @Override
    public void onItemSelected(int position) {
        pictureMvpView.showMessage(Integer.toString(position));
    }

    @Override
    public void onFinished(ArrayList<Picture> pictureList) {
        pictureMvpView.setItems(pictureList);
        pictureMvpView.hideProgress();
    }
}
