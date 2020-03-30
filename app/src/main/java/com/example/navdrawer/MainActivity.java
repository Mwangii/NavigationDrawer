package com.example.navdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity   {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Live chat Clicked", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_account)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                 //use below marked statement for switch  case use
               // int menuId=destination.getId();
                int id =destination.getId();
               /* switch(menuId){
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this,"Home is clicked",Toast.LENGTH_SHORT).show();
                        fab.show();
                        break;
                    case R.id.nav_slideshow:
                        Toast.makeText(MainActivity.this,"Slideshow is clicked",Toast.LENGTH_SHORT).show();
                        fab.show();
                        break;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this,"Gallery  is clicked",Toast.LENGTH_SHORT).show();
                        fab.show();
                   break;

                    default:
                        fab.hide();
                        break;

                }*/
                if (id == R.id.nav_home)
                {
                    Toast.makeText(MainActivity.this, "HOME IS CLICKED", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.nav_gallery)
                {
                    Toast.makeText(MainActivity.this, "GALLERY IS CLICKED", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.nav_slideshow)
                {
                    Toast.makeText(MainActivity.this, "SLIDESHOW CLICKED", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.nav_account)
                {
                    Toast.makeText(MainActivity.this, "ACCOUNT  CLICKED", Toast.LENGTH_SHORT).show();
                }

               // return true;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    //action bar options
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

      if (id == R.id.action_settings)
      {
          Toast.makeText(MainActivity.this,"Settings  is clicked",Toast.LENGTH_SHORT).show();

           return true;
     }
       else  if (id == R.id.action_help)
        {
            Toast.makeText(MainActivity.this,"Help  is clicked",Toast.LENGTH_SHORT).show();

            return true;
        }

       else  if (id == R.id.action_logoutt)
        {
            Toast.makeText(MainActivity.this,"Log Out  is clicked",Toast.LENGTH_SHORT).show();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




}
