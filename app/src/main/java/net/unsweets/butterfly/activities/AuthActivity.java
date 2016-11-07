package net.unsweets.butterfly.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.unsweets.butterfly.R;
import net.unsweets.butterfly.fragments.AuthFragment;

public class AuthActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_auth);
    if(savedInstanceState == null) {
      FragmentManager fm = getSupportFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.auth_frame, AuthFragment.newInstance());
      ft.commit();
    }
  }
}
