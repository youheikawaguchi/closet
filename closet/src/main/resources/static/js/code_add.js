window.onload = function c_Code(){
    var selected = document.getElementById('select1').value;
    document.getElementById('c_code').style.display = "none";
}
    
    function c_Code(){
    var selected = document.getElementById('select1').value;
    document.getElementById('c_code').style.display = "none";
    if(selected == 1){
        document.getElementById('calender').style.display = "none";
        document.getElementById('c_code').style.display = "block";
        //element.classList.remove("c_code");
    }else if(selected == 2){
        document.getElementById('c_code').style.display = "none";
        document.getElementById('calender').style.display = "block";
    }
}; 
