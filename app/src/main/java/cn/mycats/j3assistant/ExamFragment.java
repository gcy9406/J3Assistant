package cn.mycats.j3assistant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {


    public ExamFragment() {
        // Required empty public constructor
    }

    private WebView examWeb;
    private View view;
    private WebSettings settings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exam, container, false);
        examWeb = view.findViewById(R.id.exam_web);
        examWeb.loadUrl("https://jx3.derzh.com/exam/");
        settings = examWeb.getSettings();
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setJavaScriptEnabled(true);
        return view;
    }
}
