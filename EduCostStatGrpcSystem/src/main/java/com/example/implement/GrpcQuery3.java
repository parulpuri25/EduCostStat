package com.example.implement;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.example.proto.Query3.Query3Request;
import com.example.proto.Query3.Query3Response;
import com.example.proto.Query3.Result3;
import com.example.proto.Query3ServiceGrpc.Query3ServiceImplBase;
import com.example.tasks.EduCostStatDao3;

import io.grpc.stub.StreamObserver;

public class GrpcQuery3 extends Query3ServiceImplBase{
	
	private EduCostStatDao3 query3DAO;

    public GrpcQuery3(EduCostStatDao3 query3DAO) {
        this.query3DAO = query3DAO;
    }

	@Override
	public void query3(Query3Request request, StreamObserver<Query3Response> responseObserver) {
		List<Document> documents = query3DAO.query3(request.getYear(), request.getType(),request.getLength()); 
		
		List<Result3> results3 = new ArrayList<>();
        for (Document document : documents) {
        	Result3 result3 = Result3.newBuilder()
                    .setYear(document.getString("Year"))
                    .setState(document.getString("_id"))
                    .setType(document.getString("Type"))
                    .setLength(document.getString("Length"))
                    .setExpense(document.getDouble("TotalExpense"))
                    .build();
        	if (result3.getState() != null) {
        		results3.add(result3);
        	} else {
        	    System.out.println("Found a null value for state");
        	}
        	
        }
        Query3Response response = Query3Response.newBuilder()
                .addAllResult3(results3)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
	}
     
    

}
