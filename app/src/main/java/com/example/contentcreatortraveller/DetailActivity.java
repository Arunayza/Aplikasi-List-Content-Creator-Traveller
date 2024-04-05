package com.example.contentcreatortraveller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TRAVELER= "extra_traveler";
    public static final String EXTRA_DESK = "Deskripsi";
    public static final String EXTRA_PHOTO = "photo";
    public static final String EXTRA_NAMA = "Nama";
    public static final String EXTRA_NEGARA = "extra_Negara";
    public static final String EXTRA_TTL = "extra_TTL";
    public static final String EXTRA_IG = "extra_IG";
    public static final String EXTRA_YT = "extra_YT";
    public static final String EXTRA_TIKTOK = "extra_Tiktok";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String bodyText = "Halo , Saya Armand Maulana ";
            intent.putExtra(Intent.EXTRA_SUBJECT, "Jika Ingin Masukkan Subjek, Masukkan disini");
            intent.putExtra(Intent.EXTRA_TEXT, bodyText);
            startActivity(Intent.createChooser(intent, "Sharing Option"));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_item_photo);
        String url = getIntent().getStringExtra(EXTRA_PHOTO);
        Glide.with(this)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);

        TextView txtNama = findViewById(R.id.tv_item_nama);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        txtNama.setText(getString(R.string.nama) + nama);

        TextView txtAlias = findViewById(R.id.tv_item_alias);
        String alias = getIntent().getStringExtra(EXTRA_TRAVELER);
        txtAlias.setText(getString(R.string.traveler_alias) + alias);

        TextView txtDesk = findViewById(R.id.tv_item_desk);
        String desk = getIntent().getStringExtra(EXTRA_DESK);
        txtDesk.setText(getString(R.string.deskripsi) + desk);

        TextView txtNegara = findViewById(R.id.tv_item_negara);
        String negara = getIntent().getStringExtra(EXTRA_NEGARA);
        txtNegara.setText(getString(R.string.negara) + negara);


        TextView txtTTL = findViewById(R.id.tv_item_ttl);
        String TTL = getIntent().getStringExtra(EXTRA_TTL);
        txtTTL.setText(getString(R.string.TTL) + TTL);

        TextView txtIg = findViewById(R.id.tv_item_ig);
        String ig = getIntent().getStringExtra(EXTRA_IG);
        txtIg.setText(getString(R.string.ig) + ig);

        TextView txtYt = findViewById(R.id.tv_item_yt);
        String yt = getIntent().getStringExtra(EXTRA_YT);
        txtYt.setText(getString(R.string.yt) + yt);

        TextView txtTiktok = findViewById(R.id.tv_item_tiktok);
        String tiktok = getIntent().getStringExtra(EXTRA_TIKTOK);
        txtTiktok.setText(getString(R.string.tiktok) + tiktok);


    }
}
