package com.example.implement;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.example.proto.Query2.Query2Request;
import com.example.proto.Query2.Query2Response;
import com.example.proto.Query2.Result2;
import com.example.proto.Query2ServiceGrpc.Query2ServiceImplBase;
import com.example.tasks.EduCostStatDao2;

import io.grpc.stub.StreamObserver;

public class GrpcQuery2 extends Query2ServiceImplBase{
	
	private EduCostStatDao2 query2DAO;

    public GrpcQuery2(EduCostStatDao2 query2DAO) {
        this.query2DAO = query2DAO;
    }

	@Override
	public void query2(Query2Request request, StreamObserver<Query2Response> responseObserver) {
		List<Document> documents = query2DAO.query2(request.getYear(), request.getType(),request.getLength()); 
		
		List<Result2> results2 = new ArrayList<>();
        for (Document document : documents) {
        	Result2 result2 = Result2.newBuilder()
                    .setYear(document.getString("Year"))
                    .setState(document.getString("_id"))
                    .setType(document.getString("Type"))
                    .setLength(document.getString("Length"))
                    .setExpense(document.getDouble("TotalExpense"))
                    .build();
        	if (result2.getState() != null) {
        		results2.add(result2);
        	} else {
        	    System.out.println("Found a null value for state");
        	}
        	
        }
        Query2Response response = Query2Response.newBuilder()
                .addAllResult2(results2)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
	}
     
    

}
