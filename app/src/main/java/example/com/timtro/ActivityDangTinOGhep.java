package example.com.timtro;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import example.com.timtro.models.TimNguoiOGhep;

public class ActivityDangTinOGhep extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private EditText ten,tuoi,sdtlh,diachi,giatien;
    private ImageView imv;
    private Button btchontep,btluu;
    private Spinner spinner1,spinner2;
    private CheckBox c1,c2,c3,c4,c5,c6;
    private String[] language1,language2;
    private ArrayAdapter<String> spinnerAddapter1,spinnerAddapter2;
    private static final int PICK_IMAGE = 100;
    private String imagePath,bien1,bien2;
    private int column_index;
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangtinoghep);
        mDatabase =  FirebaseDatabase.getInstance().getReference("thongtin");
        databaseReference = mDatabase.child("nguoioghep");

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
        navigationView.setNavigationItemSelectedListener(this);

        spinner1 = (Spinner) findViewById(R.id.spiner1);
        language1 = getResources().getStringArray(R.array.gioi_tinh);
        spinnerAddapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,language1);
        spinner1.setAdapter(spinnerAddapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("selected: "+language1[i]);
                bien1=language1[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2 = (Spinner) findViewById(R.id.spiner2);
        language2 = getResources().getStringArray(R.array.gia_tien);
        spinnerAddapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,language2);
        spinner2.setAdapter(spinnerAddapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("selected: "+language2[i]);
                bien2=language2[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void connectView() {
        //Ket noi voi edit text
        ten=(EditText) findViewById(R.id.ten) ;
        tuoi=(EditText) findViewById(R.id.tuoi) ;
        sdtlh=(EditText) findViewById(R.id.sdtlh) ;
        diachi=(EditText) findViewById(R.id.diachi) ;
        giatien=(EditText) findViewById(R.id.giatien) ;
        imv = (ImageView)findViewById(R.id.imv) ;
        btluu = (Button) findViewById(R.id.btluu);
        btchontep = (Button) findViewById(R.id.btchontep) ;
        c1=(CheckBox) findViewById(R.id.checkBox1) ;
        c2=(CheckBox) findViewById(R.id.checkBox2) ;
        c3=(CheckBox) findViewById(R.id.checkBox3) ;
        c4=(CheckBox) findViewById(R.id.checkBox4) ;
        c5=(CheckBox) findViewById(R.id.checkBox5) ;
        c6=(CheckBox) findViewById(R.id.checkBox6) ;
        // set on click
        btchontep.setOnClickListener(this);
        btluu.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btchontep:
                onClickbt();
                break;
            case R.id.btluu:
                onClickluu();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            Uri chosenImageUri = data.getData();

            Bitmap mBitmap = null;

            try {
                mBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), chosenImageUri);
                imv.setImageURI(chosenImageUri);
                imagePath=getPath(chosenImageUri);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        imagePath = cursor.getString(column_index);

        return cursor.getString(column_index);
    }
    public  void onClickbt(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), 100);
        onActivityResult(100, RESULT_OK, intent);

    }
    public void onClickluu(){

        String str1 = ten.getText().toString();
        String str2 = tuoi.getText().toString();
        String str3 = sdtlh.getText().toString();
        String str4 = diachi.getText().toString();
        String str5 = giatien.getText().toString();

        if(str1.length()==0){
            Toast.makeText(ActivityDangTinOGhep.this,"Hãy nhập Tên.",Toast.LENGTH_LONG).show();

        }
        else{
            if(str2.length()==0){
                Toast.makeText(ActivityDangTinOGhep.this, "Hãy nhập Tuổi.",Toast.LENGTH_LONG).show();
            }
            else {
                if(str2.length()>2){
                    Toast.makeText(ActivityDangTinOGhep.this, "Tuổi không hợp lệ.",Toast.LENGTH_LONG).show();
                }
                else {
                    if(str3.length()==0){
                        Toast.makeText(ActivityDangTinOGhep.this, "Hãy nhập SĐT.",Toast.LENGTH_LONG).show();
                    }
                    else {
                        if(str3.length()<10){
                            Toast.makeText(ActivityDangTinOGhep.this, "SĐT không hợp lệ.",Toast.LENGTH_LONG).show();
                        }
                        else {
                            if(str4.length()==0){
                                Toast.makeText(ActivityDangTinOGhep.this, "Hãy nhập địa chỉ trọ.",Toast.LENGTH_LONG).show();
                            }
                            else {
                                if(str5.length()==0){
                                    Toast.makeText(ActivityDangTinOGhep.this, "Hãy nhập gía tiền.",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    addDataToFirebase();
                                    Toast.makeText(ActivityDangTinOGhep.this, "Đăng tin thành công.",Toast.LENGTH_LONG).show();
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
                        }
                    }
                }
            }

    }
    private void addDataToFirebase() {
        TimNguoiOGhep timNguoiOGhep = new TimNguoiOGhep();
        String tien=giatien.getText().toString()+bien2;
        timNguoiOGhep.setGiatien(tien);
        timNguoiOGhep.setGioiTinh(bien1);
        timNguoiOGhep.setDiachi(diachi.getText().toString());
        timNguoiOGhep.setSdtlienhe(sdtlh.getText().toString());
        timNguoiOGhep.setTen(ten.getText().toString());
        int age=Integer.parseInt(tuoi.getText().toString());
        timNguoiOGhep.setTuoi(age);
        String thongtintro ="";
        if(c1.isChecked()==true) thongtintro+=c1.getText().toString()+"\n";
        if(c2.isChecked()==true) thongtintro+=c2.getText().toString()+"\n";
        if(c3.isChecked()==true) thongtintro+=c3.getText().toString()+"\n";
        if(c4.isChecked()==true) thongtintro+=c4.getText().toString()+"\n";
        if(c5.isChecked()==true) thongtintro+=c5.getText().toString()+"\n";
        if(c6.isChecked()==true) thongtintro+=c6.getText().toString();
        timNguoiOGhep.setChitiet(thongtintro);
        String key = databaseReference.push().getKey();
        timNguoiOGhep.setId(key);
        databaseReference.push().setValue(timNguoiOGhep);
        Toast.makeText(ActivityDangTinOGhep.this, "dfgtrdhfgcbf",Toast.LENGTH_LONG).show();
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
            Intent intent = new Intent(ActivityDangTinOGhep.this, ActivityMap.class);
            startActivity(intent);

        } else if (id == R.id.tim_ghep) {
            Intent intent = new Intent(ActivityDangTinOGhep.this, ActivityTimOGhep.class);
            startActivity(intent);

        } else if (id == R.id.dang_cho_thue) {
            Intent intent = new Intent(ActivityDangTinOGhep.this, ActivityDangTinChoThue.class);
            startActivity(intent);

        } else if (id == R.id.dang_tim_ghep) {

        } else if (id == R.id.bao_cao) {
            Intent intent = new Intent(ActivityDangTinOGhep.this, ActivityTabBaocao.class);
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
