package tn.enis.fadwa.touristguide;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeView extends Activity {

    private ListView maListViewPerso;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_view);

        //Récupération de la listview créée dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);

        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("titre", "Accomodation");
        map.put("description", "Hotel,Apartment");
        map.put("img", String.valueOf(R.drawable.accomodation));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Events");
        map.put("description", "Technologies,Sport,Entertainment...");
        map.put("img", String.valueOf(R.drawable.event8));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Gastronomy");
        map.put("description", "Restaurant,Coffee");
        map.put("img", String.valueOf(R.drawable.gastro));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Health Care");
        map.put("description", "Hospitals,Pharmacies,Doctors");
        map.put("img", String.valueOf(R.drawable.health));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Police Station");
        map.put("description", "");
        map.put("img", String.valueOf(R.drawable.police));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Post Office");
        map.put("description", "");
        map.put("img", String.valueOf(R.drawable.poste));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Shopping");
        map.put("description", "Clothing,Electronics,Grocery");
        map.put("img", String.valueOf(R.drawable.shopping));
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
                if(map.get("titre").equals("Gastronomy")) {
                    Intent myIntent = new Intent(ListeView.this, GastronomyActivity.class);
                    startActivity(myIntent);
                }
                //on créer une boite de dialogue

            }
        });

    }
}
