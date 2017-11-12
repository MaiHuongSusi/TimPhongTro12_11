package example.com.timtro.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import example.com.timtro.R;

public class Fragment5 extends Fragment {
    Button btnStart;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_mainstart,container,false);

        btnStart = (Button) view.findViewById(R.id.btnStart);
        viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewPager.setCurrentItem(1);
            }
        });
        return view;
    }
}


