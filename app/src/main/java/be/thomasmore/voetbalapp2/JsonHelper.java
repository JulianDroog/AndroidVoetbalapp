package be.thomasmore.voetbalapp2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.voetbalapp2.models.Fixture;
import be.thomasmore.voetbalapp2.models.Stats;

public class JsonHelper {

    public List<Fixture> getFixtures(String jsonTekst) {
        List<Fixture> lijst = new ArrayList<Fixture>();
        try {
            JSONArray jsonArrayFixtures = new JSONArray(jsonTekst);
            for (int i = 0; i < jsonArrayFixtures.length(); i++) {
                JSONObject jsonObjectFixture = jsonArrayFixtures.getJSONObject(i);
                Fixture fixture = new Fixture();
                fixture.setId(jsonObjectFixture.getString("_id"));
                fixture.setDate(jsonObjectFixture.getString("date"));
                fixture.setTime(jsonObjectFixture.getString("time"));
                fixture.setHome_name(jsonObjectFixture.getString("home_name"));
                fixture.setAway_name(jsonObjectFixture.getString("away_name"));
                fixture.setCompetitionId(jsonObjectFixture.getString("competitionId"));
                lijst.add(fixture);
            }
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return lijst;
    }



//    public List<Fixture> getVakken(String jsonTekst) {
//        List<Fixture> lijst = new ArrayList<Fixture>();
//
//        try {
//            JSONObject jsonObject = new JSONObject(jsonTekst);
//            JSONArray jsonArrayVakken = jsonObject.getJSONArray("fixtures");
//            for (int i = 0; i < jsonArrayVakken.length(); i++) {
//                JSONObject jsonObjectVak = jsonArrayVakken.getJSONObject(i);
//
//                Fixture vak = new Fixture();
//                vak.setHome_name(jsonObjectVak.getString("home_name"));
//                vak.setAway_name(jsonObjectVak.getString("away_name"));
//                lijst.add(vak);
//            }
//        } catch (JSONException e) {
//            Log.e("JSON Parser", "Error parsing data " + e.toString());
//        }
//        for (Fixture item: lijst
//             ) {
//            Log.d("fixutes",  item.getAway_name());
//        }
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
    public Fixture getJsonFixture (String result) {
        Fixture fixture = new Fixture();
        try {
            JSONObject jsonObjectFixture = new JSONObject(result);
            fixture.setId(jsonObjectFixture.getString("_id"));
            fixture.setDate(jsonObjectFixture.getString("date"));
            fixture.setTime(jsonObjectFixture.getString("time"));
            fixture.setHome_name(jsonObjectFixture.getString("home_name"));
            fixture.setAway_name(jsonObjectFixture.getString("away_name"));
            fixture.setCompetitionId(jsonObjectFixture.getString("competitionId"));
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return fixture;
    }

    public Stats getJsonStats (String result) {
        Stats stats = new Stats();

        try {
            JSONObject rootobject = new JSONObject(result);
            JSONObject jsonObjectFixture = rootobject.getJSONObject("stats");
            stats.setAway_attempts(jsonObjectFixture.getInt("away_attempts"));
            stats.setAway_ontarget(jsonObjectFixture.getInt("away_ontarget"));
            stats.setAway_possesion(jsonObjectFixture.getInt("away_possesion"));
            stats.setAway_redcard(jsonObjectFixture.getInt("away_redcard"));
            stats.setHome_yellowcard(jsonObjectFixture.getInt("away_yellowcard"));
            stats.setHome_attempts(jsonObjectFixture.getInt("home_attempts"));
            stats.setHome_ontarget(jsonObjectFixture.getInt("home_ontarget"));
            stats.setHome_possesion(jsonObjectFixture.getInt("home_possesion"));
            stats.setHome_redcard(jsonObjectFixture.getInt("home_redcard"));
            stats.setHome_yellowcard(jsonObjectFixture.getInt("home_yellowcard"));
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return stats;
    }

    public JSONObject getJsonFixture (Fixture fixture) {
        JSONObject jsonObjectStudent = new JSONObject();
        try {
            jsonObjectStudent.put("competitionId", fixture.getCompetitionId());
            jsonObjectStudent.put("date", fixture.getDate());
            jsonObjectStudent.put("time", fixture.getTime());
            jsonObjectStudent.put("home_name", fixture.getHome_name());
            jsonObjectStudent.put("away_name", fixture.getAway_name());
            jsonObjectStudent.put("home_score", fixture.getHome_score());
            jsonObjectStudent.put("away_score", fixture.getAway_score());
            jsonObjectStudent.put("status", fixture.getStatus());
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jsonObjectStudent;
    }

}


