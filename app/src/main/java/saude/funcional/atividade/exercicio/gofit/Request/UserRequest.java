package saude.funcional.atividade.exercicio.gofit.Request;

import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;

public class UserRequest {
    private static final String ME_ENDPOINT = "/me";

    public static void makeUserRequest(GraphRequest.Callback callback) {
        Bundle params = new Bundle();
        params.putString("fields", "picture.type(large),name,id,email,permissions");


        GraphRequest request = new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                ME_ENDPOINT,
                params,
                HttpMethod.GET,
                callback
        );
        request.executeAsync();
    }
}
