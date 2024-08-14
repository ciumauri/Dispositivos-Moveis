package com.example.trabalhopratico1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabalhopratico1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        handler = new Handler(Looper.getMainLooper());

        final ImageDownloader imageDownloader = new ImageDownloader(handler);

        binding.btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = binding.etImageUrl.getText().toString();
                if (!url.isEmpty()) {
                    binding.progressBar.setVisibility(View.VISIBLE);
                    imageDownloader.downloadImage(url, new ImageDownloader.ImageDownloadListener() {
                        @Override
                        public void onImageDownloaded(Bitmap bitmap) {
                            binding.progressBar.setVisibility(View.GONE);
                            binding.imageView.setImageBitmap(bitmap);
                        }

                        @Override
                        public void onDownloadFailed(Exception e) {
                            binding.progressBar.setVisibility(View.GONE);
                            binding.imageView.setImageResource(android.R.drawable.ic_dialog_alert);
                        }
                    });
                }
            }
        });
    }
}
