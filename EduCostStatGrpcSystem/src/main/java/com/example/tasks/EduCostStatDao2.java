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

public class EduCostStatDao2 {
	
	private MongoCollection<Document> collection;

    public EduCostStatDao2(MongoDatabase database) {
        collection = database.getCollection("EduCostStat");
    }
    
	public List<Document> query2(String year,String type, String length) {
    	List<Bson> pipeline2 = new ArrayList<>();
    	Bson match = Filters.and(Filters.eq("Year", year), Filters.eq("Type", type), Filters.eq("Length", length));
        pipeline2.add(Aggregates.match(match));

        
        // Stage 2: Group documents by state and calculate the total expense for each state
        Bson group = Aggregates.group("$State",
                Accumulators.sum("TotalExpense", new Document("$toDouble", "$Value")),
                Accumulators.first("Year", year),
                Accumulators.first("Type", type),
                Accumulators.first("Length", length));
        pipeline2.add(group);

        // Stage 3: Sort documents by total expense in descending order and limit to the top 5
        Bson sort = Aggregates.sort(Sorts.descending("TotalExpense"));
        pipeline2.add(sort);
        Bson limit = Aggregates.limit(5);
        pipeline2.add(limit);

        // Execute the pipeline
        AggregateIterable<Document> result2 = collection.aggregate(pipeline2);
        List<Document> resultList2 = new ArrayList<>();
        for (Document doc : result2) {
            resultList2.add(doc);
        }
		return resultList2;

    }
	
	
	
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("MyDatabase");
        EduCostStatDao2 dao2 = new EduCostStatDao2(database);
		List<Document> result2 = dao2.query2("2021","Private", "4-year");
        List<Document> resultList2 = new ArrayList<>();
        for (Document doc : result2) {
            System.out.println(doc.toJson());
            resultList2.add(doc);
        }

        // Insert each document from the result list into the new collection
        if (!resultList2.isEmpty()) {
            MongoCollection<Document> collection2 = database.getCollection("EduCostStatQueryTwo");
            for (Document doc : resultList2) {
                Document existingDoc = collection2.find(Filters.eq("_id", doc.get("_id"))).first();
                if (existingDoc == null) {
                    collection2.insertOne(doc);
                } else {
                    System.out.println("Document with _id " + doc.get("_id") + " already exists in collection: " + collection2);
                }
            }
        }
        client.close();

	}

}
