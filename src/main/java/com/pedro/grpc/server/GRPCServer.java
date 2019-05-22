package com.pedro.grpc.server;

import java.io.IOException;

import javax.sql.rowset.serial.SerialBlob;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
       System.out.println("Arrancado Servicio");
       Server server = ServerBuilder.forPort(50051).build();
      
       System.out.println("Arrancando servidor..");
       server.start();
       System.out.println("Servidor Arrancado");
       Runtime.getRuntime().addShutdownHook(new Thread( () -> {
           System.out.println("Peticion de apagado");
           server.isShutdown();
           System.out.println("Servidor apagado");
       }));
       server.awaitTermination();
    }

    
}
