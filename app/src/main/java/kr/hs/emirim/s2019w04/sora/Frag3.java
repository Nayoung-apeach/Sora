package kr.hs.emirim.s2019w04.sora;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Frag3 extends Fragment {
    private View view;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private boolean profile;
    private TextView text_email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        view.findViewById(R.id.btn_logout).setOnClickListener(onClickListener);
        text_email = view.findViewById(R.id.text_email);

        String user_email = user.getEmail();
        text_email.setText(user_email);

        return view;
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_logout:
                    FirebaseAuth.getInstance().signOut();
                    myStartActivity(SignupActivity.class);
                    break;
            }
        }
    };
    private void myStartActivity(Class c){
        Intent intent = new Intent(getActivity(), c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
