package kr.hs.emirim.s2019w04.sora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContextAdapter extends RecyclerView.Adapter<ContextAdapter.ViewHolder> {
    private Context context = null;
    private ArrayList<SoraContext> contexts_item = null;
    private ContextviewListener contextviewListener = null;

    public ContextAdapter(ArrayList<SoraContext> contexts_item, Context context, ContextviewListener contextviewListener) {
        this.contexts_item = contexts_item;
        this.context = context;
        this.contextviewListener = contextviewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.question.setText("질문 : " + contexts_item.get(i).getQuestions());
        viewHolder.answer.setText("답 : " + contexts_item.get(i).getAnswer());
    }

    @Override
    public int getItemCount() {
        return contexts_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView question = null;
        public TextView answer = null;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question = (TextView)itemView.findViewById(R.id.question_list);
            answer = (TextView)itemView.findViewById(R.id.answer_list);
        }

        @Override
        public void onClick(View view) {
            contextviewListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
