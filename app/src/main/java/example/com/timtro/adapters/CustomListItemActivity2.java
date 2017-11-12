package example.com.timtro.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.timtro.R;
import example.com.timtro.models.TimNguoiOGhep;

/**
 * Created by Administrator on 14/09/2017.
 */

public class CustomListItemActivity2 extends ArrayAdapter<TimNguoiOGhep> {
    private Activity activity;
    private  int idLayout;
    private ArrayList<TimNguoiOGhep> list;
    public CustomListItemActivity2(Activity activity, int idLayout , ArrayList<TimNguoiOGhep> list){
        super(activity,idLayout,list);
        this.activity=activity;
        this.idLayout=idLayout;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(idLayout,null);
        TextView textView1 =(TextView) convertView.findViewById(R.id.tv1);
        textView1.setText(list.get(position).getGiatien());
        TextView textView2 =(TextView) convertView.findViewById(R.id.tv2);
        textView2.setText(list.get(position).getDiachi());
        TextView textView3 =(TextView) convertView.findViewById(R.id.tv3);
        textView3.setText(list.get(position).getSdtlienhe());

        return convertView;
    }
}
