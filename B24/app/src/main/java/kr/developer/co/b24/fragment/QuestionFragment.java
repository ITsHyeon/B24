package kr.developer.co.b24.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import kr.developer.co.b24.R;
import kr.developer.co.b24.model.Advice;

@SuppressLint("ValidFragment")
public class QuestionFragment extends Fragment {

    String question;

    public QuestionFragment(String question) {
        this.question = question;
    }

    public static QuestionFragment create(String question) {
        QuestionFragment fragment = new QuestionFragment(question);
        Bundle args = new Bundle();

        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.item_question, container, false);

        TextView questionContentTextView = view.findViewById(R.id.tv_question_content);

        questionContentTextView.setText(question);

        return view;
    }
}
