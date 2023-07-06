package com.example.tasks;

import java.io.IOException;

import com.example.implement.GrpcQuery1;
import com.example.implement.GrpcQuery2;
import com.example.implement.GrpcQuery3;
import com.example.implement.GrpcQuery4;
import com.example.implement.GrpcQuery5;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        String connectionString = "mongodb+srv://parulpuri0125:Assignment2@cluster0.jev73on.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("MyDatabase");
        EduCostStatDao1 dao1 = new EduCostStatDao1(database);
        EduCostStatDao2 dao2 = new EduCostStatDao2(database);
        EduCostStatDao3 dao3 = new EduCostStatDao3(database);
        EduCostStatDao4 dao4 = new EduCostStatDao4(database);
        EduCostStatDao5 dao5 = new EduCostStatDao5(database);
        GrpcQuery1 query1Service = new GrpcQuery1(dao1);
        GrpcQuery2 query2Service = new GrpcQuery2(dao2);
        GrpcQuery3 query3Service = new GrpcQuery3(dao3);
        GrpcQuery4 query4Service = new GrpcQuery4(dao4);
        GrpcQuery5 query5Service = new GrpcQuery5(dao5);
        Server server = ServerBuilder.forPort(9092).addService(query1Service)
        		.addService(query2Service).addService(query3Service).addService(query4Service).addService(query5Service).build();
        server.start();
        System.out.println("Server started at port " + server.getPort());
        server.awaitTermination();
    }
}
