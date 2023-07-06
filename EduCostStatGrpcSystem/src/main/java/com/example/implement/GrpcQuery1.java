package com.example.implement;

import java.util.ArrayList;
import java.util.List;
import com.example.proto.Query1.Query1Request;
import com.example.proto.Query1.Query1Response;
import com.example.proto.Query1ServiceGrpc.Query1ServiceImplBase;
import com.example.tasks.EduCostStatDao1;
import com.example.proto.Query1.Result;
import org.bson.Document;

import io.grpc.stub.StreamObserver;

public class GrpcQuery1 extends Query1ServiceImplBase {
    private EduCostStatDao1 query1DAO;

    public GrpcQuery1(EduCostStatDao1 query1DAO) {
        this.query1DAO = query1DAO;
    }

    
    @Override
    public void query1(Query1Request request, StreamObserver<Query1Response> responseObserver) {
        List<Document> documents = query1DAO.query1(request.getYear(), request.getState(), request.getType(),
                request.getLength(), request.getExpense());

        List<Result> results = new ArrayList<>();
        for (Document document : documents) {
            Result result = Result.newBuilder()
                    .setYear(document.getString("Year"))
                    .setState(document.getString("State"))
                    .setType(document.getString("Type"))
                    .setLength(document.getString("Length"))
                    .setExpense(document.getString("Expense"))
                    .setValue(document.getString("Value"))
                    .build();
            results.add(result);
        }

        Query1Response response = Query1Response.newBuilder()
                .addAllResult(results)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
