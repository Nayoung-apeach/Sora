package kr.hs.emirim.s2019w04.sora;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class Frag3 extends Fragment {
    private View view;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private boolean profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        if (user == null) {
//            startSignUpActivity();
//        }else{
//            for (User info profile: user.getProviderData()){
//                String name = profile.getDisplayName();
//            }
//        }

        view.findViewById(R.id.btn_logout).setOnClickListener(onClickListener);
        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_logout:
                    FirebaseAuth.getInstance().signOut();
                    startSignUpActivity();
                    break;
            }
        }
    };
    private void startSignUpActivity(){
        Intent intent = new Intent(getActivity(), StartPageActivity.class);
        startActivity(intent);
    }
}
