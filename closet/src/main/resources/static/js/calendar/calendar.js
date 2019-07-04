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
//		$("#calendar").height(h);
//		$("#calendar").animate({scrollTop:h*i});
		$("#item #date").text(date.format());
		$("#calendar").css("height","auto");
      
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
				$('#metperson').text(cal.metPerson);
				$('#cordinate-memo').text(cal.comment);
				
				//a 空にしてitem画像追加
				$('#cordinate-img').empty();				
				$.each(cal.coordinate.itemlist,function(index,value){
					$('#cordinate-img').append($("<img>").attr("src", value.picture));
					$("img").error(function(){
						$(this).attr({
							"src":"/images/item/noimage.png"
						});
					});
				});
		    	$('#coordinate_add_link').hide();
		    	$('#coordinate_detail_link').attr("href","/calendar/detail?c_id="+cal.coordinate.coordinateId);

				console.log(cal.coordinate);
				console.log(cal.coordinate.itemlist);
				$('#coordinate-wrap').show();
		    },
		    error: function(data) {
		    	$('#cordinate-title').text(date.format("YYYY年MM月DD日"));
		    	$('#coordinate_add_link').attr("href","/calendar/add?date="+date.format());
		    	$('#coordinate_add_link').show();
		    	$('#coordinate-wrap').hide();
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
//	      alert("登録イベントが取得できませんでした。");
	    }
	  });
    }
  });
  
  //console.log($('#calendar').fullCalendar('getView').start);
  $('#close').on('click', function() {
      $("#calendar").css("height","100vh");
      $("#calendar .fc-scroller").css("height","100vh");
  });
});
