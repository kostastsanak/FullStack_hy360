var doc=0;
document.getElementById("doctor").style.display="none";
document.getElementById("vigil").style.display="none";
function show_hide(){
	if(doc==0){
		document.getElementById("doctor").style.display="inline";
		document.getElementById("vigil").style.display="inline";
		return doc=1;
	}
}
function show_hide2(){
	if(doc==1){
		document.getElementById("doctor").style.display="none";
		document.getElementById("vigil").style.display="none";
		return doc=0;
	}else{
		return;
	}
}