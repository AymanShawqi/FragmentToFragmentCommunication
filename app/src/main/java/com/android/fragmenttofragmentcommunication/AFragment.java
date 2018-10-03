package com.android.fragmenttofragmentcommunication;

import android.content.Context;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AFragment extends Fragment {
    private static final String TAG = "AFragment";
    private IMainActivity mIMainActivity;
    private TextView mDisplayMessage ;
    private String incomingMessage="";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            if (mIMainActivity==null)
                 mIMainActivity=(IMainActivity)getActivity();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMainActivity.setToolbarTitle(getTag());
        Bundle bundle=this.getArguments();
        if (bundle!=null){
            incomingMessage=bundle.getString(getString(R.string.intent_message));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        mDisplayMessage=view.findViewById(R.id.incoming_message);
        setIncomingMessage();
        return view;
    }

    private void setIncomingMessage(){
        if (!incomingMessage.isEmpty()){
            mDisplayMessage.setText(incomingMessage);
        }
    }
}
