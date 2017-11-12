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

public class FragmentChiTietOGhep1 extends Fragment {
    private TextView texttelephone, texttien,textdiachi,textname,textage,textgt;
    private Button btcall;
    public static  final String DIACHI="diachi";
    public static  final String GIATIEN="giatien";
    public static  final String TEN="ten";
    public static  final String TUOI="tuoi";
    public static  final String GIOITINH="gioitinh";
    public static  final String SDTLH="sdtlh";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment1_chitietoghep,container,false);
        texttelephone = (TextView) view.findViewById(R.id.texttelephone);
        texttien = (TextView) view.findViewById(R.id.texttien);
        textdiachi = (TextView) view.findViewById(R.id.textdiachi);
        textname = (TextView) view.findViewById(R.id.textname);
        textage = (TextView) view.findViewById(R.id.textage);
        textgt = (TextView) view.findViewById(R.id.textgt);

        Bundle bundle = getArguments();
        if (bundle != null) {
            texttelephone.setText(bundle.getString(SDTLH));
            textdiachi.setText(bundle.getString(DIACHI));
            textage.setText(bundle.getString(TUOI));
            texttien.setText(bundle.getString(GIATIEN));
            textgt.setText(bundle.getString(GIOITINH));
            textname.setText(bundle.getString(TEN));
        }
        //crash

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
