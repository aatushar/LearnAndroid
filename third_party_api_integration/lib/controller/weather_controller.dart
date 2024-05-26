import 'package:get/get.dart';
import 'package:third_party_api_integration/services/weather_service.dart';
import 'package:third_party_api_integration/models/weather_model.dart';

class WeatherController extends GetxController {
  var weather = WeatherResponse(weather: Weather(description: '', icon: ''), temperature: 0.0).obs;
  var isLoading = true.obs;

  final WeatherService weatherService;

  WeatherController(this.weatherService);

  void fetchWeather(String city) async {
    try {
      isLoading(true);
      var fetchedWeather = await weatherService.fetchWeather(city);
      weather(fetchedWeather);
    } finally {
      isLoading(false);
    }
  }
}
