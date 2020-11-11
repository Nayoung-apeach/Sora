package kr.hs.emirim.s2019w04.sora;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Frag3 extends Fragment {
    private View view;
    private Object Intent;
    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag3, container, false);
        view = inflater.inflate(R.layout.frag3, container, false);

        getActivity().findViewById(R.id.logout_btn).setOnClickListener(onClickListener);
        return view;
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login_btn:
                    FirebaseAuth.getInstance().signOut();
                    StartPageActivity();
                    break;
            }
            if(FirebaseAuth.getInstance().getCurrentUser() == null){
                StartPageActivity();
            }
        }
    };

    private void StartPageActivity(){
        Intent intent = new Intent (getActivity(), StartPageActivity.class);
        startActivity(intent);
    }
}
