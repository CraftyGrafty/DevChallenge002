import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.MongoClientSettings;
import com.mongodb.BasicDBObject;
import org.bson.Document;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        ConnectionString connString = new ConnectionString(
                "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false"
        );
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .retryWrites(true)
                .build();
        MongoClient mongoClient = MongoClients.create();
        MongoCollection collection = mongoClient.getDatabase("test").getCollection("TestCollection");

        //Document document = new Document("hello", "world");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("hello","world");
        MongoCursor cursor = collection.find(searchQuery).cursor();
        System.out.println("cursor start");
        if (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        System.out.println("cursor end");


        String world = "2";
        System.out.println("Hello World " + world);
    }
}
