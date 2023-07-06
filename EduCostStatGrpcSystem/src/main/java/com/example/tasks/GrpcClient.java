package com.example.tasks;

import java.net.SocketException;

import com.example.proto.Query1.Query1Request;
import com.example.proto.Query1.Query1Response;
import com.example.proto.Query1.Result;
import com.example.proto.Query1ServiceGrpc;
import com.example.proto.Query1ServiceGrpc.Query1ServiceBlockingStub;
import com.example.proto.Query2.Query2Request;
import com.example.proto.Query2.Query2Response;
import com.example.proto.Query2.Result2;
import com.example.proto.Query2ServiceGrpc;
import com.example.proto.Query2ServiceGrpc.Query2ServiceBlockingStub;
import com.example.proto.Query3.Query3Request;
import com.example.proto.Query3.Query3Response;
import com.example.proto.Query3.Result3;
import com.example.proto.Query3ServiceGrpc;
import com.example.proto.Query3ServiceGrpc.Query3ServiceBlockingStub;
import com.example.proto.Query4.Query4Request;
import com.example.proto.Query4.Query4Response;
import com.example.proto.Query4.Result4;
import com.example.proto.Query4ServiceGrpc;
import com.example.proto.Query4ServiceGrpc.Query4ServiceBlockingStub;
import com.example.proto.Query5.Query5Request;
import com.example.proto.Query5.Query5Response;
import com.example.proto.Query5.Result5;
import com.example.proto.Query5ServiceGrpc;
import com.example.proto.Query5ServiceGrpc.Query5ServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GrpcClient {

    public static void main(String[] args) throws SocketException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092).usePlaintext().build();
        Query1ServiceBlockingStub queryStub = Query1ServiceGrpc.newBlockingStub(channel);
        Query1Request request = Query1Request.newBuilder()
            .setYear("2021")
            .setState("New York")
            .setLength("4-year")
            .setType("Private")
            .setExpense("Fees/Tuition")
            .build();
       Query2ServiceBlockingStub query2Stub = Query2ServiceGrpc.newBlockingStub(channel);
       Query2Request request2 = Query2Request.newBuilder()
                .setYear("2013")
                .setLength("4-year")
                .setType("Private")
                .build();
       Query3ServiceBlockingStub query3Stub = Query3ServiceGrpc.newBlockingStub(channel);
       Query3Request request3 = Query3Request.newBuilder()
                .setYear("2013")
                .setLength("4-year")
                .setType("Private")
                .build();
       Query4ServiceBlockingStub query4Stub = Query4ServiceGrpc.newBlockingStub(channel);
       Query4Request request4 = Query4Request.newBuilder()
    		    .setPastYears(5)
                .setLength("4-year")
                .setType("Private")
                .build();
       Query5ServiceBlockingStub query5Stub = Query5ServiceGrpc.newBlockingStub(channel);
       Query5Request request5 = Query5Request.newBuilder()
                .setYear("2021")
                .setLength("4-year")
                .setType("Private")
                .setRegion("West")
                .build();
        try {
            Query1Response response = queryStub.query1(request);
            Query2Response response2 = query2Stub.query2(request2);
            Query3Response response3 = query3Stub.query3(request3);
            Query4Response response4 = query4Stub.query4(request4);
            Query5Response response5 = query5Stub.query5(request5);
            
            System.out.println("-------Query 1-------");
            for (Result result1 : response.getResultList()) {
                System.out.println("Year: " + result1.getYear());
                System.out.println("State: " + result1.getState());
                System.out.println("Type: " + result1.getType());
                System.out.println("Length: " + result1.getLength());
                System.out.println("Expense: " + result1.getExpense());
                System.out.println("Value: " + result1.getValue());
                System.out.println();
            }
            	System.out.println("-------Query 2-------");
            for (Result2 result2 : response2.getResult2List()) {
                System.out.println("Year: " + result2.getYear());
                System.out.println("State: " + result2.getState());
                System.out.println("Type: " + result2.getType());
                System.out.println("Length: " + result2.getLength());
                System.out.println("Expense: " + result2.getExpense());
                System.out.println();
            } 
            System.out.println("-------Query 3-------");
            for (Result3 result3 : response3.getResult3List()) {
                System.out.println("Year: " + result3.getYear());
                System.out.println("State: " + result3.getState());
                System.out.println("Type: " + result3.getType());
                System.out.println("Length: " + result3.getLength());
                System.out.println("Expense: " + result3.getExpense());
                System.out.println();
            } 
            System.out.println("-------Query 4-------");
            for (Result4 result4 : response4.getResult4List()) {
                System.out.println("State: " + result4.getState());
                System.out.println("Growth Rate: " + result4.getGrowthRate());
                System.out.println("Range of Past Years: "+ result4.getPastYears());
                System.out.println();
            } 
            System.out.println("-------Query 5-------");
            for (Result5 result5 : response5.getResult5List()) {
            	System.out.println("Year: "+ result5.getYear());
            	System.out.println("Length: "+ result5.getLength());
            	System.out.println("Type: "+ result5.getType());
                System.out.println("Region: " + result5.getRegion());
                System.out.println("Average Expense: " + result5.getExpense());
                System.out.println();
            } 
        } catch (StatusRuntimeException ex) {
            System.err.println("Caught exception: " + ex.getStatus());
        }finally {
            channel.shutdown();
        }
    }
}
