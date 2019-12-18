package be.thomasmore.voetbalapp2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.models.Fixture;

public class JsonHelper {

    public List<Fixture> getFixtures(String result) {
        List<Fixture> lijst = new ArrayList<Fixture>();

        try {
            JSONObject rootJsonObj = new JSONObject(result);
            JSONArray jsonArrayFixtures = rootJsonObj.optJSONArray("fixtures");
            for (int i = 0; i < jsonArrayFixtures.length(); i++) {
                JSONObject jsonObjectVak = jsonArrayFixtures.optJSONObject(i);
                Fixture fixture = new Fixture();
                fixture.setId(jsonObjectVak.optString("id"));
                fixture.setDate(jsonObjectVak.optString("date"));
                fixture.setTime(jsonObjectVak.optString("time"));
                fixture.setHome_name(jsonObjectVak.optString("home_name"));
                fixture.setAway_name(jsonObjectVak.optString("away_name"));
                lijst.add(fixture);
            }
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        return lijst;
    }



//    public List<Vak> getVakken(String jsonTekst) {
//        List<Vak> lijst = new ArrayList<Vak>();
//
//        try {
//            JSONArray jsonArrayVakken = new JSONArray(jsonTekst);
//            for (int i = 0; i < jsonArrayVakken.length(); i++) {
//                JSONObject jsonObjectVak = jsonArrayVakken.getJSONObject(i);
//
//                Vak vak = new Vak();
//                vak.setId(jsonObjectVak.getLong("id"));
//                vak.setNaam(jsonObjectVak.getString("naam"));
//                lijst.add(vak);
//            }
//        } catch (JSONException e) {
//            Log.e("JSON Parser", "Error parsing data " + e.toString());
//        }
//
//        return lijst;
//    }
//
//    public Student getStudent(String jsonTekst) {
//        Student student = new Student();
//
//
//
//        return student;
//    }
//
//    public School getSchool(String jsonTekst) {
//        School school = null;
//
//        try {
//            JSONObject jsonObjectSchool = new JSONObject(jsonTekst);
//            school = new School();
//            school.setNaam(jsonObjectSchool.getString("naam"));
//            school.setStraat(jsonObjectSchool.getString("straat"));
//            school.setGemeente(jsonObjectSchool.getString("gemeente"));
//
//            JSONArray jsonArrayTelefoonnummers = jsonObjectSchool.getJSONArray("telefoonnummers");
//            for (int i = 0; i < jsonArrayTelefoonnummers.length(); i++) {
//                JSONObject jsonObjectTelefoonnummer = jsonArrayTelefoonnummers.getJSONObject(i);
//
//                Telefoonnummer telefoonnummer = new Telefoonnummer();
//                telefoonnummer.setPlaats(jsonObjectTelefoonnummer.getString("plaats"));
//                telefoonnummer.setNummer(jsonObjectTelefoonnummer.getString("nummer"));
//                school.addTelefoonnummer(telefoonnummer);
//            }
//        } catch (JSONException e) {
//            Log.e("JSON Parser", "Error parsing data " + e.toString());
//        }
//
//        return school;
//    }
//
//    public JSONObject getJsonStudent (Student student) {
//        JSONObject jsonObjectStudent = new JSONObject();
//        try {
//            jsonObjectStudent.put("voornaam", student.getVoornaam());
//            jsonObjectStudent.put("naam", student.getNaam());
//            jsonObjectStudent.put("klas", student.getKlas());
//        } catch (JSONException e) {
//            Log.e("JSON Parser", "Error parsing data " + e.toString());
//        }
//        return jsonObjectStudent;
//    }

}


