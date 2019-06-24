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
    contentHeight: 600,
    selectLongPressDelay: 1,

    dayClick: function(date, allDay, jsEvent, view) {
//      $('#calendar').fullCalendar('addEventSource', [{
//        title: 'aaa',
//        start: date,
//        allDay: true
//      }]);
      var select = $(".fc-highlight-skeleton").parent();
      var h = select.height();
      var i = $(".fc-row").index(select) - 1;
      $("#calendar .fc-scroller").height(h);
      $("#calendar .fc-scroller").animate({scrollTop:h*i});
      console.log(date.format());
      $("#item p").text(date.format());
      
      // イベントの有無を判定
//      date = new Date(date);
//      var date2 = new Date(date.getFullYear(), date.getMonth(), date.getDate()+1);
//      var events = $("#calendar").fullCalendar('clientEvents',(function(event) {
//        console.log(event.start >= date && event.start < date2);
//      }));
//      if(events==true){
//    	  $this.eventClick();
//      }

    },
    eventClick: function(calEvent, jsEvent, view) {
    	$('#cordinate-title').text(calEvent.title);
    	var date = new Date(calEvent['start']['_i']);
    	$.ajax({
			url: "/calendar/getdatecoorde",
			dataType: "json",
			type:"GET",
			data: {
				"date": date
			},
		success: function(cal) {
			console.log(cal);
	    },
	    error: function(data) {
	        alert("登録コーデが取得できませんでした。");
	    }
	  });
    },
    viewRender: function(view) {
	  var date = $("#calendar").fullCalendar("getDate");
	  $.ajax({
	    url: "/calendar/getcode",
	    dataType: "json",
	    type:"GET",
	    data: {
	      "date": date.format("YYYY-MM-DD")
	    },
	    success: function(EventSource) {
	      var result = [{}];
	      for(var i in EventSource) {
	    	  result.push({start:EventSource[i]["eventDate"], title:EventSource[i]["event"], allDay:true});
	      }
	      $("#calendar").fullCalendar("removeEvents");
	      $("#calendar").fullCalendar("addEventSource", result);
	    },
	    error: function(data) {
	      alert("登録コーデが取得できませんでした。");
	    }
	  });
    }
  });
  
//console.log($('#calendar').fullCalendar('getView').start);
});
