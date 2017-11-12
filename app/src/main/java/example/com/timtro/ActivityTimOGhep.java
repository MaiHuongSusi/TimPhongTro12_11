package example.com.timtro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import example.com.timtro.adapters.CustomListItemActivity2;
import example.com.timtro.models.TimNguoiOGhep;
import example.com.timtro.views.FragmentChiTietOGhep1;

public class ActivityTimOGhep extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;
    private ArrayList<TimNguoiOGhep> mlist;
    private ListView listView;
    private CustomListItemActivity2 adapter=null;
    public static  final String DIACHI="diachi";
    public static  final String GIATIEN="giatien";
    public static  final String CHITIET="chitiet";
    public static  final String TEN="ten";
    public static  final String TUOI="tuoi";
    public static  final String GIOITINH="gioitinh";
    public static  final String SDTLH="sdtlh";
    public static  final String BULDE="bulde";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timoghep);
        mDatabase = FirebaseDatabase.getInstance().getReference("thongtin");
        databaseReference = mDatabase.child("nguoioghep");
        listView = (ListView)findViewById(R.id.lv1);
        mlist =new ArrayList<TimNguoiOGhep>();
        adapter=new CustomListItemActivity2(this, R.layout.custom_listview_timoghep,mlist);
        listView.setAdapter(adapter);

        //doc du lieu
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mlist.clear();
                for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                    TimNguoiOGhep note = noteSnapshot.getValue(TimNguoiOGhep.class);
                        mlist.add(note);
                        adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(ActivityTimOGhep.this, ActivityChiTietOGhep.class);
                        Bundle bundle=new Bundle();
                        bundle.putString(DIACHI,mlist.get(i).getDiachi());
                        bundle.putString(GIATIEN,mlist.get(i).getGiatien());
                        bundle.putString(CHITIET,mlist.get(i).getChitiet());
                        bundle.putString(TEN,mlist.get(i).getTen());
                        bundle.putInt(TUOI,mlist.get(i).getTuoi());
                        bundle.putString(GIOITINH,mlist.get(i).getGioiTinh());
                        bundle.putString(SDTLH,mlist.get(i).getSdtlienhe());
                        FragmentChiTietOGhep1 fragment1 = new FragmentChiTietOGhep1();
                        fragment1.setArguments(bundle);
                        startActivity(intent);
                    }
                }
        );
        //tao chu tren thanh toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //tao thanh menu va su kien khi click no
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   //ham xu li mục setting
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.search_view) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.tim_phong) {
            Intent intent = new Intent(ActivityTimOGhep.this, ActivityMap.class);
            startActivity(intent);

        } else if (id == R.id.tim_ghep) {

        } else if (id == R.id.dang_cho_thue) {
            Intent intent = new Intent(ActivityTimOGhep.this, ActivityDangTinChoThue.class);
            startActivity(intent);


        } else if (id == R.id.dang_tim_ghep) {
            Intent intent = new Intent(ActivityTimOGhep.this, ActivityDangTinOGhep.class);
            startActivity(intent);

        } else if (id == R.id.bao_cao) {
            Intent intent = new Intent(ActivityTimOGhep.this, ActivityTabBaocao.class);
            startActivity(intent);
        }
        //cau lenh de quay ve man hinh chinh
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
