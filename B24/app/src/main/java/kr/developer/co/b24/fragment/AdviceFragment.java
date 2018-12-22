package kr.developer.co.b24.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.developer.co.b24.R;
import kr.developer.co.b24.model.Advice;

@SuppressLint("ValidFragment")
public class AdviceFragment extends Fragment {

  Advice advice;
  List<String> questionList;

  public AdviceFragment(Advice advice) {
    this.advice = advice;
  }

  public static AdviceFragment create(Advice advice) {
    AdviceFragment fragment = new AdviceFragment(advice);
    Bundle args = new Bundle();

    fragment.setArguments(args);

    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    questionList = Arrays.asList(getResources().getStringArray(R.array.question_list));
  }

  @SuppressLint("SetTextI18n")
  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    ViewGroup view = (ViewGroup) inflater.inflate(R.layout.item_advice, container, false);

    TextView memberAgeTextView = view.findViewById(R.id.tv_member);
    TextView adviceCommentTextView = view.findViewById(R.id.tv_advice_comment);
    TextView adviceLikeCountTextView = view.findViewById(R.id.tv_advice_like_count);
    CheckBox adviceLikeCheckBox = view.findViewById(R.id.cb_advice_like);

    memberAgeTextView.setText(advice.getMember().toString());
    adviceCommentTextView.setText(advice.getComment());
    adviceLikeCountTextView.setText(
        Integer.toString(advice.getLikeCount()) + getString(R.string.text_count));

    adviceLikeCheckBox.setOnCheckedChangeListener((v,isChecked) -> {
      if (isChecked){
        advice.setLikeCount((advice.getLikeCount())+1);
      }else {
        advice.setLikeCount((advice.getLikeCount())-1);
      }
      adviceLikeCountTextView.setText(
              Integer.toString(advice.getLikeCount()) + getString(R.string.text_count));
    });

    return view;
  }
}
