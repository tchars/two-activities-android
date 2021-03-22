package br.com.tchars.twoactivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView _title;
    private ImageView _image;
    private TextView _indexImage;

    private int index = 0;

    private String images [] = new String[] { "bob", "patrick" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        _image = findViewById(R.id.imageView);
        _title = findViewById(R.id.textViewTitleImage);
        _indexImage = findViewById(R.id.indexImage);
        _title.setText("Olá " + images[index]);
        _indexImage.setText(index + 1 + " de " + images.length);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void swapImage(View view) {

        if (view.getId() == R.id.buttonRight) {
            index++;
            if (index > images.length - 1) {
                index = images.length - 1;
            }
        }
        else if (view.getId() == R.id.buttonLeft) {
            index--;
            if (index < 0) {
                index = 0;
            }
        }

        Drawable image = getResources().getDrawable(getResources().getIdentifier(images[index],"drawable", getPackageName()), this.getTheme());

        _image.setImageDrawable(image);
        _title.setText("Olá " + images[index]);
        _indexImage.setText(index + 1 + " de " + images.length);
    }

}
