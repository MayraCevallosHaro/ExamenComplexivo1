package com.example.myapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {

    private String paises;
    private String alphacode2;
    private String alphacode3;

    public String getPaises() {
        return paises;
    }

    public void setPaises(String paises) {
        this.paises = paises;
    }

    public String getAlphacode2() {
        return alphacode2;
    }

    public void setAlphacode2(String alphacode2) {
        this.alphacode2 = alphacode2;
    }

    public String getAlphacode3() {
        return alphacode3;
    }

    public void setAlphacode3(String alphacode3) {
        this.alphacode3 = alphacode3;
    }

    public void setUrlbandera(String urlbandera) {
        this.urlbandera = urlbandera;
    }

    public String getUrlbandera() {
        return urlbandera;
    }

    private String urlbandera;


    public Paises(JSONObject a) throws JSONException {
        paises =  a.getString("name").toString();

        alphacode2 =  a.getString("alpha2_code").toString() ;
        alphacode3 =  a.getString("alpha3_code").toString() ;
        urlbandera = "http://www.geognos.com/api/en/countries/flag/" + a.getString("alpha2_code").toString()  + ".png";
    }

    public static ArrayList<Paises> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Paises> paises = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            paises.add(new Paises(datos.getJSONObject(i)));
        }
        return paises;
    }
}