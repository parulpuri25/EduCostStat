package com.example.tasks;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class EduCostStatDao1 {
    
	private MongoCollection<Document> collection;

    public EduCostStatDao1(MongoDatabase database) {
        collection = database.getCollection("EduCostStat");
    }
	
    public List<Document> query1(String year, String state, String type, String length, String expense) {
        Document query = new Document("Year", year)
                .append("State", state)
                .append("Type", type)
                .append("Length", length)
                .append("Expense", expense);

        FindIterable<Document> result = collection.find(query);
        List<Document> resultList = new ArrayList<>();
        for (Document doc : result) {
            resultList.add(doc);
        }
        return resultList;
    }
	
	
	
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("MyDatabase");
        EduCostStatDao1 dao1 = new EduCostStatDao1(database);

        // Query the collection with the desired parameters
        List<Document> result1 = dao1.query1("2021", "New York", "Private", "4-year","Fees/Tuition");
        List<Document> resultList1 = new ArrayList<>();
        for (Document doc : result1) {
            System.out.println(doc.toJson());
            resultList1.add(doc);
        }

        // Insert each document from the result list into the new collection
        if (!resultList1.isEmpty()) {
            MongoCollection<Document> collection1 = database.getCollection("EduCostStatQueryOne");
            for (Document doc : resultList1) {
                Document existingDoc = collection1.find(Filters.eq("_id", doc.get("_id"))).first();
                if (existingDoc == null) {
                    collection1.insertOne(doc);
                } else {
                    System.out.println("Document with _id " + doc.get("_id") + " already exists in collection: " + collection1);
                }
            }
        }
        client.close();

	}

}
