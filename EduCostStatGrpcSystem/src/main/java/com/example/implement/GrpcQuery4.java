package com.example.implement;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.example.proto.Query4.Query4Request;
import com.example.proto.Query4.Query4Response;
import com.example.proto.Query4.Result4;
import com.example.proto.Query4ServiceGrpc.Query4ServiceImplBase;
import com.example.tasks.EduCostStatDao4;

import io.grpc.stub.StreamObserver;

public class GrpcQuery4 extends Query4ServiceImplBase{
	
	private EduCostStatDao4 query4DAO;

    public GrpcQuery4(EduCostStatDao4 query4DAO) {
        this.query4DAO = query4DAO;
    }

	@Override
	public void query4(Query4Request request, StreamObserver<Query4Response> responseObserver) {
    List<Document> documents = query4DAO.query4(request.getPastYears(), request.getType(),request.getLength()); 
		
		List<Result4> results4 = new ArrayList<>();
        for (Document document : documents) {
        	Result4 result4 = Result4.newBuilder()
                    .setState(document.getString("State"))
                    .setGrowthRate(document.getDouble("GrowthRate"))
                    .setPastYears(document.getInteger("Range of PastYears"))
                    .build();
        	
        		results4.add(result4);
        	
        	
        }
        Query4Response response = Query4Response.newBuilder()
                .addAllResult4(results4)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
	}

	
    

}
