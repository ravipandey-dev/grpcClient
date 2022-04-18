package com.test.grpcClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userGrpc.userBlockingStub userBlockingStub = userGrpc.newBlockingStub(channel);
        User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("RAV").setPassword("abc").build();
        User.Response response = userBlockingStub.login(request);
        System.out.println("response recieved with status " + response.getResponseCode());
    }
}
