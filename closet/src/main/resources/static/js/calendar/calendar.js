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
    	var d = new Date(date);
		var select = $(".fc-highlight-skeleton").parent();
		var h = select.height();
		var i = $(".fc-row").index(select) - 1;
		$("#calendar .fc-scroller").height(h);
		$("#calendar .fc-scroller").animate({scrollTop:h*i});
		$("#item #date").text(date.format());
      
		$.ajax({
			url: "/calendar/getdatecoorde",
			dataType: "json",
			type:"GET",
			data: {
				"date": d,
				"userid" : 1
			},
			success: function(cal) {
				$('#cordinate-title').text(cal.event);
				console.log(cal.metPerson);
				console.log(cal.coordinate);
				
		    },
		    error: function(data) {
		    	$('#cordinate-title').text(date.format("YYYY-MM-DD"));
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
	      alert("登録イベントが取得できませんでした。");
	    }
	  });
    }
  });
  
  //console.log($('#calendar').fullCalendar('getView').start);
  $('#close').on('click', function() {
      $("#calendar .fc-scroller").height(600);
  });
});
