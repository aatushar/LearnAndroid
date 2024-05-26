import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:third_party_api_integration/models/weather_model.dart';

class WeatherService {
  final String apiKey = 'YOUR_API_KEY';

  Future<WeatherResponse> fetchWeather(String city) async {
    final response = await http.get(Uri.parse(
        'https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey&units=metric'));
    if (response.statusCode == 200) {
      return WeatherResponse.fromJson(jsonDecode(response.body));
    } else {
      throw Exception('Failed to load weather data');
    }
  }
}
