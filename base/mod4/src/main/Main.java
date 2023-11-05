package main;

import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        System.out.println("Все заказы\n");
        String user_id = null;
        ArrayList<String> item_id = new ArrayList<>();
        try {
            ResultSet resultUser = db.getArtUser();
            ResultSet resultItem = db.getArtItem();
            while (resultUser.next()) {
                user_id = resultUser.getString("id");

            while (resultItem.next()){
                item_id.add(resultItem.getString("id"));
            }
            for (String item : item_id){
                db.insertArt(user_id, item);
            }
            ResultSet resOrd = db.getArtOrd();

            while (resOrd.next()) {
                ResultSet resultUserId = db.getArtUserId(resOrd.getString("user_id"));
                ResultSet resultItemId = db.getArtItemId(resOrd.getString("item_id"));
                if (resultUserId.next() & resultItemId.next()) {
                    System.out.print(resultUserId.getString("login") + " - " + resultItemId.getString("title") + "\n");
                }
                resOrd.getString("user_id");
                resOrd.getString("item_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
