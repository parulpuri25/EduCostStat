package com.example.implement;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.example.proto.Query5.Query5Request;
import com.example.proto.Query5.Query5Response;
import com.example.proto.Query5.Result5;
import com.example.proto.Query5ServiceGrpc.Query5ServiceImplBase;
import com.example.tasks.EduCostStatDao5;

import io.grpc.stub.StreamObserver;

public class GrpcQuery5 extends Query5ServiceImplBase {
	
	
	private EduCostStatDao5 query5DAO;

    public GrpcQuery5(EduCostStatDao5 query5DAO) {
        this.query5DAO = query5DAO;
    }

	@Override
	public void query5(Query5Request request, StreamObserver<Query5Response> responseObserver) {
    List<Document> documents = query5DAO.query5(request.getYear(), request.getType(),request.getLength(),request.getRegion()); 
		
		List<Result5> results5 = new ArrayList<>();
        for (Document document : documents) {
        	Result5 result5 = Result5.newBuilder()
        			.setYear(document.getString("Year"))
        			.setLength(document.getString("Length"))
        			.setType(document.getString("Type"))
                    .setRegion(document.getString("_id"))
                    .setExpense(document.getDouble("AvgExpense"))
                    .build();
        	
        		results5.add(result5);
        	
        	
        }
        Query5Response response = Query5Response.newBuilder()
                .addAllResult5(results5)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
	}

	
    

}

