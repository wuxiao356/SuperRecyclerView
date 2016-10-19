package com.wuyu.superrecyclerview.swipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wuyu.superrecyclerview.R;

import java.util.List;

public abstract class BaseSwipeAdapter<VH extends BaseSwipeAdapter.BaseSwipeableViewHolder> extends RecyclerView.Adapter<VH>
        implements com.wuyu.superrecyclerview.swipe.SwipeItemManagerInterface {

    protected com.wuyu.superrecyclerview.swipe.SwipeItemManagerImpl mItemManger = new com.wuyu.superrecyclerview.swipe.SwipeItemManagerImpl(this);

    /**
     * Don't forget to call super.onBindViewHolder when overriding
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(VH holder, int position) {
        mItemManger.updateConvertView(holder, position);
    }

    @Override
    public void openItem(int position) {
        mItemManger.openItem(position);
    }

    @Override
    public void closeItem(int position) {
        mItemManger.closeItem(position);
    }

    @Override
    public void closeAllExcept(com.wuyu.superrecyclerview.swipe.SwipeLayout layout) {
        mItemManger.closeAllExcept(layout);
    }

    @Override
    public List<Integer> getOpenItems() {
        return mItemManger.getOpenItems();
    }

    @Override
    public List<com.wuyu.superrecyclerview.swipe.SwipeLayout> getOpenLayouts() {
        return mItemManger.getOpenLayouts();
    }

    @Override
    public void removeShownLayouts(com.wuyu.superrecyclerview.swipe.SwipeLayout layout) {
        mItemManger.removeShownLayouts(layout);
    }

    @Override
    public boolean isOpen(int position) {
        return mItemManger.isOpen(position);
    }

    @Override
    public com.wuyu.superrecyclerview.swipe.SwipeItemManagerImpl.Mode getMode() {
        return mItemManger.getMode();
    }

    @Override
    public void setMode(com.wuyu.superrecyclerview.swipe.SwipeItemManagerImpl.Mode mode) {
        mItemManger.setMode(mode);
    }

    public static class BaseSwipeableViewHolder extends RecyclerView.ViewHolder {

        public com.wuyu.superrecyclerview.swipe.SwipeLayout swipeLayout      = null;
        public com.wuyu.superrecyclerview.swipe.SwipeLayout.OnLayout      onLayoutListener = null;
        public com.wuyu.superrecyclerview.swipe.SwipeLayout.SwipeListener swipeMemory      = null;
        public int                       position         = -1;

        public BaseSwipeableViewHolder(View itemView) {
            super(itemView);

            swipeLayout = (com.wuyu.superrecyclerview.swipe.SwipeLayout) itemView.findViewById(R.id.recyclerview_swipe);
        }
    }
}
