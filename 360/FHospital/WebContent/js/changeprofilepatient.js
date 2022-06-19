var one=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0;

document.getElementById("txt1").style.display="none";
document.getElementById("txt2").style.display="none";
document.getElementById("txt3").style.display="none";
document.getElementById("txt4").style.display="none";
document.getElementById("txt5").style.display="none";
document.getElementById("txt6").style.display="none";
document.getElementById("txt7").style.display="none";
document.getElementById("txt8").style.display="none";
function show1(){
	if(one==0){
		document.getElementById("txt1").style.display="table-row";
		return one=1;
	}else{
		document.getElementById("txt1").style.display="none";
		return one=0;
	}
}
function show2(){
	if(two==0){
		document.getElementById("txt2").style.display="table-row";
		return two=1;
	}else{
		document.getElementById("txt2").style.display="none";
		return two=0;
	}
}
function show3(){
	if(three==0){
		document.getElementById("txt3").style.display="table-row";
		return three=1;
	}else{
		document.getElementById("txt3").style.display="none";
		return three=0;
	}
}
function show4(){
	if(four==0){
		document.getElementById("txt4").style.display="table-row";
		return four=1;
	}else{
		document.getElementById("txt4").style.display="none";
		return four=0;
	}
}
function show5(){
	if(five==0){
		document.getElementById("txt5").style.display="table-row";
		return five=1;
	}else{
		document.getElementById("txt5").style.display="none";
		return five=0;
	}
}
function show6(){
	if(six==0){
		document.getElementById("txt6").style.display="table-row";
		return six=1;
	}else{
		document.getElementById("txt6").style.display="none";
		return six=0;
	}
}
function show7(){
	if(seven==0){
		document.getElementById("txt7").style.display="table-row";
		return seven=1;
	}else{
		document.getElementById("txt7").style.display="none";
		return seven=0;
	}
}
function show8(){
	if(eight==0){
		document.getElementById("txt8").style.display="table-row";
		return eight=1;
	}else{
		document.getElementById("txt8").style.display="none";
		return eight=0;
	}
}