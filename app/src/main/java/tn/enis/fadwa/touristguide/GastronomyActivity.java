package tn.enis.fadwa.touristguide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Noor on 22/01/2016.
 */
public class GastronomyActivity extends Activity {

    private ListView maListViewPerso;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomy);

        //Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);

        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("titre", "Lebanese House");
        map.put("description", "Route Soukra, Km 1 Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.lebanese_house));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Cercina");
        map.put("description", "19, Rue Ibn Mejed, Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.cercina));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Le Corail");
        map.put("description", "Avenue Habib-Maazoun 39, Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.corail));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", " Cafe Diwan");
        map.put("description", "Borj erssas | Les remparts entre Beb El Kasbah et Beb El Diwan, Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.diwan));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", " bagdad");
        map.put("description", "63 ave farhat hached | 63 ave farhat hached, Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.bagdad));
        listItem.add(map);



        map = new HashMap<String, String>();
        map.put("titre", "Saffoud Abid");
        map.put("description", "Ahmed Bey, Sfax, Tunisie");
        map.put("img", String.valueOf(R.drawable.brochettes));
        listItem.add(map);

        //Création d'un SimpleAdapter qui se chargera de mettre les items présent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
                new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});

        //On attribut à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                if(map.get("titre").equals("Lebanese House")) {
                    Intent myIntent = new Intent(GastronomyActivity.this, Details.class);
                    startActivity(myIntent);
                }
                //on créer une boite de dialogue

            }
        });


    }
}
