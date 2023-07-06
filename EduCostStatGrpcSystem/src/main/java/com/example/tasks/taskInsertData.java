package com.example.tasks;

import java.io.FileReader;
import java.io.IOException;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class taskInsertData {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("MyDatabase");
        MongoCollection<Document> col = db.getCollection("EduCostStat");

     try {
            
            CSVReader reader = new CSVReader(new FileReader("data.csv"));

            // Read the header row to get the field names
            String[] header = reader.readNext();

            
            String[] row;
            while ((row = reader.readNext()) != null) {
                Document doc = new Document()
                        .append("Year", row[0])
                        .append("State", row[1])
                        .append("Type", row[2])
                        .append("Length", row[3])
                        .append("Expense", row[4])
                        .append("Value", row[5])
                        .append("Region", row[6]);
                col.insertOne(doc);
            }

                    } catch (IOException | CsvException e) {
            ( e).printStackTrace();
        }
      
  
}}