import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:third_party_api_integration/controllers/weather_controller.dart';
import 'package:third_party_api_integration/services/weather_service.dart';

class WeatherScreen extends StatelessWidget {
  final WeatherController weatherController = Get.put(WeatherController(WeatherService()));

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Weather App'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Obx(() {
              if (weatherController.isLoading.value) {
                return CircularProgressIndicator();
              } else {
                final weather = weatherController.weather.value;
                return Column(
                  children: [
                    Text(
                      'Temperature: ${weather.temperature}°C',
                      style: TextStyle(fontSize: 24),
                    ),
                    Text(
                      'Description: ${weather.weather.description}',
                      style: TextStyle(fontSize: 18),
                    ),
                    Image.network(
                      'http://openweathermap.org/img/w/${weather.weather.icon}.png',
                    ),
                  ],
                );
              }
            }),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                weatherController.fetchWeather('London');
              },
              child: Text('Get Weather'),
            ),
          ],
        ),
      ),
    );
  }
}
