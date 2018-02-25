package misao.edu.boomgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;
    Button button;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final int position = getIntent().getIntExtra( "id",0 );
        final int boom = getIntent().getIntExtra( "end",0 );

        imageView = findViewById( R.id.gridView );
        textView = findViewById( R.id.game );
        button = findViewById( R.id.button );


        try{
            Thread.sleep( 100 );
            if (boom == position){
                vibrator = (Vibrator)getSystemService( VIBRATOR_SERVICE );
                vibrator.vibrate( 300 );
                imageView.setImageResource( R.drawable.boom );
                textView.setText( "GAME OVER" );
                textView.setTextColor( Color.rgb(250,0,0)  );


            }else{
                imageView.setImageResource( R.drawable.safe );
                textView.setText( "SAFE!!" );
                textView.setTextColor( Color.rgb(0,0,128) );

            }

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (boom==position){
                    Intent intent = new Intent( MainActivity.this,SecondActivity.class );
                    startActivity( intent );
                }else{
                    finish();
                }


            }


        } );

    }
}
