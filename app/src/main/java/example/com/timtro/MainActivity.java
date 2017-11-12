package example.com.timtro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Administrator on 11/09/2017.
 */

public class MainActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.btn_login_facebook);
        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(final LoginResult loginResult) {
                GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(loginResult.getAccessToken(),
                        "me/taggable_friends", null, HttpMethod.GET, new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        try {
                            JSONArray rawName = response.getJSONObject().getJSONArray("data");
                            jsonData = rawName.toString();
                            Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                            String name = message(Profile.getCurrentProfile());
                            String urlProfile = "https://graph.facebook.com/" + loginResult.getAccessToken().getUserId() + "/picture?type=large";
                            Toast.makeText(MainActivity.this, "Success.", Toast.LENGTH_LONG).show();
                            intent.putExtra("name", name);
                            intent.putExtra("url", urlProfile);
                            intent.putExtra("friend", jsonData);
                           startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).executeAsync();


            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Login attempt canceled.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                startActivity(intent);
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(MainActivity.this, "Login attempt failed.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private String message(Profile profile) {
        StringBuilder stringBuffer = new StringBuilder();
        if (profile != null) {
            stringBuffer.append("Welcome ").append(profile.getName());
        }
        return stringBuffer.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

/*
public class MainActivity extends AppCompatActivity{
    //dung de login fb
    private LoginButton mBtnLoginFacebook;
    private CallbackManager mCallbackManager;
    private String name,email,image;
    public static  final String NAME="name";
    public static  final String EMAIL="email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCallbackManager = CallbackManager.Factory.create();
        mBtnLoginFacebook = (LoginButton) findViewById(R.id.btn_login_facebook);
        mBtnLoginFacebook.setReadPermissions(Arrays.asList("public_profile","email"));
        setLogin_Button();
       */
/* Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(5000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                    startActivity(intent);
                }
            }
        };
        bamgio.start();*//*

    }
    private void setLogin_Button() {
        mBtnLoginFacebook.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                result();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this,"Đăng nhập không thành công!",Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                */
/*Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                startActivity(intent);*//*


            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this,"Đăng nhập không thành công!",Toast.LENGTH_LONG).show();
               */
/* Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                startActivity(intent);*//*

            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON",response.getJSONObject().toString());
                try {
                    email=object.getString("email");
                    name=object.getString("name");
                    image=object.getString(Profile.getCurrentProfile().getId());
                    Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                    */
/*Intent intent = new Intent(MainActivity.this, ActivityMap.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(NAME,name);
                    bundle.putString(EMAIL,email);
                    startActivity(intent);*//*

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle  bundle = new Bundle();
        bundle.putString("fields","name,email");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
*/
