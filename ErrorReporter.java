package com.linecorp.reviewexam.rockpaperscissors;

import android.os.Handler;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;

/**
 * Utility to report error.
 */
public class ErrorReporter {
    private static final Handler HANDLER = new Handler();

    /**
     * Reports a given exception, which happens while getting an opponent hand.
     */
    public static void report(final IOException e) {
        HANDLER.post(new Runnable() {
            @Override
            public void run() {
                try {

                    HashMap<String, String> postData = new HashMap<>();
                    postData.put("Error", e.toString());

                    JSONObject jsonObject = new JSONObject(postData);
                    URL url = new URL("http://example.com/reporterror");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    try {
                        connection.setRequestMethod("POST");
                    } catch (ProtocolException e1) {
                    }
                    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    connection.setFixedLengthStreamingMode(jsonObject.toString().getBytes().length);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    connection.connect();
                    DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                    outputStream.write(jsonObject.toString().getBytes("UTF-8"));
                    outputStream.flush();
                    outputStream.close();

                    connection.disconnect();
                } catch (IOException e) {
                }
            }
        });
    }
}
