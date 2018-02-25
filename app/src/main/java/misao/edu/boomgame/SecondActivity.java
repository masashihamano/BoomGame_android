package misao.edu.boomgame;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Random;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );

        final GridView gridView = findViewById( R.id.imageGridView );
        gridView.setAdapter( new ImageAdapter(this) );

        Random random = new Random(  );
        final int r = random.nextInt(9);
        final ImageAdapter imageAdapter = new ImageAdapter(this);


        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent( getApplicationContext(),MainActivity.class );
                intent.putExtra( "id",position );
                intent.putExtra( "end",r );
                startActivity( intent );

                ImageView imageView = (ImageView) view;
                imageView.setImageResource( R.drawable.check );

                imageView.setEnabled( false );



            }
        } );

    }
}
