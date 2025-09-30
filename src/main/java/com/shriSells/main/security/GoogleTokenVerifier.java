package com.shriSells.main.security;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.Collections;

public class GoogleTokenVerifier {

    private static final String CLIENT_ID = "GID.apps.googleusercontent.com";

    private static final GoogleIdTokenVerifier verifier =
            new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                    .setAudience(Collections.singletonList(CLIENT_ID))
                    .build();

    public static GoogleIdToken.Payload verify(String idTokenString) {
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                return idToken.getPayload(); // contains email, name, sub, etc.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
