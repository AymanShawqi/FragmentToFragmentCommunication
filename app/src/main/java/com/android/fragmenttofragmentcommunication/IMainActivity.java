package com.android.fragmenttofragmentcommunication;

public interface IMainActivity {
    void setToolbarTitle(String fragmentTag);
    void inflateFragment(String fragmentTag,String message);
}
