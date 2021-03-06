package ca.qc.cgmatane.informatique.findit.vue;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ca.qc.cgmatane.informatique.findit.R;

public class VueGalerie extends AppCompatActivity {

    protected GridView vueGrilleGalerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_galerie);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent intentionNaviguerModiferEvenement = new Intent(VueGalerie.this, VueAfficherImage.class);
                intentionNaviguerModiferEvenement.putExtra("position",position);
                startActivityForResult(intentionNaviguerModiferEvenement,1);

            }
        });
        Button actionNaviguerRetour = (Button) findViewById(R.id.action_naviguer_retour_jeu);
        actionNaviguerRetour.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                retourAncienneActivite();
            }
        });


    }

    public void retourAncienneActivite(){
        this.finish();
    }
}
