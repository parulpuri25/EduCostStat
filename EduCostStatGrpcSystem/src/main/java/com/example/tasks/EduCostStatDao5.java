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

public class EduCostStatDao5 {

	
	private MongoCollection<Document> collection;

    public EduCostStatDao5(MongoDatabase database) {
        collection = database.getCollection("EduCostStat");
    }
    
public List<Document> query5(String year,String type, String length,String region) {
    	


    	List<Bson> pipeline5 = new ArrayList<>();
    	  Bson match5 = Filters.and(Filters.eq("Year", year), Filters.eq("Type", type), Filters.eq("Length", length),
    			  Filters.eq("Region",region));
    	  pipeline5.add(Aggregates.match(match5));
    	 Bson group5 = Aggregates.group("$Region",
    	          Accumulators.avg("AvgExpense", new Document("$toDouble", "$Value")),
    	          Accumulators.first("Year", year),
                  Accumulators.first("Type", type),
                  Accumulators.first("Length", length));
    	  pipeline5.add(group5);
    	  AggregateIterable<Document> result5 = collection.aggregate(pipeline5);
    	  List<Document> resultList5 = new ArrayList<>();
    	  for (Document doc : result5) {
    	      resultList5.add(doc);
    	  }
		return resultList5;

    }
    
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("MyDatabase");
        EduCostStatDao5 dao5 = new EduCostStatDao5(database);
        List<Document> result5 = dao5.query5("2021","Private", "4-year","West");
        System.out.println(result5);
        
        if (!result5.isEmpty()) {
            MongoCollection<Document> collection5 = database.getCollection("EduCostStatQueryFive");
            for (Document doc : result5) {
                Document existingDoc = collection5.find(Filters.eq("_id", doc.get("_id"))).first();
                if (existingDoc == null) {
                    collection5.insertOne(doc);
                } else {
                    System.out.println("Document with _id " + doc.get("_id") + " already exists in collection: " + collection5);
                }
            }
        }
        client.close();
	}
    
}
