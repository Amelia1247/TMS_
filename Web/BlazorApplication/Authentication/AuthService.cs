using System.Security.Claims;
using System.Text.Json;
using Contracts;
using HttpClients;
using Microsoft.JSInterop;

namespace BlazorApplication.Authentication;

public class AuthService : IAuthService {
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null;
    private readonly IUserService _userService;

    private static string? JwtToken { get; set; } = string.Empty;


    public AuthService(IUserService userService) {
        this._userService = userService;
    }

    public async Task LoginAsync(string username, string password) {
        var tokenDto = await _userService.LoginAsync(username, password);
        JwtToken = tokenDto.Token;
        HttpClientUtil.AuthenticationToken = JwtToken;
        ClaimsPrincipal claimsPrincipal = CreateClaimsPrincipal();
        OnAuthStateChanged.Invoke(claimsPrincipal);
    }


    public  Task LogOutAsync() {
        JwtToken = string.Empty;
        OnAuthStateChanged.Invoke(new ClaimsPrincipal());
        return Task.CompletedTask;
    }


    public Task<ClaimsPrincipal> GetAuthAsync() {
        return Task.FromResult(CreateClaimsPrincipal());
    }


    private ClaimsPrincipal CreateClaimsPrincipal() {
        if (string.IsNullOrEmpty(JwtToken)) {
            return new ClaimsPrincipal();
        }

        var claims = ParseClaimsFromJwtToken(JwtToken);
        var identity = new ClaimsIdentity(claims, "jwt");
        return new ClaimsPrincipal(identity);
    }

    private IEnumerable<Claim> ParseClaimsFromJwtToken(string jwt) {
        string payload = jwt.Split('.')[1];
        byte[] jsonBytes = ParseBase64WithoutPadding(payload);
        Dictionary<string, object>? keyValuePairs = JsonSerializer.Deserialize<Dictionary<string, object>>(jsonBytes);
        return keyValuePairs!.Select(kvp => new Claim(kvp.Key, kvp.Value.ToString()!));
    }

    private byte[] ParseBase64WithoutPadding(string base64) {
        switch (base64.Length % 4) {
            case 2:
                base64 += "==";
                break;
            case 3:
                base64 += "=";
                break;
        }

        return Convert.FromBase64String(base64);
    }


}