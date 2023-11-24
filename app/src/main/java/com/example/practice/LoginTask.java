package com.example.practice;

import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginTask extends AsyncTask<String, Void, String> {

    private LoginTaskListener listener;

    // 리스너 메서드를 정의하는 인터페이스
    public interface LoginTaskListener {
        void onLoginSuccess(String response);
        void onLoginError(String error);
    }

    // 리스너를 설정하는 생성자
    public LoginTask(LoginTaskListener listener) {
        this.listener = listener;
    }
    @Override
    protected String doInBackground(String... params) {
        String urlString = ServerURL.getURL(); // 서버의 실제 URL
        String id = params[0];
        String pw = params[1];

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            JSONObject data = new JSONObject();
            data.put("id", id);
            data.put("pw", pw);

            outputStream.write(data.toString().getBytes());

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                return response.toString();
            } else {
                return "Error: " + connection.getResponseMessage();
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.startsWith("Error")) {
            listener.onLoginError(result);
        } else {
            listener.onLoginSuccess(result);
        }
    }
}