function c_Select(){
	if(doucument.getElementbyId('select1')){
		var id = doucument.getElementbyId('select1').value;
	    document.getElementById('code').style.display = "none";
	    document.getElementById('calender').style.display = "none";
	    if(id == '1'){
	        document.getElementById('1').style.display = "";
	    }
	}
}