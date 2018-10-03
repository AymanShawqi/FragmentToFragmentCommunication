package com.android.fragmenttofragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    private static final String TAG = "MainActivity";
    //widget
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarTitle=findViewById(R.id.toolbar_title);
       // if(savedInstanceState==null){
            init();
       //}
    }

    private void init(){
        SelectorFragment fragment=new SelectorFragment();
        doFragmentTransaction(fragment,getString(R.string.fragment_selector),false,"");
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String message){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        if (!message.isEmpty()){
            Bundle bundle=new Bundle();
            bundle.putString(getString(R.string.intent_message),message);
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.main_container,fragment,tag);
        if(addToBackStack){
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void setToolbarTitle(String fragmentTag) {
        toolbarTitle.setText(fragmentTag);
    }

    @Override
    public void inflateFragment(String fragmentTag, String message) {
        if(fragmentTag.equals(getString(R.string.fragment_a))){
            AFragment fragment=new AFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
        else if(fragmentTag.equals(getString(R.string.fragment_b))){
            BFragment fragment=new BFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
        else if(fragmentTag.equals(getString(R.string.fragment_c))){
            CFragment fragment=new CFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
    }



}
