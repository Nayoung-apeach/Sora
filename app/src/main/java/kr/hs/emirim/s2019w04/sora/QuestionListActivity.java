package kr.hs.emirim.s2019w04.sora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class QuestionListActivity extends AppCompatActivity implements View.OnClickListener, ContextviewListener{

    private ArrayList<SoraContext> contextsItem = null;
    private ContextAdapter contextAdapter = null;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        init();
        initView();
    }

    private void addChildEvent(){
        databaseReference.child("Context").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                SoraContext soraContext = snapshot.getValue(SoraContext.class);
                contextsItem.add(soraContext);
                contextAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    private void init(){
        contextsItem = new ArrayList<>();
    }

    private  void initView(){
        Button regbtn = (Button)findViewById(R.id.read_data_btn);
        regbtn.setOnClickListener(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.question_list_view);
        contextAdapter= new ContextAdapter(contextsItem,this,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contextAdapter);
    }

    @Override
    public void onItemClick(int position, View view) {

    }
}