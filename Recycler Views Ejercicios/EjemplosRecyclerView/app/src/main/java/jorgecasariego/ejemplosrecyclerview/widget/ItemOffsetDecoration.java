package jorgecasariego.ejemplosrecyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jorgecasariego on 4/8/17.
 *
 * ItemDecoration una super clase que permite agregar un decorator a cada elemento o todos los
 * elementos de un RecyclerView mediante el método addItemDecoration(ItemDecoration decor),
 * existen muchas formas para crear un ItemDecoration lo más importante es que siempre hay que
 * heredar de RecyclerView.ItemDecoration.
 *
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int mItemOffset;

    public ItemOffsetDecoration(int itemOffset) {
        mItemOffset = itemOffset;
    }


    public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
        this(context.getResources().getDimensionPixelSize(itemOffsetId));
    }

    /**
     * Un ejemplo sencillo podría ser usando el método outRect.set(int left, int top, int right, int bottom)
     * para insertar algo similar a un padding o margin a cada vista de nuestro RecyclerView sin
     * necesidad de modificar los parámetros de un layout.
     *
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);

    }
}
