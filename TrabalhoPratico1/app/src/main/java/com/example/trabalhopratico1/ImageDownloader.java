package com.example.trabalhopratico1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {

    public interface ImageDownloadListener {
        void onImageDownloaded(Bitmap bitmap);
        void onDownloadFailed(Exception e);
    }

    private final Handler handler;

    public ImageDownloader(Handler handler) {
        this.handler = handler;
    }

    public void downloadImage(final String url, final ImageDownloadListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream in = new URL(url).openStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(in);
                    in.close();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onImageDownloaded(bitmap);
                        }
                    });
                } catch (final IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onDownloadFailed(e);
                        }
                    });
                }
            }
        }).start();
    }
}
