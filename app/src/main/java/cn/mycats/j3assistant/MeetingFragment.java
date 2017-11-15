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
public class MeetingFragment extends Fragment {




    public MeetingFragment() {
        // Required empty public constructor
    }
    private WebView meetWeb;
    private View view;
    private WebSettings settings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_meeting, container, false);
        meetWeb = view.findViewById(R.id.meet_web);
        meetWeb.loadUrl("https://jx3.derzh.com/serendipity/");
        settings = meetWeb.getSettings();
        settings.setBlockNetworkImage(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setJavaScriptEnabled(true);
        return view;
    }

}
