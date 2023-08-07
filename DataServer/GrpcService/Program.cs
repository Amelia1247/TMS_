using Contracts;
using EfcData;
using EfcData.ServiceImpl;
using GrpcService.GrpcController;
using Microsoft.AspNetCore.Server.Kestrel.Core;

using PlayerConverter = GrpcService.converters.PlayerConverter;
using TeamConverter = GrpcService.converters.TeamConverter;
using TournamentConverter = GrpcService.converters.TournamentConverter;
using UserConverter = GrpcService.converters.UserConverter;

var builder = WebApplication.CreateBuilder(args);

builder.WebHost.ConfigureKestrel(options =>
{
    // Setup a HTTP/2 endpoint without TLS.
    options.ListenLocalhost(5081, o => o.Protocols =
        HttpProtocols.Http2);
});

// Add services to the container.
builder.Services.AddDbContext<DatabaseAccess>();
builder.Services.AddGrpc();
builder.Services.AddScoped<IUserService, UserServiceImpl>();
builder.Services.AddScoped<IPlayerService, PlayerServiceImpl>();
builder.Services.AddScoped<ITeamService, TeamServiceImpl>();
builder.Services.AddScoped<ITournamentService, TournamentServiceImpl>();
builder.Services.AddScoped<EfcData.converters.TeamConverter>();
builder.Services.AddScoped<EfcData.converters.PlayerConverter>();
builder.Services.AddScoped<EfcData.converters.TournamentConverter>();
builder.Services.AddScoped<EfcData.converters.UserConverter>();
builder.Services.AddScoped<UserConverter>();
builder.Services.AddScoped<PlayerConverter>();
builder.Services.AddScoped<TournamentConverter>();
builder.Services.AddScoped<TeamConverter>();


var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGrpcService<UserController>();
app.MapGrpcService<PlayerController>();
app.MapGrpcService<TeamController>();
app.MapGrpcService<TournamentController>();
app.MapGet("/", () => "Communication with gRPC endpoints must be made through a gRPC client. To learn how to create a client, visit: https://go.microsoft.com/fwlink/?linkid=2086909");

app.Run();