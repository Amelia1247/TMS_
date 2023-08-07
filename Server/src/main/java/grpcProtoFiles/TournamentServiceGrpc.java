package grpcProtoFiles;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: tournament.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TournamentServiceGrpc {

  private TournamentServiceGrpc() {}

  public static final String SERVICE_NAME = "tournament.TournamentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest,
      grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> getCreateTournamentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTournament",
      requestType = grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest.class,
      responseType = grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest,
      grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> getCreateTournamentMethod() {
    io.grpc.MethodDescriptor<grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest, grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> getCreateTournamentMethod;
    if ((getCreateTournamentMethod = TournamentServiceGrpc.getCreateTournamentMethod) == null) {
      synchronized (TournamentServiceGrpc.class) {
        if ((getCreateTournamentMethod = TournamentServiceGrpc.getCreateTournamentMethod) == null) {
          TournamentServiceGrpc.getCreateTournamentMethod = getCreateTournamentMethod =
              io.grpc.MethodDescriptor.<grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest, grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTournament"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TournamentServiceMethodDescriptorSupplier("CreateTournament"))
              .build();
        }
      }
    }
    return getCreateTournamentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TournamentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TournamentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TournamentServiceStub>() {
        @java.lang.Override
        public TournamentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TournamentServiceStub(channel, callOptions);
        }
      };
    return TournamentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TournamentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TournamentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TournamentServiceBlockingStub>() {
        @java.lang.Override
        public TournamentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TournamentServiceBlockingStub(channel, callOptions);
        }
      };
    return TournamentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TournamentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TournamentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TournamentServiceFutureStub>() {
        @java.lang.Override
        public TournamentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TournamentServiceFutureStub(channel, callOptions);
        }
      };
    return TournamentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TournamentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createTournament(grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTournamentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTournamentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest,
                grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse>(
                  this, METHODID_CREATE_TOURNAMENT)))
          .build();
    }
  }

  /**
   */
  public static final class TournamentServiceStub extends io.grpc.stub.AbstractAsyncStub<TournamentServiceStub> {
    private TournamentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TournamentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TournamentServiceStub(channel, callOptions);
    }

    /**
     */
    public void createTournament(grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest request,
        io.grpc.stub.StreamObserver<grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTournamentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TournamentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TournamentServiceBlockingStub> {
    private TournamentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TournamentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TournamentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse createTournament(grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTournamentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TournamentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TournamentServiceFutureStub> {
    private TournamentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TournamentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TournamentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse> createTournament(
        grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTournamentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TOURNAMENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TournamentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TournamentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TOURNAMENT:
          serviceImpl.createTournament((grpcProtoFiles.TournamentOuterClass.CreateTournamentRequest) request,
              (io.grpc.stub.StreamObserver<grpcProtoFiles.TournamentOuterClass.CreateTournamentResponse>) responseObserver);
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

  private static abstract class TournamentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TournamentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpcProtoFiles.TournamentOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TournamentService");
    }
  }

  private static final class TournamentServiceFileDescriptorSupplier
      extends TournamentServiceBaseDescriptorSupplier {
    TournamentServiceFileDescriptorSupplier() {}
  }

  private static final class TournamentServiceMethodDescriptorSupplier
      extends TournamentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TournamentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TournamentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TournamentServiceFileDescriptorSupplier())
              .addMethod(getCreateTournamentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
