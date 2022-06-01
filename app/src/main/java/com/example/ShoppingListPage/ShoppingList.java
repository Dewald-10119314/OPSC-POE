package com.example.ShoppingListPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.Adapters.ShoppingListAdapter;
import com.example.DashBoardPage.Dashboard_Activity;
import com.example.DataModels.Item_Information;
import com.example.test.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ShoppingList extends AppCompatActivity {

    private static final String TAG ="ShoppingList_Page";
    private ListView listView;
    //Declarations for DrawerLayout (geeksforgeeks.org, 2022)
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView burgerNavigationView;
    ArrayList<Item_Information> ShoppingListArrayList = new ArrayList<>();

    TextView ItemNameShoppingList;
    TextView CategoryNameShoppingList;
    ImageView ItemImageShoppingList;
    TextView ItemPriceShoppingList;
    TextView ItemQuantityShoppingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_page);

        // drawer layout instance to toggle the menu icon to open
        //drawer and back button to close drawer (geeksforgeeks.org, 2022).
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //Instantiating burgerNavigationView and binding it to view (Pulak, 2017).
        burgerNavigationView = findViewById(R.id.burgerNavigationView);

        //Setting navigation item listener (Pulak, 2017).
        burgerNavigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button (geeksforgeeks.org, 2022).
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar (geeksforgeeks.org, 2022).
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        //adapter for shopping list
//        Log.d(TAG, "onCreate : Started.");
//        ListView mList = (ListView) findViewById(R.id.shoppingListView);

//        ItemNameShoppingList = (TextView) findViewById(R.id.ItemViewName);
//        CategoryNameShoppingList = (TextView) findViewById(R.id.VegetablesTextView);
//        ItemImageShoppingList = (ImageView) findViewById(R.id.LettuceImage);
//        ItemPriceShoppingList = (TextView) findViewById(R.id.Price);
//        ItemQuantityShoppingList = (TextView) findViewById(R.id.NumOfItems);

        //object made
//        Item_Information slo = new Item_Information(ItemNameShoppingList.toString(),int.class.cast(ItemImageShoppingList),
//                double.class.cast(ItemPriceShoppingList), CategoryNameShoppingList.toString(), int.class.cast(ItemQuantityShoppingList));

        Item_Information slo = new Item_Information("Water", R.drawable.bodega_image,
                20.10, "Drinks", 2);
//
//        //add to list
//        ArrayList<Item_Information> ShoppingListArrayList = new ArrayList<>();
//
        ShoppingListArrayList.add((slo));
//
//        ShoppingList_Adapter adp = new ShoppingList_Adapter(this, R.layout.shopping_list_template, ShoppingListArrayList);
//        mList.setAdapter(adp);
        listView = (ListView) findViewById(R.id.shoppingListView);
        ShoppingListAdapter shopAdapter = new ShoppingListAdapter(getApplicationContext(), 0, ShoppingListArrayList);
        listView.setAdapter(shopAdapter);
    }

    //Method to handle the OnCLicked events within the burger menu (Pulak, 2017)
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            //Go to dashboard
            Intent dashB = new Intent(this, Dashboard_Activity.class);
            startActivity(dashB);
        } else if (id == R.id.nav_shopping_list){
            //Go to shopping list page
            Intent shopList = new Intent(this, ShoppingList.class);
            startActivity(shopList);
        } else if (id == R.id.nav_graph_screen) {
            //Go to Graph page
            //   Intent graphPage = new Intent(this, ShoppingList_Page.class);
            //   startActivity(graphPage);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked (geeksforgeeks.org, 2022).
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}