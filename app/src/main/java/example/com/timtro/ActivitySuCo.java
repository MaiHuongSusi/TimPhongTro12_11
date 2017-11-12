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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import example.com.timtro.models.SuCo;

public class ActivitySuCo extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private EditText edtmail, edtreview;
    private Button btngui;
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_suco);
        mDatabase = FirebaseDatabase.getInstance().getReference("BÁO CÁO");
        databaseReference = mDatabase.child("Sự cố");

        connectView();

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
        navigationView.setNavigationItemSelectedListener(this);}


    private void connectView() {
        //Ket noi voi edit text
        edtmail = (EditText) findViewById(R.id.edtmail6);
        edtreview = (EditText) findViewById(R.id.edtReview6);
        btngui = (Button) findViewById(R.id.btnGui6);

        // set on click
        btngui.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onClickGui();
    }

    public void onClickGui() {

        String str1 = edtmail.getText().toString();
        String str2 = edtreview.getText().toString();

        if (str1.length() == 0) {
            Toast.makeText(ActivitySuCo.this, "Hãy nhập Email.", Toast.LENGTH_LONG).show();

        } else {
            if (str2.length() == 0) {
                Toast.makeText(ActivitySuCo.this, "Hãy nhập phản hồi.", Toast.LENGTH_LONG).show();
            } else {
                addDataToFirebase();
                Toast.makeText(ActivitySuCo.this, "Đã gửi phản hồi.", Toast.LENGTH_LONG).show();
                Thread bamgio = new Thread() {
                    public void run() {
                        try {
                            sleep(2000);
                        } catch (Exception e) {

                        } finally {
                            Intent activitymoi = new Intent("example.com.timtro.ActivityMap");
                            startActivity(activitymoi);

                        }
                    }
                };
                bamgio.start();
            }
        }
    }

    private void addDataToFirebase() {
        SuCo suCo = new SuCo();
        suCo.setEmail(edtmail.getText().toString());
        suCo.setReview(edtreview.getText().toString());
        String key = databaseReference.push().getKey();
        suCo.setId(key);
        databaseReference.push().setValue(suCo);
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
            Intent intent = new Intent(ActivitySuCo.this, ActivityMap.class);
            startActivity(intent);

        } else if (id == R.id.tim_ghep) {
            Intent intent = new Intent(ActivitySuCo.this, ActivityTimOGhep.class);
            startActivity(intent);

        } else if (id == R.id.dang_cho_thue) {
            Intent intent = new Intent(ActivitySuCo.this, ActivityDangTinChoThue.class);
            startActivity(intent);

        } else if (id == R.id.dang_tim_ghep) {
            Intent intent = new Intent(ActivitySuCo.this, ActivityDangTinOGhep.class);
            startActivity(intent);

        } else if (id == R.id.bao_cao) {
            Intent intent = new Intent(ActivitySuCo.this, ActivityTabBaocao.class);
            startActivity(intent);
        }
        //cau lenh de quay ve man hinh chinh
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /*protected void onPause(){
        super.onPause();
        finish();
    }*/

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

