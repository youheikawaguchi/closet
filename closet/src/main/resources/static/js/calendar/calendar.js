// document.addEventListener('DOMContentLoaded', function() {
//   var calendarEl = document.getElementById('calendar');
//   var calendar = new FullCalendar.Calendar(calendarEl, {
$(document).ready(function () {
  $('#calendar').fullCalendar({
    plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
    selectable: true,
    header: {
      left: 'prev',
      center: 'title',
      right:'next'
    },
    contentHeight: 500,
    selectLongPressDelay: 1,

    // dateClick: function(date, allDay, jsEvent, view) {
    dayClick: function(date, allDay, jsEvent, view) {
      $('#calendar').fullCalendar('addEventSource', [{
        title: 'aaa',
        start: date,
        allDay: true
      }]);
      var select = $(".fc-highlight-skeleton").parent();
      var h = select.height();
      var i = $(".fc-row").index(select) - 1;
      $("#calendar .fc-scroller").height(h);
      $("#calendar .fc-scroller").animate({scrollTop:h*i});
      console.log(date.format());
      $("#item p").text(date.format());
      // date = new Date(date);
      // var date2 = new Date(date.getFullYear(), date.getMonth(), date.getDate()+1);
      // var events = view.calendar.clientEvents(function(event) {
      //   console.log(event.start >= date && event.start < date2);
      // });

    },
    eventClick: function(calEvent, jsEvent, view) {
       $('#cordinate-title').text(calEvent.title);
    },
    // events:
  });
console.log($('#calendar').fullCalendar('getView').start);
});
