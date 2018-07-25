package com.example.miqo93.filmlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Film> movieList = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        AdapterFilm filmAdapter = new AdapterFilm(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(filmAdapter);
        creatMovies();
    }

    private void creatMovies() {
        Film movie;

        movie = new Film("Дэдпул 2", "Единственный и неповторимый болтливый наемник — вернулся! Ещё более масштабный, ещё более разрушительный и даже ещё более голозадый, чем прежде! Когда в его жизнь врывается суперсолдат с убийственной миссией",
                "https://www.kinopoisk.ru/film/961715/", R.drawable.dedpul);
        movieList.add(movie);
        movie = new Film("Первому игроку приготовиться", "Действие фильма происходит в 2045 году, мир погружается в хаос и находится на грани коллапса. Люди ищут спасения в игре OASIS — огромной вселенной виртуальной реальности",
                "https://www.kinopoisk.ru/film/538225/", R.drawable.igrok);
        movieList.add(movie);
        movie = new Film("Монстры на каникулах 3", "На этот раз Дракула вместе со своими друзьями отправляется в круиз на шикарном лайнере. Развлечения там на любой вкус: от монстробаскетбола и экзотических экскурсий, до лунных ванн. ",
                "https://www.kinopoisk.ru/film/monstry-na-kanikulakh-3-more-zovyot-2018-950968/", R.drawable.monstri);
        movieList.add(movie);
        movie = new Film("Чёрная Пантера", "С первого взгляда можно решить, что Ваканда — обычная территория дикой Африки, но это не так. Здесь, в недрах пустынных земель, скрываются залежи уникального металла, способного поглощать вибрацию.",
                "http://kinokrad.co/324569-chjornaya-pantera-2018-07-12.html", R.drawable.pantera);
        movieList.add(movie);
        movie = new Film("Мир юрского периода 2", "Основатели парка Юрского периода решают восстановить его работу, пренебрегая действующим вулканом, который находится в центре острова.",
                "https://www.kinopoisk.ru/film/924311/", R.drawable.parkurskogoperiuda);
        movieList.add(movie);
    }


}
