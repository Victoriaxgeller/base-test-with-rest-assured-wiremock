package mock;

import api.fakestore.model.BaseModel;
import api.fakestore.model.Cart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class WireMockClient {
    Gson gson = new Gson();

    public <T> T sendPostRequest(T body, String path, Class<T> classOfT) throws IOException {
        String reqBody = gson.toJson(body);
        stubFor(post(urlEqualTo(path)).willReturn(aResponse().withBody(reqBody)));
        OkHttpClient client = new OkHttpClient();

        String jsonObject = client.newCall(buildRequest(reqBody, path)).execute().body().string();
        return gson.fromJson(jsonObject, TypeToken.get(classOfT));

    }

    public Request buildRequest(String body, String path) {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), body);
        return new Request.Builder()
                .url("http://localhost:8088" + path)
                .post(requestBody)
                .build();
    }
}
