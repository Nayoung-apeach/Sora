package kr.hs.emirim.s2019w04.sora;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Frag1 extends Fragment {
    private View view;
    private Button btn_check; //질문하기 버튼
    private EditText question; //질문
    private TextView answertext; //질문받기
    Random randomanswer = new Random();

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    String[]answer1 = {"보다 흥미로워질 것이 분명하다", "그로 인해 멋진 일들이 일어날지도", "참고 기다려라", "염려하지 마라", "속히 마무리 하도록", "당신이 주도권을 잡을 필요가 있다",
            "더 관대해라", "너무 성급히 행동해선 안된다", "명백한 사실을 관과하진 말아라", "넘어가라", "별 의미 없다", "조언을 구하라", "내 대답은 YES", "잘 풀릴 수 있으니 참고 기달려라",
            "마음을 열고 기다려라", "너무 조급해하지 말아라" ,"욕심을 버려라" ,"끈기있게 버텨라"};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);

        answertext = view.findViewById(R.id.answertext);
        question = (EditText) view.findViewById(R.id.question);
        btn_check = (Button) view.findViewById(R.id.btn_check);

        final int answer = randomanswer.nextInt(answer1.length) + 1;

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(question.getText().toString())) {   //이거 뜻이 빈칸이 아니라는 소리니까 반대로 해야돼
                    String questiontxt = question.getText().toString();
                    answertext.setText("답 : " + answer1[answer]);
                    String answertext = answer1[answer];
                    SoraContext context = new SoraContext(questiontxt, answertext);
                    databaseReference.child("Context").push().setValue(context).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getActivity(), "질문이 저장되었습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "글자를 적어주세요!", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}