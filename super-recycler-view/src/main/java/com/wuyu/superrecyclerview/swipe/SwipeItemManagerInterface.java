package com.wuyu.superrecyclerview.swipe;

import java.util.List;

public interface SwipeItemManagerInterface {

    void openItem(int position);

    void closeItem(int position);

    void closeAllExcept(com.wuyu.superrecyclerview.swipe.SwipeLayout layout);

    List<Integer> getOpenItems();

    List<com.wuyu.superrecyclerview.swipe.SwipeLayout> getOpenLayouts();

    void removeShownLayouts(com.wuyu.superrecyclerview.swipe.SwipeLayout layout);

    boolean isOpen(int position);

    Mode getMode();

    void setMode(Mode mode);


    enum Mode {
        Single, Multiple
    }
}
