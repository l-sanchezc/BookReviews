package edu.iit.lazaro.bookreviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    SqlHelper db = new SqlHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /** CRUD Operations **/
        Log.d("My name", "Lazaro Sanchez Campos");

        // add Books
        db.addBook(new Book("Professional Android 4 Application Development", "Reto Meier","3", "professional"));
        db.addBook(new Book("Beginning Android 4 Application Development", "Wei-Meng Lee", "2", "beginning"));
        db.addBook(new Book("Programming Android", "Wallace Jackson", "4", "programming"));
        db.addBook(new Book("Hello, Android", "Wallace Jackson", "4", "hello"));

        // get all books
        List<Book> list = db.getAllBooks();

        // update one book
        int j = db.updateBook(list.get(3),"Hello, Android", "Ben Jackson");

        // delete one book
        //db.deleteBook(list.get(0));

        // get all books
        db.getAllBooks();

        List<Book> books = new ArrayList<Book>();
        books=db.getAllBooks();

        // get number of records
        Log.d("Total record count", db.getIds(list.get(0))+"");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner Drop down element items (some list you build)
        List<String> spinnerList = new ArrayList<String>();
        spinnerList.add("Select Analytics...");
        spinnerList.add("Get Highest Rated Title(s)");
        spinnerList.add("Get Lowest Rated Title(s)");
        spinnerList.add("Get Record Count");
        spinnerList.add("Retrieve Title(s) with Android 4");

        // Creating adapter for spinner, pass your list into the constructor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, spinnerList);

        // Drop down layout style - list view with radio button
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(adapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {

        if (position == 1) {
            Toast.makeText(MainActivity.this,
                    db.getHighestRated(), Toast.LENGTH_LONG).show();
        }
        if (position == 2) {
            Toast.makeText(MainActivity.this,
                    db.getLowestRated(), Toast.LENGTH_LONG).show();
        }
        if (position == 3) {
            Toast.makeText(MainActivity.this,
                    db.getIds(db.getAllBooks().get(0))+"", Toast.LENGTH_LONG).show();
        }
        if (position == 4) {
            Toast.makeText(MainActivity.this,
                    db.getBooksByContent(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}