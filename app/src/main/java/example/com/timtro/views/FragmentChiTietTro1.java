package example.com.timtro.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import example.com.timtro.R;

public class FragmentChiTietTro1 extends Fragment {
    private TextView texttelephone;
    private Button btcall;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment1_chitiettro,container,false);
        texttelephone = (TextView) view.findViewById(R.id.texttelephone);
        btcall=(Button) view.findViewById(R.id.call) ;
        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + texttelephone.getText().toString()));//change the number
                startActivity(callIntent);
            }
        });
        return view;
    }
}
