package com.pedro.grpc.client;

import java.io.IOException;

import com.pedro.grpc.Dummy;
import com.pedro.grpc.DummyServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {

    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("RpcClient ");
        //.usePlaintext() es para que no pete la seguridad
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localHost", 50051).usePlaintext().build();
        System.out.println("Creando cliente sicrono");
        DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);
        System.out.println("Creando cliente asicrono");
        DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc.newFutureStub(channel);
        
        
        
        System.out.println("Cerrando cliente");
        channel.shutdown();
        
    }
    
    
    
    
}
