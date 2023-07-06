package com.example.tasks;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class EduCostStatDao4 {
	
	
	private MongoCollection<Document> collection;

    public EduCostStatDao4(MongoDatabase database) {
        collection = database.getCollection("EduCostStat");
    }
    public List<Document> query4(int pastYears, String type, String length){
    	int baseYear = 2021;
        int startYear = baseYear - pastYears;
        String startYearStr = String.valueOf(startYear);
        String baseYearStr = String.valueOf(baseYear);

		List<Bson> pipeline4 = new ArrayList<>();
		pipeline4.add(Aggregates.match(Filters.and(Filters.gte("Year", startYearStr), Filters.lte("Year", baseYearStr),
				Filters.eq("Type", type), Filters.eq("Length", length))));
		
		pipeline4.add(Aggregates.group(new Document().append("State", "$State").append("Year", "$Year"),
				Accumulators.sum("TotalExpense", new Document("$toDouble", "$Value"))));
		
		pipeline4.add(Aggregates.sort(Sorts.ascending("_id.State", "_id.Year")));
		List<Document> stateYearExpenses = collection.aggregate(pipeline4).into(new ArrayList<>());

		
		List<Document> calgrowthRates = new ArrayList<>();
		List<Document> resultList4 = new ArrayList<>();
		String currentState = "";
		double beginExpense = 0;
		double endExpense = 0;

		for (Document stateYearExpense : stateYearExpenses) {
			String state1 = stateYearExpense.get("_id", Document.class).getString("State");		
			String year1 = stateYearExpense.get("_id", Document.class).getString("Year");
			
			if (!state1.equals(currentState)) {
				currentState = state1;
				beginExpense = ((Number) stateYearExpense.get("TotalExpense")).doubleValue();
				endExpense = 0.0;
				
			} else if (year1.equals(baseYearStr)) {
				endExpense = ((Number) stateYearExpense.get("TotalExpense")).doubleValue();
                // growthRate = (end-begin)/(begin * pastYears) * 100  
				double growthRate = ((double) (endExpense - beginExpense)) / (beginExpense * pastYears) * 100;

				calgrowthRates.add(new Document("State", state1).append("GrowthRate", growthRate).append("Range of PastYears", pastYears));
			}
			calgrowthRates.sort((doc1, doc2) -> Double.compare(doc2.getDouble("GrowthRate"), doc1.getDouble("GrowthRate")));
			resultList4 = calgrowthRates.subList(0, Math.min(5, calgrowthRates.size()));
		}
		return resultList4;
		
    }
	public static void main(String[] args) {
		MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("MyDatabase");
        EduCostStatDao4 dao4 = new EduCostStatDao4(database);
        List<Document> result4 = dao4.query4(1,"Private", "4-year");
        List<Document> resultList4 = new ArrayList<>();
        for (Document doc : result4) {
            System.out.println(doc.toJson());
            resultList4.add(doc);
        }

        // Insert each document from the result list into the new collection
        if (!resultList4.isEmpty()) {
            MongoCollection<Document> collection4 = database.getCollection("EduCostStatQueryFour");
            for (Document doc : resultList4) {
            	Document existingDoc = collection4.find(
            		    Filters.and(
            		        Filters.eq("State", doc.get("State")),
            		        Filters.eq("Range of PastYears", doc.get("Range of PastYears"))
            		    )
            		).first();

                if (existingDoc == null) {
                    collection4.insertOne(doc);
                } else {
                    System.out.println("Document with State " + doc.get("State") + " already exists in collection: " + collection4);
                }
            }
        }
        client.close();
	}

}
