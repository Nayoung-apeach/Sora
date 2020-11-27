package kr.hs.emirim.s2019w04.sora;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Frag1 extends Fragment {
    private View view;
    private EditText Questions;
    private TextView answerText;
    Button button_check;
    Random randomanswer = new Random();

    String[]answer1 = {"그건 아닌것 같아", "다시 생각해 봐", "안 먹는걸 추천 해", "다른걸 먹어",
            "매운게 좋을 것 같아", "조금만 먹어", "간단한게 좋을 것 같아", "완전 좋은 생각이야", "부드러운 음식",
            "추억돋는 음식", "달달한 음식", "행복해지는 음식을 먹어", "아마도", "다시 생각해", "그건 아니야", "아닌것 같아", "나라면 하지 않겠어", "왜 고민해?",
            "하지마", "좋아", "고민하지 마", "해버려", "하는게 좋을 것 같아", "미쳤어?", "도랐어?", "나라면 하지 않을 것 같아",
            "음...꼭  해야할까?", "나는 아니라고 생각해", "해야될 것 같은데?", "하는게 좋을 듯", "완전 강추", "어쩌면", "....노답",
            "안돼", "아니", "응", "좋아요", "다시 한 번 물어봐", "그걸 질문이라고 해?", "그것도 안돼", "곧", "우웩", "새콤한 음식",
            "새로운 도전을 추천 해", "새로운 거", "부정적인 생각은 버리도록", "고민하지 말고 질러라", ""};

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        answerText = view.findViewById(R.id.answertext);
        final int answer = randomanswer.nextInt(answer1.length) + 1;

        Button btn_check = (Button) view.findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerText.setText("답 : " + answer1[answer]); // + answer1[]);
            }
        });
        return view;
    }
}