using System.Text;
using BlazorApplication.Authentication;
using Contracts;
using HttpClients;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.IdentityModel.Tokens;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddRazorPages();
builder.Services.AddServerSideBlazor();


builder.Services.AddScoped<IUserService, UserHttpClient>();
builder.Services.AddScoped<IPlayerService, PlayerHttpClient>();
builder.Services.AddScoped<ITeamService, TeamHttpClient>();
builder.Services.AddScoped<ITournamentService, TournamentHttpClient>();
builder.Services.AddScoped<AuthenticationStateProvider, AuthenticationProvider>();
builder.Services.AddScoped<IAuthService, AuthService>();

builder.Services.AddAuthorization(options => {
    options.AddPolicy("Admin", policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Admin"));
    options.AddPolicy("Guest", policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Guest"));
    options.AddPolicy("All",
        policyBuilder => policyBuilder.RequireAuthenticatedUser().RequireClaim("Role", "Guest", "Admin"));

});

// Add authentication with info about JWT
 builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
 {
     options.RequireHttpsMetadata = false;
     options.SaveToken = true;
     options.TokenValidationParameters = new TokenValidationParameters()
     {
         ValidateIssuer = true,
         ValidateAudience = true,
         ValidAudience = builder.Configuration["Jwt:Audience"],
         ValidIssuer = builder.Configuration["Jwt:Issuer"],
         IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"]))
     };
 });
var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();

app.UseStaticFiles();

app.UseRouting();

app.MapBlazorHub();
app.MapFallbackToPage("/_Host");
app.UseAuthentication(); //Use authentication


app.Run();
