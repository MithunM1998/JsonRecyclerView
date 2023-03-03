package com.example.jsonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<Movie> movieList=new ArrayList<>();
   SearchView searchView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    Movie movie;
    public static Context mContext;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
      /*searchView=(SearchView)findViewById(R.id.searchview);
      searchView.clearFocus();

      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
          @Override
          public boolean onQueryTextSubmit(String query) {
              return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
            // filterList(newText);
              recyclerViewAdapter.getFilter().filter(newText);
              return true;
          }
      });*/

        String movie_array="{\n" +
                "  \"Movies\": [\n" +
                "    {\n" +
                "      \"Title\": \"Avatar\",\n" +
                "      \"Year\": \"2009\",\n" +
                "      \"Rated\": \"PG-13\",\n" +
                "      \"Released\": \"18 Dec 2009\",\n" +
                "      \"Runtime\": \"162 min\",\n" +
                "      \"Genre\": \"Action, Adventure, Fantasy\",\n" +
                "      \"Director\": \"James Cameron\",\n" +
                "      \"Writer\": \"James Cameron\",\n" +
                "      \"Actors\": \"Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang\",\n" +
                "      \"Images\": [\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2ODQ3NjMyMl5BMl5BanBnXkFtZTcwODg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxOTEwNDcxN15BMl5BanBnXkFtZTcwOTg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMDg1Nzk1MV5BMl5BanBnXkFtZTcwMDk0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"Title\": \"I Am Legend\",\n" +
                "      \"Year\": \"2007\",\n" +
                "      \"Rated\": \"PG-13\",\n" +
                "      \"Released\": \"14 Dec 2007\",\n" +
                "      \"Runtime\": \"101 min\",\n" +
                "      \"Genre\": \"Drama, Horror, Sci-Fi\",\n" +
                "      \"Director\": \"Francis Lawrence\",\n" +
                "      \"Writer\": \"Mark Protosevich (screenplay), Akiva Goldsman (screenplay), Richard Matheson (novel), John William Corrington, Joyce Hooper Corrington\",\n" +
                "      \"Actors\": \"Will Smith, Alice Braga, Charlie Tahan, Salli Richardson-Whitfield\",\n" +
                "      \"Images\": [\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTI0NTI4NjE3NV5BMl5BanBnXkFtZTYwMDA0Nzc4._V1_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTIwMDg2MDU4M15BMl5BanBnXkFtZTYwMTA0Nzc4._V1_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5MDM1OTU5OV5BMl5BanBnXkFtZTYwMjA0Nzc4._V1_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0MTI2NjMzMzFeQTJeQWpwZ15BbWU2MDMwNDc3OA@@._V1_.jpg\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"Title\": \"300\",\n" +
                "      \"Year\": \"2006\",\n" +
                "      \"Rated\": \"R\",\n" +
                "      \"Released\": \"09 Mar 2007\",\n" +
                "      \"Runtime\": \"117 min\",\n" +
                "      \"Genre\": \"Action, Drama, Fantasy\",\n" +
                "      \"Director\": \"Zack Snyder\",\n" +
                "      \"Writer\": \"Zack Snyder (screenplay), Kurt Johnstad (screenplay), Michael Gordon (screenplay), Frank Miller (graphic novel), Lynn Varley (graphic novel)\",\n" +
                "      \"Actors\": \"Gerard Butler, Lena Headey, Dominic West, David Wenham\",\n" +
                "      \"Images\": [\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTMwNTg5MzMwMV5BMl5BanBnXkFtZTcwMzA2NTIyMw@@._V1_SX1777_CR0,0,1777,937_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQwNTgyNTMzNF5BMl5BanBnXkFtZTcwNDA2NTIyMw@@._V1_SX1777_CR0,0,1777,935_AL_.jpg\",\n" +
                "        \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MjQzOTEwMV5BMl5BanBnXkFtZTcwMzE2NTIyMw@@._V1_SX1777_CR0,0,1777,947_AL_.jpg\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        try {
            JSONObject jsonObject=new JSONObject(movie_array);
            JSONArray jsonArray=jsonObject.getJSONArray("Movies");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject Object=jsonArray.getJSONObject(i);
                Movie movie=new Movie();
                movie.setMovieTitle(Object.getString("Title"));
                movie.setMovieRated(Object.getString("Rated"));
                movie.setMovieYear(Object.getString("Year"));
                movie.setMovieDirector(Object.getString("Director"));
                movie.setMovieGenre(Object.getString("Genre"));
                movie.setMovieReleased(Object.getString("Released"));
                movie.setMovieRuntime(Object.getString("Runtime"));
                movie.setMovieActors(Object.getString("Actors"));
                movie.setMovieWriter(Object.getString("Writer"));

                JSONArray imageArray = Object.getJSONArray("Images");
                String imjObj = imageArray.getString(0);
                movie.setImgUrl(imjObj);

                movieList.add(movie);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerViewAdapter=new RecyclerViewAdapter(this,movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem searchViewItem=menu.findItem(R.id.searchView);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // filterList(newText);
                recyclerViewAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
/*private void filterList(String text) {
        List<Movie> filteredmovies=new ArrayList<>();

        for (Movie m:movieList
             ) {
            if (m.getMovieTitle().toLowerCase().contains(text.toLowerCase())){
                filteredmovies.add(m);
            }else

            if (m.getMovieYear().toLowerCase().contains(text.toLowerCase())){
                filteredmovies.add(m);

            }else

            if (m.getMovieDirector().toLowerCase().contains(text.toLowerCase())){
                filteredmovies.add(m);

            }


        }
        recyclerViewAdapter.setFilteredList(filteredmovies);
    }*/


}