using System.Net.Http.Headers;
using System.Runtime.InteropServices;
using System.Text;
using System.Text.Json;

namespace HttpClients;

public static class HttpClientUtil {
    private const int PortNumber = 8080;
    private const string HostName = "localhost";
    public static string AuthenticationToken { get; set; } = string.Empty;
    
    public static async Task<T> SendHttpPostRequest<B, T>(string path, B body) {
        return await SendHttpRequest<B, T>(RequestType.POST, path, true, body);
    }

    public static async Task<T> SendHttpPostRequestNoToken<B, T>(string path, B body) {
        return await SendHttpRequest<B, T>(RequestType.POST, path, false, body);
    }

    public static async Task<T> SendHttpPutRequest<B, T>(string path, B body) {
        return await SendHttpRequest<B, T>(RequestType.PUT, path, true, body);
    } 
    public static async Task<T> SendHttpPutRequestNoToken<B, T>(string path, B body) {
        return await SendHttpRequest<B, T>(RequestType.PUT, path, false, body);
    }

    public static async Task<T> SendHttpGetRequest<B, T>(string path) {
        return await SendHttpRequest<B, T>(RequestType.GET, path, true);
    }  
    public static async Task<T> SendHttpGetRequestNoToken<B, T>(string path) {
        return await SendHttpRequest<B, T>(RequestType.GET, path, false);
    }

    public static async Task<T> SendHttpDeleteRequest<B, T>(string path) {
        return await SendHttpRequest<B, T>(RequestType.DELETE, path, true);
    }   
    public static async Task<T> SendHttpDeleteRequestNoToken<B, T>(string path) {
        return await SendHttpRequest<B, T>(RequestType.DELETE, path, false);
    }

    /**
     *  * B ==> The request type
     * T ==> Expected response type
     * For eg: While creating reservation, we need to send in CreateReservationDTO as body
     *         and we expect ReservationDTO back. Then the method structure will look like:
     *                 SendHttpResponse<CreateReservationDTO, ReservationDTO>.
     */
    private static async Task<T> SendHttpRequest<B, T>(RequestType requestType, string path, bool withToken,
        [Optional] B body) {
        using var httpClient = new HttpClient();
        if (withToken && AuthenticationToken.Length > 0) {
            httpClient.DefaultRequestHeaders.Authorization =
                new AuthenticationHeaderValue("Bearer", AuthenticationToken);
        }

        HttpResponseMessage responseMessage;

        switch (requestType) {
            case RequestType.GET:
                responseMessage = await httpClient.GetAsync(GetUrl(path));
                break;

            case RequestType.DELETE:
                responseMessage = await httpClient.DeleteAsync(GetUrl(path));
                break;

            case RequestType.POST:
                if (body == null) {
                    throw new Exception("Body is required POST request");
                }

                string bodyAsJson = GetSerialized<B>(body);
                var stringContent = new StringContent(bodyAsJson, Encoding.UTF8, "application/json");
                Console.WriteLine("Sending post request" + bodyAsJson);
                Console.Write("URL" + GetUrl(path));
                responseMessage = await httpClient.PostAsync(GetUrl(path), stringContent);
                break;

            case RequestType.PUT:
                if (body == null) {
                    throw new Exception("Body is required for PUT request");
                }

                bodyAsJson = GetSerialized<B>(body);
                stringContent = new StringContent(bodyAsJson, Encoding.UTF8, "application/json");
                responseMessage = await httpClient.PutAsync(GetUrl(path), stringContent);
                break;
            default: throw new Exception("Invalid request type");
        }

        string responseContent = await GetResponseContent(responseMessage);
        return GetDeserialized<T>(responseContent);
    }

    private static string GetUrl(string path) {
        return $"http://{HostName}:{PortNumber}/{path}";
    }


    private static T GetDeserialized<T>(string jsonFormat) {
        T obj = JsonSerializer.Deserialize<T>(jsonFormat, new JsonSerializerOptions() {
            PropertyNameCaseInsensitive = true,
        })!;
        return obj;
    }

    private static string GetSerialized<T>(T obj) {
        string jsonFormat = JsonSerializer.Serialize(obj, new JsonSerializerOptions() {
            PropertyNameCaseInsensitive = true,
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        });
        return jsonFormat;
    }

    private static async Task<string> GetResponseContent(HttpResponseMessage responseMessage) {
        var responseContent = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode) {
            Console.WriteLine("Throwing exception");
            throw new Exception($"Error : {responseMessage}, {responseContent} ");
        }

        return responseContent;
    }
}

public enum RequestType {
    GET,
    POST,
    PUT,
    DELETE
}