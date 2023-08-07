package grpcProtoFiles;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: player.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PlayerServiceGrpc {

  private PlayerServiceGrpc() {}

  public static final String SERVICE_NAME = "player.PlayerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest,
      grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> getCreatePlayerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePlayer",
      requestType = grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest.class,
      responseType = grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest,
      grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> getCreatePlayerMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest, grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> getCreatePlayerMethod;
    if ((getCreatePlayerMethod = PlayerServiceGrpc.getCreatePlayerMethod) == null) {
      synchronized (PlayerServiceGrpc.class) {
        if ((getCreatePlayerMethod = PlayerServiceGrpc.getCreatePlayerMethod) == null) {
          PlayerServiceGrpc.getCreatePlayerMethod = getCreatePlayerMethod =
              io.grpc.MethodDescriptor.<grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest, grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePlayer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlayerServiceMethodDescriptorSupplier("CreatePlayer"))
              .build();
        }
      }
    }
    return getCreatePlayerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest,
      grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> getGetAllPlayersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPlayers",
      requestType = grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest.class,
      responseType = grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest,
      grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> getGetAllPlayersMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest, grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> getGetAllPlayersMethod;
    if ((getGetAllPlayersMethod = PlayerServiceGrpc.getGetAllPlayersMethod) == null) {
      synchronized (PlayerServiceGrpc.class) {
        if ((getGetAllPlayersMethod = PlayerServiceGrpc.getGetAllPlayersMethod) == null) {
          PlayerServiceGrpc.getGetAllPlayersMethod = getGetAllPlayersMethod =
              io.grpc.MethodDescriptor.<grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest, grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPlayers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlayerServiceMethodDescriptorSupplier("GetAllPlayers"))
              .build();
        }
      }
    }
    return getGetAllPlayersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest,
      grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> getGetPlayersByTeamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPlayersByTeam",
      requestType = grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest.class,
      responseType = grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest,
      grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> getGetPlayersByTeamMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest, grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> getGetPlayersByTeamMethod;
    if ((getGetPlayersByTeamMethod = PlayerServiceGrpc.getGetPlayersByTeamMethod) == null) {
      synchronized (PlayerServiceGrpc.class) {
        if ((getGetPlayersByTeamMethod = PlayerServiceGrpc.getGetPlayersByTeamMethod) == null) {
          PlayerServiceGrpc.getGetPlayersByTeamMethod = getGetPlayersByTeamMethod =
              io.grpc.MethodDescriptor.<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest, grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPlayersByTeam"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PlayerServiceMethodDescriptorSupplier("GetPlayersByTeam"))
              .build();
        }
      }
    }
    return getGetPlayersByTeamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PlayerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerServiceStub>() {
        @java.lang.Override
        public PlayerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerServiceStub(channel, callOptions);
        }
      };
    return PlayerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PlayerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerServiceBlockingStub>() {
        @java.lang.Override
        public PlayerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerServiceBlockingStub(channel, callOptions);
        }
      };
    return PlayerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PlayerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PlayerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PlayerServiceFutureStub>() {
        @java.lang.Override
        public PlayerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PlayerServiceFutureStub(channel, callOptions);
        }
      };
    return PlayerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PlayerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createPlayer(grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePlayerMethod(), responseObserver);
    }

    /**
     */
    public void getAllPlayers(grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPlayersMethod(), responseObserver);
    }

    /**
     */
    public void getPlayersByTeam(grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPlayersByTeamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreatePlayerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest,
                grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse>(
                  this, METHODID_CREATE_PLAYER)))
          .addMethod(
            getGetAllPlayersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest,
                grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse>(
                  this, METHODID_GET_ALL_PLAYERS)))
          .addMethod(
            getGetPlayersByTeamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest,
                grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse>(
                  this, METHODID_GET_PLAYERS_BY_TEAM)))
          .build();
    }
  }

  /**
   */
  public static final class PlayerServiceStub extends io.grpc.stub.AbstractAsyncStub<PlayerServiceStub> {
    private PlayerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createPlayer(grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePlayerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPlayers(grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllPlayersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPlayersByTeam(grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPlayersByTeamMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PlayerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PlayerServiceBlockingStub> {
    private PlayerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse createPlayer(grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePlayerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse getAllPlayers(grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllPlayersMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse getPlayersByTeam(grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPlayersByTeamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PlayerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PlayerServiceFutureStub> {
    private PlayerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PlayerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PlayerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse> createPlayer(
        grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePlayerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse> getAllPlayers(
        grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllPlayersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse> getPlayersByTeam(
        grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPlayersByTeamMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PLAYER = 0;
  private static final int METHODID_GET_ALL_PLAYERS = 1;
  private static final int METHODID_GET_PLAYERS_BY_TEAM = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PlayerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PlayerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PLAYER:
          serviceImpl.createPlayer((grpcProtoFiles.PlayerOuterClass.CreatePlayerRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.CreatePlayerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_PLAYERS:
          serviceImpl.getAllPlayers((grpcProtoFiles.PlayerOuterClass.GetAllPlayersRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetAllPlayersResponse>) responseObserver);
          break;
        case METHODID_GET_PLAYERS_BY_TEAM:
          serviceImpl.getPlayersByTeam((grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.PlayerOuterClass.GetPlayersByTeamResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PlayerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PlayerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpcProtoFiles.PlayerOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PlayerService");
    }
  }

  private static final class PlayerServiceFileDescriptorSupplier
      extends PlayerServiceBaseDescriptorSupplier {
    PlayerServiceFileDescriptorSupplier() {}
  }

  private static final class PlayerServiceMethodDescriptorSupplier
      extends PlayerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PlayerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PlayerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PlayerServiceFileDescriptorSupplier())
              .addMethod(getCreatePlayerMethod())
              .addMethod(getGetAllPlayersMethod())
              .addMethod(getGetPlayersByTeamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
