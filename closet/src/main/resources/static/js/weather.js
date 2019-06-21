$(document).ready(function () {
  var AREA = '/35.6804,139.769017/'; //tokyo

  $.ajax({
      url: "https://api.darksky.net/forecast/0b74630dcb7c17c9bf28b8ae0cf00db2" + AREA,
      dataType: "jsonp",
      data: "lang=ja&units=si&exclude=hourly,alerts,flag",

      success: function (data) {
        //当日の天気
        $('.dayWeather').text(data.currently.summary);
        $('.nowTemp').text(data.currently.temperature);
        $('.maxTemp').text(data.daily.data[0].temperatureHigh);
        $('.minTemp').text(data.daily.data[0].temperatureLow);
        $('.dayWeatherIcon').attr('src', data.currently.icon + '.png');

        //翌日の天気
        $('.tomorrowWeather').text(data.daily.data[1].summary);
        $('.tomorrowMaxTemp').text(data.daily.data[1].temperatureHigh);
        $('.tomorrowMinTemp').text(data.daily.data[1].temperatureLow);
        $('.tomorrowWeatherIcon').attr('src', data.daily.data[1].icon + '.png');
      }
  });
});
