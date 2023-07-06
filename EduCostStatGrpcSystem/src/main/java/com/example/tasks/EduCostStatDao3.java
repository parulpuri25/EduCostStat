package com.example.tasks;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class EduCostStatDao3 {
     
	private MongoCollection<Document> collection;

    public EduCostStatDao3(MongoDatabase database) {
        collection = database.getCollection("EduCostStat");
    }
    
    public List<Document> query3(String year,String type, String length) {
    	List<Bson> pipeline3 = new ArrayList<>();

        // Stage 1: Match documents with the specified year, type, and length
        Bson match3 = Filters.and(Filters.eq("Year", year), Filters.eq("Type", type), Filters.eq("Length", length));
        pipeline3.add(Aggregates.match(match3));

        // Stage 2: Group documents by state and calculate the total expense for each state
        Bson group3 = Aggregates.group("$State",
                Accumulators.sum("TotalExpense", new Document("$toDouble", "$Value")),
                Accumulators.first("Year", year),
                Accumulators.first("Type", type),
                Accumulators.first("Length", length));
        pipeline3.add(group3);

        // Stage 3: Sort documents by total expense in ascending order and limit to the top 5
        Bson sort3 = Aggregates.sort(Sorts.ascending("TotalExpense"));
        pipeline3.add(sort3);
        Bson limit3 = Aggregates.limit(5);
        pipeline3.add(limit3);

        // Execute the pipeline
        AggregateIterable<Document> result3 = collection.aggregate(pipeline3);
        List<Document> resultList3 = new ArrayList<>();
        for (Document doc : result3) {
            resultList3.add(doc);
        }
		return resultList3;
    	
    }
	
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("MyDatabase");
        EduCostStatDao3 dao3 = new EduCostStatDao3(database);
		List<Document> result3 = dao3.query3("2013","Private", "4-year");
        List<Document> resultList3 = new ArrayList<>();
        for (Document doc : result3) {
            System.out.println(doc.toJson());
            resultList3.add(doc);
        }

        // Insert each document from the result list into the new collection
        if (!resultList3.isEmpty()) {
            MongoCollection<Document> collection3 = database.getCollection("EduCostStatQueryThree");
            for (Document doc : resultList3) {
                Document existingDoc = collection3.find(Filters.eq("_id", doc.get("_id"))).first();
                if (existingDoc == null) {
                    collection3.insertOne(doc);
                } else {
                    System.out.println("Document with _id " + doc.get("_id") + " already exists in collection: " + collection3);
                }
            }
            client.close();
        }

	}

}
