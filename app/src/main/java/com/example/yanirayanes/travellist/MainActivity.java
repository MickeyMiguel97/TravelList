package com.example.yanirayanes.travellist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    PaisAdapter adapter;
    ArrayList<Pais> pais,bm;
    LinearLayoutManager lManager;
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pais = new ArrayList<>();
        bm= new ArrayList<>();
        btn1 = findViewById(R.id.games);
        btn2 = findViewById(R.id.fav);


        rv= findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new PaisAdapter(pais,this);
        rv.setAdapter(adapter);

    }
    //Funciones onclick para los botones del menu

    public void boton1_list(View v){
        adapter.setFalse();
        btn1.setBackgroundColor(getResources().getColor(R.color.azul));
        btn2.setBackgroundColor(getResources().getColor(R.color.skyblue));
        adapter = new PaisAdapter(pais,v.getContext());
        rv.setAdapter(adapter);
    }
    public void boton2_bookmark(View v){
        adapter.setTrue();
        btn2.setBackgroundColor(getResources().getColor(R.color.azul));
        btn1.setBackgroundColor(getResources().getColor(R.color.skyblue));
        adapter = new PaisAdapter(bm,v.getContext());
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {

        String TAG = "Mensaje";
        pais= new ArrayList<>();
        pais.add(new Pais("Alemania", R.drawable.alemania,"Pueblos"));
        pais.add(new Pais("Argentina", R.drawable.argentina,"Patagonia"));
        pais.add(new Pais("Brasil", R.drawable.brasil,"Cristo"));
        pais.add(new Pais("Canada", R.drawable.canada,"Vistas panoramicas"));
        pais.add(new Pais("Chile", R.drawable.chile,"Montaña"));
        pais.add(new Pais("Egipto", R.drawable.egipto,"Piramide"));
        pais.add(new Pais("España", R.drawable.españa,"Metropolis"));
        pais.add(new Pais("Francia", R.drawable.francia,"Torre eiffel"));
        pais.add(new Pais("Mexico", R.drawable.mexico,"Sitio arqueologico"));
        pais.add(new Pais("Estados Unidos", R.drawable.usa,"Estatua de la libertad"));

    }
    //funcion para agregar a los marcadores
    public void addBookmark(Pais travelapp){
        bm.add(travelapp);
    }
    //funcion para quitar de los marcadores
    // se recorre la lista de marcadores y si encuentra uno con un nombre que este en la lista original
    // rompe el ciclo y se quitar del arraylist
    // y se le da f5 para ver que se quito con el isOnBookmark
    public void quitar(String GameName){
        int i=0;

        for(Pais game : bm){
            if(game.getName() == GameName){
                break;
            }
            i++;
        }
        bm.remove(i);
        if(adapter.isOnBookmark()){
            adapter = new PaisAdapter(bm, this);
            rv.setAdapter(adapter);
        }
    }
}
