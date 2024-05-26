import 'package:hive/hive.dart';

part 'weather_model.g.dart';

@HiveType(typeId: 1)
class Weather extends HiveObject {
  @HiveField(0)
  final String description;

  @HiveField(1)
  final String icon;

  Weather({required this.description, required this.icon});

  factory Weather.fromJson(Map<String, dynamic> json) {
    return Weather(
      description: json['description'],
      icon: json['icon'],
    );
  }
}

@HiveType(typeId: 2)
class WeatherResponse extends HiveObject {
  @HiveField(0)
  final Weather weather;

  @HiveField(1)
  final double temperature;

  WeatherResponse({required this.weather, required this.temperature});

  factory WeatherResponse.fromJson(Map<String, dynamic> json) {
    return WeatherResponse(
      weather: Weather.fromJson(json['weather'][0]),
      temperature: json['main']['temp'],
    );
  }
}
